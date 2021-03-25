package com.amu.debug.main.container.internal.annotation.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String systemName = context.getEnvironment().getProperty("os.name");
		if(systemName.contains("Windows")){
			return true;
		}
		return false;
	}
}
