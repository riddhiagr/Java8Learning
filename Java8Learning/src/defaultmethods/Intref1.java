package defaultmethods;

public interface Intref1 {

	public default  void m1() {
		System.out.println("Intref1 default method");
	}
	
	default void m2(String value) {
		System.out.println("Intref1 m2 default method with value : "+value);
	}
	
	default int m3(String value) {
		System.out.println("Intref1 m3 default method with value : "+value);
		return value.length();
	}
}
