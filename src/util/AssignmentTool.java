package util;

<<<<<<< HEAD
import entity.Clazz;
import entity.FixedAssets;
import entity.SubClass;

=======
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
=======
import dao.impl.ClazzDaoImpl;
import entity.Clazz;
import entity.FixedAssets;
import entity.SubClass;

>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
/**
 * 充分利用反射技术来实现<br>
 * 
 * 一个用于将ResultSet获取到的值贴给特定的Bean的实用方法 <br>
 * 这里为了大作业的简单化，专门用于处理固定资产单项的转bean处理
 * 
 * <br>
 * * assets_name,assets_catagory,assets_model,assets_value,
 * assets_purchase_date,assets_state,assets_user,assets_remark)
 * 
 * @author 郭瑞彪
 *
 */
public class AssignmentTool {

	public static List<Object> result2BeanList(ResultSet rs, String classType) {
		try {
			List<Object> list = new ArrayList<Object>();
			while (rs.next()) {
				Object obj = null;
				if (classType.equals("Clazz")) {
					obj = new Clazz();
					((Clazz) obj).setName(rs.getString("class_name"));
				} else if (classType.equals("SubClass")) {
					obj = new SubClass();
<<<<<<< HEAD
					((SubClass) obj).setClassName(rs.getString("class_name"));
					((SubClass) obj).setSubClassName(rs.getString("sub_class_name"));
=======
					((SubClass) obj).setClazzName(rs.getString("class_name"));
					((SubClass) obj).setName(rs.getString("sub_class_name"));
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
				}
				list.add(obj);
			}
			if (list != null) {
				return list;
			}
		} catch (Exception e) {
			throw new RuntimeException("结果集转换成BeanList时失败！\n" + e);
		}
		return null;
	}

	/**
	 * 将从数据库获取的结果集转化成一个封装起来的bean并作为结果进行返回
	 * 
	 * @param rs
	 * @return
	 */
	public static FixedAssets assignment2Bean(ResultSet rs) {
		try {
			FixedAssets fas = new FixedAssets();

<<<<<<< HEAD
			if (rs.next()) {
				fas.setId(rs.getInt("assets_id"));
				fas.setName(rs.getString("assets_name"));
				fas.setCategory(rs.getInt("assets_category"));
				fas.setClassName(rs.getString("assets_class"));
				fas.setSubClassName(rs.getString("assets_sub_class"));
=======
			while (rs.next()) {
				fas.setName(rs.getString("assets_name"));
				fas.setCatagory(rs.getInt("assets_catagory"));
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
				fas.setModel(rs.getString("assets_model"));
				fas.setValue(rs.getInt("assets_value"));
				fas.setPurchaseDate(rs.getDate("assets_purchase_date"));
				fas.setState(rs.getInt("assets_state"));
<<<<<<< HEAD
				fas.setUser(rs.getInt("assets_user_id"));
				fas.setUserName(rs.getString("assets_user_name"));
=======
				fas.setUser(rs.getInt("assets_user"));
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
				fas.setRemark(rs.getString("assets_remark"));
			}
			return fas;
		} catch (Exception e) {
			throw new RuntimeException("ResultSet to Bean Error！\n" + e);
		}
	}

	/**
	 * 将从数据库中获得的结果集转换成一个装有返回结果的List集合
	 * 
	 * @param rs
	 * @return
	 */
	public static List<FixedAssets> assignment2BeanList(ResultSet rs) {
		try {

			List<FixedAssets> lists = new ArrayList<FixedAssets>();
			while (rs.next()) {
				FixedAssets fas = new FixedAssets();
<<<<<<< HEAD
				fas.setId(rs.getInt("assets_id"));
				fas.setName(rs.getString("assets_name"));
				fas.setCategory(rs.getInt("assets_category"));
				fas.setClassName(rs.getString("assets_class"));
				fas.setSubClassName(rs.getString("assets_sub_class"));
=======
				fas.setName(rs.getString("assets_name"));
				fas.setCatagory(rs.getInt("assets_catagory"));
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
				fas.setModel(rs.getString("assets_model"));
				fas.setValue(rs.getInt("assets_value"));
				fas.setPurchaseDate(rs.getDate("assets_purchase_date"));
				fas.setState(rs.getInt("assets_state"));
<<<<<<< HEAD
				fas.setUser(rs.getInt("assets_user_id"));
				fas.setUserName(rs.getString("assets_user_name"));
=======
				fas.setUser(rs.getInt("assets_user"));
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
				fas.setRemark(rs.getString("assets_remark"));
				lists.add(fas);
			}
			return lists;
		} catch (Exception e) {
			throw new RuntimeException("ResultSet to Bean Error！\n" + e);
		}
	}

}
