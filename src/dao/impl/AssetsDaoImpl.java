package dao.impl;

<<<<<<< HEAD
import dao.AssetsDao;
import dao.BaseDao;
import entity.*;
import org.apache.commons.dbutils.QueryRunner;
import util.AssignmentTool;
import util.ConnectionFactory;
import util.DateFormat;

import java.io.File;
import java.io.FileInputStream;
=======
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
<<<<<<< HEAD
import java.util.Properties;
=======

import org.apache.commons.dbutils.QueryRunner;

import dao.AssetsDao;
import dao.BaseDao;
import entity.Admin;
import entity.Clazz;
import entity.FixedAssets;
import entity.SubClass;
import entity.User;
import util.AssignmentTool;
import util.ConnectionFactory;
import util.DateFormat;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c

/**
 * 固定资产管理类，完成资产单项的CRUD，以及相关的额外的查询选项
 * 
 * @author 郭瑞彪
 *
 */
public class AssetsDaoImpl extends BaseDao implements AssetsDao {

	/**
	 * 根据给定的bean 来实现资产单项的添加工作
	 */
	@Override
	public boolean add(Object bean) {
		try {
<<<<<<< HEAD
			String sql = "insert into fixed_assets(assets_name,assets_category,assets_model,assets_value,assets_purchase_date,assets_state,assets_remark)"
					+ " values(?,?,?,?,?,?,?)";
			FixedAssets fas = (FixedAssets) bean;
			Object[] params = { fas.getName(), fas.getCategory(), fas.getModel(), fas.getValue(), fas.getPurchaseDate(),
					fas.getState(), fas.getRemark() };
=======
			String sql = "insert into fixed_assets(assets_name,assets_catagory,assets_model,assets_value,assets_purchase_date,assets_state,assets_user,assets_remark)"
					+ " values(?,?,?,?,?,?,?,?)";
			FixedAssets fas = (FixedAssets) bean;
			Object[] params = { fas.getName(), fas.getCatagory(), fas.getModel(), fas.getValue(), fas.getPurchaseDate(),
					fas.getState(), fas.getUser(), fas.getRemark() };
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject((Integer) (i + 1), params[i]);
			}
			int isSuccess = ps.executeUpdate();
			conn.close();
			ps.close();
<<<<<<< HEAD
			return isSuccess == 1;
=======
			return isSuccess == 1 ? true : false;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
		} catch (Exception e) {
			throw new RuntimeException("固定资产插入数据时失败！\n" + e);
		}
	}

	/**
	 * 根据资产的资产编号来删除特定的资产项
	 */
	@Override
	public boolean delete(Object bean) {
		try {
			Integer assets_id = (Integer) bean;
			String sql = "delete from fixed_assets where assets_id = '" + assets_id + "'";
			Connection conn = ConnectionFactory.getConnection();
			int isDeleted = conn.createStatement().executeUpdate(sql);
<<<<<<< HEAD
			return isDeleted == 1;
=======
			return isDeleted == 1 ? true : false;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
		} catch (Exception e) {
			throw new RuntimeException("删除资产单项时出错！\n" + e);
		}
	}

	/**
	 * 根据资产编号来实现 资产单项的详细信息的修改
<<<<<<< HEAD
	 * assets_name,assets_category,assets_model,assets_value,
=======
	 * assets_name,assets_catagory,assets_model,assets_value,
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	 * assets_purchase_date,assets_state,assets_user,assets_remark)
	 */
	////////////////////////////////////////////////////////////////////////// 设计失败的地方，没有考虑到具体的修改单项时会用到的参数的信息
	public boolean modify(Object bean, int assets_id) {
		try {
			// Integer assets_id = (int) bean;
<<<<<<< HEAD
			String sql = "update fixed_assets set assets_name=?,assets_category=?,assets_model=?,assets_value=?,assets_purchase_date=?,assets_state=?,assets_user=?,assets_remark=? where assets_id = '"
=======
			String sql = "update fixed_assets set assets_name=?,assets_catagory=?,assets_model=?,assets_value=?,assets_purchase_date=?,assets_state=?,assets_user=?,assets_remark=? where assets_id = '"
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
					+ assets_id + "'";
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			FixedAssets fas = (FixedAssets) bean;
<<<<<<< HEAD
			Object[] params = { fas.getName(), fas.getCategory(), fas.getModel(), fas.getValue(), fas.getPurchaseDate(),
					fas.getState(), fas.getUser()==0? null:fas.getUser(), fas.getRemark() };
=======
			Object[] params = { fas.getName(), fas.getCatagory(), fas.getModel(), fas.getValue(), fas.getPurchaseDate(),
					fas.getState(), fas.getUser(), fas.getRemark() };
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
			for (int i = 0; i < params.length; i++) {
				ps.setObject((Integer) (i + 1), params[i]);
			}
			int isModified = ps.executeUpdate();
			conn.close();
			ps.close();
<<<<<<< HEAD
			return isModified == 1;
=======
			return isModified == 1 ? true : false;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
		} catch (Exception e) {
			throw new RuntimeException("修改资产单项时出错！\n" + e);
		}
	}

	/**
	 * 很据单个的资产单项来查取出单个资产的详细的信息，存储于bean中然后进行返回 *
<<<<<<< HEAD
	 * assets_name,assets_category,assets_model,assets_value,
=======
	 * assets_name,assets_catagory,assets_model,assets_value,
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	 * assets_purchase_date,assets_state,assets_user,assets_remark)
	 */
	@Override
	public Object get(Object assets_id) {
		try {
<<<<<<< HEAD
			String sql = "select * from fixed_assets_view where assets_id="+assets_id;
=======
			String sql = "select assets_name, assets_catagory, assets_model, assets_value, "
					+ "assets_purchase_date, assets_state, assets_user, assets_remark from fixed_assets where assets_id ='"
					+ assets_id + "'";
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
			Connection conn = ConnectionFactory.getConnection();
			conn.close();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			FixedAssets fas = (FixedAssets) AssignmentTool.assignment2Bean(rs);
			return fas;
		} catch (Exception e) {
			throw new RuntimeException("获取单个的资产单项时出错\n" + e);
		}
	}
