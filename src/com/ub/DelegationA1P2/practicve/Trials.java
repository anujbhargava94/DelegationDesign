package com.ub.DelegationA1P2.practicve;


public class Trials {
	public static void main(String args[]) {
		C c = new D();						//this will only call the methods defined in C, if any method is redundant then D will override the method and C will override the atrributes.
		Integer value = 100;
		System.out.println(c.k());
		c.passByValue(value);
		System.out.println(value);
	}
	

}

class C {
	int d1 = 1000000;
	int d2 = 2000000;

	public int r() {
		return d1+d2;
	}

	public int k() {
		// TODO Auto-generated method stub
		return 9999;
	}
	
	public void passByValue(Integer value) {
		value=value+1;
	}
	
}

class D extends C {
	int d1 = 1000000;
	int d2 = 2000000;

	public int k() {
		return d1+d2;
	}
	
	
	
}
