package util_test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import util.JDBCPool;

/**
 * 用于测试数据库连接池实现成功与否
 * 
 * @author 郭瑞彪
 *
 */
public class JDBCPoolTest {

	@Test
	public void testConnNumbers() throws Exception {
		List<Connection> pool = new ArrayList<Connection>();
		JDBCPool jdbcpool = new JDBCPool();
		for (int i = 0; i < 10; i++) {
			pool.add(jdbcpool.getConnection());
		}
		System.out.println("当数据库连接请求小于等于10的时候：" + pool.size());
		pool.clear();
		
		try {
			for (int i = 0; i < 20; i++) {
				pool.add(jdbcpool.getConnection());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("当数据库连接请求大于10的时候：" + pool.size());
	}

}
