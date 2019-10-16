package com.hyh.spider.load;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.hyh.util.driver.MyDriverUtil;

/**
 * @author hu.yuhao
 * a加载实现类
 * */
public class LoadImpl extends Load {

	@Override
	public WebDriver loadPage(String url) {
		// TODO Auto-generated method stub
		WebDriver driver = MyDriverUtil.getInstance();
		
		//默认超时处理，server timeout。断开连接
		try {
			driver.get(url);
			System.out.println(url+"  加载完成......");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(url+"  :加载超时异常......");
			return null;
		}
		return driver;
	}

	@Override
	public WebDriver loadPage(String url, long timeout, TimeUnit unit) {
		// TODO Auto-generated method stub
		WebDriver driver = MyDriverUtil.getInstance();
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		try {
			driver.get(url);
			System.out.println(url+"  加载完成......");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(url+"  :加载超时异常......");
			return null;
		}
		return driver;
	}

}
