/**
  * @filename NewsCrawler.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.crawler;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.net.HttpRequest;
import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

 /**
 * @type NewsCrawler
 * @description 抓取 合肥工业大学网站 新闻内容
 * @author qianye.zheng
 */
public class NewsCrawler extends BreadthCrawler
{

	/**
	 * @description 构造方法
	 * @param crawlPath 伯克利DB使用的文件夹 crawl
	 * @param autoParse
	 * @author qianye.zheng
	 */
	public NewsCrawler(String crawlPath, boolean autoParse)
	{
		super(crawlPath, autoParse);
		
		/*
		 * 添加种子，一个或多个
		 * 种子即爬虫的起始页面.
		 */
		this.addSeed("http://news.hfut.edu.cn/list-1-1.html");
		/*
		 * 添加正则，可以调用多次
		 * + 表示包括，- 表示排除，默认是 +.
		 */
		//this.addRegex(urlRegex);
		this.addRegex("http://news.hfut.edu.cn/show-.*html");
		// 不抓取 url 中含有以下的
		this.addRegex("-.*\\.(jpg|png|gif).*");
		// 不抓取含有 url 中含有 #的
		this.addRegex("-.*#.*");
		
	}

	/**
	 * @description 每个正在爬取的页面需要进行操作
	 * @param page
	 * @param next
	 * @author qianye.zheng
	 */
	@Override
	public void visit(Page page, CrawlDatums next)
	{
		/*
		 * 把抓取的数据的处理逻辑放在此方法中，
		 * 例如可以将抓取的进行处理输出或存储到数据源等
		 */
		String url = page.getUrl();
		if (page.matchUrl("http://news.hfut.edu.cn/show-.*html"))
		{
			Document doc = page.doc();
			// 解析获取标题
			/**
			 * 
			 * h2标签的结构，需要深入处理才能获取纯净的标题
			 * [学校隆重集会庆祝第三十个教师节, <br>,  , <span class="t">发布日期：
			 * 2014-09-11&nbsp;&nbsp;通讯员:王建&nbsp;&nbsp;字号：<a href="javascript:doZoom(18)"><span class="f18">
			 * 大</span></a> <a href="javascript:doZoom(16)"><span class="f16">中</span></a> 
			 * <a href="javascript:doZoom(14)"><span class="f14">小</span></a>&nbsp;&nbsp;
			 * 【<a href="/print-1-12727-1.html" target="_blank">打印</a>】</span>]
			 */
			//String title = page.select("div[id=Article]>h2").first().text();
			String title = null;
			Element titleElement = page.select("div[id=Article]").select("h2").first();
			
			title = titleElement.childNode(0).toString();
			// first()
			String content = page.select("div#artibody", 0).text();
			
			// 输出
			System.out.println("url: " + url);
			System.out.println("title : " + title);
			System.out.println("content : " + content);
		}
	}

	
	/**
	 * @description 
	 * @param crawlDatum
	 * @return
	 * @throws Exception
	 * @author qianye.zheng
	 */
	@Override
	public HttpResponse getResponse(CrawlDatum crawlDatum) throws Exception
	{
		 HttpRequest request = new HttpRequest(crawlDatum);
		 request.setTimeoutForRead(5 * 1000);
		
		return super.getResponse(crawlDatum);
	}
}
