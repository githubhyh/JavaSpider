package com.hyh.download.download;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.hyh.download.parse.URLParse;
import com.hyh.download.task.DownloadTask;
import com.hyh.resource.SpiderInit;

public class DownloadManage {
	private Set<List<String>> urls = new HashSet<List<String>>();
	private ExecutorService pool;
	private final static int taskNum = Integer.parseInt(SpiderInit.getSourceTaskNum());
	public void init() {
		urls = new URLParse().parseUrl(SpiderInit.getSourceSavePath());
	}
	public void start() {	
		for (List<String> list:urls) {
			int count = 0;
			Iterator<String> iterator = list.iterator();
			while (iterator.hasNext()) {
				count++;
				pool.submit(new DownloadTask(iterator.next()));
				if (count%taskNum == 0||!iterator.hasNext()) {
					count=0;
					pool.shutdown();
					try {
						pool.awaitTermination(20, TimeUnit.SECONDS);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println("下载超时，线程退出......");
					}
					System.out.println("下载完成......");
					pool = Executors.newFixedThreadPool(taskNum);
				}
			}
		}
	}
}
