package entrance;

<<<<<<< HEAD
import entity.*;
import service.*;
import util.DateFormat;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


=======
>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
/**
 * 软件工作入口
 * 
 * @author 郭瑞彪
 *
 */
public class Main {
<<<<<<< HEAD
	private static Admin admin;

	private static void print(String s){System.out.print(s);}
	private static void println(String s){System.out.println(s);}
	private static void println( ){System.out.println();}
	private static void printCut(){System.out.println("--------------------------------------------------------------");}
	private static void printTitle(String s){
		String name="";
		try {
			name = admin.getName();
			name="管理员:"+name;
		}catch (Exception e){
			name="未登录";
		}
		System.out.println(s+"\t"+name);
	}
	private static void printSelect(String s){
		printCut();
		println(s);
	}
	private static void printError(String s){
		println("ERROR:"+s);
	}

	private static void cls(int n){
		for(int i=0;i<n;i++){
			println("");
		}
	}
	private static void cls(){
		cls(20);
	}

	private static int getInputInt(){
		Scanner scanner=new Scanner(System.in);
		int in;
		try {
			in = scanner.nextInt();
		}catch (InputMismatchException e){
			printError("输入类型错误,应输入int");
			in=-1;
		}
		return in;
	}
	private static String getInputString(){
		Scanner scanner=new Scanner(System.in);
		String in="";
		try {
			in = scanner.next();
		}catch (InputMismatchException e){
			printError("输入类型错误,应输入string");
			return null;
		}
		return in;
	}


	private boolean login(){
		printTitle("管理员登录");
		print("用户名:");
		String admin_name = getInputString();
		print("密码:");
		String admin_password = getInputString();
		admin = new Admin();
		admin.setName(admin_name);
		admin.setPassword(admin_password);
		if (AdminBusiness.loginByName(admin)) {
			println("登陆成功");
			return true;
		} else {
			println("登陆失败");
			return false;
		}
	}

	//FAMS->资产管理
	private void assets_manage(){
		int in=0;
		boolean check=true;
		while (check){
			printTitle("FAMS->资产管理");
			printSelect("1:类别管理\t2:资产管理\t0:退出");
			in=getInputInt();
			switch (in) {
				case 1:
					assets_class_manage();
					break;
				case 2:
					assets_assets_manage();
					break;
				case 0:
					check=false;
					break;
			}
		}
	}

	//FAMS->类别管理
	private void assets_class_manage(){
		boolean check=true;
		int in;
		while(check) {
			printTitle("FAMS->类别管理");
			printSelect("1:查看现有类别\t2:添加大类\t3:删除大类\t4:添加小类\t5:删除小类\t0:退出");
			in = getInputInt();
			switch (in) {
				case 1:
					assets_class_all();
					break;
				case 2:
					assets_class_addClass();
					break;
				case 3:
					assets_class_deleteClass();
					break;
				case 4:
					assets_class_addSubClass();
					break;
				case 5:
					assets_class_deleteSubClass();
					break;
				case 0:
					check=false;
					break;
			}
		}
	}

	//FAMS->类别管理->查看现有类别
	private void assets_class_all() {
		boolean check=true;
		int page = 1;
		while (check) {
			printTitle("FAMS->类别管理->所有类别->page" + page);
			printSelect("编号\t名称\t大类编号\t大类名称");
			List<SubClass> scList = CategoryBusiness.getAllClass(page);
			for (int i = 0; i < scList.size(); i++) {
				println(String.valueOf(scList.get(i)));
			}
			printSelect("1:上一页 2:下一页 0:退出");
			switch (getInputInt()){
				case 1:
					page--;
					if(page<1) page=1;
					break;
				case 2:
					page++;
					break;
				case 0:
					check=false;
			}
		}
	}

	//FAMS->类别管理->添加大类
	private void assets_class_addClass() {
		printTitle("FAMS->类别管理->添加大类");
		print("要添加的大类名称:");
		String inClassName=getInputString();
		boolean classAddResult=CategoryBusiness.addClass(inClassName);
		if(classAddResult)
			println("添加大类成功");
		else
			println("添加大类失败");
	}

