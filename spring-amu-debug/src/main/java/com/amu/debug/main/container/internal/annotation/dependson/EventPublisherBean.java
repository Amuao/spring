package com.amu.debug.main.container.internal.annotation.dependson;

/**
 * 事件发布者
 */
public class EventPublisherBean {

	private void initialize() {
		System.out.println("************EventPublisherBean initializing************");
		EventManager.getInstance().publish("event published from EventPublisherBean");
	}
}
