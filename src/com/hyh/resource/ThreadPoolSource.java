package com.hyh.resource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hu.yuhao
 * a线程池
 * */
public class ThreadPoolSource {
	private static ExecutorService pool;
	private ThreadPoolSource() {}
	
	public static ExecutorService getInstance() {
		if (pool == null) {
			synchronized (ThreadPoolSource.class) {
				if (pool == null) {
					pool = Executors.newFixedThreadPool(Integer.parseInt(SpiderInit.getThreadPoolSize()));
				}
			}
		}
		return pool;
	}
}
