# Database Design

This is also very important for the whole development. So we designed it reference our requirement analysis.

## Entity-Relationship View

![数据库ER图](http://a3.qpic.cn/psb?/V147oidM132mH5/HwUIT6GaAQVqoeXs5xwWnnuA266GyNfcif*0R4xqqlg!/b/dAcBAAAAAAAA&bo=nAMLA5wDCwMDCSw!&rf=viewer_4)

## Database Table Property Details

-  <font color='green' size='5'>资产大类信息表</font>`class`:  
	- `class_id`: 大类的类编号
	- `clas_name`: 大类的类名称属性

- <font color='green'size='5'>资产小类信息表</font>`sub_class`:   
	- `sub_class_id`: 小类的类编号
	- `sub_class_name`: 小类的类名称属性
	- `class_id`: 作为外键起到约束作用的列，表示小类从属于哪个大类

- <font color='green'size='5'>资产单项信息表</font>`fixed_assets`:  
	- `assets_id`: 资产编号
	- `assets_name`: 资产名称
	- `assets_catagory`: 资产所属的小类的类型，因为知道了小类，其所属的大类就已经确定了
	- `assets_model`:  资产的型号
	- `assets_value`:  资产的价值或者价格
	- `assets_purchase_date`: 资产的购买日期 
	- `assets_state`:  资产的状态。0表示可借，1表示维修，2 表示报废。
	- `assets_user`:   已借出资产的持有人编号，未借出此项为空
	- `assets_remark`:  资产单项的备注信息


- <font color='green'size='5'>资产外借信息表</font>`assets_out`:    
	- `assets_out_id`: 资产外借 编号信息
	- `assets_id`:     资产编号信息
	- `assets_out_admin`:   处理资产外借的管理员
	- `assets_out_user`:    资产外借时的使用人员的编号
	- `assets_out_date`:    资产外借日期
	- `assets_out_purpose`:   使用人员借用资产的目的，或者用途
	- `assets_out_remark`:    资产外借的时候的备注信息


- <font color='green'size='5'>资产归还资产表</font>`assets_in`:     
	- `assets_in_id`:  资产归还 编号信息
	- `assets_id`:     归还的资产的编号信息
	- `assets_in_admin`:  处理归还资产的管理员的编号
	- `assets_in_user`:   归还资产单项的使用人员的编号信息
	- `assets_in_date`:   资产单项被归还的日期
	- `assets_in_remark`:   资产单项被归还的备注信息


-  <font color='green'size='5'>管理员信息表</font>`admin`:          
	- `admin_id`:  管理员表的编号信息
	- `admin_name`:  管理员的姓名
	- `admin_password`:  管理员的密码信息


- <font color='green'size='5'> 使用人员信息表</font>`user`:            
	- `user_id`:  使用人员的编号信息
	- `user_name`:  使用人员的名称
	- `user_job`:  使用人员的职位
	- `user_remark`:  使用人员本身的备注信息


---

<!-- UY BEGIN -->
<div id="uyan_frame"></div>
<script type="text/javascript" src="http://v2.uyan.cc/code/uyan.js"></script>
<!-- UY END -->