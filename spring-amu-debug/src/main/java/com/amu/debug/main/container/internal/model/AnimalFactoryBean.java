package com.amu.debug.main.container.internal.model;

import org.springframework.beans.factory.FactoryBean;

public class AnimalFactoryBean implements FactoryBean<Animal> {

	private String name;

	private int age;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public Animal getObject() throws Exception {
		return new Animal(name,age);
	}

	@Override
	public Class<?> getObjectType() {
		return Animal.class;
	}
}
