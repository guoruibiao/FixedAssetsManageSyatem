package daoimpl_test;

import org.junit.Test;

import dao.impl.ClazzDaoImpl;

/**
 * 对ClazzDaoImpl的添加分类的测试
 * 
 * @author 郭瑞彪
 *
 */
public class ClazzDaoImplTest {

	@Test
	public void testAddCatagoryClazz() throws Exception {
		ClazzDaoImpl daoImpl = new ClazzDaoImpl();
		boolean isSuccess = daoImpl.addCatagory("class", "移动设备", 0);
		System.out.println("添加分类：" + isSuccess);
	}

	@Test
	public void testAddCatagorySubClass() throws Exception {
		ClazzDaoImpl daoImpl = new ClazzDaoImpl();
		boolean isSuccess = daoImpl.addCatagory("sub_class", "手机", 9);
		System.out.println("添加子分类：" + isSuccess);
	}

	@Test
	public void testDeleteSubClass() throws Exception {
		ClazzDaoImpl daoImpl = new ClazzDaoImpl();
		boolean isSuccess = daoImpl.deleteCatagory("sub_class", "手机");
		System.out.println("删除小分类：" + isSuccess);
	}

	@Test
	public void testDeleteClass() throws Exception {
		ClazzDaoImpl daoImpl = new ClazzDaoImpl();
		boolean isSuccess = daoImpl.deleteCatagory("class", "移动设备");
		System.out.println("删除大分类：" + isSuccess);
	}

	@Test
	public void testGetClazzId() throws Exception {
		ClazzDaoImpl daoImpl = new ClazzDaoImpl();
		int class_id = daoImpl.getClazzId("移动设备");
		if (class_id != -1) {
			System.out.println("移动设备所属的大类编号为：" + class_id);
		} else {
			System.out.println("移动设备所属的大类编号查询失败！");
		}
	}

	@Test
	public void testGetSubClassName() throws Exception {
		ClazzDaoImpl daoImpl = new ClazzDaoImpl();
		int subClassId = daoImpl.getSubClassId("手机");
		if (subClassId != -1) {
			System.out.println("手机所属的小类编号是：" + subClassId);
		} else {
			System.out.println("手机所属的编号信息查询失败！");
		}
	}

}
