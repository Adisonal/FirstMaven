# FirstMaven
第一次提交
这是在b站上看视频（作者:花生）跟着练习的第一个Spring Boot搭建项目
------------------------------------------------------
package com.jt.dao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
@SpringBootTest
public class DataSourceTests {
                            /*
                            * 这里的DataSource是一个数据源标准或者说规范，Java所有连接池需要基于
                            * 这个规范进行实现。我们项目中添加了spring-boot-starter-jdbc依赖后，
                            * 系统中会自动帮我们引入一个HikariCP连接池，这个连接中有一个HikariDataSource
                            * 对象就是基于javax.sql.DataSource规范做了落地实现，这个对象在springboot
                            * 工程启动时，进行自动配置(DataSourceAutoConfiguration)。
                            */
@Autowired
private DataSource dataSource;//HikariDataSource
                            /* JDBC2.0 提供了javax.sql.DataSource接口，它负责建立与数据库的连接，当在应用程序中访问数据库时
                            不必编写连接数据库的代码，直接引用DataSource获取数据库的连接对象即可。用于获取操作数据Connection对象。
                            数据源建立多个数据库连接，这些数据库连接会保存在数据库连接池中，当需要访问数据库时，只需要从数据库连接池中
                            获取空闲的数据库连接，当程序访问数据库结束时，数据库连接会放回数据库连接池中。
                            DataSource可以看作数据源，它封装了数据库参数，连接数据库，程序中操作DataSource对象即可对数据库进行增删改查操作。*/
@Test
void testGetConnection() throws SQLException {
                            /* 传统的JDBC访问数据库技术，每次访问数据库都需要通过数据库驱动器Driver和数据库名称以及密码等等资源建立数据库连接。
                            这样的连接存在两大问题：
                            1. 频繁的建立数据库连接与断开数据库，这样会消耗大量的资源和时间，降低性能。
                            2. 数据库的连接需要用户名和密码等等，这些需要一定的内存和CPU一定开销。*/
          //通过dataSource获取链接时，首先要获取的是连接池(HikariPool)，然后从池获取连接。
          //这里有三个设计模式：单例模式，享元模式，桥接模式
Connection connection = dataSource.getConnection();
System.out.println(connection);
}

}
