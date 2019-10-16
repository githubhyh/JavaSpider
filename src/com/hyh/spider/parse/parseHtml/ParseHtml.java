package com.hyh.spider.parse.parseHtml;

import java.util.Collection;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.hyh.spider.parse.Parse;

/**
 * @author hu.yuhao
 * a正则匹配网页资源（匹配下一页）
 * */
public class ParseHtml extends Parse {

	@Override
	public Set<String> parseSource(WebDriver driver, String targetCSS, String attribute) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> parseYouWant(Collection<? extends String> urls, String regex) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Set<String> parseYouWant(String url, String targetCSS, String attribute, String regex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> parseYouWant(String url, String targetCSS, String attribute) {
		// TODO Auto-generated method stub
		return null;
	}

}
