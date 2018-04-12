/**
 * 描述: 
 * FetchImgServiceTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.fetch;

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

import com.hua.service.FetchImgService;
import com.hua.test.BaseTest;
import com.hua.util.FileUtil;
import com.hua.util.ProjectUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * FetchImgServiceTest
 */
public final class FetchImgServiceTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFetchAllImg() {
		try {
			String url = "http://www.qyer.com/photo/19069726/?spm=allphoto";
			url = "http://www.qyer.com/photo/19263812/?spm=allphoto";
			url = "http://jingyan.baidu.com/article/4ae03de31cc08b3eff9e6be6.html";
			url = "http://www.qyer.com/photo/19069725/?spm=allphoto";
			url = "http://hotels.ctrip.com/hotel/18453.html";
			FetchImgService service = new FetchImgService();
			service.fetchAllImg(url);
			
			
		} catch (Exception e) {
			log.error("testFetchAllImg =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFetchBigImg() {
		try {
			String url = "http://www.qyer.com/photo/19069726/?spm=allphoto";
			url = "http://www.qyer.com/photo/19263812/?spm=allphoto";
			url = "http://baike.baidu.com/link?url=8P1ZVy5G0fZQSVCHMfB7x8jOPKPBwUhTXbbh783eNOva6XdVxV3JyIxPSo8hvdvs-8m5LM9DaJ4VPtOFWLWBCtw7Uxkrqe8vJ7pzKdMSSMu";
			url = "https://www.baidu.com/s?wd=%E4%BA%91%E6%BA%AA&rsv_spt=1&rsv_iqid=0xf1e73ade000018e9&issp=1&f=8&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_sug3=7&rsv_sug1=6&rsv_sug7=100";
			url = "http://jingyan.baidu.com/article/4ae03de31cc08b3eff9e6be6.html";
			FetchImgService service = new FetchImgService();
			service.fetchBigImg(url);
			
		} catch (Exception e) {
			log.error("testFetchBigImg =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDeleteDir() {
		try {
			String tempBasePath = ProjectUtil.getAbsolutePath("/temp", true) + "/";
			FileUtil.deleteDirectory(tempBasePath);
			
		} catch (Exception e) {
			log.error("testDeleteDir =====> ", e);
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
