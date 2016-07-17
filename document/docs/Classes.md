# Classes View

UML can explain so many classes. So clear it is.

## Entity

Entities is created by referencing database tables.

![Entity](http://a2.qpic.cn/psb?/V147oidM132mH5/KQKFOoycKhvp3jMdGS9isuUqnHaFE5Gl*2f87jNNGZ4!/b/dAwBAAAAAAAA&bo=XAP3AVwD9wEDCSw!&rf=viewer_4)
## Dao

Except basic opertions CRUD,there are so many interfaces in this package, which can depend on how we implments them.
![Dao](http://a2.qpic.cn/psb?/V147oidM132mH5/XmY7IFB7iieH3HcpN3OYIjN.loebM9o6QnR7dRPEge4!/b/dOUAAAAAAAAA&bo=QALmAQAAAAADAIA!&rf=viewer_4)
## DaoImpl

DaoImplments is the implements of dao interface. It's the burdge between Service and Database&entity。 
![DaoImpl](http://a2.qpic.cn/psb?/V147oidM132mH5/mkHRsQsrb9Su49e3S0hOoRtzHKPRoY0Yjkg07Y73jmM!/b/dI0BAAAAAAAA&bo=QAJ3AkACdwIDACU!&rf=viewer_4)
## Service

Our Business is begin at here. Call those methods is very easy. It's mandatory to set  them well.
![Service](http://a1.qpic.cn/psb?/V147oidM132mH5/FC*zKLxhiRfSmk9.pmDj3JrJh1nKi63DWT5pDazgRYU!/b/dOEAAAAAAAAA&bo=FAMBAhQDAQIDACU!&rf=viewer_4)
## Type Hierachy

Hierachy is a good way to optimize our code. We can have a clear mind to solve those boring problems. And we can also read other's logic easily. It's very very important for our teamwork.Don't you think so?

![Type Hierachy](http://a2.qpic.cn/psb?/V147oidM132mH5/uMBokQKK14EvsX2Nu4oWgBLwL*feRtWX*cUx5bxSmqY!/b/dAwBAAAAAAAA&bo=fQEPAn0BDwIDACU!&rf=viewer_4)


---

<!-- UY BEGIN -->
<div id="uyan_frame"></div>
<script type="text/javascript" src="http://v2.uyan.cc/code/uyan.js"></script>
<!-- UY END -->