	//FAMS->类别管理->删除大类
	private void assets_class_deleteClass() {
		printTitle("FAMS->类别管理->删除大类");
		print("要删除的大类名称:");
		String className=getInputString();
		boolean classDeleteResult=CategoryBusiness.deleteClass(className);
		if (classDeleteResult){
			println("删除成功");
		}else{
			println("删除失败");
		}
	}

	//FAMS->类别管理->添加小类
	private void assets_class_addSubClass() {
		printTitle("FAMS->类别管理->添加小类");
		print("要添加的小类名称:");
		String inSubClassName=getInputString();
		print("要加入到的大类ID:");
		int inClassID=getInputInt();
		boolean subClassAddResult=CategoryBusiness.addSubClass(inSubClassName,inClassID);
		if(subClassAddResult)
			println("添加小类成功");
		else
			println("添加小类失败");
	}

	//FAMS->类别管理->删除小类
	private void assets_class_deleteSubClass() {
		printTitle("FAMS->类别管理->删除小类");
		print("要删除的小类名称:");
		String subClassName=getInputString();
		boolean subClassDeleteResult=CategoryBusiness.deleteSubClass(subClassName);
		if (subClassDeleteResult){
			println("删除成功");
		}else{
			println("删除失败");
		}
	}

	//FAMS->资产管理
	private void assets_assets_manage(){
		boolean check=true;
		while(check) {
			printTitle("FAMS->资产管理");
			printSelect("1: 查看所有资产\t2:添加资产\t3:修改\t4:删除\t5:筛选\t0:退出");
			switch (getInputInt()) {
				case 1:
					assets_all();
					break;
				case 2:
					assets_add();
					break;
				case 3:
					assets_modify();
					break;
				case 4:
					assets_delete();
					break;
				case 5:
					assets_filter();
					break;
				case 0:
					check=false;
					break;
			}
		}
	}

	//FAMS->资产管理->删除
	private void assets_delete() {
		printTitle("FAMS->资产管理->删除");
		print("要删除的资产ID:");
		int assets_id=getInputInt();
		AssetsManager am=new AssetsManager();
		boolean delete_result=am.delete(assets_id);
		if(delete_result)
			println("删除成功");
		else
			println("删除失败");
	}

	//FAMS->资产管理->修改
	private void assets_modify() {
		printTitle("FAMS->资产管理->修改");
		print("要修改的资产ID:");
		int assets_id=getInputInt();
		AssetsManager as=new AssetsManager();
		FixedAssets fixedAssets= (FixedAssets) as.get(assets_id);
		printSelect("ID\t名称\t类ID\t大类\t小类\t型号\t价格\t购买日期\t状态\t使用人id\t名字\t备注");
		println(String.valueOf(fixedAssets));
		printCut();
		printSelect("1:名称\t2:类别\t3:型号\t4;价值\t5:购买日期\t6:状态\t7:备注\t0:退出");
		switch (getInputInt()){
			case 1:
				print("名称:");
				String name=getInputString();
				fixedAssets.setName(name);
				if(as.modify(fixedAssets,assets_id))
					println("修改成功");
				else
					println("修改失败");
				break;
			case 2:
				print("类别:");
				int category=getInputInt();
				fixedAssets.setCategory(category);
				if(as.modify(fixedAssets,assets_id))
					println("修改成功");
				else
					println("修改失败");
				break;
			case 3:
				print("型号:");
				String model=getInputString();
				fixedAssets.setModel(model);
				if(as.modify(fixedAssets,assets_id))
					println("修改成功");
				else
					println("修改失败");
				break;
			case 4:
				print("价值:");
				int value=getInputInt();
				fixedAssets.setValue(value);
				if(as.modify(fixedAssets,assets_id))
					println("修改成功");
				else
					println("修改失败");
				break;
			case 5:
				print("日期:");
				Date date= DateFormat.parseToDate(getInputString());
				fixedAssets.setPurchaseDate(date);
				if(as.modify(fixedAssets,assets_id))
					println("修改成功");
				else
					println("修改失败");
				break;
			case 6:
				print("状态(0:正常 1:维修 2:损坏):");
				int state=getInputInt();
				fixedAssets.setState(state);
				if(as.modify(fixedAssets,assets_id))
					println("修改成功");
				else
					println("修改失败");
				break;
			case 7:
				print("备注:");
				String remark=getInputString();
				fixedAssets.setRemark(remark);
				if(as.modify(fixedAssets,assets_id))
					println("修改成功");
				else
					println("修改失败");
				break;
			case 0:
				break;

		}
	}

