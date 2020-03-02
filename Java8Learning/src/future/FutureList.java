package future;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

public class FutureList {

	public void listFuturesWithSomeFailure() {
		final List<ListenableFuture<Integer>> futurelist = Lists.newArrayList();
		for(int i =0;i<10;i++) {
			futurelist.add(getVal(i));
		}
		
		Futures.addCallback(Futures.successfulAsList(futurelist), new FutureCallback<List<Integer>>() {
			@Override
			public void onSuccess(final List<Integer> listResult) {
				int count = 0;
				for(Integer val: listResult) {
					if(val == null) {
						count++;
					}
				}
				
				System.out.println("Failed futures = "+ count);
			}

			@Override
			public void onFailure(final Throwable t) {

			}
		});
	}
	
	public void listFuturesWithSomeFailureVoid() {
		final List<ListenableFuture<Void>> futurelist = Lists.newArrayList();
		for(int i =0;i<10;i++) {
			futurelist.add(getValVoid(i));
		}
		
		Futures.addCallback(Futures.successfulAsList(futurelist), new FutureCallback<List<Void>>() {
			@Override
			public void onSuccess(final List<Void> listResult) {
				int count = 0;
				for(Void val: listResult) {
					if(val == null) {
						count++;
					}
				}
				
				System.out.println("Failed futures = "+ count);
			}

			@Override
			public void onFailure(final Throwable t) {

			}
		});
	}

	private ListenableFuture<Integer> getVal(int i) {
		
		SettableFuture<Integer> result = SettableFuture.create();
		
		if(i%2==0) {
			result.set(i);
		}else {
			result.setException(new IllegalArgumentException("not supported" + i));
		}
		return result;
	}
	
	private ListenableFuture<Void> getValVoid(int i) {
		
		SettableFuture<Void> result = SettableFuture.create();
		
		if(i%2==0) {
			result.set(null);
		}else {
			result.setException(new IllegalArgumentException("not supported"));
		}
		return result;
	}
	
	public void listFuturesWithAllFailure() {
		final List<ListenableFuture<Integer>> futurelist = Lists.newArrayList();
		for(int i =0;i<10;i++) {
			futurelist.add(getVal());
		}
		
		Futures.addCallback(Futures.successfulAsList(futurelist), new FutureCallback<List<Integer>>() {
			@Override
			public void onSuccess(final List<Integer> listResult) {
				int count = 0;
				for(Integer val: listResult) {
					if(val == null) {
						count++;
					}
				}
				
				System.out.println("Failed futures = "+ count);
			}

			@Override
			public void onFailure(final Throwable t) {
				System.out.println("All failed");
			}
		});
	}
	
	private ListenableFuture<Integer> getVal() {

		SettableFuture<Integer> result = SettableFuture.create();

		result.setException(new IllegalArgumentException("not supported"));
		return result;
	}
	
	public void listFuturesWithAsList() {
		final List<ListenableFuture<Integer>> futurelist = Lists.newArrayList();
		for(int i =0;i<10;i++) {
			futurelist.add(getVal(i));
		}
		
		Futures.addCallback(Futures.allAsList(futurelist), new FutureCallback<List<Integer>>() {
			@Override
			public void onSuccess(final List<Integer> listResult) {
				int count = 0;
				for(Integer val: listResult) {
					if(val == null) {
						count++;
					}
				}
				
				System.out.println("Failed futures = "+ count);
			}

			@Override
			public void onFailure(final Throwable t) {
				System.out.println("All failed");
			}
		});
	}
	
	public void listFuturesWithSuccessfulList() {
		final List<ListenableFuture<String>> futurelist = Lists.newArrayList();
		for(int i =0;i<10;i++) {
			futurelist.add(getValString(i));
		}
		
		Futures.addCallback(Futures.successfulAsList(futurelist), new FutureCallback<List<String>>() {
			@Override
			public void onSuccess(final List<String> listResult) {
				int count = 0;
				for(String val: listResult) {
					if(val == null) {
						count++;
					}
				}
				
				System.out.println("Failed futures = "+ count);
			}

			@Override
			public void onFailure(final Throwable t) {
				System.out.println("All failed");
			}
		});
	}
	
	public void listFuturesWithLoop() {
		final List<ListenableFuture<String>> futurelist = Lists.newArrayList();
		for(int i =0;i<10;i++) {
			futurelist.add(getValString(i));
		}
		
		Futures.addCallback(getFinalOutput(futurelist), new FutureCallback<String>() {

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onFailure(Throwable t) {
				String msg = t.getMessage();
				String[] msgs = msg.split(";");
				System.out.println("Failed = "+ msgs[0] + " reason= "+ msgs[1]);
			}
		});
		
		Futures.addCallback(Futures.successfulAsList(futurelist), new FutureCallback<List<String>>() {
			@Override
			public void onSuccess(final List<String> listResult) {
				int count = 0;
				for(String val: listResult) {
					if(val == null) {
						count++;
					}
				}
				
				System.out.println("Failed futures = "+ count);
			}

			@Override
			public void onFailure(final Throwable t) {
				System.out.println("All failed");
			}
		});
	}
	
	private ListenableFuture<String> getFinalOutput(final List<ListenableFuture<String>> futurelist){
		
		SettableFuture<String> result = SettableFuture.create();
		List<String> failed = Lists.newArrayList();
		final AtomicInteger count = new AtomicInteger(0);
		final AtomicInteger processed = new AtomicInteger(0);
		
		for(ListenableFuture<String> futu : futurelist) {
			
			Futures.addCallback(futu, new FutureCallback<String>() {

				@Override
				public void onSuccess(String temp) {
					count.incrementAndGet();
					if(processed.incrementAndGet() == futurelist.size()) {
						if(failed.isEmpty())
							result.set("");
						else
							result.setException(new IllegalArgumentException(failed.get(0)));
					}
				}

				@Override
				public void onFailure(Throwable t) {
					failed.add(t.getMessage());
					count.getAndIncrement();
					if(processed.incrementAndGet() == futurelist.size()) {
						if(failed.isEmpty())
							result.set("");
						else {
							
							Throwable throwable = new Throwable(t);
							result.setException(new IllegalArgumentException(failed.size() + ";"+failed.get(0)));
							}
					}
				}
			});
		}
		
		return result;
	}
	
	private ListenableFuture<String> getValString(int i) {
		
		SettableFuture<String> result = SettableFuture.create();
		
		if(i%2==0) {
			result.set("Passed");
		}else {
			result.setException(new IllegalArgumentException("not supported"));
		}
		return result;
	}
}
