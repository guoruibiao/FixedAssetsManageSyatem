package service;

<<<<<<< HEAD
import dao.impl.UserDaoImpl;
import entity.User;

import java.util.List;

=======
import java.util.List;

import dao.impl.AssetsDaoImpl;
import dao.impl.UserDaoImpl;
import entity.FixedAssets;
import entity.User;

>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
/**
 * 用于资产使用人员的业务逻辑类
 * 
 * @author 郭瑞彪
 *
 */
public class UserBusiness {
<<<<<<< HEAD
	public static UserDaoImpl userDao=new UserDaoImpl();
=======

>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	/**
	 * 判断用户是否已经注册过的业务逻辑方法，只有注册过的用户才拥有外借固定资产的权限
	 * 
	 * @param user
	 *            包含有当前用户的详细信息的实体Bean
	 * @return 返回值为true表示该用户拥有借出固定资产的权限，返回值为false则代表没有这样的权限。
	 */
	public static boolean isRegistered(User user) {
<<<<<<< HEAD
		return userDao.isRegister(user) ? true : false;
=======
		UserDaoImpl dao = new UserDaoImpl();
		return dao.isRegister(user) ? true : false;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	}

	/**
	 * 根据用户的编号，来查找该用户名下借出的所有的固定资产单项
	 * 
<<<<<<< HEAD
	 *
	 *            用户编号
	 * @return 该方法返回的是一个集合，用于存放该用户编号下所借出的所有的资产单项
	 */
	public static boolean addUser(User user){
		return userDao.addUser(user);
	}

	public static boolean deleteUser(int id){
		return userDao.deleteUser(id);
	}

	public static List<User> getAllUser(int page){
		return userDao.getAllUser(page);
=======
	 * @param userID
	 *            用户编号
	 * @return 该方法返回的是一个集合，用于存放该用户编号下所借出的所有的资产单项
	 */
	public static List<FixedAssets> getAllAssets(int userID) {
		AssetsDaoImpl dao = new AssetsDaoImpl();
		return dao.findByUser(userID) != null ? dao.findByUser(userID) : null;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	}

}
