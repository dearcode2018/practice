/**
  * @filename FetchImgService.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.hua.util.FileUtil;
import com.hua.util.IOUtil;
import com.hua.util.ProjectUtil;
import com.hua.util.StringUtil;

 /**
 * @type FetchImgService
 * @description 
 * @author qianye.zheng
 */
public class FetchImgService
{
	/* apache commons log */
	protected Log log = LogFactory.getLog(this.getClass().getName());
	
	private static final String relativePath = "/download";
	
	private static final String tempRelativePath = "/temp";
	
	/**
	 * 以http或https开头的，直接通过流的方式去获取图片
	 * 
	 * 以/开头的或其他非http或https开头的，需要拼接url的主机地址然后再获取图片
	 */
	
	/**
	 * 
	 * @description 抓取所有
	 * @param url
	 * @author qianye.zheng
	 */
	public void fetchAllImg(final String url)
	{
		try
		{
			final String baseUri = getBaseUri(url);
			final URL urlObj = new URL(url);
			final Document document = Jsoup.parse(urlObj, 20 * 1000);
			final Elements elements = document.getElementsByTag("img");
			final Iterator<Element> it = elements.iterator();
			Element element = null;
			String srcValue = null;
			URL imgUrl = null;
			InputStream inputStream = null;
			OutputStream outputStream = null;
			final String basePath = ProjectUtil.getAbsolutePath(relativePath, true) + "/";
			String path = null;
			while (it.hasNext())
			{
				try
				{
					element = it.next();
					srcValue = element.attr("src");
					if (StringUtil.isEmpty(srcValue) || StringUtil.isEmpty(srcValue.trim()))
					{
						continue;
					}
					srcValue = getFullUrl(baseUri, srcValue);
					log.info("imgUrl = " + srcValue);
					imgUrl = new URL(srcValue);
					inputStream = imgUrl.openStream();
					path = basePath + new Date().getTime() + ".png";
					outputStream = new FileOutputStream(path);
					IOUtil.transport(inputStream, outputStream);
					outputStream.close();
					inputStream.close();
				} catch (final Exception e)
				{
					e.printStackTrace();
					continue;
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @description 抓取大图
	 * 在多个图片中，判断哪个图片最大，则取哪一个
	 * @param url
	 * @author qianye.zheng
	 */
	public void fetchBigImg(final String url)
	{
		final String tempBasePath = ProjectUtil.getAbsolutePath(tempRelativePath, true) + "/";
		final String basePath = ProjectUtil.getAbsolutePath(relativePath, true) + "/";
		final String baseUri = getBaseUri(url);
		try
		{
			final URL urlObj = new URL(url);
			final Document document = Jsoup.parse(urlObj, 20 * 1000);
			final Elements elements = document.getElementsByTag("img");
			final Iterator<Element> it = elements.iterator();
			Element element = null;
			String srcValue = null;
			URL imgUrl = null;
			InputStream inputStream = null;
			OutputStream outputStream = null;
			final File tempFile = new File(tempBasePath);
			// 创建新的临时目录
			if (tempFile.exists())
			{
				// 存在先删除
				tempFile.mkdirs();
			}
			tempFile.mkdirs();
			String path = null;
			while (it.hasNext())
			{
				try
				{
					element = it.next();
					srcValue = element.attr("src");
					if (StringUtil.isEmpty(srcValue) || StringUtil.isEmpty(srcValue.trim()))
					{
						continue;
					}
					srcValue = getFullUrl(baseUri, srcValue);
					log.info("imgUrl = " + srcValue);
					imgUrl = new URL(srcValue);
					inputStream = imgUrl.openStream();
					path = tempBasePath + new Date().getTime() + ".png";
					outputStream = new FileOutputStream(path);
					IOUtil.transport(inputStream, outputStream);
					outputStream.close();
					inputStream.close();
				} catch (final Exception e)
				{
					e.printStackTrace();
					continue;
				}
			}
			
			// 遍历循环，找出最大图片，然后拷贝到指定目录，然后再全部删除所有图片
			final File file = new File(tempBasePath);
			final File[] files = file.listFiles();
			final long[] sizes = new long[files.length];
			for (int i = 0; i < files.length; i++)
			{
				sizes[i] = files[i].length();
			}
			// 找出最大的
			final long maxLength = NumberUtils.max(sizes);
			for (int i = 0; i < files.length; i++)
			{
				if (maxLength == files[i].length())
				{ // 找出最大的，然后拷贝到指定目录
					FileUtil.copy(files[i], basePath);
				}
			}
		} catch (final Exception e)
		{
			e.printStackTrace();
		} finally
		{ // 删除临时目录
			// 删除临时目录
			FileUtil.deleteDirectory(tempBasePath);
		}
	}
	
	/**
	 * 
	 * @description 获取完整的url
	 * @param baseUri
	 * @param url
	 * @return
	 * @author qianye.zheng
	 */
	private static final String getFullUrl(final String baseUri, final String url)
	{
		if (url.startsWith("http") || url.startsWith("https"))
		{
			return url;
		} else
		{
			return baseUri + url;
		}
	}
	
	/**
	 * 
	 * @description 
	 * @param uri
	 * @return
	 * @author qianye.zheng
	 */
	private static final String getBaseUri(final String uri)
	{
		/*
		 * http://news.mydrivers.com/1/488/488036.htm
		 * 应该截取 http://news.mydrivers.com 部分
		 */
		String result = null;
		if (StringUtil.isNotEmpty(uri))
		{
			if (uri.startsWith("http://"))
			{
				result = uri.substring(0, uri.indexOf("/", "http://".length()));
			} else if (uri.startsWith("https://"))
			{
				result = uri.substring(0, uri.indexOf("/", "https://".length()));
			}
		}
		
		return result;
	}
	
	@Test
	public void test()
	{
		String uri = null;
		uri = "http://news.mydrivers.com/1/488/488036.htm";
		System.out.println(getBaseUri(uri));
		uri = "https://news.mydrivers.com/1/488/488036.htm";
	}
	
}
