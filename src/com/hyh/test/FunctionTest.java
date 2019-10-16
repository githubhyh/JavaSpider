package com.hyh.test;

import com.hyh.manage.ManageCenter;

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
		Runnable task = null;
		try {
			task = new ManageCenter().getTask(Class.forName("com.hyh.spider.task.htmltask.ParseHtmlManage"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(task);
	}

}
