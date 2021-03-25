package com.amu.debug.main.container.postprocessor.beanfactory;

import com.amu.debug.main.container.postprocessor.beanfactory.model.DataSource;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.lang.reflect.Field;

/**
 * spring中两大后置处理器
 * 	1.BeanFactoryPostProcessor 针对BeanFactory
 * 	2.BeanPostProcessor        针对Bean
 * 下面主要探究BeanFactoryPostProcessor的原理
 */
public class BeanFactoryPostProcessorDemoTest {
	public static void main(String[] args) throws ClassNotFoundException {
		AbstractApplicationContext context = new GenericApplicationContext();
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
		GenericBeanDefinition definition =new GenericBeanDefinition();
		Class<?> clazz = context.getClass().getClassLoader().loadClass("com.amu.debug.main.container.postprocessor.beanfactory.model.DataSource");
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			String fieldName = field.getName();
			//definition.getPropertyValues().add(fieldName,);
		}
		definition.setBeanClass(DataSource.class);
		beanFactory.registerBeanDefinition("dataSource",definition);
		context.addBeanFactoryPostProcessor( new MyBeanFactoryPostProcessor());
		context.refresh();
	}
}