	//FAMS->资产管理->添加
	private void assets_add() {
		printTitle("FAMS->资产管理->添加");
		AssetsManager am=new AssetsManager();
		print("名称:");
		String name=getInputString();
		print("类别编号(小类):");
		int category=getInputInt();
		print("型号:");
		String model=getInputString();
		print("价值:");
		int value=getInputInt();
		print("购买日期:");
		Date date=DateFormat.parseToDate(getInputString());
		print("状态(0:正常 1:维修 2:损坏):");
		int state=getInputInt();
		print("备注");
		String remark=getInputString();
		FixedAssets fa=new FixedAssets();
		fa.setName(name);
		fa.setCategory(category);
		fa.setModel(model);
		fa.setValue(value);
		fa.setPurchaseDate(date);
		fa.setState(state);
		fa.setRemark(remark);
		boolean add_result=am.add(fa);
		if(add_result)
			println("添加成功");
		else
			println("添加失败");
	}

	//FAMS->资产管理->所有资产
	private void assets_all(){
		boolean check=true;
		int page = 1;
		while (check) {
			printTitle("FAMS->资产管理->所有资产->page" + page);
			printSelect("ID\t名称\t类ID\t大类\t小类\t型号\t价格\t购买日期\t状态\t使用人id\t名字\t备注");
			List<FixedAssets> faList = AssetsManager.getAllAssets(page);
			for (int i = 0; i < faList.size(); i++) {
				println(String.valueOf(faList.get(i)));
			}
			printSelect("1:上一页\t2:下一页\t0:退出");
			switch (getInputInt()){
				case 1:
					page--;
					if(page<1) page=1;
					break;
				case 2:
					page++;
					break;
				case 0:
					check=false;
			}
		}
	}

	//FAMS->资产管理->查找资产
	private void assets_filter(){
		boolean check=true;
		while(check) {
			printTitle("FAMS->资产管理->查找资产");
			printSelect("1:按类别查找\t2:按使用者查找\t0:退出");

			switch (getInputInt()) {
				case 1:
					assets_filter_class();
					break;
				case 2:
					assets_filter_user();
					break;
				case 0:
					check=false;
					break;

			}
		}
	}

	//FAMS->资产管理->查找资产->按类别
	private void assets_filter_class(){
		boolean check=true;
		while(check) {
		printTitle("FAMS->资产管理->查找资产->按类别");
		printSelect("1:查找大类\t2:查找小类\t0:退出");
			switch (getInputInt()) {
				case 1:
					assets_filter_class_big();
					break;
				case 2:
					assets_filter_class_small();
					break;
				case 0:
					check=false;
					break;

			}
		}
	}

	//FAMS->资产管理->查找资产->大类
	private void assets_filter_class_big(){
		boolean check=true;
		int page = 1;
		print("要查找的大类名称:");
		String className=getInputString();
		while (check) {
			printTitle("FAMS->资产管理->查找资产->按类别->大类->page" + page);
			printSelect("ID\t名称\t类ID\t大类\t小类\t型号\t价格\t购买日期\t状态\t使用人id\t名字\t备注");
			List<FixedAssets> faList = AssetsManager.getAssetsByClass(className,page);
			for (int i = 0; i < faList.size(); i++) {
				println(String.valueOf(faList.get(i)));
			}
			printSelect("1:上一页 2:下一页 0:退出");
			switch (getInputInt()){
				case 1:
					page--;
					if(page<1) page=1;
					break;
				case 2:
					page++;
					break;
				case 0:
					check=false;
					break;
			}
		}
	}

