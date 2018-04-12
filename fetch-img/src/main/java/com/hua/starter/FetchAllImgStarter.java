/**
 * 描述: 
 * FetchAllImgStarter.java
 * @author	qye.zheng
 * 
 *  version 1.0
 */
package com.hua.starter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.Reader;

import org.junit.Test;

import com.hua.service.FetchImgService;
import com.hua.util.IOUtil;
import com.hua.util.ProjectUtil;
import com.hua.util.StringUtil;

/**
 * 描述: 启动器
 * @author  qye.zheng
 * 
 * FetchAllImgStarter
 */
public final class FetchAllImgStarter
{

	private static final String inputFilePath = ProjectUtil.getAbsolutePath("/url.txt", true);
	

	// 启动器模板
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void start()
	{
		/** ===== begin 驱动参数设置  ===== */
		// 读取文件
		final File file = new File(inputFilePath);
		try
		{
			final Reader reader = IOUtil.streamToReader(new FileInputStream(file));
			final BufferedReader bufferedReader = IOUtil.bufferedReader(reader);
			final FetchImgService service = new FetchImgService();
			String url = bufferedReader.readLine();
			while (StringUtil.isNotEmpty(url))
			{
				url = url.trim();
				service.fetchAllImg(url);
				url = bufferedReader.readLine();
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		/** ===== end of 驱动参数设置 ===== */

		// 启动驱动
		
		
	}

}
