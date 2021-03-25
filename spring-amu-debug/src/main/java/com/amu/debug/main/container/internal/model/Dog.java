package com.amu.debug.main.container.internal.model;

public class Dog {
	private String name;
	private int age;

	public void eat(String food) {
		System.out.println("dog eat" + food);
	}

	public void walk() {
		System.out.println("dog walk");
	}

	public void say() {
		System.out.println("Hello " + name);
	}
}
