**mybatis 批量更新update**https://blog.csdn.net/xyjawq1/article/details/74129316
次更新多条数据:
（1）逐条更新:在业务代码中循环遍历逐条更新。
 这种方式最大的问题就是效率问题，逐条更新，每次都会连接数据库，然后更新，再释放连接资源（虽然通过连接池可以将频繁连接数据的效率大大提高，抗不住数据量大），这中损耗在数据量较大的时候便会体现出效率问题。
（2）一条sql语句来更新所有数据，逐条更新的操作放到数据库端，在业务代码端展现的就是一次性更新所有数据。

写法一：是通过循环，依次执行update语句
```xml
<update id="updateBatch"  parameterType="java.util.List">  
    <foreach collection="list" item="item" index="index" open="" close="" separator=";">
        update course
        <set>
            name=${item.name}
        </set>
        where id = ${item.id}
    </foreach>      
</update>
```
==一条记录update一次，性能比较差，容易造成阻塞。==
<trim>属性说明
1.prefix,suffix 表示在trim标签包裹的部分的前面或者后面添加内容
2.如果同时有prefixOverrides,suffixOverrides 表示会用prefix,suffix覆盖Overrides中的内容。
3.如果只有prefixOverrides,suffixOverrides 表示删除开头的或结尾的xxxOverides指定的内容。

**什么是Mybatis?**
1. Mybatis是一个半orm（对象映射）框架，它内部封装了JDBC，开发时只需要关注SQL的本身，不需要 加载驱动、创建连接、写statement的过程，程序员直接编写原生的sql,灵活性高。
2. Mybatis可以使用XML 或注解来配置和映射原生信息，将POJO映射成数据库的记录(对象的属性字段)，避免了所有JDBC代码和手动设置参数以及获取结果集。

**#{}与${}的区别是什么**
#{} 是预编译处理，${}是字符串替换。

**当实体类中的属性名与表中的字段名不一样，怎么办**

1. 使用as 别名的方式让字段的别名与属性名一致。

2. 使用<resultMap>来映射字段名和实体类属性名的一一对应的关系 

**Mybatis是如何将SQL执行结果封装成目标对象并返回的，都有哪些映射形式？**
 1. ResultMap形式。 将SQL执行结果用<ResultMap>标签映射成目标对象。

 2.  使用SQL列的别名，将查询结果用as转换为列的别名书写成对象属性名。
**Mybatis是否支持延迟加载？ 如果支持它的原理是什么？**
  Mybatis仅支持association和collection对象的延迟加载，association指的是一对一, collection指的是一对多，在Mybatis的配置文件里，可以配置是否启用延迟加载lazyLoadingEnabled=true/false。

**MyBatis 的缓存**
Mybatis对缓存提供支持，一级缓存是默认使用的，二级缓存需要手动开启。

一级缓存的作用域是一个sqlsession内；
二级缓存作用域是针对mapper进行缓存；
- 一级缓存：
  因为使用SelSession第一次查询后，MyBatis会将其放在缓存中，以后再查询的时候，如果没有声明需要刷新，并且缓存没有超时的情况下，SqlSession都会取出当前缓存的数据，而不会再次发送SQL到数据库。
- 二级缓存：

总结：

建议统一使用第三方插件来做缓存，如redis，mamcache等，
关闭mybatis的一级缓存和二级缓存，
mybatis仅仅只限于orm框架，数据库和对象的映射，以及操作sql；