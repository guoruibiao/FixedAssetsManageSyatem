# Project Structure And Project Hierachy

We all konw that the structure is very important. It's the core of one software.

## Project Hierachy

Like the picture as follows, it's the hierachy of our homework.

![MVC 架构模型](http://a2.qpic.cn/psb?/V147oidM132mH5/15UAS6dwUe*KGyRTUPiJbAWS8eplCRjstZ9f54RF1IQ!/b/dKYAAAAAAAAA&bo=cgSAAgAAAAADANE!&rf=viewer_4)


## Project Structure

The project directories is necessary for us to have a look.

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


### Main structure
![Main structure](http://a1.qpic.cn/psb?/V147oidM132mH5/J00H7eaWmDH94yJ84vn*4u3myH6BhROHWFXughIIPHA!/b/dKsAAAAAAAAA&bo=1QHjAAAAAAADABI!&rf=viewer_4)

### Some jars and dependency
![一些第三方的jar包以及相关的依赖项](http://a3.qpic.cn/psb?/V147oidM132mH5/XmI.UQieMn4C63TEGYP8yaonjLTHpbUTRObfu32GY4w!/b/dLAAAAAAAAAA&bo=FwKGAQAAAAADALc!&rf=viewer_4)

### The Details
![上半部分](http://a1.qpic.cn/psb?/V147oidM132mH5/BwD3afUHB9egcSRKrJui0XY4x7WuS2ml6rVjqOzpMr8!/b/dKUAAAAAAAAA&bo=HAJSAgAAAAADAGs!&rf=viewer_4)

![下半部分](http://a3.qpic.cn/psb?/V147oidM132mH5/fb0QnAA68i*bQv.X*Zw68J8iVLioUmU3RlU*N2sxP8o!/b/dKoAAAAAAAAA&bo=IAIfAgAAAAADABo!&rf=viewer_4)


---

<!-- UY BEGIN -->
<div id="uyan_frame"></div>
<script type="text/javascript" src="http://v2.uyan.cc/code/uyan.js"></script>
<!-- UY END -->