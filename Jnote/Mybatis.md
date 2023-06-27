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

