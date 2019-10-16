package com.hyh.spider.task.htmltask;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hyh.resource.SpiderInit;
import com.hyh.resource.URLSource;
import com.hyh.spider.parse.ParseImpl;

public class ParseHtmlTask implements Runnable {
	private ThreadLocal<List<String>> currentTasks = new ThreadLocal<List<String>>();
	private URLSource source;
	public ParseHtmlTask(List<String> tasks, URLSource source) {
		// TODO Auto-generated constructor stub
		currentTasks.set(tasks);
		this.source = source;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<String> tasks = currentTasks.get();
		for (String task:tasks) {
			Set<String> youWant = new ParseImpl().parseYouWant(task, SpiderInit.getHtmlTargetCss(), SpiderInit.getHtmlAttributeName());
			Pattern compile1 = Pattern.compile(SpiderInit.getHtmlPathRegex());
			Pattern compile = Pattern.compile(SpiderInit.getSourcePathRegex());
			for (String url : youWant) {
				Matcher matcher = compile.matcher(url);
				if (matcher.find()) {
					source.addImg(matcher.group());
					System.out.println(url);
				}else {
					Matcher matcher1 = compile1.matcher(url);
					if (matcher1.find()) {
						String currentTask = matcher1.group();
						if (!currentTask.equals(task)) {
							source.addPage(currentTask);
							System.out.println("下一页：  "+currentTask);
						}
					}
				}
			}
			System.out.println(task+"  网页解析完成......");
		}
	}

}
