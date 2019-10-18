package com.hyh.resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author hu.yuhao
 * */
public class SpiderInit {
	private static String htmlCachePath;
	private static String imgCachePath;
	private static String sourceSavePath;
	private static String threadPoolSize;
	private static String htmlTaskNum;
	private static String sourceTaskNum;
	private static String targetCSS;
	private static String attributeName;
	private static String htmlTargetCss;
	private static String htmlAttributeName;
	private static String htmlPathRegex;
	private static String sourcePathRegex;
	private static String getHtmlSourceTime;
	private static String getImgSourceTime;
	private static String downloadSavePath;
	private static String downloadTaskNum;
	
	static {
		try {
			InputStream inputStream = new FileInputStream("./spider-cfg.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			htmlCachePath = properties.getProperty("htmlCachePath");
			imgCachePath = properties.getProperty("imgCachePath");
			sourceSavePath = properties.getProperty("sourceSavePath");
			threadPoolSize = properties.getProperty("threadPoolSize");
			htmlTaskNum = properties.getProperty("htmlTaskNum");
			sourceTaskNum = properties.getProperty("sourceTaskNum");
			targetCSS = properties.getProperty("targetCSS");
			attributeName = properties.getProperty("attributeName");
			htmlTargetCss = properties.getProperty("htmlTargetCss");
			htmlAttributeName = properties.getProperty("htmlAttributeName");
			htmlPathRegex = properties.getProperty("htmlPathRegex");
			sourcePathRegex = properties.getProperty("sourcePathRegex");
			getHtmlSourceTime = properties.getProperty("getHtmlSourceTime");
			getImgSourceTime = properties.getProperty("getImgSourceTime");
			downloadSavePath = properties.getProperty("downloadSavePath");
			downloadTaskNum = properties.getProperty("downloadTaskNum");
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("资源文件加载错误！！！请确认后，重新启动");
			System.exit(1);
		}
	}

	public static String getHtmlCachePath() {
		return htmlCachePath;
	}

	public static String getImgCachePath() {
		return imgCachePath;
	}

	public static String getSourceSavePath() {
		return sourceSavePath;
	}

	public static String getThreadPoolSize() {
		return threadPoolSize;
	}

	public static String getHtmlTaskNum() {
		return htmlTaskNum;
	}

	public static String getSourceTaskNum() {
		return sourceTaskNum;
	}

	public static String getTargetCSS() {
		return targetCSS;
	}

	public static String getAttributeName() {
		return attributeName;
	}

	public static String getHtmlPathRegex() {
		return htmlPathRegex;
	}

	public static String getSourcePathRegex() {
		return sourcePathRegex;
	}

	public static String getHtmlAttributeName() {
		return htmlAttributeName;
	}

	public static String getHtmlTargetCss() {
		return htmlTargetCss;
	}

	public static String getGetHtmlSourceTime() {
		return getHtmlSourceTime;
	}

	public static String getGetImgSourceTime() {
		return getImgSourceTime;
	}

	public static String getDownloadSavePath() {
		return downloadSavePath;
	}

	public static String getDownloadTaskNum() {
		return downloadTaskNum;
	}
}
