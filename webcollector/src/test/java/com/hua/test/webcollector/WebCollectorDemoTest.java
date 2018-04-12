/**
 * 描述: 
 * WebCollectorDemoTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.webcollector;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.crawler.ImageDrawler;
import com.hua.crawler.NewsCrawler;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * WebCollectorDemoTest
 */
public final class WebCollectorDemoTest extends BaseTest {

	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testWebCollectorDemo() {
		try {
			
			
		} catch (Exception e) {
			log.error("testWebCollectorDemo =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 抓取 合肥工业大学网站 新闻内容
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCrawlHeFeiGongYeUniversityNews() {
		try {
			NewsCrawler newsCrawler = new NewsCrawler("crawl", true);
			// 设置线程个数
			newsCrawler.setThreads(50);
			// 每次迭代爬取的网页数量上限
			newsCrawler.setTopN(100);
			// 是否断点爬取 
			newsCrawler.setResumable(false);
			// 设置 迭代次数 并且开始爬取
			newsCrawler.start(4);
		} catch (Exception e) {
			log.error("testCrawlHeFeiGongYeUniversityNews =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 抓取 图片
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCrawlImage() {
		try {
			ImageDrawler imageDrawler = new ImageDrawler("crawl", true);
			/*
			 * 添加种子，一个或多个
			 * 种子即爬虫的起始页面.
			 */
			//imageDrawler.addSeed("http://news.hfut.edu.cn/list-1-1.html");
			imageDrawler.addSeed("http://hotels.ctrip.com/hotel/18453.html");
			// 设置线程个数
			imageDrawler.setThreads(50);
			// 每次迭代爬取的网页数量上限
			imageDrawler.setTopN(100);
			// 是否断点爬取 
			imageDrawler.setResumable(false);
			// 设置 迭代次数 并且开始爬取
			imageDrawler.start(4);
			
		} catch (Exception e) {
			log.error("testCrawlImage =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 抓取 图片
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCrawlImage2() {
		try {
			ImageDrawler imageDrawler = new ImageDrawler("crawl", true);
			/*
			 * 添加种子，一个或多个
			 * 种子即爬虫的起始页面.
			 */
			imageDrawler.addSeed("https://www.flickr.com/photos/lucasantoro/17548347312/sizes/l");
			// 设置线程个数
			imageDrawler.setThreads(50);
			// 每次迭代爬取的网页数量上限
			imageDrawler.setTopN(100);
			// 是否断点爬取 
			imageDrawler.setResumable(false);
			// 设置 迭代次数 并且开始爬取
			imageDrawler.start(4);
			
		} catch (Exception e) {
			log.error("testCrawlImage2 =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}
