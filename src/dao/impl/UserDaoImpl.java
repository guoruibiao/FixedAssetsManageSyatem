package dao.impl;

<<<<<<< HEAD
import dao.UserDao;
import entity.User;
import util.ConnectionFactory;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserDaoImpl implements UserDao{
=======
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import entity.User;
import util.ConnectionFactory;

public class UserDaoImpl {
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c

	/**
	 * 判断资产使用人员是否登录
	 * 
<<<<<<< HEAD
	 * @param user 用户对象
	 * @return boolean 是否登记过
=======
	 * @param user
	 * @return
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	 */
	public boolean isRegister(User user) {
		try {
			Connection conn = ConnectionFactory.getConnection();
<<<<<<< HEAD
			String sql = "select count(*) from users where user_name = '" + user.getName() + "'";
=======
			String sql = "select count(*) from user where user_name = '" + user.getName() + "'";
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// 只有当用户名已经登记的时候才会返回true，否则返回false
<<<<<<< HEAD
				return rs.getInt(1) == 1;
			}
		} catch (Exception e) {
			System.out.println("用户未登记，请先登记！");
=======
				return rs.getInt(1) == 1 ? true : false;
			}
		} catch (Exception e) {
			throw new RuntimeException("用户未登记，请先登记！");
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
		}
		return false;
	}

<<<<<<< HEAD

	/**
	 *获取所有用户
	 * @param page 分页页数
	 * @return List<User>
     */
	@Override
	public List<User> getAllUser(int page) {
		try {
			Properties config=new Properties();
			FileInputStream is = new FileInputStream(new File("src/fams.cfg.properties"));
			config.load(is);
			int pageSize= Integer.parseInt(config.getProperty("PAGESIZE"));
			is.close();
			Connection conn = ConnectionFactory.getConnection();
			String sql = "select * from users limit "+(page-1)*pageSize+","+page*pageSize;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<User> list=new ArrayList<>();
			while (rs.next()) {
				User user=new User();
				user.setId(rs.getInt("user_id"));
				user.setName(rs.getString("user_name"));
				user.setJob(rs.getString("user_job"));
				user.setRemark(rs.getString("user_remark"));
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			System.out.println("查询用户时出错"+e);
			return null;
		}
	}

	/**
	 * 添加用户
	 * @param user 要加入的user对象
	 * @return 是否成功
     */
	@Override
	public boolean addUser(User user) {
		try{
			Connection conn = ConnectionFactory.getConnection();
			String sql = "insert into users (user_name,user_job,user_remark) values ('"+user.getName()+"','"+user.getJob()+"','"+user.getRemark()+"')";
			Statement stmt = conn.createStatement();
			int rs = stmt.executeUpdate(sql);
			if(rs==1)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.out.println("添加用户出错"+e);
			return false;
		}
	}

	/**
	 *
	 * @param id
	 * @return
     */
	@Override
	public boolean deleteUser(int id) {
		try{
			Connection conn = ConnectionFactory.getConnection();
			String sql = "delete from users where user_id="+id;
			Statement stmt = conn.createStatement();
			int rs = stmt.executeUpdate(sql);
			if(rs==1)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.out.println("添加用户出错"+e);
			return false;
		}
	}

=======
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	/**
	 * 根据用户的名称获取其所在表项的编号值
	 * 
	 * @param username
	 * @return
	 */
	public static int getIdByName(String username) {
		try {
<<<<<<< HEAD
			String sql = "select user_id from users where user_name = '" + username + "'";
=======
			String sql = "select user_id from user where user_name = '" + username + "'";
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
			Connection conn = ConnectionFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			int user_id = -1;
			if (rs.next()) {
				user_id = rs.getInt("user_id");
				return user_id != -1 ? user_id : -1;
			}
			return -1;
		} catch (Exception e) {
<<<<<<< HEAD
			System.out.println("根据用户的用户名获得该用户的编号失败！\n" + e);
			return -1;
=======
			throw new RuntimeException("根据用户的用户名获得该用户的编号失败！\n" + e);
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
		}
	}
}
