package com.hyh.spider.parse;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.WebDriver;

/**
 * @author hu.yuhao
 * a抽象解析类
 * */
public abstract class Parse implements IParse {
	public abstract Set<String> parseSource(WebDriver driver, String targetCSS, String attribute);

	public abstract Set<String> parseYouWant(Collection<? extends String> urls, String regex);
	
	public abstract Set<String> parseYouWant(String url, String targetCSS, String attribute, String regex);
	
	public abstract Set<String> parseYouWant(String url, String targetCSS, String attribute);
	
	@Override
	public Set<String> parse(WebDriver driver, String targetCSS, String attribute) {
		// TODO Auto-generated method stub
		if (driver == null) {
			return new HashSet<String>();
		}
		return parseSource(driver, targetCSS, attribute);
	}
}
