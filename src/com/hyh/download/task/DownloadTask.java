package com.hyh.download.task;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

import com.hyh.download.content.ContentType;
import com.hyh.resource.SpiderInit;

public class DownloadTask implements Runnable {
	private String url = new String();
	public DownloadTask(String url) {
		// TODO Auto-generated constructor stub
		this.url = url;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		download(url);
	}
	
	public void download(String srcUrl) {
		try {
			URL url = new URL(srcUrl);
			URLConnection urlConnection = url.openConnection();
			urlConnection.setDoInput(true);
			urlConnection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			String contentType = urlConnection.getContentType();
			String suffix = ContentType.getSuffix(contentType);
			InputStream inputStream = urlConnection.getInputStream();
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			File temp = new File(SpiderInit.getDownloadSavePath() + uuid + suffix);
			DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(temp));
			byte[] buffer = new byte[4096];
			int count = 0;
			while ((count = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, count);
			}
			outputStream.flush();
			outputStream.close();
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(srcUrl+"   资源下载错误......");
		}
	}

}
