package functionalinterface.impl;

import functionalinterface.IAdditionCalculator;
import functionalinterface.IMyFirstFunctionalInterface;

public class FunctinalInterfaceUser {
	
	public void print(String value) {
		IMyFirstFunctionalInterface i = ()-> System.out.println(value);
		i.method1();
	}
	
	public void add(int a, int b ) {
		IAdditionCalculator adder = ()->  a+b;
		System.out.println(adder.addNumbers());
	}
}
