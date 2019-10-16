package com.hyh.spider.task.imgtask;

import java.util.List;
import java.util.concurrent.ExecutorService;

import com.hyh.resource.URLSource;

public class ParseSourceManage implements Runnable {
	private URLSource source;
	private ExecutorService pool;
	public ParseSourceManage(URLSource source, ExecutorService pool) {
		// TODO Auto-generated constructor stub
		this.source = source;
		this.pool = pool;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			List<String> list = getSource(source);
			System.out.println("执行资源解析......");
			System.out.println(list);
			pool.submit(()->{
				new ParseSourceTask(list).run();
			});
			System.out.println(pool);
			try {
				Thread.sleep(35000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("资源解析中断，线程已经退出......");
			}
		}
	}
	
	public List<String> getSource(URLSource source) {
		return source.getImgPaths();
	}
}