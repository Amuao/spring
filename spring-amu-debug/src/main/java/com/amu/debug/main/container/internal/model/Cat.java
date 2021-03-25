package com.amu.debug.main.container.internal.model;

public class Cat {
	private String name;
	private int age;

	public void eat(String food){
		System.out.println("cat eat" + food);
	}

	public void walk(){
		System.out.println("cat  walk");
	}

	public void say(){
		System.out.println("Hello " + name);
	}
}
