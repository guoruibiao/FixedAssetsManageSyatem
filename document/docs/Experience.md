# Our Experience

下面谈谈完成此次大作业的一些感悟吧。

## 郭瑞彪的感悟

### 反思
	
小学期刚开始的时候，觉得自己学了`Java`这么久了，自认为学的很好了。所以就没怎么在意课堂上相关知识点的讲解。而是学一些其他的比较新奇的东西，虽然在一定程度上获取到了更多的知识，但是却没能打下更加牢固的根基，现在想想这真的是有点“拣了芝麻丢了西瓜”的韵味。

其实仔细的思考一下，老马在课堂上所讲的基本上全是企业级或者开发级这个层面上常用的技术。相比于自己学习而言，很大程度上更加贴近于真实条件下软件的开发，所以是很有必要的。虽然自己学过这些所有的知识点，但还是会很有用的。

在此，我深刻的反思自己这种不认真的行为，确实是应该静下心来，稳扎稳打的学一波的。

### 收获

说到收获，这就有很多了。

 先从课堂上学到的一个小技巧吧。那是一个关于`JDBC`操作的小例子，具体见下面的代码。
	
	/**
	 * 根据给定的bean 来实现资产单项的添加工作
	 */
	@Override
	public boolean add(Object bean) {
		try {
			String sql = "insert into fixed_assets(assets_name,assets_catagory,assets_model,assets_value,assets_purchase_date,assets_state,assets_user,assets_remark)"
					+ " values(?,?,?,?,?,?,?,?)";
			FixedAssets fas = (FixedAssets) bean;
			Object[] params = { fas.getName(), fas.getCatagory(), fas.getModel(), fas.getValue(), fas.getPurchaseDate(),
					fas.getState(), fas.getUser(), fas.getRemark() };
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject((Integer) (i + 1), params[i]);
			}
			int isSuccess = ps.executeUpdate();
			conn.close();
			ps.close();
			return isSuccess == 1 ? true : false;
		} catch (Exception e) {
			throw new RuntimeException("固定资产插入数据时失败！\n" + e);
		}
	}


	
一个简单的小技巧，但是真的在开发中是那么的实用。我想这也是能经得起时间考验的程序员的智慧的结晶吧。


然后是关于团队开发的收获。

我们小组是两个人，我和姚晋宏。在开始编码之前，我们就关于关系型数据库的设计做了详细的讨论，然后根据项目需求制定了相关的表以及内部字段。这个过程让我也看到了自己这方面的不足。比如说本次表的设计，我的感悟是：

- 首先考虑独立于其他的表的那个表结构，这样的表最容易确定下来。

- 然后是考虑业务关系，可以这样的进行假设。当这个表中的数据发生改变的时候会引起其他的表的数据发生改变吗？ 如果会看看是一对一，多对一还是多对多的关系。然后设置外键约束即可。

- 有的时候需要添加视图`View`来保护数据库中的表，也有的时候会添加`Trigger` 或者`存储过程`来保证数据的联动效果。

- 最后根据表关系创建`E-R`关系图即可。

然后是团队项目合作过程的配合感悟，我和姚晋宏在开发的时候经过了详细的讨论，明确了各自的任务，前后端的开发互不干扰而且又能恰如其分的默契的配合，这样的团队开发才是最高效的团队开发。 



### 方向

开发的过程，真的是一个很锻炼人的过程。一直以为泛型，反射什么的技术没有什么实用性，现在看来还真的是`Too young to simple`啊。实际的开发中最常用而且也是最好用的估计就是这些东西了。

我的想法就是近期写出一套常用的工具集，然后不断的检验其正确定以及实用性。


## 姚晋宏的感悟



---

<!-- UY BEGIN -->
<div id="uyan_frame"></div>
<script type="text/javascript" src="http://v2.uyan.cc/code/uyan.js"></script>
<!-- UY END -->