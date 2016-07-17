package service;

import dao.impl.AdminDAOImpl;
<<<<<<< HEAD
import dao.impl.ClassDaoImpl;
=======
import dao.impl.ClazzDaoImpl;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
import entity.Admin;

/**
 * 专门用于处理Admin功能需求的业务处理类
 * 
 * @author 郭瑞彪
 *
 */
public class AdminBusiness {

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
<<<<<<< HEAD
	public static boolean addCategory(String tableName, String clazzName, int clazz_id) {
		ClassDaoImpl dao = new ClassDaoImpl();
		return dao.addCategory(tableName, clazzName, clazz_id) ? true : false;
=======
	public static boolean addCatagory(String tableName, String clazzName, int clazz_id) {
		ClazzDaoImpl dao = new ClazzDaoImpl();
		return dao.addCatagory(tableName, clazzName, clazz_id) ? true : false;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
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
<<<<<<< HEAD
	public static boolean deleteCategory(String tableName, String clazzName) {
		ClassDaoImpl dao = new ClassDaoImpl();
		return dao.deleteCategory(tableName, clazzName);
=======
	public static boolean deleteCatagory(String tableName, String clazzName) {
		ClazzDaoImpl dao = new ClazzDaoImpl();
		return dao.deleteCatagory(tableName, clazzName) ? true : false;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	}

	/**
	 * 管理员 登陆方法
	 * 
	 * @param admin
	 *            包含有管理员的详细的信息的实体bean.
	 * @return 返回值为true表示登陆成功，返回值为false表示登录失败
	 */
<<<<<<< HEAD
	public static boolean loginByName(Admin admin) {
		AdminDAOImpl dao = new AdminDAOImpl();
		return dao.loginByName(admin);
	}

	public static boolean loginById(Admin admin) {
		AdminDAOImpl dao = new AdminDAOImpl();
		return dao.loginById(admin);
=======
	public static boolean login(Admin admin) {
		AdminDAOImpl dao = new AdminDAOImpl();
		return dao.login(admin) ? true : false;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	}

	/**
	 * 管理员拥有更改自己的密码的权限，但是无权更改其他的管理员密码的权限。
	 * 
	 * @param admin
	 *            包含有可以完整的登陆的管理员的详细信息的Bean实体
	 * @param newPassword
	 *            管理员想要更改的新密码
	 * @return
	 */
	public static boolean changePassword(Admin admin, String newPassword) {
		AdminDAOImpl dao = new AdminDAOImpl();
<<<<<<< HEAD
		return dao.changePassword(admin, newPassword);
=======
		return dao.changePassword(admin, newPassword) ? true : false;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	}

}
