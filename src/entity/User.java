package entity;

/**
 * 借用固定资产的申请人（用户）
 * 
 * @author 郭瑞彪
 *
 */
public class User {

<<<<<<< HEAD
	private int id;

=======
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	/**
	 * 借用固定资产的用户名称
	 */
	private String name;
	/**
	 * 借用固定资产的用户的职位
	 */
	private String job;
	/**
	 * 借用固定资产的备注信息
	 */
	private String remark;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return id+"\t"+name+"\t"+job+"\t"+remark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
=======
		return "User [name=" + name + ", job=" + job + ", remark=" + remark + "]";
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
