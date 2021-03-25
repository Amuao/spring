package com.amu.debug.main.container.postprocessor.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.stream.Stream;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		Stream.of(beanFactory.getBeanDefinitionNames()).forEach((n)-> System.out.println(n));
		BeanDefinition dataSource = beanFactory.getBeanDefinition("dataSource");
		System.out.println(dataSource);
		System.out.println("this is my bean factory post processor ************************");
	}
}
