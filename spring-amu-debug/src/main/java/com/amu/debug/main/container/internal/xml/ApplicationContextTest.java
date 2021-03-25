package com.amu.debug.main.container.internal.xml;

import com.amu.debug.main.container.internal.model.Cat;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class ApplicationContextTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-container.xml");
		Cat cat = context.getBean("cat",Cat.class);
		cat.eat("🐟");
		cat.walk();


		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext-container.xml"));
		Cat cat2 = factory.getBean("cat",Cat.class);
		cat2.eat("🐟");
		cat2.walk();
		System.out.println(cat == cat2);

	}
}
