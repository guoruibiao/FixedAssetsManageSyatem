package service;

import dao.impl.ClassDaoImpl;
import entity.SubClass;

import java.util.List;

/**
 * 相关于固定资产分类的业务逻辑处理类
 * 
 * @author 郭瑞彪
 *
 */
public class CategoryBusiness {

	public static List<SubClass> getAllClass(int page){
        return ClassDaoImpl.getAllClass(page);
    }

    public static boolean addClass(String className){
        return ClassDaoImpl.addCategory("class",className,0);
    }

    public static boolean addSubClass(String subClassName,int classId){
        return ClassDaoImpl.addCategory("sub_class",subClassName,classId);
    }

    public static boolean deleteClass(String className){
        return ClassDaoImpl.deleteCategory("class",className);
    }

    public static boolean deleteSubClass(String subClassName){
        return ClassDaoImpl.deleteCategory("sub_class",subClassName);
    }

	
	
}
