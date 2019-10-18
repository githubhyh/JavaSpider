package com.hyh.sync;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.hyh.resource.SpiderInit;

/**
 * @author hu.yuhao
 * 文件高并发写入
 * */
public class SyncFile {
	private static File file = null;
	private static FileOutputStream fos = null;
	private static BufferedOutputStream bos = null;
	private static SyncFile syncFile = null;
	private SyncFile() {}
	
	static {
		try {
			file = new File(SpiderInit.getSourceSavePath());
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("并发文件产生错误......");
		}
	}
	
	public static SyncFile getInstance() {
		if (syncFile == null) {
			synchronized (SyncFile.class) {
				if (syncFile == null) {
					syncFile = new SyncFile();
				}
			}
		}
		return syncFile;
	}
	
	public synchronized void writeSourceToFile(String data, String destPath) {
		try {
			bos.write(data.getBytes());
			bos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("资源文件写入错误......");
		}
	}
	
	
	public void close() {
		try {
			if (bos != null) {
				bos.flush();
				bos.close();
			}
			if (fos != null) {
				fos.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("关闭并发文件流时产生错误......");
		}
	}
}
