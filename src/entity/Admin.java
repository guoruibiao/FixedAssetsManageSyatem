package entity;

/**
 * 系统管理员
 * 
 * @author 郭瑞彪
 *
 */
public class Admin {

<<<<<<< HEAD
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id;

=======
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	/**
	 * 管理员的名称
	 */
	private String name;
	/**
	 * 管理员账号对应的密码
	 */
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

<<<<<<< HEAD
=======
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c

	@Override
	public String toString() {
		return "Admin [name=" + name + ", password=" + password + "]";
	}

}
