package com.hyh.spider.load;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

/**
 * @author hu.yuhao
 * a资源加载抽象父类
 * */
public abstract class Load {
	public abstract WebDriver loadPage(String url);
	public abstract WebDriver loadPage(String url, long timeout, TimeUnit unit);
}
