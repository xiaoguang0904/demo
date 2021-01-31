# demo
这是一个基于springboot的webapi项目，只有订单增，删，改，查四个接口（返回json格式）  
项目中的dao及entity下的文件是由MybatisX插件自动生成  
由于springboot集成了tomcat，导入项目打包后直接启动DemoApplication.java即可  
  
项目版本相关  
springboot-2.4.2  
mybatis-2.1.4

DB  
mysql-8.0.23 

JDK  
openJDK-15  

### 项目目录结构如下
```
|-- src
    |-- main
    |   |-- java
    |   |   |-- com
    |   |       |-- toj
    |   |           |-- demo
    |   |               |-- DemoApplication.java                    --项目启动类
    |   |               |-- component
    |   |               |   |-- OrderComponent.java                 --订单操作(增加，删除，查询，更新)component
    |   |               |-- controller
    |   |               |   |-- OrderController.java                --订单操作(增加，删除，查询，更新)controller
    |   |               |   |-- result
    |   |               |       |-- OrderResult.java                --返回结果类
    |   |               |-- dao
    |   |               |   |-- TojOrderDao.java                    --订单Dao(由MyBatisX自动生成)
    |   |               |-- entity
    |   |               |   |-- TojOrder.java                       --订单实体类((由MyBatisX自动生成))
    |   |               |-- service
    |   |                   |-- OrderService.java                   --订单操作(增加，删除，查询，更新)service
    |   |-- resources
    |       |-- application.properties                              --数据库配置信息
    |       |-- com
    |       |   |-- toj
    |       |       |-- demo
    |       |           |-- dao
    |       |               |-- TojOrderDao.xml                     --订单相关SQL(由MyBatisX自动生成)
    |       |-- static                                              --由于项目无js,img静态资源文件等，此文件夹为空
    |       |-- templates                                           --由于项目无页面，此文件夹为空
    |-- test                                                        --测试文件夹说明略
        |-- java
            |-- com
                |-- example
                |-- toj
                    |-- demo
                        |-- DemoApplicationTests.java
```
### 数据库建表如下
```
# 数据库只包含一个表toj_order
CREATE TABLE `toj_order`  (
  `order_no` int NOT NULL AUTO_INCREMENT,
  `order_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
```


### 请求URL
```
===============增加===============
http://localhost:8080/order/add
请求参数
{
    "orderDesc": "desc1"                  
}
===============删除==============
http://localhost:8080/order/delete?id=1
===============更新==============
http://localhost:8080/order/update
请求参数
{
    "orderNo": "1",                       
    "orderDesc": "desc1"          
}
===============查询==============
http://localhost:8080/order/search?id=1
```

### 返回结果:成功(json格式)
```
{
    "result": "SUCCESS", 
    "id": "1",                       --只有查询时返回
    "desc": "desc1"                  --只有查询时返回
}
```

### 返回结果:失败(json格式)
```
{
    "result": "FAILED"
}
```
