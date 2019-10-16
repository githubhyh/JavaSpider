package com.hyh.spider.parse;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public interface IParse {
	public Set<String> parse(WebDriver driver, String targetCSS, String attribute);
}
