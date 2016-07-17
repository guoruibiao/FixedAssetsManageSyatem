package entity;

/**
 * 资产大类bean
 * 
 * @author 郭瑞彪
 *
 */
public class Clazz {

	/**
	 * 资产大类，类名所属
	 */
	private String name;

	public Clazz() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Clazz [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
