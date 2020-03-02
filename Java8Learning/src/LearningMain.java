import java.util.Arrays;

import defaultmethods.impl.Test;
import functionalinterface.impl.FunctinalInterfaceUser;
import future.FutureList;
import predicate.PredicateBeginner;

public class LearningMain {
//	public static void main(String[] args)
//	{
//		//lambda expression
//		Runnable runObject = () -> {
//			for(int i =0 ;i<10;i++)
//				System.out.println("Child thread1");
//		};
//		System.out.println("\n");
//		Thread t = new Thread(runObject);
//		Thread t2 = new Thread(()-> {
//			for(int i =0 ;i<10;i++)
//				System.out.println("Child thread2");}); 
//		t.start();
//		t2.start();
//		System.out.println("\n");
//		FunctinalInterfaceUser functionalInterface = new FunctinalInterfaceUser();
//		functionalInterface.print("Hello World");
//		functionalInterface.add(10, 20);
//		
//		//default method
//		Test test = new Test();
//		test.m1();
//		test.m2("Hello World");
//		System.out.println("\n");
//		System.out.println(test.m3("Hello World"));
//		
//		//Predicate
//		System.out.println("\n");
//		PredicateBeginner predicateBeginner = new PredicateBeginner();
//		predicateBeginner.getNamesWithK(Arrays.asList("Kartik", "Karishma", "Rampur", "Kanpur"));
//		System.out.println("\n");
//		predicateBeginner.removeNullAndEmpty(Arrays.asList("Name", null, "", "Name1", null, "", "LastName"));
//	}
	
	public static void main(String[] args) {
		FutureList list = new FutureList();
//		list.listFuturesWithSomeFailure();
//		
//		list.listFuturesWithAllFailure();
//		list.listFuturesWithSomeFailureVoid();
//		list.listFuturesWithAsList();
//		list.listFuturesWithSuccessfulList();
		list.listFuturesWithLoop();
	}
	
}
