package com.amu.debug.main.container.internal.annotation.dependson;

/**
 * 事件监听者
 */
public class EventListenerBean {

	private void initialize() {
		System.out.println("************EventListenerBean initializing************");
		EventManager.getInstance().addListener(s ->
				System.out.println("*****************event received in EventListenerBean**************** : " + s));
	}
}
