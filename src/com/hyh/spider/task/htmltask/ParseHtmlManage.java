package com.hyh.spider.task.htmltask;

import java.util.List;
import java.util.concurrent.ExecutorService;

import com.hyh.resource.URLSource;

public class ParseHtmlManage implements Runnable {
	private URLSource source;
	private ExecutorService pool;
	public ParseHtmlManage(URLSource source, ExecutorService pool) {
		// TODO Auto-generated constructor stub
		this.source = source;
		this.pool = pool;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			List<String> list = getSource(source);
			System.out.println("执行网页解析......");
			System.out.println(list);
			pool.submit(()->{
				new ParseHtmlTask(list, source).run();
			});
			System.out.println(pool);
			try {
				Thread.sleep(180000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("网页解析线程中断，线程退出......");
			}
		}
	}
	public List<String> getSource(URLSource source) {
		return source.getHtmlPaths();
	}
}
