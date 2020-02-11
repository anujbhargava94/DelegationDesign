package com.ub.DelegationA1P2;

public class Delegation2 {

	public static void main(String args[]) {

		E e = new E();
		System.out.println(e.f() - e.g() + e.h() - e.p(1) + e.q(2) - e.r() + e.k(100));

		E2 e2 = new E2();
		System.out.println(e2.f() - e2.g() + e2.h() - e2.p(1) + e2.q(2) - e2.r() + e2.k(100));

		F f = new F();
		System.out.println(f.f() + f.g() + f.h() + f.p(1) - f.q(2) - f.r() - f.j(10) + f.l(100));

		F2 f2 = new F2();
		System.out.println(f2.f() + f2.g() + f2.h() + f2.p(1) - f2.q(2) - f2.r() - f2.j(10) + f2.l(100));
	}

}

//===== TRANSFORMATION IN TERMS OF DELEGATION ======

//INTERFACES

interface IA {
	public int f();

	public int p(int m);

	public int q(int m);
}

interface IB extends IA {
	public int g();
}

interface IC extends IB {
	public int r(); // q from A

	public int h();
}

interface ID extends IC {

	public int j(int n); // h,r from IC
}

interface IE extends IC {

	public int k(int n); // q and h from IC
}

interface IF extends ID {

	public int l(int n); // q and h from IC
}

//CLASSES 

class A2 implements IA {
	int a1 = 100;
	int a2 = 200;
	IA this2;																		//subClass instance to access the base classes behaviour and attributes

	A2(IA a) {																	//Parameterised constructor to get the instance of calling class
		this2 = a;
	}

	@Override
	public int f() {
		// TODO Auto-generated method stub
		return a1 + this2.p(100) + this2.q(100);
	}

	@Override
	public int p(int m) {
		// TODO Auto-generated method stub
		return this2.p(m);
	}

	@Override
	public int q(int m) {
		// TODO Auto-generated method stub
		return this2.q(m);
	}

}

class B2 implements IB {
	int b1 = 1000;
	int b2 = 2000;
	A2 super2;																	//superClass instance to access the base classes behaviour and attributes
	IB this2;																		//subClass instance to access the base classes behaviour and attributes

	B2() {																		//Passing the current instance to the Delegate class(Parent)
		super2 = new A2(this);
		this2 = this;
	}
	
	B2(IB b) {																	//Parameterised constructor to get the instance of calling class
		super2 = new A2(b);														//Passing the calling instance to the Delegate class(Parent)
		this2 = b;
	}

	@Override
	public int f() {
		// TODO Auto-generated method stub
		return super2.f();
	}

	@Override
	public int p(int m) {
		// TODO Auto-generated method stub
		return m + super2.a1 + b1;
	}

	@Override
	public int q(int m) {
		// TODO Auto-generated method stub
		return m + super2.a2 + b2;
	}

	@Override
	public int g() {
		// TODO Auto-generated method stub
		return this2.p(100) + this2.q(200);
	}
}

class C2 implements IC {
	int c1 = 10000;
	int c2 = 20000;

	IC this2;																			//subClass instance to access the base classes behaviour and attributes
	B2 super2;																		//superClass instance to access the base classes behaviour and attributes

	C2(IC c) {																		//Passing the calling instance to the Delegate class(Parent)
		this2 = c;
		super2 = new B2(this2);
	}

	@Override
	public int g() {
		// TODO Auto-generated method stub
		return super2.g();
	}

	@Override
	public int f() {
		// TODO Auto-generated method stub
		return super2.f();
	}

	@Override
	public int p(int m) {
		// TODO Auto-generated method stub
		return super2.p(m);
	}

	@Override
	public int q(int m) {
		// TODO Auto-generated method stub
		return m + super2.super2.a2 + super2.b2 + c2;
	}

	@Override
	public int r() {
		// TODO Auto-generated method stub
		return this2.f() + this2.g() + this2.h();
	}

	@Override
	public int h() {
		// TODO Auto-generated method stub
		return this2.h();
	}

}

class D2 implements ID {
	int d1 = 1000000;
	int d2 = 2000000;

	C2 super2;																//superClass instance to access the base classes behaviour and attributes
	ID this2;																	//subClass instance to access the base classes behaviour and attributes

	D2() {
		super2 = new C2(this);												//Passing the current instance to the Delegate class(Parent)
		this.this2 = this;
	}


	D2(ID iD) {																//Parameterised constructor to get the instance of calling class
		super2 = new C2(iD);												//Passing the calling instance to the Delegate class(Parent)
		this.this2 = iD;
	}

	@Override
	public int r() {
		// TODO Auto-generated method stub
		return this2.f() + this2.g() + this2.h();
	}

	@Override
	public int h() {
		// TODO Auto-generated method stub
		return super2.super2.super2.a1 + super2.super2.b1 + super2.c1;
	}

	@Override
	public int g() {
		// TODO Auto-generated method stub
		return super2.g();
	}

	@Override
	public int f() {
		// TODO Auto-generated method stub
		return super2.f();
	}

	@Override
	public int p(int m) {
		// TODO Auto-generated method stub
		return super2.p(m) + d2;
	}

	@Override
	public int q(int m) {
		// TODO Auto-generated method stub
		return super2.q(m);
	}

	@Override
	public int j(int n) {
		// TODO Auto-generated method stub
		return this2.r() + super2.r();
	}
}

class E2 implements IE {
	int e1 = 1;
	int e2 = 2;
	C2 super2;																	//superClass instance to access the base classes behaviour and attributes

	E2() {
		super2 = new C2(this);													//Passing the current instance to the Delegate class(Parent)
	}

	@Override
	public int r() {
		// TODO Auto-generated method stub
		return super2.r();
	}

	@Override
	public int h() {
		// TODO Auto-generated method stub
		return super2.super2.super2.a1 + super2.super2.b1 + e1;
	}

	@Override
	public int g() {
		// TODO Auto-generated method stub
		return super2.g();
	}

	@Override
	public int f() {
		// TODO Auto-generated method stub
		return super2.f();
	}

	@Override
	public int p(int m) {
		// TODO Auto-generated method stub
		return super2.p(m);
	}

	@Override
	public int q(int m) {
		// TODO Auto-generated method stub
		return p(m) + super2.c2;
	}

	@Override
	public int k(int n) {
		// TODO Auto-generated method stub
		return q(n) + super2.q(n);
	}
}

class F2 implements IF {
	int f1 = 10;
	int f2 = 20;
	D2 super2;													//superClass instance to access the base classes behaviour and attributes

	F2() {
		super2 = new D2(this);									//Passing the calling instance to the Delegate class(Parent)
	}

	@Override
	public int j(int n) {
		// TODO Auto-generated method stub
		return super2.j(n);
	}

	@Override
	public int r() {
		// TODO Auto-generated method stub
		return super2.r();
	}

	@Override
	public int h() {
		// TODO Auto-generated method stub
		return super2.super2.c2 + f2;
	}

	@Override
	public int g() {
		// TODO Auto-generated method stub
		return super2.g();
	}

	@Override
	public int f() {
		// TODO Auto-generated method stub
		return super2.f();
	}

	@Override
	public int p(int m) {
		// TODO Auto-generated method stub
		return super2.p(m);
	}

	@Override
	public int q(int m) {
		// TODO Auto-generated method stub
		return p(m) + super2.super2.c1 + super2.d1;
	}

	@Override
	public int l(int n) {
		// TODO Auto-generated method stub
		return q(n) + super2.q(n);
	}
}
