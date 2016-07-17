package dao;

import entity.Admin;

/**
 * 专门为管理员所需要的登陆以及修改密码等功能而设置的DAO接口
 * 
 * @author 郭瑞彪
 *
 */
public interface AdminDao {

	/**
	 * 提供管理员修改自己密码的方法接口
	 * 
	 * @param admin
	 * @param newPassword 
	 */
	public boolean changePassword(Admin admin,String newPassword);

	/**
	 * 提供管理员登陆的接口
	 * 
	 * @param admin
	 */
<<<<<<< HEAD
	public boolean loginById(Admin admin);
	public boolean loginByName(Admin admin);
=======
	public boolean login(Admin admin);
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c

}
