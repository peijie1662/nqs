NBCT网站查询服务（NBCT Web Query Service）
===

### 目前框架介绍：

    1.springboot项目,Mybaties(ORM),JWT(TOKEN),Swagger(TEST),大家如要深入了解，自行百度。
    
    2.项目连接2个数据库，即Web DB，查询的Qry DB.
    

### Qry功能开发注意事项
    
    1.nbct.com.cn.customerquery.entity创建实体类，对应查询结果。
    
    2.resource/mapper/qry下对应的xml文件中写sql。
    
    3.nbct.com.cn.customerquery.mapper.qry添加对应sql语句的接口。
    
    4.nbct.com.cn.customerquery.service对应方法。
    
    5.nbct.com.cn.customerquery.controller到前端接口。
    
    6.上述流程可参考已有例子。
    
    7.如无必要，不要修改其它包中代码，修改的话互相通知。
