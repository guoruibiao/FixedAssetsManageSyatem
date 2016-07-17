package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;

import util.ConnectionFactory;

public class ClazzDaoImpl {

	/**
	 * 固定资产类别添加方法，可以根据参数来自动的选择使用那种方式的插入策略！
	 * 
	 * @param tableName
	 *            要插入分类数据项的表名
	 * @param clazzName
	 *            要插入的数据项的分类的名称
	 * @param clazz_id
	 *            这里只是针对属于小类的时候所用的对应的大类的编号
	 * @return
	 */
	public boolean addCatagory(String tableName, String clazzName, int clazz_id) {
		try {
			String sql = "";
			if (tableName.equals("class")) {
				sql = "insert into class(class_name) values('" + clazzName + "')";
			} else if (tableName.equals("sub_class")) {
				sql = "insert into sub_class(sub_class_name,class_id) values('" + clazzName + "','" + clazz_id + "')";
			} else {
				throw new RuntimeException("固定资产差入类别时出错，数据库中没有这张表，请检查一下表的名称的拼写！");
			}
			Connection conn = ConnectionFactory.getConnection();
			int executeResult = conn.createStatement().executeUpdate(sql);
			return executeResult == 1 ? true : false;
		} catch (Exception e) {
			throw new RuntimeException("添加固定资产类别时出错！\n" + e);
		}
	}

	/**
	 * 删除 固定资产的大类以及小类的数据
	 * 
	 * 当删除小类的时候直接删除小类的名称即可<br>
	 * 当删除的类属为大类的时候，除了删除大类的名称，仍然要删除从属于此类的所有的子类
	 * 
	 * @param tableName
	 * @param clazzName
	 * @return
	 */
	public boolean deleteCatagory(String tableName, String clazzName) {
		try {
			if (tableName.equals("class")) {
				Connection conn = ConnectionFactory.getConnection();
				String SQL = "delete from class where class_name = '" + clazzName + "'";
				int isDeleted = conn.createStatement().executeUpdate(SQL);
				return isDeleted == 1 ? true : false;
			} else if (tableName.equals("sub_class")) {
				String sql = "delete from sub_class where sub_class_name = '" + clazzName + "'";
				Connection conn = ConnectionFactory.getConnection();
				int isDeleted = conn.createStatement().executeUpdate(sql);
				conn.close();
				return isDeleted == 1 ? true : false;
			} else {
				throw new RuntimeException("对不起，数据库中并没有" + tableName + "这张表!,请检查您的表名的拼写，然后再试试吧！\n");
			}

		} catch (Exception e) {
			throw new RuntimeException("删除分类时出错！\n" + e);
		}
	}

	/**
	 * 根据给定的大类的名称，获取大类所在表的编号，方便小类插入数据时的参数给定
	 * 
	 * @param clazzName
	 *            给定的类名称
	 * @return
	 */
	public int getClazzId(String clazzName) {
		try {
			String sql = "select class_id from class where class_name = '" + clazzName + "'";
			Connection conn = ConnectionFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				int class_id = rs.getInt("class_id");
				return class_id;
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			throw new RuntimeException("根据类名获取该类名所属的编号查询失败！" + e);
		}
		return -1;
	}

	/**
	 * 根据所给小类的类名查找其所属表中的编号信息
	 * 
	 * @param subClassName
	 * @return
	 */
	public int getSubClassId(String subClassName) {
		try {
			String sql = "select sub_class_id from sub_class where sub_class_name = '" + subClassName + "'";
			Connection conn = ConnectionFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				int class_id = rs.getInt("sub_class_id");
				return class_id;
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			throw new RuntimeException("根据类名获取该类名所属的编号查询失败！" + e);
		}
		return -1;
	}

	/**
	 * 根据小类的类名来获取其所属的大类的类名
	 * 
	 * @param subClassName
	 * @return
	 */
	public static String getClazzName(String subClassName) {
		String ClazzName = "";
		try {
			String sql = "select class_name from class where class_id = (select class_id from sub_class where sub_class_name='"
					+ subClassName + "')";
			Connection conn = ConnectionFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				ClazzName = rs.getString("class_name");
				return ClazzName;
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			throw new RuntimeException("根据小类的类名获取其所属的大类的类名时出错！\n" + e);
		}
		return null;
	}

	/**
	 * 通过小类查询得到的大类的ID来进一步获取大类的名称
	 * 
	 * @return
	 */
	public static String getClassNameById(int class_id) {
		String ClazzName = "";
		try {
			String sql = "select class_name from class where class_id = '" + class_id + "'";
			Connection conn = ConnectionFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				ClazzName = rs.getString("class_name");
				return ClazzName;
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			throw new RuntimeException("根据小类的类名获取其所属的大类的类名时出错！\n" + e);
		}
		return null;

	}

}
