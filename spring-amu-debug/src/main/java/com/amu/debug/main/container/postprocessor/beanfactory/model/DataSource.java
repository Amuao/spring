package com.amu.debug.main.container.postprocessor.beanfactory.model;

/**
 * 模拟数据库的实体类，值都是用占位符代替
 */
public class DataSource {
	private String url = "${url}";
	private String className = "${className}";
	private String userName = "${userName}";
	private String password = "${password}";

	public void setUrl(String url) {
		this.url = url;
	}
}
