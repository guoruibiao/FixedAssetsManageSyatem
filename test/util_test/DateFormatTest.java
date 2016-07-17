package util_test;

import java.util.Date;

import org.junit.Test;

import util.DateFormat;

/**
 * 测试一下自己的时间处理类
 * 
 * @author 郭瑞彪
 *
 */
public class DateFormatTest {

	@Test
	public void getStandardDate() throws Exception {
		Date date = DateFormat.getSqlDate();
		System.out.println(date);
	}

}