<<<<<<< HEAD
	/**
     * 可选参数筛选
	 * @param paramName 要筛选的字段名
	 * @param paramValue 要筛选的字段值
	* */
	public ArrayList<FixedAssets> getAssetsByParam(boolean isAll,String paramName,Object paramValue,int page) {
		try {
			Properties config=new Properties();
			FileInputStream is = new FileInputStream(new File("src/fams.cfg.properties"));
			config.load(is);
			int pageSize= Integer.parseInt(config.getProperty("PAGESIZE"));
			is.close();

            String sql="";
            if (isAll){
                sql="select * from fixed_assets_view"+" order by assets_id "+" limit "+(page-1)*pageSize+","+page*pageSize;
            }else {
                sql = "select * from fixed_assets_view where " + paramName + "='" +paramValue+"'"+" order by assets_id "+"limit "+(page-1)*pageSize+","+page*pageSize;
            }
			Connection conn = ConnectionFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			ArrayList<FixedAssets> fal= (ArrayList<FixedAssets>) AssignmentTool.assignment2BeanList(rs);
			conn.close();
			return fal;
		} catch (Exception e) {
			throw new RuntimeException("获取资产筛选时出错\n" + e);
		}
	}

=======
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c

	/**
	 * getAll方法适用于返回一类数据时使用，比如assets_name这种可以重名的查找
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List getAll(Object assets_name) {
		try {
<<<<<<< HEAD
			// String sql = "select assets_name, assets_category, assets_model,
=======
			// String sql = "select assets_name, assets_catagory, assets_model,
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
			// assets_value, "
			// + "assets_purchase_date, assets_state, assets_user, assets_remark
			// from fixed_assets where assets_name ='"
			// + assets_name + "'";
			String sql = "select * from fixed_assets where assets_name = '" + assets_name + "'";
			Connection conn = ConnectionFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			conn.close();
			List<FixedAssets> list = AssignmentTool.assignment2BeanList(rs);
			return list;
		} catch (Exception e) {
			throw new RuntimeException("获取多个的资产单项时出错\n" + e);
		}
	}

	/**
	 * 已经登记的人员可以领用固定资产，领用时需要记录的信息有：<br>
	 * 设备编号，领用日期，领用人，管理员，用途，备注。<BR>
	 * 只有状态为正常且使用者为空的资产才能被领用，否则不能。
	 */
	@Override
