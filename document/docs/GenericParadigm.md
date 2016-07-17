# The Usage of Generic Paragidm

Generic Paradigm exists in java from JDK1.5 and later. It brings so many convenient for us coder.

## sample 1


	package dao;
	
	import java.util.List;
	
	/**
	 * 用于增删改查信息的抽象基类
	 * 
	 * @author 郭瑞彪
	 *
	 */
	public class BaseDao<T> {
	
		/**
		 * 添加一条数据项
		 * 
		 * @param bean
		 */
		public boolean add(T bean) {
			return false;
		}
	
		/**
		 * 删除一个数据项
		 * 
		 * @param bean
		 */
		public boolean delete(T bean) {
			return false;
		}
	
		/**
		 * 修改一个数据项
		 * 
		 * @param bean
		 */
		public boolean modify(T bean) {
			return false;
		}
	
		/**
		 * 根据查询条件获取一个数据项
		 * 
		 * @param str
		 * @return
		 */
		public T get(T str) {
			return null;
		}
	
		/**
		 * 根据查询条件获取所有的数据项
		 * 
		 * @param str
		 * @return
		 */
		public List<T> getAll(T str) {
			return null;
		}
	
	}



## Sample 2

```
	
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

```

## Sample 3

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
				subclass.setName(rs.getString("sub_class_name"));
				int class_id = rs.getInt("class_id");
				subclass.setClazzName(ClazzDaoImpl.getClassNameById(class_id));
				ls.add(subclass);
			}
			return ls != null ? ls : null;
		} catch (Exception e) {
			throw new RuntimeException("根据小类属性查找所有信息失败！" + e);
		}
	}

---
## Sample 4

	/**
	 * 将从数据库中获得的结果集转换成一个装有返回结果的List集合
	 * 
	 * @param rs
	 * @return
	 */
	public static List<FixedAssets> assignment2BeanList(ResultSet rs) {
		try {

			List<FixedAssets> lists = new ArrayList<FixedAssets>();
			while (rs.next()) {
				FixedAssets fas = new FixedAssets();
				fas.setName(rs.getString("assets_name"));
				fas.setCatagory(rs.getInt("assets_catagory"));
				fas.setModel(rs.getString("assets_model"));
				fas.setValue(rs.getInt("assets_value"));
				fas.setPurchaseDate(rs.getDate("assets_purchase_date"));
				fas.setState(rs.getInt("assets_state"));
				fas.setUser(rs.getInt("assets_user"));
				fas.setRemark(rs.getString("assets_remark"));
				lists.add(fas);
			}
			return lists;
		} catch (Exception e) {
			throw new RuntimeException("ResultSet to Bean Error！\n" + e);
		}
	}


## Sample 5

	public static List<Object> result2BeanList(ResultSet rs, String classType) {
		try {
			List<Object> list = new ArrayList<Object>();
			while (rs.next()) {
				Object obj = null;
				if (classType.equals("Clazz")) {
					obj = new Clazz();
					((Clazz) obj).setName(rs.getString("class_name"));
				} else if (classType.equals("SubClass")) {
					obj = new SubClass();
					((SubClass) obj).setClazzName(rs.getString("class_name"));
					((SubClass) obj).setName(rs.getString("sub_class_name"));
				}
				list.add(obj);
			}
			if (list != null) {
				return list;
			}
		} catch (Exception e) {
			throw new RuntimeException("结果集转换成BeanList时失败！\n" + e);
		}
		return null;
	}


## Sample 6

	/*
	 * 既然是一个数据库连接池，就必须有许多的连接，所以需要使用一个集合类保存这些连接 (non-Javadoc)
	 * 
	 * @see javax.sql.CommonDataSource#getLogWriter()
	 */
	private static LinkedList<Connection> list = new LinkedList<Connection>();
---

<!-- UY BEGIN -->
<div id="uyan_frame"></div>
<script type="text/javascript" src="http://v2.uyan.cc/code/uyan.js"></script>
<!-- UY END -->