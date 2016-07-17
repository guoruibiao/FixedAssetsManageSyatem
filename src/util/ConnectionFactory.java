package util;

import java.sql.Connection;

/**
 * 专门处理获取数据库连接资源的管理类
 * 
 * @author 郭瑞彪
 *
 */
public class ConnectionFactory {

	/**
	 * 单例模式下的数据库连接
	 */
	private static Connection conn = null;

	/**
	 * 采用缓冲模式 创建获取数据库连接的方法，实现对JDBCPool的高效利用
	 * 
	 * @return
	 * @throws Exception
	 */
	public static synchronized Connection getConnection() throws Exception {

		if (conn == null) {
			JDBCPool pool = new JDBCPool();
			conn = pool.getConnection();
			return conn;
		}
		return conn;
	}

}
