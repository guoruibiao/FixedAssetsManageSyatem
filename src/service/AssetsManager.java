package service;

<<<<<<< HEAD
import dao.AssetsDao;
import dao.BaseDao;
import dao.impl.AssetsDaoImpl;
import entity.*;

import java.util.List;
=======
import java.util.List;

import dao.AssetsDao;
import dao.BaseDao;
import dao.impl.AssetsDaoImpl;
import entity.Admin;
import entity.Clazz;
import entity.FixedAssets;
import entity.SubClass;
import entity.User;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c

/**
 * 专门用于处理和用户打交道的相关于固定资产单项的业务逻辑类
 * 
 * @author 郭瑞彪
 *
 */
public class AssetsManager extends BaseDao implements AssetsDao {

	/**
	 * 实例化一个静态的DaoImplementation实现，可以在一定的程度上减少代码的冗余，减少内存资源的消耗以及加快程序的运行速度。
	 */
	public static AssetsDaoImpl dao = new AssetsDaoImpl();

	/**
	 * 资产管理类，此方法用于处理相关于资产的添加操作
	 * 
	 * @param bean
	 *            Bean实体是封装了包含有资产单向详细信息的的实体
	 * @return 返回值为true代表添加数据项成功了，返回值为false则代表添加数据项的失败！
	 * 
	 */
	@Override
	public boolean add(Object bean) {
<<<<<<< HEAD
		return dao.add(bean);
=======
		return dao.add(bean) ? true : false;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	}

	/**
	 * 资产管理类，此方法用于处理相关于资产的删除操作
	 * 
	 * @param bean
	 *            Bean实体是封装了包含有资产单向详细信息的的实体
	 * @return 返回值为true代表添加数据项成功了，返回值为false则代表添加数据项的失败！
	 * 
	 */
	@Override
	public boolean delete(Object bean) {
<<<<<<< HEAD
		return dao.delete(bean);
=======
		return dao.delete(bean) ? true : false;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	}

	/**
	 * 由于设计问题，这里的方法处理的并不好，应该是只有管理员才能拥有权限来进行对资产单项的修改操作。
	 * 这里仅仅是按照给定的资产单项的编号以及给定的包含有项目单项的详细信息的实体Bean来进行资产单项的信息的修改操作
	 * 
	 * @param assets_id
	 *            资产单项所属表结构中的编号，为int类型
	 * @param bean
	 *            Bean实体是封装了包含有资产单向详细信息的的实体
	 * @return 返回值为true代表添加数据项成功了，返回值为false则代表添加数据项的失败！
	 */
	public boolean modify(Object bean, int assets_id) {
<<<<<<< HEAD
		return dao.modify(bean, assets_id);
=======
		return dao.modify(bean, assets_id) ? true : false;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	}

	/**
	 * 资产单项的查找操作，这个方法的指定参数为项目单项的编号，所以获取到的数据将是唯一的一个，且至多有一个。
	 * 
	 * @param str
	 *            其实是项目单项在其所鼠标结构中的项目编号，为int值
	 * @return 返回值是一个封装了包含有此项目编号对应的项目单项的详细的信息实体Bean
	 */
	@Override
	public Object get(Object str) {
		return dao.get(str) != null ? dao.get(str) : null;
	}

	/**
	 * 这个方法使用的并不是有唯一性的资产单项的资产编号，而是使用了有可能重复的资产单项的名称，所以有可能会获取到很多相符的数据项，
	 * 因此，这里使用了一个集合的方式来作为返回值来存储这些数据。
	 * 
	 * @param str
	 *            资产单项对应的名称
	 * @return 一个封装了一个或者多个的资产单项的集合。
	 */
	@Override
	public List getAll(Object str) {
		return dao.getAll(str) != null ? dao.getAll(str) : null;
	}

