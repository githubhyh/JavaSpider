package com.hyh.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import com.hyh.resource.ThreadPoolSource;

public class FunctionTest {
	public static void main(String[] args) {
//		WebDriver driver = MyDriverUtil.getInstance();
//		driver.get("http://thz7.net/thread-768005-1-876.html");
//		List<WebElement> elements = driver.findElements(By.cssSelector("img"));
//		for (WebElement e : elements) {
//			String attribute = e.getAttribute("file");
//			System.out.println(attribute);
//		}
//		Load loadImpl = new LoadImpl();
//		WebDriver driver = loadImpl.loadPage("http://thz7.net/thread-768005-1-876.html", 4, TimeUnit.SECONDS);
//		System.out.println(driver.manage().timeouts());
		
//		Set<String> youWant = new ParseImpl().parseYouWant("http://thz7.net/thread-768005-1-876.html", "img", "file");
//		for (String value:youWant) {
//			System.out.println(value);
//		}
		
//		ExecutorService service = ThreadPoolSource.getInstance();
//		service.submit(()->{
//			System.out.println(service);
//		});
		
//		List<String> tasks = new ArrayList<String>();
//		tasks.add("http://thz7.net/thread-768005-1-876.html");
//		new ParseSourceTask(tasks).run();/JavaSpider/src/com/hyh/spider/task/htmltask/ParseHtmlManage.java
//		Runnable task = null;
//		try {
//			task = new ManageCenter().getTask(Class.forName("com.hyh.spider.task.htmltask.ParseHtmlManage"));
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(task);
//		new DownloadTask("http://www.xoimg.club/u/20190910/13153476.jpg").
//		download("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1571311150015&di=429541a4f2756e2cdfc01f84e58cf384&imgtype=0&src=http%3A%2F%2Fu.moimg.net%2Fueditor%2Fimage%2F20150125%2F1422187989223363.gif");
		ExecutorService pool = ThreadPoolSource.getInstance();
		System.out.println("start");
		pool.submit(()->{
			//Thread.sleep(2000);
			System.out.println("任务完成");
		});
		boolean termination = false;
		try {
			termination = pool.awaitTermination(3, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("done");
		System.out.println(termination);
		pool.submit(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("开始新任务");
			}
		});
	}

}
