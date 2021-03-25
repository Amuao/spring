package com.amu.debug.main.container.internal.annotation.config;

import com.amu.debug.main.container.external.ExternalBeanImportTest;
import com.amu.debug.main.container.internal.annotation.condition.WindowsCondition;
import com.amu.debug.main.container.internal.annotation.dependson.EventListenerBean;
import com.amu.debug.main.container.internal.annotation.dependson.EventPublisherBean;
import com.amu.debug.main.container.internal.model.AnimalFactoryBean;
import org.springframework.context.annotation.*;


@Configuration
@ComponentScan(value = "com.amu.debug.main.container.internal") //指定扫描的范围
@Import(value = ExternalBeanImportTest.class) //当有些第三方的包不在指定的扫描范围时，可以使用import导入
@EnableAspectJAutoProxy()  //需要引入aspect包 表示开启代理
public class ApplicationConfig {

	/**
	 * 工厂bean 返回Animal类对象
	 * @return
	 */
	@Bean
	@Conditional(value = WindowsCondition.class) //条件注入
	public AnimalFactoryBean createAnimalBean() {
		return new AnimalFactoryBean();
	}


	@Bean(initMethod = "initialize")
	@DependsOn(value = {"eventListener"})
	public EventPublisherBean eventSource(){
		return new EventPublisherBean();
	}

	@Bean(name = "eventListener" ,initMethod = "initialize")
	public EventListenerBean eventListener(){
		return new EventListenerBean();
	}
}
