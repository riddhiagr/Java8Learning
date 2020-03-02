package defaultmethods.impl;

import defaultmethods.Intref1;
import defaultmethods.Intref2;

public class Test implements Intref1, Intref2{

	@Override
	public void m1() {
		Intref1.super.m1();
		Intref2.super.m1();
	}

}
