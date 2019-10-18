package com.hyh.download.content;

public class ContentType {
	public static String getSuffix(String type) {
		String[] split = type.split("/");
		System.out.println("suffix"+split[1]);
		if ("jpeg".equals(split[1])) {
			return ".jpg";
		}else if ("gif".equals(split[1])) {
			return ".gif";
		}else {
			return ".jpg";
		}
	}
}
