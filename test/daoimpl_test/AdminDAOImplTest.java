package daoimpl_test;

import org.junit.Test;

import dao.impl.AdminDAOImpl;
import entity.Admin;

/**
 * 管理员登陆以及修改密码测试用例
 * 
 * @author 郭瑞彪
 *
 */
public class AdminDAOImplTest {
	
	@Test
	public void testChangePwd() throws Exception {
		AdminDAOImpl daoimpl = new AdminDAOImpl();
		Admin admin = new Admin();
		admin.setName("admin");
		admin.setPassword("admin");
		boolean flag = daoimpl.changePassword(admin, "admin");
		System.out.println("更改密码：" + flag);
	}
	
	@Test
	public void testLogin() throws Exception {
		Admin admin = new Admin();
		admin.setName("admin");
		admin.setPassword("nimda");
		AdminDAOImpl daoimpl = new AdminDAOImpl();
		boolean isLogined = daoimpl.login(admin);
		System.out.println("登陆：" + isLogined);
	}
	
	@Test
	public void getAdminID() throws Exception {
		AdminDAOImpl dao = new AdminDAOImpl();
		int admin_id = dao.getByName("grb");
		System.out.println("grb's Id is: " + admin_id);
	}

}
