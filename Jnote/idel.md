## SQL学习网页
https://www.w3school.com.cn/sql/sql_insert.asp
##报错记录
- idea Maven报Unable to import maven project: See logs for details解决方法
https://blog.csdn.net/zz18435842675/article/details/102662527/
idel 与maven版本不兼容：
```
2023-02-05 17:29:12,090 [ 119227]  ERROR -      #org.jetbrains.idea.maven - JDK: 11.0.7; VM: OpenJDK 64-Bit Server VM; Vendor: JetBrains s.r.o. 

```
- 解决IDEA快速构建Maven工程报错：No archetype found in remote catalog. Defaulting to internal catalog：翻译的意思：在远程目录中找不到原型。默认为内部目录

解决：1、创建Maven项目的时候添加属性： archetypecatalog=internal
2、![本地图片](/11.png)

**IDEA整理代码格式**

- 右键选择Reformat Code
- 快捷键Ctrl+Alt+L
IDEA中连接PostgreSQL数据库：https://blog.csdn.net/yangguang_98/article/details/119479234

# Navicat
Navicat创建pgsql序列自增:
https://blog.csdn.net/bjhan_csdn/article/details/108023266