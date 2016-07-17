package dao.impl;

<<<<<<< HEAD
import dao.AdminDao;
import dao.BaseDao;
import entity.Admin;
import org.apache.commons.dbutils.QueryRunner;
import util.ConnectionFactory;

=======
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

<<<<<<< HEAD
=======
import org.apache.commons.dbutils.QueryRunner;

import dao.AdminDao;
import dao.BaseDao;
import entity.Admin;
import util.ConnectionFactory;
import util.JDBCPool;

>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
public class AdminDAOImpl extends BaseDao implements AdminDao {

	@Override
	public boolean changePassword(Admin admin, String newPassword) {

		try {
			Connection conn = ConnectionFactory.getConnection();
<<<<<<< HEAD
			QueryRunner runner = new QueryRunner();
			String upsql = "update admin set admin_password = ? where admin_name = ?";
			int result=runner.update(conn, upsql, newPassword, admin.getName());
			conn.close();
			if(result==1)
				return true;
			else
				return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("修改密码发生错误");
		}

		return false;
	}

	@Override
	public boolean loginByName(Admin admin) {
		try {
			String admin_name = admin.getName();
			String admin_password = admin.getPassword();
			String sql = "select * from admin where admin_name = ? and admin_password = ?";
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, admin_name);
			ps.setString(2, admin_password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id=rs.getInt("admin_id");
				admin.setId(id);
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
=======
			boolean isExists = login(admin);
			if (isExists) {
				QueryRunner runner = new QueryRunner();
				String upsql = "update admin set admin_password = ? where admin_name = ?";
				runner.update(conn, upsql, newPassword, admin.getName());
				return true;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
<<<<<<< HEAD
	public boolean loginById(Admin admin) {
		try {
			int admin_id = admin.getId();
			String admin_password = admin.getPassword();
			String sql = "select count(*) as ncounts from admin where admin_id = ? and admin_password = ?";
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, admin_id);
			ps.setString(2, admin_password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String name=rs.getString("admin_name");
				admin.setName(name);
				return true;
			}else{
				return false;
=======
	public boolean login(Admin admin) {
		try {
			String admin_name = admin.getName();
			String admin_password = admin.getPassword();
			String sql = "select count(*) as ncounts from admin where admin_name = ? and admin_password = ?";
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, admin_name);
			ps.setString(2, admin_password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int counts = rs.getInt(1);
				if (counts == 1)
					return true;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD
=======

>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
		return false;
	}

	/**
	 * 根据管理员的名称获取其所在表项的编号值
<<<<<<< HEAD
	 *
	 * @return
	 * 已废除
=======
	 * 
	 * @param username
	 * @return
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	 */
	public static int getByName(String adminname) {
		try {
			String sql = "select admin_id from admin where admin_name = '" + adminname + "'";
			Connection conn = ConnectionFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			int user_id = -1;
			if (rs.next()) {
				user_id = rs.getInt("admin_id");
				return user_id != -1 ? user_id : -1;
			}
			return -1;
		} catch (Exception e) {
			throw new RuntimeException("根据用户的用户名获得该用户的编号失败！\n" + e);
		}
	}

}
