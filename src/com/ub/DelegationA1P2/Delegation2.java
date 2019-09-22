package com.ub.DelegationA1P2;

public class Delegation2 {
	
public static void main(String args[]) {
	
	E e = new E();
	System.out.println(e.f()-e.g()+e.h()-e.p(1)+e.q(2)-e.r()+e.k(100));
	
	E2 e2 = new E2();
	System.out.println(e2.f()-e2.g()+e2.h()-e2.p(1)+e2.q(2)-e2.r()+e2.k(100));

	F f = new F();
	System.out.println(f.f()+f.g()+f.h()+f.p(1)-f.q(2)-f.r()-f.j(10)+f.l(100));
	
	F2 f2 = new F2();
	System.out.println(f2.f()+f2.g()+f2.h()+f2.p(1)-f2.q(2)-f2.r()-f2.j(10)+f2.l(100));		
}
}