	//FAMS->资产管理->查找资产->小类
	private void assets_filter_class_small(){
		boolean check=true;
		int page = 1;
		print("要查找的小类名称:");
		String subClassName=getInputString();
		while (check) {
			printTitle("FAMS->资产管理->查找资产->按类别->小类->page" + page);
			printSelect("ID\t名称\t类ID\t大类\t小类\t型号\t价格\t购买日期\t状态\t使用人id\t名字\t备注");
			List<FixedAssets> faList = AssetsManager.getAssetsBySubClass(subClassName,page);
			for (int i = 0; i < faList.size(); i++) {
				println(String.valueOf(faList.get(i)));
			}
			printSelect("1:上一页 2:下一页 0:退出");
			switch (getInputInt()){
				case 1:
					page--;
					if(page<1) page=1;
					break;
				case 2:
					page++;
					break;
				case 0:
					check=false;
					break;
			}
		}
	}

	//FAMS->资产管理->查找资产->按用户
	private void assets_filter_user(){
		boolean check=true;
		while(check) {
		printTitle("FAMS->资产管理->查找资产->按用户");
		printSelect("1:用户ID\t 2:用户名\t 0:退出");
			switch (getInputInt()) {
				case 1:
					assets_filter_user_id();
					break;
				case 2:
					assets_filter_user_name();
					break;
				case 0:
					check=false;
					break;

			}
		}
	}

	//FAMS->资产管理->查找资产->按用户ID
	private void assets_filter_user_id() {
		boolean check=true;
		int page = 1;
		print("要查找的用户ID:");
		int userId=getInputInt();
		while (check) {
			printTitle("FAMS->资产管理->查找资产->按用户->ID->page" + page);
			printSelect("ID\t名称\t类ID\t大类\t小类\t型号\t价格\t购买日期\t状态\t使用人id\t名字\t备注");
			List<FixedAssets> faList = AssetsManager.getAssetsByUserId(userId,page);
			for (int i = 0; i < faList.size(); i++) {
				println(String.valueOf(faList.get(i)));
			}
			printSelect("1:上一页 2:下一页 0:退出");
			switch (getInputInt()){
				case 1:
					page--;
					if(page<1) page=1;
					break;
				case 2:
					page++;
					break;
				case 0:
					check=false;
					break;
			}
		}
	}

	//FAMS->资产管理->查找资产->按用户名
	private void assets_filter_user_name() {
		boolean check=true;
		int page = 1;
		print("要查找的用户名:");
		String userName=getInputString();
		while (check) {
			printTitle("FAMS->资产管理->查找资产->按用户->用户名->page" + page);
			printSelect("ID\t名称\t类ID\t大类\t小类\t型号\t价格\t购买日期\t状态\t使用人id\t名字\t备注");
			List<FixedAssets> faList = AssetsManager.getAssetsByUserName(userName,page);
			for (int i = 0; i < faList.size(); i++) {
				println(String.valueOf(faList.get(i)));
			}
			printSelect("1:上一页 2:下一页 0:退出");
			switch (getInputInt()){
				case 1:
					page--;
					if(page<1) page=1;
					break;
				case 2:
					page++;
					break;
				case 0:
					check=false;
					break;
			}
		}
	}

	//FAMS->资产领用
	private void lendout(){
		printTitle("FAMS->资产领用");
		print("要领用的资产ID:");
		int assets_id=getInputInt();
		print("领用人ID:");
		int user=getInputInt();
		print("用途:");
		String usage=getInputString();
		print("备注:");
		String remark=getInputString();
		AssetsManager as=new AssetsManager();
		boolean lend_result=as.lendOut(assets_id,user,admin,usage,remark);
		if (lend_result)
			println("领用成功");
		else
			println("领用失败");
	}

