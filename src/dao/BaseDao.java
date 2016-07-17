package dao;

import java.util.List;

/**
 * 用于增删改查信息的抽象基类
 * 
 * @author 郭瑞彪
 *
 */
public class BaseDao<T> {

	/**
	 * 添加一条数据项
	 * 
	 * @param bean
	 */
	public boolean add(T bean) {
		return false;
	}

	/**
	 * 删除一个数据项
	 * 
	 * @param bean
	 */
	public boolean delete(T bean) {
		return false;
	}

	/**
	 * 修改一个数据项
	 * 
	 * @param bean
	 */
	public boolean modify(T bean) {
		return false;
	}

	/**
	 * 根据查询条件获取一个数据项
	 * 
	 * @param str
	 * @return
	 */
	public T get(T str) {
		return null;
	}

	/**
	 * 根据查询条件获取所有的数据项
	 * 
	 * @param str
	 * @return
	 */
	public List<T> getAll(T str) {
		return null;
	}

}
