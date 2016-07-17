package entity;

import java.util.Date;

/**
 * 固定资产单项的详细信息
 * 
 * @author 郭瑞彪
<<<<<<< HEAD
 *姚晋宏修改：
 * 删除属性
 * 添加属性assets_id,className,subClassName,userName
 * 修改toString方法
=======
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
 *
 */
public class FixedAssets {

	/**
<<<<<<< HEAD
	 * 固定资产ID
	 */
	private int id;

	/**
	 * 固定资产名称
	 */
	private String name;

	/**
	 * 小类id
	 */
	private int category;

	/**
	*所有类别信息
	 */
	private String className;
	/**
	 *所有类别信息
	 */
	private String subClassName;

=======
	 * 固定资产名称
	 */
	private String name;
	/**
	 * 固定资产所属类别，专指小类
	 */
	private int catagory;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	/**
	 * 固定资产型号
	 */
	private String model;
	/**
	 * 固定资产价值
	 */
	private int value;
	/**
	 * 固定资产购买日期
	 */
	private Date purchaseDate;
	/**
	 * 固定资产状态，0 代表可借空闲，1代表借出状态，2代表处于维修状态，3 代表损坏状态,
	 */
	private int state;
	/**
	 * 固定资产备注信息
	 */
	private String remark;
	/**
	 * 资产设备使用者
	 */
	private int user;
<<<<<<< HEAD
	/**
	 * 资产设备使用者名字
	 */
	private String userName;

	public FixedAssets() {
		super();
		// TODO Auto-generated constructor stub
=======

	public String getName() {
		return name;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return id+"\t"+name+"\t"+className+"\t"+subClassName+"\t"+model+"\t"+value+"\t"+purchaseDate+"\t"+stateCase()+"\t"+user+"\t"+ userName +"\t"+remark;
	}

	public String stateCase(){
		switch (state){
			case 0:
				return "正常";
			case 1:
				return "维修";
			case 2:
				return "损坏";
		}
		return "未知";
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
=======
		return "FixedAssets [name=" + name + ", catagory=" + catagory + ", model=" + model + ", value=" + value
				+ ", purchaseDate=" + purchaseDate + ", state=" + state + ", remark=" + remark + ", user=" + user + "]";
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public void setName(String name) {
		this.name = name;
	}

<<<<<<< HEAD
=======
	public int getCatagory() {
		return catagory;
	}

	public FixedAssets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setCatagory(int catagory) {
		this.catagory = catagory;
	}

>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
<<<<<<< HEAD
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSubClassName() {
		return subClassName;
	}

	public void setSubClassName(String subClassName) {
		this.subClassName = subClassName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

=======
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c

}