	//FAMS->资产归还
	private void returnBack(){
		printTitle("FAMS->资产归还");
		print("要归还的资产ID:");
		int assets_id=getInputInt();
		print("归还人ID:");
		int user=getInputInt();
		print("备注:");
		String remark=getInputString();
		AssetsManager as=new AssetsManager();
		boolean lend_result=as.returnBack(assets_id,admin,user,remark);
		if (lend_result)
			println("归还成功");
		else
			println("归还失败");
	}

	//FAMS->用户管理
	private void user_manage(){
		boolean check=true;
		while (check) {
			printTitle("FAMS->用户管理");
			printSelect("1:查看所有用户\t2:添加用户\t3:删除用户\t0:退出");
			switch (getInputInt()){
				case 1:
					user_all();
					break;
				case 2:
					user_add();
					break;
				case 3:
					user_delete();
					break;
				case 0:
					check=false;
					break;
			}
		}

	}

	//FAMS->管理员管理
	private void admin_manage() {
		printTitle("FAMS->管理员管理");
		printSelect("1:修改密码\t0:退出");
		switch (getInputInt()){
			case 1:
				change_password();
				break;
			case 0:
				break;
		}
	}

	//FAMS->用户管理->所有用户
	private void user_all() {
		boolean check=true;
		int page = 1;
		while (check) {
			printTitle("FAMS->用户管理->所有用户->page" + page);
			printSelect("ID\t名字\t工作\t备注");
			List<User> userList = UserBusiness.getAllUser(page);
			for (int i = 0; i < userList.size(); i++) {
				println(String.valueOf(userList.get(i)));
			}
			printSelect("1:上一页\t2:下一页\t0:退出");
			switch (getInputInt()){
				case 1:
					page--;
					if(page<1) page=1;
					break;
				case 2:
					page++;
					break;
				case 0:
					check=false;
			}
		}
	}

	//FAMS->用户管理->添加用户
	private void user_add() {
		printTitle("FAMS->用户管理->添加用户");
		print("用户名:");
		String name=getInputString();
		print("工作:");
		String job=getInputString();
		print("备注");
		String remark=getInputString();
		User user=new User();
		user.setName(name);
		user.setJob(job);
		user.setRemark(remark);
		boolean result=UserBusiness.addUser(user);
		if(result)
			println("添加成功");
		else
			println("添加失败");
	}

	//FAMS->用户管理->删除用户
	private void user_delete() {
		printTitle("FAMS->用户管理->删除用户");
		println("要删除的用户id");
		int id=getInputInt();
		boolean result=UserBusiness.deleteUser(id);
		if(result)
			println("删除成功");
		else
			println("删除失败");
	}

	//FAMS->管理员管理->修改密码
	private void change_password(){
		printTitle("FAMS->管理员管理->修改密码");
		print("请输入当前密码:");
		String ps_old=getInputString();
		if(ps_old.equals(admin.getPassword())){
			while(true) {
				print("请输入新密码:");
				String ps_new = getInputString();
				print("请确认新密码:");
				String ps_re = getInputString();
				if (ps_re.equals(ps_new)) {
					boolean result = AdminBusiness.changePassword(admin, ps_new);
					if (result) {
						println("修改成功");
						admin.setPassword(ps_new);
					}
					else
						println("修改失败");
					break;
				}else{
					println("两次密码不匹配");
				}
			}
		}else{
			println("密码错误");
		}
	}

	//FAMS->出入管理
	private void lend_return_manage() {
		boolean check=true;
		while(check){
			printTitle("FAMS->出入管理");
			printSelect("1:查看领用记录\t2:查看归还记录\t3:领用资产\t4:归还资产\t0:退出");

			switch (getInputInt()){
				case 1:
					lendOut_record();
					break;
				case 2:
					returnBack_record();
					break;
				case 3:
					lendout();
					break;
				case 4:
					returnBack();
					break;
				case 0:
					check=false;
					break;
			}
		}
	}

