package com.hyh.spider.task.imgtask;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyh.resource.SpiderInit;
import com.hyh.spider.parse.ParseImpl;
import com.hyh.sync.SyncFile;
import com.hyh.util.file.FileUtil;

public class ParseSourceTask implements Runnable {
	/**
	 * @author hu.yuhao
	 * a当前线程任务队列
	 * */
	private ThreadLocal<List<String>> currentTask = new ThreadLocal<List<String>>();
	public ParseSourceTask(List<String> tasks) {
		// TODO Auto-generated constructor stub
		currentTask.set(tasks);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<String> tasks = currentTask.get();
		ObjectMapper mapper = new ObjectMapper();
		for (String task:tasks) {
			try {
				Set<String> youWant = new ParseImpl().parseYouWant(task, SpiderInit.getTargetCSS(), SpiderInit.getAttributeName());
				String valueAsString = mapper.writeValueAsString(youWant);
				SyncFile.getInstance().writeSourceToFile(valueAsString+"\n", SpiderInit.getSourceSavePath());
				System.out.println(valueAsString);
				System.out.println(task+"  解析完成，线程退出......");
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				System.out.println("json转化错误，执行下一个任务......");
			}
		}
	}
}
