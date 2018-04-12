/**
  * @filename ImageDrawler.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.crawler;

import java.util.Date;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

import com.hua.util.FileUtil;
import com.hua.util.ProjectUtil;
import com.hua.util.StringUtil;

 /**
 * @type ImageDrawler
 * @description 图片抓取器
 * @author qianye.zheng
 */
public class ImageDrawler extends BreadthCrawler
{
	private static final String path = ProjectUtil.getAbsolutePath("/doc/download", true);
	
	/**
	 * @description 构造方法
	 * @param crawlPath
	 * @param autoParse
	 * @author qianye.zheng
	 */
	public ImageDrawler(String crawlPath, boolean autoParse)
	{
		super(crawlPath, autoParse);
	}

	/**
	 * @description 
	 * @param page
	 * @param next
	 * @author qianye.zheng
	 */
	@Override
	public void visit(Page page, CrawlDatums next)
	{
		/*
		 * 根据http头中的Content-Type信息判断当前资源是网页还是图片
		 */
		String contentType = page.getResponse().getContentType();
		if (StringUtil.isEmpty(contentType))
		{
			return ;
		} else if (contentType.contains("html"))
		{ // html 则抽取其中包含图片的url，放入后续任务
			Elements imgs = page.select("img[src]");
			for (Element img : imgs)
			{
				String imgSrc = img.attr("abs:src");
				next.add(imgSrc);
			}
		} else if (contentType.startsWith("image"))
		{ // 如果是图片直接下载
			String extensionName = contentType.split("/")[1];
			String imageFilename = new Date().getTime() + "." + extensionName;
			// 保存文件
			FileUtil.writeByteArray(path + "/" + imageFilename, page.getContent());
		}
		
		
		
	}

}
