package com.hyh.test;

import javax.swing.JOptionPane;

import com.hyh.manage.ManageCenter;
import com.hyh.spider.task.htmltask.ParseHtmlManage;
import com.hyh.spider.task.imgtask.ParseSourceManage;

public class MainFunction {
	public static void main(String[] args) {
		ManageCenter manageCenter = new ManageCenter();
		manageCenter.init();
		manageCenter.submitTask(ParseHtmlManage.class, ParseSourceManage.class);
		manageCenter.start();
		int dialog = JOptionPane.showConfirmDialog(null, "停止爬虫...", "爬虫正在运行...", JOptionPane.YES_NO_OPTION);
		if (dialog == JOptionPane.YES_OPTION) {
			manageCenter.shutdownNow();
		}
	}
}
