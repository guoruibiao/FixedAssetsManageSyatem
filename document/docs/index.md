# Welcome to Our FixedAssetsManageSystem

This is a simple document of our work. For more details, see as follows!<br>
<font color='green'>:-)   &nbsp;</font> you can click items you want at your left side.

## Outline

* `Requirement Analysis`  - Something about what we done.
* `Database Design` - For better usage and easy to code, database design is the basement.
* `Classes ` - So many Classes we designed reference database.
* `Project Structure & Project hierarchy` - We devided this homework into some divs for better use.
* `The Usage of Generic Paradigm` - We benifited from generic paradigm so much. 
* `User Interface Show` - Show you the details of our homework.
* `Experience` - Here you can see our expreience during developing this.
* `About Us` - If you have something to say, see this page,please. 

## Project layout

项目目录图：


	FixedAssetsManageSystem:   # Our Homework Overview
		- src/
			- dao/                            Interfaces for CRUD
				- AdminDao.java    
				- AssetsDao.java
				- BaseDao.java
				- UserDao.java
			- dao.impl/                       Implements of DAO
				- AdminDaoImpl.java
				- AssetsDaoImpl.java
				- ClazzDaoImpl.java
				- UserDaoImpl.java
			- entity/                         Entity for database table
				- Admin.java
				- Clazz.java
				- FIxedAssets.java
				- SubClass.java
				- User.java
				- todo.txt
			- entrance/                        The entrance of this software
				- Main.java
			- service/                         For Business using
				- AdminBusiness.java
				- AssetsManager.java
				- CatagoryBusiness.java
				- UserBusiness.java
			- util/                            Utils for coding in some methods
				- AssignmentTool.java
				- DateFormat.java
				- ConnectionFactory.java
				- JDBCPool.java
		- test/                                My Code Test
			- dao.impl.test/
				- ···
			- util.test/
				- ···
		- JRE System Library/                 Java Runtime Environment
		- Referenced Libraries/               Java Referenced Lbraries
		- JUnit 4/                            @Test using
		- document/
		- lib/                                Necessary for Coding
			- apache-commons-DbUtils.jar
			- mysql-connector.java


---

<!-- UY BEGIN -->
<div id="uyan_frame"></div>
<script type="text/javascript" src="http://v2.uyan.cc/code/uyan.js"></script>
<!-- UY END -->