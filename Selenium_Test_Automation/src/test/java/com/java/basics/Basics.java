package com.java.basics;

public class Basics {
	
	int a=10;
	int b=20;
	
	int addition() {
		int c=a+b;
		System.out.println("Addition of a and b is : " +c);
		return c;
	}
	
	public static void main(String[] args) {
		Basics b = new Basics();
		int res = b.addition();
		System.out.println(res);
	}

}
