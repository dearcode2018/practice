/**
 * 描述: 
 * FetchHtmlTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.spider;

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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.StringUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * FetchHtmlTest
 */
public final class FetchHtmlTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFetchCommentOnCsdn() {
		try {
			/*
			 * 抓取论坛的评论，自动分页抓取
			 */
			String url = null;
			url = "http://bbs.csdn.net/topics/392030381";
			//url = "http://bbs.csdn.net";
			//url = "http://bbs.csdn.net/home";
			/*
			 * 异常点: 
			 */
			// __utma=17226283.539636829.1435122294.1445220619.1457609818.66; __gads=ID=dc4472ddd894e26e:T=1435122027:S=ALNI_MYfG0GOmMJixT6sYjHMRc_YyyXzhA; __qca=P0-23322922-1435122301719; __message_sys_msg_id=0; __message_gu_msg_id=0; __message_cnel_msg_id=0; uuid_tt_dd=-4864961603933155797_20150624; bdshare_firstime=1435568916071; _ga=GA1.2.539636829.1435122294; UN=dearzqy; UE="dearzqy@163.com"; lzstat_uv=2528399020472260363|3582543@2912261@3599144; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1462250592; BT=1462601099087; __message_in_school=0; __message_district_code=000000; dc_tos=oeyte7; _csdn_newbbs_session=BAh7B0kiD3Nlc3Npb25faWQGOgZFRkkiJTI3ZjE0YmFmYzI2MmQwYTUzYjllOTNlYzI2ZTU2NjZlBjsAVEkiEF9jc3JmX3Rva2VuBjsARkkiMWtNL0MvQldQUUFhWEp6Z2pOL1MybDFJU0FSVmxCU1FVOW1yUDRYTjFEdTg9BjsARg%3D%3D--b70b7f918935f7b7ca4b36e9587ab33b7ea4c288; dc_session_id=1476326744360
			Connection connection = Jsoup.connect(url);	
			connection.cookie("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			connection.cookie("Accept-Encoding", "gzip");
			connection.cookie("Host", "bbs.csdn.net");
			connection.cookie("Connection", "keep-alive");
			connection.cookie("Cache-Control", "max-age=0");
			connection.cookie("Content-Type", "application/x-www-form-urlencoded");
			connection.cookie("Content-Language", "zh-cn");
			connection.cookie("Connection", "keep-alive");
			connection.cookie("Upgrade-Insecure-Requests", "1");
			//connection.cookie("Cache-Control", "no-cache");
			connection.cookie("User-Agent", "Mozilla/31.0 (compatible; MSIE 10.0; Windows NT; DigExt)");
			//connection.cookie("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0");
			//connection.cookie("Cookie", "__utma=17226283.539636829.1435122294.1445220619.1457609818.66; __gads=ID=dc4472ddd894e26e:T=1435122027:S=ALNI_MYfG0GOmMJixT6sYjHMRc_YyyXzhA; __qca=P0-23322922-1435122301719; __message_sys_msg_id=0; __message_gu_msg_id=0; __message_cnel_msg_id=0; uuid_tt_dd=-4864961603933155797_20150624; bdshare_firstime=1435568916071; _ga=GA1.2.539636829.1435122294; UN=dearzqy; UE=\"dearzqy@163.com\"; lzstat_uv=2528399020472260363|3582543@2912261@3599144; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1462250592; BT=1462601099087; __message_in_school=0; __message_district_code=000000; dc_tos=oeyte7; _csdn_newbbs_session=BAh7B0kiD3Nlc3Npb25faWQGOgZFRkkiJTI3ZjE0YmFmYzI2MmQwYTUzYjllOTNlYzI2ZTU2NjZlBjsAVEkiEF9jc3JmX3Rva2VuBjsARkkiMWtNL0MvQldQUUFhWEp6Z2pOL1MybDFJU0FSVmxCU1FVOW1yUDRYTjFEdTg9BjsARg%3D%3D--b70b7f918935f7b7ca4b36e9587ab33b7ea4c288; dc_session_id=1476326744360");
			//connection.cookie("Cookie", "UserInfo=cnick; __utma=17226283.539636829.1435122294.1445220619.1457609818.66; __gads=ID=dc4472ddd894e26e:T=1435122027:S=ALNI_MYfG0GOmMJixT6sYjHMRc_YyyXzhA; __qca=P0-23322922-1435122301719; __message_sys_msg_id=0; __message_gu_msg_id=0; __message_cnel_msg_id=0; uuid_tt_dd=-4864961603933155797_20150624; bdshare_firstime=1435568916071; _ga=GA1.2.539636829.1435122294; UN=dearzqy; UE=\"dearzqy@163.com\"; lzstat_uv=2528399020472260363|3582543@2912261@3599144; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1476329822; BT=1462601099087; __message_in_school=0; __message_district_code=000000; dc_tos=oeywc8; dc_session_id=1476329822013; _csdn_newbbs_session=BAh7B0kiD3Nlc3Npb25faWQGOgZFRkkiJTI3ZjE0YmFmYzI2MmQwYTUzYjllOTNlYzI2ZTU2NjZlBjsAVEkiEF9jc3JmX3Rva2VuBjsARkkiMWtNL0MvQldQUUFhWEp6Z2pOL1MybDFJU0FSVmxCU1FVOW1yUDRYTjFEdTg9BjsARg%3D%3D--b70b7f918935f7b7ca4b36e9587ab33b7ea4c288; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1476329822");
			//connection.cookie("Cookie", "UserName=; path=/; expires=Thu, 01-Jan-1970 00:00:00 GMT");
			//connection.cookie("Cookie", "UserInfo=; path=/; expires=Thu, 01-Jan-1970 00:00:00 GMT");
			connection.cookie("Cookie", "UserInfo=cnick; __utma=17226283.539636829.1435122294.1445220619.1457609818.66; __gads=ID=dc4472ddd894e26e:T=1435122027:S=ALNI_MYfG0GOmMJixT6sYjHMRc_YyyXzhA; __qca=P0-23322922-1435122301719; __message_sys_msg_id=0; __message_gu_msg_id=0; __message_cnel_msg_id=0; uuid_tt_dd=-4864961603933155797_20150624; bdshare_firstime=1435568916071; _ga=GA1.2.539636829.1435122294;lzstat_uv=2528399020472260363|3582543@2912261@3599144; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1476329822; BT=1462601099087; __message_in_school=0; dc_session_id=1476347461483; _csdn_newbbs_session=BAh7B0kiD3Nlc3Npb25faWQGOgZFRkkiJTI3ZjE0YmFmYzI2MmQwYTUzYjllOTNlYzI2ZTU2NjZlBjsAVEkiEF9jc3JmX3Rva2VuBjsARkkiMWtNL0MvQldQUUFhWEp6Z2pOL1MybDFJU0FSVmxCU1FVOW1yUDRYTjFEdTg9BjsARg%3D%3D--b70b7f918935f7b7ca4b36e9587ab33b7ea4c288; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1476329822; dc_tos=oez8zp; __message_district_code=000000; UserInfo=cnick");
			//connection.referrer("http://bbs.csdn.net/topics/392030381");
			// 设置请求参数
			//connection.data("param1", "value1");
			//connection.data("page", "1");
			Document document = null;
			Elements elements = null;
			Element element = null;
			// 设置超时时间
			connection.timeout(5 * 1000);
			// 请求方法 生成文档对象，从文档对象中去获取
			/*
			 * 参数放在url中就使用get方法
			 */
			document = connection.get();
			//document = connection.post();
			
			/*
			 * 通过人工分析html结构，从中提取需要的成分
			 */
			elements = document.getElementsByClass("post_body");
			// 评论内容
			String comment = null;
			if (null != elements && !elements.isEmpty())
			{
				for (int i = 0; i < elements.size(); i++)
				{
					element = elements.get(i);
					comment = element.html();
					System.out.println("第 " + (i + 1) + " 楼层" + comment);
				}
			}
			
			
		} catch (Exception e) {
			log.error("testFetchCommentOnCsdn =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFetchHtml001() {
		try {
			/*
			 * 抓取论坛的评论，自动分页抓取
			 */
			String url = null;
			url = "http://10.100.112.55/bug-browse.html";
			url = "http://10.100.112.55/bug-browse-13-byModule-125.html";
			/*
			 * 异常点: 
			 */
			Connection connection = Jsoup.connect(url);
			connection.cookie("Cookie", "lang=zh-cn; theme=default; keepLogin=on; za=zhengqianye; zp=d8b1089f7f4ab151bcd733d8f757b13fe7c68f47; lastProduct=13; qaBugOrder=assignedTo_desc; sid=1oem72r04iahen7egepq5mcqi5; selfClose=0; windowWidth=1903; windowHeight=566");
			// 设置请求参数
			//connection.data("param1", "value1");
			//connection.data("page", "1");
			Document document = null;
			Elements elements = null;
			Element element = null;
			// 设置超时时间
			connection.timeout(5 * 1000);
			// 请求方法 生成文档对象，从文档对象中去获取
			/*
			 * 参数放在url中就使用get方法
			 */
			document = connection.get();
			//document = connection.post();
			
			// 获取host
			final String currentPath = url.substring(0, url.indexOf("/", "http://".length()));
			
			// 获取导航列表url
			Element treeUl = document.getElementsByClass("tree").first();
			Elements navAs = treeUl.getElementsByTag("a");
			final Set<String> urls = new HashSet<String>();
			for (int i = 0; i < navAs.size(); i++)
			{
				urls.add(currentPath + navAs.get(i).attr("href"));
			}
			
			// 循环处理
			for (String u : urls)
			{
				connection = Jsoup.connect(u);
				connection.cookie("Cookie", "lang=zh-cn; theme=default; keepLogin=on; za=zhengqianye; zp=d8b1089f7f4ab151bcd733d8f757b13fe7c68f47; lastProduct=13; qaBugOrder=assignedTo_desc; sid=1oem72r04iahen7egepq5mcqi5; selfClose=0; windowWidth=1903; windowHeight=566");
				document = connection.get();
				/*
				 * 通过人工分析html结构，从中提取需要的成分
				 */
				elements = document.getElementsByClass("text-left");
				String value = null;
				Element td = null;
				Element a = null;
				for (int i = 0; i < elements.size(); i++)
				{
					td = elements.get(i);
					if (td.classNames().size() == 1)
					{ // 只有个class
						a = elements.get(i).getElementsByTag("a").first();
						value = a.html();
						System.out.println(value);
					}
				}
			}
			
			//FileUtil.writeString(new File(ProjectUtil.getAbsolutePath("/doc/m.html", true)), document.toString());
			//System.out.println(document.toString());
			
		} catch (Exception e) {
			log.error("testFetchHtml001 =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFetchHtml002() {
		try {
			/*
			 * 抓取论坛的评论，自动分页抓取
			 */
			String url = null;
			url = "http://www.cnblogs.com/BensonHe/p/3935677.html";
			/*
			 * 异常点: 
			 */
			Connection connection = Jsoup.connect(url);
			// 设置请求参数
			//connection.data("param1", "value1");
			//connection.data("page", "1");
			Document document = null;
			Elements elements = null;
			Element element = null;
			// 设置超时时间
			connection.timeout(5 * 1000);
			// 请求方法 生成文档对象，从文档对象中去获取
			/*
			 * 参数放在url中就使用get方法
			 */
			document = connection.get();
			//document = connection.post();
			System.out.println(document.toString());
			/*
			 * 通过人工分析html结构，从中提取需要的成分
			 */
			elements = document.getElementsByClass("catListPostCategory");
			String value = null;
			element = elements.first();
			
			Elements lis = element.getElementsByTag("ul").get(0).getElementsByTag("li");
			for (int i = 0; i < lis.size(); i++)
			{
				Element a = lis.get(i).getElementsByTag("a").first();
				value = a.html();
				System.out.println("导航: " + value);
			}
			
		} catch (Exception e) {
			log.error("testFetchHtml002 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testHttpClient() {
		try {
			String url = null;
			url = "http://bbs.csdn.net/topics/392030381";
			//url = "http://bbs.csdn.net";
			//url = "http://bbs.csdn.net/home";		
			URL urlObj = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0");
			connection.setRequestProperty("Accept", "textml,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			connection.setRequestProperty("Host", "api.laifudao.com");
			connection.setRequestProperty("Connection", "keep-alive");
			connection.setRequestProperty("Cache-Control", "max-age=0");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Content-Language", "zh-cn");
			connection.setRequestProperty("Connection", "keep-alive");
			connection.setRequestProperty("Cache-Control", "no-cache");
			connection.connect();
			InputStream inputStream = connection.getInputStream();
			// 对应的字符编码转换
			Reader reader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String str = null;
			StringBuffer sb = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				sb.append(str);
			}

			String firstCookie = "";
			// 获取cookie
			Map<String, List<String>> map = connection.getHeaderFields();
			Set<String> set = map.keySet();
			for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				if (!StringUtil.isEmpty(key) && key.equals("Set-Cookie")) {
					System.out.println("key=" + key + ",开始获取cookie");
					List<String> list = map.get(key);
					StringBuilder builder = new StringBuilder();
					for (String str1 : list) {
						log.info("testHttpClient =====> str1 = " + str1);
						builder.append(str1).toString();
					}
					firstCookie = builder.toString();
					//System.out.println("第一次得到的cookie=" + firstCookie);
				}
			}

			reader.close();
			connection.disconnect();
			System.out.println(firstCookie);
			//System.out.println(sb.toString());
			
		} catch (Exception e) {
			log.error("testHttpClient =====> ", e);
		}
	}
		
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFetchHtmlOfWX() {
		try {
			/*
			 * 在搜狗搜索引擎上搜索 https://www.sogou.com/ 相应的微信公众号或文章
			 */
			String url = null;
			url = "http://mp.weixin.qq.com/s?__biz=MjM5MTI0NjQ0MA==&mid=2655811774&idx=2&sn=a0d499ac8ba8a6c32822ac9c882597c0&scene=24&srcid=0805cp7y552iPg8UmhImQrhE#wechat_redirect";
			url = "http://mp.weixin.qq.com/s?timestamp=1476349668&src=3&ver=1&signature=gnYyQypI1IsIXeuxJoxPIPl2cZibdSGB2qur2il7xm9lE5uj2UjYJA*fWqDF1Kd5vBJFC3*fl7wKH*2BRz9s*NI8I2dJfFAtuoL-fzOZgyV2ptnwLswe1KK6H*BzBN0Hsdif7jQM-5FKIrf1JsMDqOBVtPmbq1kWwuYaaylzEF4=";
			Connection connection = Jsoup.connect(url);
			// 设置请求参数
			//connection.data("param1", "value1");
			//connection.data("page", "1");
			Document document = null;
			// 设置超时时间
			connection.timeout(5 * 1000);
			// 请求方法 生成文档对象，从文档对象中去获取
			/*
			 * 参数放在url中就使用get方法
			 */
			document = connection.get();
			//document = connection.post();
			System.out.println(document.toString());
			
		} catch (Exception e) {
			log.error("testFetchHtmlOfWX =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFetchJsonInWX() {
		try {
			/*
			 * 在搜狗搜索引擎上搜索 https://www.sogou.com/ 相应的微信公众号或文章
			 */
			String url = null;
			url = "http://mp.weixin.qq.com/mp/getcomment?src=3&ver=1&timestamp=1476349668&signature=gnYyQypI1IsIXeuxJoxPIPl2cZibdSGB2qur2il7xm9lE5uj2UjYJA*fWqDF1Kd5vBJFC3*fl7wKH*2BRz9s*NI8I2dJfFAtuoL-fzOZgyV2ptnwLswe1KK6H*BzBN0Hsdif7jQM-5FKIrf1JsMDqOBVtPmbq1kWwuYaaylzEF4%3D&&uin=&key=&pass_ticket=&wxtoken=&devicetype=&clientversion=0&x5=0";
			HttpClient httpClient = HttpClientBuilder.create().build();
			// http get 实例
			HttpGet httpGet = new HttpGet(url);
			HttpResponse response = httpClient.execute(httpGet);
			
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				// 成功响应 200 ok
				InputStream input = response.getEntity().getContent();
				String result = StringUtil.streamToString(input);
				log.info("testGet =====> result = " + result );
				
			}
			
		} catch (Exception e) {
			log.error("testFetchJsonInWX =====> ", e);
		}
	}	
		
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFetchHtml() {
		try {
			
			
		} catch (Exception e) {
			log.error("testFetchHtml =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 抓取微信公众中号文章和评论
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFetchWeiXinArticleAndComment() {
		try {
			/**
			 * 1. 通过url解析文件列表，从文章列表中解析出各个文章的url
			 * 
			 * 2. 每个文章的中解析html来获取评论 (微信公众号展示最多100条评论)
			 * 
			 * 
			 */
			String url = null;
			url = "http://mp.weixin.qq.com/s?__biz=MjM5MTI0NjQ0MA==&mid=2655811774&idx=2&sn=a0d499ac8ba8a6c32822ac9c882597c0&scene=24&srcid=0805cp7y552iPg8UmhImQrhE#wechat_redirect";
			url = "http://mp.weixin.qq.com/s?timestamp=1476349668&src=3&ver=1&signature=gnYyQypI1IsIXeuxJoxPIPl2cZibdSGB2qur2il7xm9lE5uj2UjYJA*fWqDF1Kd5vBJFC3*fl7wKH*2BRz9s*NI8I2dJfFAtuoL-fzOZgyV2ptnwLswe1KK6H*BzBN0Hsdif7jQM-5FKIrf1JsMDqOBVtPmbq1kWwuYaaylzEF4=";
			url = "http://mp.weixin.qq.com/profile?src=3&timestamp=1476409615&ver=1&signature=amLuIuerspJwR-eJWmIaX0zlvOQBi012JP-1OFz5XauIB8qsXpIqEi*Txf7jJqYIEG-6*se28leok2187P0Feg==";
			Connection connection = Jsoup.connect(url);
			// 设置请求参数
			//connection.data("param1", "value1");
			//connection.data("page", "1");
			Document document = null;
			// 设置超时时间
			connection.timeout(5 * 1000);
			// 请求方法 生成文档对象，从文档对象中去获取
			/*
			 * 参数放在url中就使用get方法
			 */
			document = connection.get();
			//document = connection.post();
			System.out.println(document.toString());
			
			
			
			
		} catch (Exception e) {
			log.error("testFetchWeiXinArticleAndComment =====> ", e);
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
