#maven(优秀的依赖管理工具)
Maven 是一款基于 Java 平台的项目管理和整合工具，它将项目的开发和管理过程抽象成一个项目对象模型（POM）。开发人员只需要做一些简单的配置，Maven 就可以自动完成项目的编译、测试、打包、发布以及部署等工作。

Maven 能够帮助开发者完成以下任务：
构建项目
生成文档
创建报告
维护依赖
软件配置管理
发布
部署

###约定优于配置
Maven对项目的目录结构、测试用例命名方式等内容都做了规定，凡是使用 Maven 管理的项目都必须遵守这些规则。Maven 项目构建过程中，会自动创建默认项目结构，开发人员仅需要在相应目录结构下放置相应的文件即可。

###Maven POM
POM（Project Object Model，项目对象模型）是 Maven 的基本组件，它是以 xml 文件的形式存放在项目的根目录下，名称为 pom.xml。 Maven 执行一个任务时，它会先查找当前项目的 POM 文件，读取所需的配置信息，然后执行任务。

在 POM 中可以设置如下配置：
项目依赖
插件
目标
构建时的配置文件
版本 
开发者
邮件列表

项目的唯一标识:工程组（groupId），及其名称（artifactId）和版本.
所有的 Maven 项目都有一个 POM 文件，所有的 POM 文件都必须有 project 元素和 3 个必填字段：groupId、artifactId 以及 version。
![本地图片](/pom1.png)


Maven 提供了大量不同类型的 Archetype 模板，通过它们可以帮助用户快速的创建 Java 项目，其中最简单的模板就是 maven-archetype-quickstart，它只需要用户提供项目最基本的信息，就能生成项目的基本结构及 POM 文件。

###Maven 坐标
Maven 坐标一套规则，它规定：世界上任何一个构件都可以使用 Maven 坐标并作为其唯一标识，Maven 坐标包括 **groupId、artifactId、version、packaging**等元素，只要用户提供了正确的坐标元素，Maven 就能找到对应的构件。 
helloMaven项目定义：
```
<project> 
    <groupId>net.biancheng.www</groupId>
    <artifactId>helloMaven</artifactId>
    <packaging>jar</packaging>
    <version>1.0-SNAPSHOT</version>
</project>
```

**依赖**：
- 如果一个 Maven 构建所产生的构件（例如 Jar 文件）被其他项目引用，那么该构件就是其他项目的依赖。
- Maven 坐标是依赖的前提
- 当 Maven 项目需要声明某一个依赖时，通常只需要在其 POM 中配置该依赖的坐标信息，Maven 会根据坐标自动将依赖下载到项目中。
例如，某个项目中使用 servlet-api 作为其依赖，其配置如下。
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
...
    <dependencies>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>servlet-api</artifactId>
            <version>2.5</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>
</project>
```
dependencies 元素可以包含一个或者多个 dependency 子元素，用以声明一个或者多个项目依赖，每个依赖都可以包含以下元素：
groupId、artifactId 和 version：依赖的基本坐标，对于任何一个依赖来说，基本坐标是最重要的，Maven 根据坐标才能找到需要的依赖。
type：依赖的类型，对应于项目坐标定义的 packaging。大部分情况下，该元素不必声明，其默认值是 jar。
scope：依赖的范围。
optional：标记依赖是否可选。
exclusions：用来排除传递性依赖。
大部分依赖声明只包含 groupId、artifactId 和 version 三个元素.
![本地图片](/pom1.png)
**获取依赖坐标**
通常情况下，绝大部分依赖的 Maven 坐标都能在 https://mvnrepository.com/ 中获取。
**仓库**
仓库就是存放依赖和插件的地方。
Maven 仓库可以分为 2 个大类：
本地仓库
远程仓库

当 Maven 根据坐标寻找构件时，它会首先查看本地仓库，若本地仓库存在此构件，则直接使用；若本地仓库不存在此构件，Maven 就会去远程仓库查找，若发现所需的构件后，则下载到本地仓库使用。如果本地仓库和远程仓库都没有所需的构件，则 Maven 就会报错。
**setings.xml详解**
https://www.cnblogs.com/jingmoxukong/p/6050172.html#settings.xml%E5%85%83%E7%B4%A0%E8%AF%A6%E8%A7%A3
**构建与测试**
http://c.biancheng.net/maven2/build-test.html


建立Maven项目时，网上建议的分别是 

1、cocoon-22-archetype-webapp

2、maven-archetype-quickstart

3、maven-archetype-webapp