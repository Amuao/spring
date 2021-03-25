package com.amu.debug.main.container.internal.xml;

import com.amu.debug.main.container.internal.model.Animal;
import com.amu.debug.main.container.internal.model.AnimalFactoryBean;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 使用Ioc时，我们一般有两种方式：
 * 1.BeanFactory
 * 我见到的比较少
 * 官方注释是
 * 	`The root interface for accessing a Spring bean container.`
 * 	访问spring bean容器的根接口
 * 2.ApplicationContext
 * 比较常见的是
 * 官方注释是
 * 	`Central interface to provide configuration for an application.
 * 	This is read-only while the application is running, but may be
 * 	reloaded if the implementation supports this.`
 *  为应用程序提供配置的中心接口。在应用程序运行时这是只读的，但如果实现支持此功能，则可以重新加载。
 *
 * 本测试主要目的是为了弄清楚BeanFactory，顺便也探究下这两种方式的区别
 *
 */
public class BeanFactoryTest {

	public static void main(String[] args) {

		//1.创建工厂
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		//2.创建bean定义
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		//定义属性
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		PropertyValue value = new PropertyValue("name", "cat");
		propertyValues.addPropertyValue(value);

		//设置bean的类型和属性
		beanDefinition.setPropertyValues(propertyValues);
		beanDefinition.setBeanClass(Animal.class);

		//3.将定义好的bean注册到容器

		factory.registerBeanDefinition("animal",beanDefinition);
		factory.preInstantiateSingletons(); //这一步会提前实例化bean

		//4.使用bean
		Animal animal = (Animal) factory.getBean("animal");
		animal.say();

		//test
		//注入一个工厂类
		GenericBeanDefinition factoryBeanDefinition = new GenericBeanDefinition();
		MutablePropertyValues values = new MutablePropertyValues();
		PropertyValue nameValue = new PropertyValue("name", "小花");
		PropertyValue ageValue = new PropertyValue("age", 10);
		values.addPropertyValue(nameValue);
		values.addPropertyValue(ageValue);
		factoryBeanDefinition.setBeanClass(AnimalFactoryBean.class);
		factoryBeanDefinition.setPropertyValues(values);
		factory.registerBeanDefinition("animalFactory",factoryBeanDefinition);
		factory.preInstantiateSingletons(); //这一步会提前实例化bean
		Animal bean = (Animal) factory.getBean("animalFactory"); //获取到工厂产生的对象
		AnimalFactoryBean factoryBean = (AnimalFactoryBean) factory.getBean("&animalFactory"); //获取工厂对象本身
		bean.say();
		System.out.println(factoryBean);
		

		//test2
		BeanFactory factory2 = new XmlBeanFactory(new ClassPathResource("applicationContext-container.xml"));
		factory2.getBean("cat");
	}
}
