# Requirement Analysis

This is the most important thing for us before developing. So let's have a look.


## References

We just using teacher's document as our reference. And we also search some words from the internet.

- <font color='red'>FixedAssets:</font> which value more than 2000￥。

- raw document:
	随着公司业务不断发展，人员越来越多，固定资产的管理人员压力逐渐增大，需要建立数据库和使用软件系统来进行管理。

## Functions

- 管理员登录:
	要使用本系统必须先登录，并且只有固定资产管理员能够登录。登录的时候需要填写正确的用户名和密码，管理员可以修改自己的密码。系统允许有多个固定资产的管理员，每个管理员的权限相同。

- 固定资产信息管理		
	- 固定资产类别管理：
		
		固定资产的类别在录入资产信息之前就定义好，录入资产信息之后可以增加新的类别。类别要求分为两级，如大类可以是办公外设、数码产品、计算机等；小类分为办公外设：传真机、复印机、打印机、其它；数码产品：数码相机、投影仪；计算机：笔记本电脑、台式机、服务器等。
		类别应允许添加和删除操作。
  	- 固定资产信息管理：
  		
		资产的信息包括编号、名称、类别、型号、价值、购买日期、状态、使用者、备注等。资产型号是文本信息，资产的状态分为：正常、维修、报废，使用者为空表示资产未被使用。资产应允许执行添加、修改和删除操作。

- 人员信息管理

	这里的“人员”是指可能领用资产的人，人员的信息包括人员编号、姓名、职务和备注。

- 资产的领用

	已经登记的人员，可以领用固定资产，领用时需要记录的信息有：设备编号、领用日期、管理员、用途、备注。只有状态为正常且使用者为空的资产才能被领用，在维修或者已经报废的资产不能够领用。

- 资产的归还
	资产使用完毕后要归还给管理员，需要记录如下信息：设备编号，归还日期，管理员。

- 资产信息浏览和查询 

	- 按资产类别浏览：
		分类分成两级，要求能显示大类和小类下面的资产情况，资产状况。
	
	- 查询资产信息：
		可以按照资产编号、资产类别、使用者查询详细信息。按照使用者查询显示该人员领用的所有资产


---

<!-- UY BEGIN -->
<div id="uyan_frame"></div>
<script type="text/javascript" src="http://v2.uyan.cc/code/uyan.js"></script>
<!-- UY END -->