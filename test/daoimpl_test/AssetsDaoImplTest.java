package daoimpl_test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import dao.impl.AssetsDaoImpl;
import entity.Admin;
import entity.Clazz;
import entity.FixedAssets;
import entity.SubClass;
import entity.User;

/**
 * 专门用于测试固定资产基本操作的测试用例
 * 
 * @author 郭瑞彪
 *
 */
public class AssetsDaoImplTest {

	/**
	 * insert into
	 * fixed_assets(assets_name,assets_catagory,assets_model,assets_value,
	 * assets_purchase_date,assets_state,assets_user,assets_remark)
	 * 
	 * @throws Exception
	 */
	@Test
	public void add() throws Exception {
		AssetsDaoImpl dao = new AssetsDaoImpl();
		FixedAssets bean = new FixedAssets();
		bean.setName("牧马人键盘");
		bean.setCatagory(1);
		bean.setModel("20160714keyboard");
		bean.setValue(250);
		bean.setPurchaseDate(new Date());
		bean.setState(0);
		bean.setRemark("每个程序员必备的一款好键盘，解放双手的最佳选择！");

		boolean isSuccess = dao.add(bean);
		System.out.println("添加了一项固定资产，成功：" + isSuccess);
	}

	@Test
	public void delete() throws Exception {
		int assets_id = 7;
		AssetsDaoImpl dao = new AssetsDaoImpl();
		boolean isDeleted = dao.delete(assets_id);
		System.out.println("删除操作成功！" + isDeleted);
	}

	@Test
	public void modify() throws Exception {
		AssetsDaoImpl dao = new AssetsDaoImpl();
		FixedAssets bean = new FixedAssets();
		bean.setName("牧马人键盘");
		bean.setCatagory(1);
		bean.setModel("20160714keyboard");
		bean.setValue(250);
		bean.setPurchaseDate(new Date());
		bean.setState(0);
		bean.setRemark("每个程序员必备的一款好键盘，解放双手的最佳选择！");

		boolean isModified = dao.modify(bean, 8);
		System.out.println("修改操作成功：" + isModified);
	}

	@Test
	public void get() throws Exception {
		AssetsDaoImpl dao = new AssetsDaoImpl();
		FixedAssets fas = (FixedAssets) dao.get(3);
		System.out.println(fas.toString());
	}

	@Test
	public void getAll() throws Exception {
		AssetsDaoImpl dao = new AssetsDaoImpl();
		List<FixedAssets> ls = dao.getAll("笔记本");
		System.out.println(ls.size());
		for (int i = 0; i < ls.size(); i++) {
			System.out.println(ls.get(i).toString());
		}
	}

	@Test
	public void findByClazz() throws Exception {
		AssetsDaoImpl dao = new AssetsDaoImpl();
		List<Clazz> ls = dao.findByClazz("办公外设");
		for (int i = 0; i < ls.size(); i++) {
			System.out.println(ls.get(i).toString());
		}
	}

	@Test
	public void findBySubClass() throws Exception {
		AssetsDaoImpl dao = new AssetsDaoImpl();
		List<SubClass> ls = dao.findBySubClass("服务器");
		for (int i = 0; i < ls.size(); i++) {
			System.out.println(ls.get(i).toString());
		}
	}

	@Test
	public void findByAssetsID() throws Exception {
		AssetsDaoImpl dao = new AssetsDaoImpl();
		FixedAssets fas = dao.findByAssetsID(3);
		System.out.println(fas.toString());
	}

	@Test
	public void findByUser() throws Exception {
		AssetsDaoImpl dao = new AssetsDaoImpl();
		List<FixedAssets> fass = dao.findByUser(1);
		for (FixedAssets fas : fass) {
			System.out.println(fas.toString());
		}
	}

	@Test
	public void lendOut() throws Exception {
		AssetsDaoImpl dao = new AssetsDaoImpl();
		User user = new User();
		Admin admin = new Admin();
		user.setName("a");
		admin.setName("grb");
		String usage = "为了工作需要而借的笔记本电脑";
		String remark = "此人借据完整，有领导盖章证明！";
		boolean canLendOut = dao.lendOut(3, user, admin, usage, remark);
		System.out.println("借出成功： " + canLendOut);
	}

	/**
	 * 归还方法声明returnBack(int assets_id, Admin admin) {
	 * 
	 * @throws Exception
	 */
	@Test
	public void returnBack() throws Exception {
		AssetsDaoImpl dao = new AssetsDaoImpl();
		Admin admin = new Admin();
		admin.setName("yjh");
		boolean isReturned = dao.returnBack(2, admin);
		System.out.println("归还成功：" + isReturned);
	}

}
