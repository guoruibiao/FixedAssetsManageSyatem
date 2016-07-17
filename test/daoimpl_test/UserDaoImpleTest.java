package daoimpl_test;

import org.junit.Test;

import dao.impl.UserDaoImpl;
import entity.User;

/**
 * 测试用户登录接口
 * 
 * @author 郭瑞彪
 *
 */
public class UserDaoImpleTest {

	@Test
	public void testRegister() throws Exception {
		User user = new User();
		user.setName("Tom");
		UserDaoImpl daoimpl = new UserDaoImpl();
		boolean flag = daoimpl.isRegister(user);
		System.out.println("用户注册：" + flag);
	}

	@Test
	public void getUserId() throws Exception {
		UserDaoImpl dao = new UserDaoImpl();
		int user_id = dao.getIdByName("a");
		System.out.println("a's id is :" + user_id);
	}

}