	//FAMS->出入管理->领用记录
	private void lendOut_record() {
		boolean check=true;
		while(check) {
			printTitle("FAMS->出入管理->领用记录");
			printSelect("1:查询所有\t2:查询未归还的\t0:退出");
			switch (getInputInt()){
				case 1:
					lendOut_record_all();
					break;
				case 2:
					lendOut_record_nr();
					break;
				case 0:
					check=false;
					break;
			}
		}

	}

	//FAMS->出入管理->领用记录->所有
	private void lendOut_record_all() {
		boolean check=true;
		int page = 1;
		while (check) {
			printTitle("FAMS->出入管理->领用记录->所有->page" + page);
			printSelect("ID\t设备ID\t设备名称\t经办管理员\t用户ID\t用户名\t日期\t用途\t状态\t备注");
			List<LendOut> loList = LendReturnBusiness.getAllLend(page);
			for (int i = 0; i < loList.size(); i++) {
				println(String.valueOf(loList.get(i)));
			}
			println("1:上一页 2:下一页 0:退出");
			switch (getInputInt()){
				case 1:
					page--;
					if(page<1) page=1;
					break;
				case 2:
					page++;
					break;
				case 0:
					check=false;
			}
		}
	}

	//FAMS->出入管理->领用记录->未归还
	private void lendOut_record_nr() {
		boolean check=true;
		int page = 1;
		while (check) {
			printTitle("FAMS->出入管理->领用记录->未归还->page" + page);
			printSelect("ID\t设备ID\t设备名称\t经办管理员\t用户ID\t用户名\t日期\t用途\t状态\t备注");
			List<LendOut> loList = LendReturnBusiness.getLendNotReturn(page);
			for (int i = 0; i < loList.size(); i++) {
				println(String.valueOf(loList.get(i)));
			}
			println("1:上一页 2:下一页 0:退出");
			switch (getInputInt()){
				case 1:
					page--;
					if(page<1) page=1;
					break;
				case 2:
					page++;
					break;
				case 0:
					check=false;
			}
		}
	}

	//FAMS->出入管理->归还记录
	private void returnBack_record() {
		boolean check=true;
		int page = 1;
		while (check) {
			printTitle("FAMS->出入管理->归还记录page" + page);
			printSelect("ID\t设备ID\t设备名称\t经办管理员\t用户ID\t用户名\t日期\t备注");
			List<ReturnBack> allReturn = LendReturnBusiness.getAllReturn(page);
			for (int i = 0; i < allReturn.size(); i++) {
				println(String.valueOf(allReturn.get(i)));
			}
			println("1:上一页 2:下一页 0:退出");
			switch (getInputInt()){
				case 1:
					page--;
					if(page<1) page=1;
					break;
				case 2:
					page++;
					break;
				case 0:
					check=false;
			}
		}
	}



	public void start() {
		while (true) {
			printTitle("FAMS固定资产管理系统");
			printSelect("1:登陆\t0:退出");
			int in = getInputInt();
			if (in == 1) {
				boolean isLogin=login();
				if(isLogin){
					boolean check=true;
					while (check) {
						printSelect("1;资产管理\t2:人员管理\t3:出入管理\t4:管理员管理\t0:退出");
						switch (getInputInt()) {
							case 1:
								assets_manage();
								break;
							case 2:
								user_manage();
								break;
							case 3:
								lend_return_manage();
								break;
							case 4:
								admin_manage();
								break;
							case 0:
								check=false;
								break;
						}
					}

				}
			}else{
				return;
			}


		}



	}



	public static void main(String [] args){
		Main main=new Main();
		main.start();
=======

	/**
	 * 本项目的唯一指定入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

>>>>>>> 1b8d6745bf1df4eec54b2f29d40315ffd5f10a1c
	}

}