	/**
	 * 已经登记的人员可以领用固定资产，领用时需要记录的信息有：<br>
	 * 设备编号，领用日期，领用人，管理员，用途，备注。<BR>
	 * 只有状态为正常且使用者为空的资产才能被领用，否则不能。
	 * 
	 * @param assets_id
	 *            资产单项在其所属表结构中的唯一的资产编号
	 * @param user
	 *            借出此资产单项的用户
	 * @param admin
	 *            处理此次借出事件的管理员
	 * @param usage
	 *            用户借出此资产单项的用途
	 * @param remark
	 *            记录此次借出事件的备注信息
	 * @return 返回值为true代表这次的借出事件能够成功的执行，返回值为false则代表此次事件的不成功还行！
	 */
	@Override
<<<<<<< HEAD
	public boolean lendOut(int assets_id, int user, Admin admin, String usage, String remark) {
		try {
			boolean result = dao.lendOut(assets_id, user, admin, usage, remark);
			return result;
		}catch (Exception e){
			System.out.println("资产不可用");
			return false;
		}
=======
	public boolean lendOut(int assets_id, User user, Admin admin, String usage, String remark) {
		return dao.lendOut(assets_id, user, admin, usage, remark) ? true : false;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	}

	/**
	 * 资产使用完毕后要归还给管理员，需要记录如下信息：设备编号，归还日期，管理员。
	 * 
	 * @param assets_id
	 *            资产单项在其所属表结构中的唯一的资产编号
	 * @param admin
	 *            监管此次归还事件的管理员
	 * @return 返回值为true则代表此次的归还事件顺利的执行，返回值为false则代表此次归还事件不成功，用户名下仍然会存在此资产单项的记录
	 */
	@Override
<<<<<<< HEAD
	public boolean returnBack(int assets_id, Admin admin,int user,String remark) {
		return dao.returnBack(assets_id, admin,user,remark);
=======
	public boolean returnBack(int assets_id, Admin admin) {
		return dao.returnBack(assets_id, admin) ? true : false;
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	}

	/**
	 * 查询该系统中存在的所有的大类的详细的信息
	 * 
	 * @param clazzName
	 *            其实这个参数并没有用到，由此看来这次的API的设计仍然是有很多的缺陷啊 :-(
	 * @return 返回一个封装了系统中所有的大类的名称的详细信息的集合
	 */
	@Override
	public List<Clazz> findByClazz(String clazzName) {
		return dao.findByClazz(clazzName) != null ? dao.findByClazz(clazzName) : null;
	}

	/**
	 * 根据所给小类的类名称，查询到该小类所属的大类以及盖晓磊本身具有的详细信息的集合
	 * 
	 * @param subclassName
	 *            所给的小类的类名称
	 * @return 返回值代表了封装了该小类同名的所有资产单项以及各自所属的大类等的详细信息的集合
	 */
	@Override
	public List<SubClass> findBySubClass(String subclassName) {
		return dao.findBySubClass(subclassName) != null ? dao.findBySubClass(subclassName) : null;
	}

	/**
	 * 通过资产单项的资产编号来实现对该资产单项详细信息的查询
	 * 
	 * @param assetsID
	 *            该资产单项所属的表结构的资产编号信息
	 * @return 返回值代表了与该资产编号唯一匹配的资产单项的详细信息。
	 */
	@Override
	public FixedAssets findByAssetsID(int assetsID) {
		return dao.findByAssetsID(assetsID) != null ? dao.findByAssetsID(assetsID) : null;
	}

	/**
	 * 根据用户的编号信息，来查询该用户名下所借出的所有的资产单项的集合。
	 * 
	 * @param userID
	 *            用户的编号
	 * @return 返回值代表了该用户名下所有的资产单项的详细信息的集合
	 */
	@Override
	public List<FixedAssets> findByUser(int userID) {
		return dao.findByUser(userID) != null ? dao.findByUser(userID) : null;
	}
<<<<<<< HEAD
	static public List<FixedAssets> getAllAssets(int page){
		return dao.getAssetsByParam(true,"",0,page);
	}
	static public List<FixedAssets> getAssetsById(int id){
		return dao.getAssetsByParam(false,"assets_id",id,1);
	}
	static public List<FixedAssets> getAssetsByClass(String className,int page){
		return dao.getAssetsByParam(false,"assets_class",className,page);
	}
	static public List<FixedAssets> getAssetsBySubClass(String subClass,int page){
		return dao.getAssetsByParam(false,"assets_sub_class",subClass,page);
	}static public List<FixedAssets> getAssetsByUserId(int userid,int page){
		return dao.getAssetsByParam(false,"assets_user_id",userid,page);
	}
	static public List<FixedAssets> getAssetsByUserName(String userName,int page){
		return dao.getAssetsByParam(false,"assets_user_name",userName,page);
	}



=======
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c

}
