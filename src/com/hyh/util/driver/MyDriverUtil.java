package com.hyh.util.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author hu.yuhao
 * a获取加载浏览器
 * */
public class MyDriverUtil {
	private MyDriverUtil() {}
	public static WebDriver getInstance() {
		return createDriver();
	}
	
	private static WebDriver createDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless", "--disable-gpu");
		
		//只需加载DOM树，减少网页加载时间
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}
}
