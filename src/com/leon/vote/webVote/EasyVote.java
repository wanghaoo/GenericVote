package com.leon.vote.webVote;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;
/**
 * 简单网页投票
 * @author leon
 * @date 2016-07-12
 * @version java7
 */
public class EasyVote {
	public static final String URL = "http://tp.cvnews.com.cn/toupiao.php";
	/**
	 * 投票
	 * @param url   需要投票的url
	 * @throws IOException
	 */
	public static void vote(String url, String param) throws IOException {
		URL _url = new URL(url);
		HttpURLConnection _hc = (HttpURLConnection)_url.openConnection();
		_hc.setRequestMethod("POST");
		// 设置通用的请求属性
//		_hc.setRequestProperty("Accept-Encoding", "gzip");
//		_hc.setRequestProperty("Accept-Language", "zh-CN");
		_hc.setRequestProperty("Content-Length", "11");
		_hc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		_hc.setRequestProperty("Cookie", "a1292_pages=1; a1292_times=1");
		_hc.setRequestProperty("Host", "tp.cvnews.com.cn");
		_hc.setRequestProperty("Origin", "http://tp.cvnews.com.cn");
		_hc.setRequestProperty("Referer", "http://tp.cvnews.com.cn/index.php?t=1468114490");
		_hc.setRequestProperty("X-Requested-With", "XMLHttpRequest");
		_hc.setRequestProperty("accept", "*/*");
		_hc.setRequestProperty("connection", "Keep-Alive");
		_hc.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		_hc.setDoInput(true);
		_hc.setDoOutput(true);
		PrintWriter _pw = new PrintWriter(_hc.getOutputStream());
		_pw.print(param);
		_pw.flush();
		_pw.close();
		Scanner _scanner = new Scanner(_hc.getInputStream());
		while(_scanner.hasNext()) {
			System.out.println(_scanner.nextLine());
		}
		_scanner.close();
		_hc.disconnect();
	}
	
	public static void main(String[] args) {
		try {
			vote(URL, "cid=0&id=21");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
