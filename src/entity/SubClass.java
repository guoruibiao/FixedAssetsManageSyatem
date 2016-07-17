package entity;

/**
 * 资产小类，分类所属
 * 
 * @author 郭瑞彪
 *
 */
public class SubClass {

<<<<<<< HEAD
	public String getSubClassName() {
		return subClassName;
	}

	public void setSubClassName(String subClassName) {
		this.subClassName = subClassName;
	}

	public int getSubClassId() {
		return subClassId;
	}

	public void setSubClassId(int subClassId) {
		this.subClassId = subClassId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	/**
	 * 资产小类的类名所属
	 */
	private String subClassName;
	private int subClassId;
	/**
	 * 小类资产所属的大类范围
	 */
	private String className;
	private int classId;
=======
	/**
	 * 资产小类的类名所属
	 */
	private String name;
	/**
	 * 小类资产所属的大类范围
	 */
	private String clazzName;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c

	public SubClass() {
		super();
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD

	@Override
	public String toString() {
		//return "SubClass [name=" + name + ", clazzName=" + clazzName + "]";
		return classId+"\t"+className+"\t"+subClassId+"\t"+subClassName;
	}

=======
	@Override
	public String toString() {
		return "SubClass [name=" + name + ", clazzName=" + clazzName + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c

}
