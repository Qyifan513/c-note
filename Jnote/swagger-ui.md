##SpringBoot 集成 Swagger-UI 详解
- 准备：将两个 Swagger 的坐标数据放到项目的 pom.xml
```
<dependency>
  <groupId>io.springfox</groupId>
  <artifactId>springfox-swagger2</artifactId>
  <version>2.6.1</version>
</dependency>
<dependency>
  <groupId>io.springfox</groupId>
  <artifactId>springfox-swagger-ui</artifactId>
  <version>2.6.1</version>
</dependency>
```
引入后能够使用Swagger-ui的注解

**Swagger-UI 的集成注解**
- 一、Swagger-UI 集成注解与配置类分开配置

引入了 Swagger-UI 的 Maven 坐标之后，只需要在 SpringBoot 应用的启动类的上方加入开启 Swagger-UI 的注解即可在项目中来使用 Swagger-UI。开启使用 Swagger-UI 的注解：**@EnableSwagger2**。@EnableSwagger2 注解的声明通过 SpringBoot 应用去自动装配
- 二、Swagger-UI 集成注解与配置类集中配置
我们新建一个名为 Swagger2Config的类，在该类的最上方添加两个注解 **@Configuration** 和 **@EnableSwagger2**。将配置类和 Swagger-UI 的所有注解都通过 @Configuration 注解来处理。


**Swagger2一些常用注解**
- @API
https://blog.csdn.net/kang9399052316/article/details/105765068
