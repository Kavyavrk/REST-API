package com.backend.testing;

public class A 
{
	public A a()
	{
		System.out.println("execute method a");
		return new A();
	}
	
	public A b()
	{
		System.out.println("execute method b");
		return new A();
	}
	
	public B c()
	{
		System.out.println("execute method c");
		return new B();
	}
}

