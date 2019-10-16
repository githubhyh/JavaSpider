package com.hyh.spider.parse;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hyh.spider.load.Load;
import com.hyh.spider.load.LoadImpl;

public class ParseImpl extends Parse {

	@Override
	public Set<String> parseSource(WebDriver driver, String targetCSS, String attribute) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>();
		List<WebElement> elements = driver.findElements(By.cssSelector(targetCSS));
		for (WebElement e:elements) {
			String value = e.getAttribute(attribute);
			if (value != null)
				set.add(value);
		}
		driver.quit();
		return set;
	}

	@Override
	public Set<String> parseYouWant(Collection<? extends String> urls, String regex) {
		// TODO Auto-generated method stub
		Pattern compile = Pattern.compile(regex);
		Set<String> set = new HashSet<String>();
		for (String url : urls) {
			Matcher matcher = compile.matcher(url);
			if (matcher.find()) {
				set.add(matcher.group());
			}
		}
		return set;
	}

	/**
	 * @author hu.yuhao
	 * a采用默认浏览器进行解析
	 * */
	@Override
	public Set<String> parseYouWant(String url, String targetCSS, String attribute, String regex) {
		// TODO Auto-generated method stub
		Load loder = new LoadImpl();
		WebDriver page = loder.loadPage(url);
		Set<String> source = parseSource(page, targetCSS, attribute);
		Set<String> youWant = parseYouWant(source, regex);
		return youWant;
	}

	@Override
	public Set<String> parseYouWant(String url, String targetCSS, String attribute) {
		// TODO Auto-generated method stub
		Load loder = new LoadImpl();
		WebDriver page = loder.loadPage(url);
		Set<String> source = parseSource(page, targetCSS, attribute);
		return source;
	}

}
