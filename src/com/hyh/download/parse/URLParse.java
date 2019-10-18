package com.hyh.download.parse;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyh.resource.SpiderInit;
import com.hyh.util.file.FileUtil;

public class URLParse extends Parse {
	
	public Set<List<String>> parseUrl(File file) {
		List<String> urls = new ArrayList<String>();
		if (file!=null&&file.exists()) {
			urls = FileUtil.readSource(file);
		}
		return parseUrl(urls);
	}
	
	public Set<List<String>> parseUrl(String path) {
		File file = new File(path);
		return parseUrl(file);
	}
	
	public Set<List<String>> parseUrl() {
		List<String> source = FileUtil.readSource(SpiderInit.getSourceSavePath());
		return parseUrl(source);
	}
	
	@SuppressWarnings("unchecked")
	public Set<List<String>> parseUrl(List<String> data) {
		Set<List<String>> resources = new HashSet<List<String>>();
		
		if (data==null||data.isEmpty()) return resources;
		
		ObjectMapper mapper = new ObjectMapper();
		JavaType parametricType = mapper.getTypeFactory().constructParametricType(ArrayList.class, String.class);
		if (data!=null&&!data.isEmpty()) {
			for (String e:data) {
				try {
					List<String> urls = (List<String>)mapper.readValue(e, parametricType);
					resources.add(urls);
				}catch (Exception e1) {
					// TODO: handle exception
					System.out.println("json错误：String to List<String> ERROR......");
				}
			}
		}
		return resources;
	}
}
