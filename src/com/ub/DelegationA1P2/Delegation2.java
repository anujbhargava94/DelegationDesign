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
	IA iA;

	A2(IA a) {
		iA = a;
	}

	@Override
	public int f() {
		// TODO Auto-generated method stub
		return a1 + iA.p(100) + iA.q(100);
	}

	@Override
	public int p(int m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int q(int m) {
		// TODO Auto-generated method stub
		return 0;
	}

}

class B2 implements IB {
	int b1 = 1000;
	int b2 = 2000;
	A2 superA;
	IB iB;

	B2() {
		superA = new A2(this);
		iB = this;
	}

	B2(IB b) {
		superA = new A2(b);
		iB = b;
	}

	@Override
	public int f() {
		// TODO Auto-generated method stub
		return superA.f();
	}

	@Override
	public int p(int m) {
		// TODO Auto-generated method stub
		return m + superA.a1 + b1;
	}

	@Override
	public int q(int m) {
		// TODO Auto-generated method stub
		return m + superA.a2 + b2;
	}

	@Override
	public int g() {
		// TODO Auto-generated method stub
		return iB.p(100) + iB.q(200);
	}
}

class C2 implements IC {
	int c1 = 10000;
	int c2 = 20000;

	IC iC;
	B2 superB;

	C2(IC c) {
		iC = c;
		superB = new B2(iC);
	}

	@Override
	public int g() {
		// TODO Auto-generated method stub
		return superB.g();
	}

	@Override
	public int f() {
		// TODO Auto-generated method stub
		return superB.f();
	}

	@Override
	public int p(int m) {
		// TODO Auto-generated method stub
		return superB.p(m);
	}

	@Override
	public int q(int m) {
		// TODO Auto-generated method stub
		return m + superB.superA.a2 + superB.b2 + c2;
	}

	@Override
	public int r() {
		// TODO Auto-generated method stub
		return iC.f() + iC.g() + iC.h();
	}

	@Override
	public int h() {
		// TODO Auto-generated method stub
		return 0;
	}

}

class D2 implements ID {
	int d1 = 1000000;
	int d2 = 2000000;

	C2 superC;

	D2() {
		superC = new C2(this);
	}

	ID iD;

	D2(ID iD) {
		superC = new C2(iD);
		this.iD = iD;
	}

	@Override
	public int r() {
		// TODO Auto-generated method stub
		return iD.f() + iD.g() + iD.h();
	}

	@Override
	public int h() {
		// TODO Auto-generated method stub
		return superC.superB.superA.a1 + superC.superB.b1 + superC.c1;
	}

	@Override
	public int g() {
		// TODO Auto-generated method stub
		return superC.g();
	}

	@Override
	public int f() {
		// TODO Auto-generated method stub
		return superC.f();
	}

	@Override
	public int p(int m) {
		// TODO Auto-generated method stub
		return superC.p(m) + d2;
	}

	@Override
	public int q(int m) {
		// TODO Auto-generated method stub
		return superC.q(m);
	}

	@Override
	public int j(int n) {
		// TODO Auto-generated method stub
		return iD.r() + superC.r();
	}
}

class E2 implements IE {
	int e1 = 1;
	int e2 = 2;
	C2 superC;

	E2() {
		superC = new C2(this);
	}

	@Override
	public int r() {
		// TODO Auto-generated method stub
		return superC.r();
	}

	@Override
	public int h() {
		// TODO Auto-generated method stub
		return superC.superB.superA.a1 + superC.superB.b1 + e1;
	}

	@Override
	public int g() {
		// TODO Auto-generated method stub
		return superC.g();
	}

	@Override
	public int f() {
		// TODO Auto-generated method stub
		return superC.f();
	}

	@Override
	public int p(int m) {
		// TODO Auto-generated method stub
		return superC.p(m);
	}

	@Override
	public int q(int m) {
		// TODO Auto-generated method stub
		return p(m) + superC.c2;
	}

	@Override
	public int k(int n) {
		// TODO Auto-generated method stub
		return q(n) + superC.q(n);
	}
}

class F2 implements IF {
	int f1 = 10;
	int f2 = 20;
	D2 superD;

	F2() {
		superD = new D2(this);
	}

	@Override
	public int j(int n) {
		// TODO Auto-generated method stub
		return superD.j(n);
	}

	@Override
	public int r() {
		// TODO Auto-generated method stub
		return superD.r();
	}

	@Override
	public int h() {
		// TODO Auto-generated method stub
		return superD.superC.c2 + f2;
	}

	@Override
	public int g() {
		// TODO Auto-generated method stub
		return superD.g();
	}

	@Override
	public int f() {
		// TODO Auto-generated method stub
		return superD.f();
	}

	@Override
	public int p(int m) {
		// TODO Auto-generated method stub
		return superD.p(m);
	}

	@Override
	public int q(int m) {
		// TODO Auto-generated method stub
		return p(m) + superD.superC.c1 + superD.d1;
	}

	@Override
	public int l(int n) {
		// TODO Auto-generated method stub
		return q(n) + superD.q(n);
	}
}