<<<<<<< HEAD
	public boolean lendOut(int assets_id, int user_id, Admin admin, String usage, String remark) {
		try {
			// 只有已经登记的人才有权来领用固定资产
			Connection conn = ConnectionFactory.getConnection();
			ResultSet rs;
			String sql = "insert into assets_out(assets_id,assets_out_admin,assets_out_user,assets_out_date,assets_out_purpose,assets_out_remark) values(?,?,?,?,?,?)";
			QueryRunner runner = new QueryRunner();
			int admin_id = AdminDAOImpl.getByName(admin.getName());
			Date assets_out_date = DateFormat.getSqlDate();
			Object[] params = { assets_id, admin_id, user_id, assets_out_date, usage, remark };
			int isRecorded = runner.update(conn, sql, params);
			conn.close();
			if (isRecorded != 0) {
				return true;
			} else {
				return false;
=======
	public boolean lendOut(int assets_id, User user, Admin admin, String usage, String remark) {
		try {
			UserDaoImpl userdao = new UserDaoImpl();
			boolean isRegistered = userdao.isRegister(user);
			if (isRegistered) {
				// 只有已经登记的人才有权来领用固定资产
				String sql = "select assets_state,assets_user from fixed_assets where assets_id = '" + assets_id + "'";
				Connection conn = ConnectionFactory.getConnection();
				ResultSet rs = conn.createStatement().executeQuery(sql);
				if (rs.next()) {
					int assets_state = rs.getInt("assets_state");
					int assets_user = rs.getInt("assets_user");
					// 只有当设备处于可借出状态的时候才能被使用者借走, 且使用者为空
					if (assets_state == 0 && assets_user == 0) {
						sql = "insert into assets_out(assets_id,assets_out_admin,assets_out_user,assets_out_date,assets_out_purpose,assets_out_remark) values(?,?,?,?,?,?)";
						QueryRunner runner = new QueryRunner();
						// 根据out表的字段获取要插入到表中的数据项参数.
						// 但是会出现重名时候的异常代码
						int user_id = UserDaoImpl.getIdByName(user.getName());
						int admin_id = AdminDAOImpl.getByName(admin.getName());
						Date assets_out_date = DateFormat.getSqlDate();
						Object[] params = { assets_id, admin_id, user_id, assets_out_date, usage, remark };
						int isRecorded = runner.update(conn, sql, params);
						conn.close();
						if (isRecorded != 0) {
							return true;
						} else {
							return false;
						}
					}
				}
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
			}
		} catch (Exception e) {
			throw new RuntimeException("在借出固定资产时出现错误！\n" + e);
		}
<<<<<<< HEAD
=======
		return false;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	}

	/**
	 * 资产使用完毕后要归还给管理员，需要记录如下信息：设备编号，归还日期，管理员。
	 */
	@Override
<<<<<<< HEAD
	public boolean returnBack(int assets_id, Admin admin,int user,String remark) {
=======
	public boolean returnBack(int assets_id, Admin admin) {
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
		try {
			String sql = "insert into assets_in(assets_id,assets_in_admin,assets_in_user,assets_in_date,assets_in_remark) values(?,?,?,?,?)";
			Connection conn = ConnectionFactory.getConnection();
			// PreparedStatement ps = conn.prepareStatement(sql);
<<<<<<< HEAD
			int user_id = getUserIdByAssetsID(assets_id);
			Object[] params = { assets_id, admin.getId(), user_id, DateFormat.getSqlDate(),
=======
			String remark = "此人归还此固定资产单项的时候，物品保存完好！";
			int user_id = getUserIdByAssetsID(assets_id);
			Object[] params = { assets_id, AdminDAOImpl.getByName(admin.getName()), user_id, DateFormat.getSqlDate(),
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
					remark };
			QueryRunner runner = new QueryRunner();
			int isReturned = runner.update(conn, sql, params);
			conn.close();
<<<<<<< HEAD
			return isReturned != 0;
		} catch (Exception e) {
			System.out.println("在归还固定资产时出现错误");
			return false;
=======
			return isReturned != 0 ? true : false;
		} catch (Exception e) {
			throw new RuntimeException("在归还固定资产时出现错误！\n" + e);
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
		}
	}

	/**
	 * 罗列出所有的大类
	 */
	@Override
	public List<Clazz> findByClazz(String clazzName) {
		try {
			String sql = "select class_name from class ";
			Connection conn = ConnectionFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			List<Clazz> ls = new ArrayList<Clazz>();
			while (rs.next()) {
				Clazz clazz = new Clazz();
				clazz.setName(rs.getString("class_name"));
				ls.add(clazz);
			}
			return ls != null ? ls : null;
		} catch (Exception e) {
			throw new RuntimeException("根据类属性查找所有信息失败！" + e);
		}
	}

	/**
	 * 罗列出所有的小类的信息
	 */
	@Override
	public List<SubClass> findBySubClass(String subclassName) {
		try {
			String sql = "select sub_class_name,class_id from sub_class where sub_class_name = '" + subclassName + "'";
			Connection conn = ConnectionFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			List<SubClass> ls = new ArrayList<SubClass>();
			while (rs.next()) {
				SubClass subclass = new SubClass();
<<<<<<< HEAD
				subclass.setSubClassName(rs.getString("sub_class_name"));
				int class_id = rs.getInt("class_id");
				subclass.setClassName(ClassDaoImpl.getClassNameById(class_id));
				ls.add(subclass);
			}
			return ls;
=======
				subclass.setName(rs.getString("sub_class_name"));
				int class_id = rs.getInt("class_id");
				subclass.setClazzName(ClazzDaoImpl.getClassNameById(class_id));
				ls.add(subclass);
			}
			return ls != null ? ls : null;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
		} catch (Exception e) {
			throw new RuntimeException("根据小类属性查找所有信息失败！" + e);
		}
	}

	/**
	 * 根据资产单项的编号来查找该资产单项的详细信息
	 */
	@Override
	public FixedAssets findByAssetsID(int assetsID) {
		try {
			String sql = "select * from fixed_assets where assets_id = '" + assetsID + "'";
			Connection conn = ConnectionFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			FixedAssets fas = AssignmentTool.assignment2Bean(rs);
			return fas != null ? fas : null;
		} catch (Exception e) {
			throw new RuntimeException("根据资产单号来获取资产单项的详细信息的时候出错了！\n" + e);
		}
	}

	/**
	 * 根据用户的用户编号来实现获取该用户名下借用的所有资产的列表
	 */
	@Override
	public List<FixedAssets> findByUser(int userID) {
		try {
			String sql = "select * from fixed_assets where assets_user = '" + userID + "'";
			Connection conn = ConnectionFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			List<FixedAssets> ls = AssignmentTool.assignment2BeanList(rs);
			return ls != null ? ls : null;
		} catch (Exception e) {
			throw new RuntimeException("根据用户编号来获取资产单项的详细信息的时候出错了！\n" + e);
		}
	}

	/**
	 * 根据物品单项来获取借了此物品的用户的编号
	 * 
	 * @param assets_id
	 * @return
	 */
	public static int getUserIdByAssetsID(int assets_id) {
		try {
			String sql = "select assets_user from fixed_assets where assets_id = '" + assets_id + "'";
			Connection conn = ConnectionFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			int user_id = -1;
			if (rs.next()) {
				user_id = rs.getInt("assets_user");
				return user_id;
			}
			conn.close();
			return -1;
		} catch (Exception e) {
			throw new RuntimeException("在根据物品的编号获取此时正在借用此物品的用户的编号出错了！\n" + e);
		}
	}

}
