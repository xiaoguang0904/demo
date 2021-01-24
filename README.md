# demo
这是一个springboot最简单的webapi项目，只有订单查询一个接口（返回json格式）  
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
    |   |               |   |-- OrderSearchComponent.java           --订单查询component
    |   |               |-- controller
    |   |               |   |-- OrderSearchController.java          --订单查询controller
    |   |               |   |-- result
    |   |               |       |-- OrderResult.java                --返回结果类
    |   |               |-- dao
    |   |               |   |-- OrderDao.java                       --订单Dao(由MyBatisX自动生成)
    |   |               |-- entity
    |   |               |   |-- Order.java                          --订单实体类((由MyBatisX自动生成))
    |   |               |-- service
    |   |                   |-- OrderSearchService.java             --订单查询service层
    |   |-- resources
    |       |-- application.properties                              --数据库配置信息
    |       |-- com
    |       |   |-- toj
    |       |       |-- demo
    |       |           |-- dao
    |       |               |-- OrderDao.xml                        --订单查询SQL(由MyBatisX自动生成)
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
# 数据库只包含一个表order
CREATE TABLE `order`  (
  `order_no` int NOT NULL AUTO_INCREMENT,
  `order_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
```

### 插入数据如下
```
INSERT INTO `order` (`order_no`, `order_desc`) VALUES (1, 'desc1');
INSERT INTO `order` (`order_no`, `order_desc`) VALUES (2, 'desc2');
INSERT INTO `order` (`order_no`, `order_desc`) VALUES (3, 'desc3');
```

### 请求URL
```
http://localhost:8080/order/search?id=1
```

### 返回结果:成功(json格式)
```
{
    "result": "SUCCESS", 
    "id": "1", 
    "desc": "desc1"
}
```

### 返回结果:失败(json格式)
```
{
    "result": "FAILED"
}
```
