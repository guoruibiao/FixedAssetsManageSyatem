package dao;

import java.util.List;

import entity.Admin;
import entity.Clazz;
import entity.FixedAssets;
import entity.SubClass;
import entity.User;

/**
 * 用于资产管理的管家类
 * 
 * @author 郭瑞彪
 *
 */
public interface AssetsDao {

	/**
	 * 已经登记的人员可以领用固定资产，领用时需要记录的信息有：设备编号，领用日期，领用人，管理员
	 * ，用途，备注。只有状态为正常且使用者为空的资产才能被领用，否则不能。
	 * 
	 * @param assets_id
	 * @param user
	 * @param admin
	 * @param usage
	 * @param remark
	 * @return
	 */
<<<<<<< HEAD
	public boolean lendOut(int assets_id, int user, Admin admin, String usage, String remark);
=======
	public boolean lendOut(int assets_id, User user, Admin admin, String usage, String remark);
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c

	/**
	 * 资产使用完毕后要归还给管理员，需要记录如下信息：设备编号，归还日期，管理员。
	 * 
	 * @param assets_id
	 * @param admin
	 * @return
	 */
<<<<<<< HEAD
	public boolean returnBack(int assets_id, Admin admin,int user,String remark);
=======
	public boolean returnBack(int assets_id, Admin admin);
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c

	/**
	 * 通过大类的类名来查找当前类下面的所有的小类的使用情况
	 * 
	 * @param clazzName
	 * @return
	 */
	public List<Clazz> findByClazz(String clazzName);

	/**
	 * 通过小类的类名来查找小类下所属的资产使用情况
	 * 
	 * @param subclassName
	 * @return
	 */
	public List<SubClass> findBySubClass(String subclassName);

	/**
	 * 通过资产编号查询某一个固定资产的详细的信息
	 * 
	 * @param assetsID
	 * @return
	 */
	public FixedAssets findByAssetsID(int assetsID);

	/**
	 * 通过用户的用户名称 来查询该用户名下借用的所有的资产信息
	 * 
	 * @param userName
	 * @return
	 */
	public List<FixedAssets> findByUser(int userID);

}
