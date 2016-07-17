package dao;

import entity.User;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
/**
 * 使用人员DAO设计，用于完成用户相关的操作
 * 
 * @author 郭瑞彪
 *
 */
public interface UserDao {

	/**
	 * 判断资产使用人员是否登录
	 * 
	 * @param user
	 * @return
	 */
<<<<<<< HEAD
	public  boolean isRegister(User user);

	List<User> getAllUser(int page);

	boolean addUser(User user);

	boolean deleteUser(int id);
=======
	public boolean isRegister(User user);
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c

}
