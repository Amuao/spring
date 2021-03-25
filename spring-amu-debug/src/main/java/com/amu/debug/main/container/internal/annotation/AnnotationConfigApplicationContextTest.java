package com.amu.debug.main.container.internal.annotation;

import com.amu.debug.main.container.internal.annotation.config.ApplicationConfig;
import com.amu.debug.main.container.internal.model.Animal;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicationContextTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		for (String beanDefinitionName : context.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
		Animal animal = context.getBean("createAnimalBean",Animal.class);
		System.out.println(animal);
		ApplicationConfig config = context.getBean("applicationConfig",ApplicationConfig.class);
		System.out.println(config);
	}
}
