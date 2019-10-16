package com.hyh.spider.load;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

/**
 * @author hu.yuhao
 * a加载器接口
 * */
public interface ILoad {
	/**
	 * @author hu.yuhao
	 * a默认加载处理，load完成后返回driver
	 * @param url 需要加载的网页链接
	 * @return WebDriver 将加载好的driver返回（driver包含了页面所有信息）
	 * @exception 空值异常，加载超时异常
	 * */
	public WebDriver load(String url);
	
	/**
	 * @author hu.yuhao
	 * a设置加载时间，超出时间抛出异常，在规定的时间内加载完成就返回driver
	 * @param url 需要加载的网页链接
	 * @param timeout 超时时间，范围大于0小于 LONG.MAX_VALUE
	 * @param unit 时间格式{秒，毫秒等}
	 * @return WebDriver 加载好的driver
	 * @exception 参数异常，空值异常，超时异常
	 * */
	public WebDriver load(String url, long timeout, TimeUnit unit);
}
