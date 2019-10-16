package com.hyh.manage;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.hyh.resource.SpiderInit;
import com.hyh.resource.ThreadPoolSource;
import com.hyh.resource.URLSource;
import com.hyh.sync.SyncFile;
import com.hyh.util.file.FileUtil;

public class ManageCenter {
	private ExecutorService pool = ThreadPoolSource.getInstance();
	private URLSource source = URLSource.getInstance();
	private ExecutorService managePool = Executors.newFixedThreadPool(4);
	
	private List<Runnable> manageList = new ArrayList<Runnable>();
	
	//任务管理器注入
	public void submitTask(Runnable...tasks) {
		for (Runnable task:tasks) {
			manageList.add(task);
		}
	}
	
	public void submitTask(Class<?>...tasksClass) {
		for (Class<?> temp:tasksClass) {
			manageList.add(getTask(temp));
		}
	}
	
	//启动任务管理器
	public void start() {
		for (Runnable task:manageList) {
			managePool.submit(task);
		}
	}
	
	//关闭任务管理器，且将内存中的资源写入文件，下次接着爬取
	/***/
	public void shutdownNow() {
		SyncFile.getInstance().close();
	}
	
	public void init() {
		System.out.println("资源初始化......");
		List<String> htmls = FileUtil.readSource(SpiderInit.getHtmlCachePath());
		List<String> sources = FileUtil.readSource(SpiderInit.getImgCachePath());
		source.addHtmls(htmls);
		source.addImgs(sources);
		System.out.println("初始化完成......");
	}
	
	/**
	 * @author hu.yuhao
	 * a反射获取任务管理器
	 * */
	public Runnable getTask(Class<?> clazz) {
		Runnable task = null;
		try {
			Constructor<?> constructor = clazz.getConstructor(URLSource.class, ExecutorService.class);
			task = (Runnable)constructor.newInstance(source, pool);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("反射构建时产生错误......");
			e.printStackTrace();
		}
		return task;
	}
}
