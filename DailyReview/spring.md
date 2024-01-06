# Spring

Spring的一个最大的目的就是使JAVA EE开发更加容易。Spring Framework框架具有：非侵入式、控制反转、依赖注入、面向切面编程、容器、组件化和一站式。

**使用Spring框架的好处：**
#### Spring Framework的组件
##### Core Container
**其他模块建立的基础**
- Beans模块：提供框架的基础部分，包括控制反转和依赖注入
- Core核心模块：封装了 Spring 框架的底层部分,包括资源访问、类型转换及一些常用工具类。
- Context上下文模块：集成Beans模块功能并添加资源绑定、数据验证、容器生命周期和事件传播等。**ApplicationContext接口是上下文模块的焦点**
- SpEL表达式语言模块
##### Data Access/Integration(数据访问/集成)
- JDBC
- ORM
- OXM
- JMS
- Transactions事务模块：支持编程和声明式事务管理。

##### Web模块
- Web模块：提供了基本的 Web 开发集成特性，例如多文件上传功能、使用的 Servlet 监听器的 IOC 容器初始化以及 Web 应用上下文。
- Servlet模块：提供了一个 Spring MVC Web 框架实现。Spring MVC 框架提供了基于注解的请求资源注入、更简单的数据绑定、数据验证等及一套非常易用的 JSP 标签，完全无缝与 Spring 其他技术协作。
- WebSocket模块：快速的搭建 WebSocket Server，从而实现双向通讯。
- Webflux模块：完全异步且非阻塞的新的响应式web框架。
##### AOP、Aspects、Instrumentation和Messaging
##### Test模块 
Spring 支持 Junit 和 TestNG 测试框架，而且还额外提供了一些基于 Spring 的测试功能，比如在测试 Web 框架时，模拟 Http 请求的功能。

### 注入方式
https://blog.csdn.net/Eazon_chan/article/details/117130024

#### @JSONField注解

该注解在fastjson解析一个类为Json对象时，作用到类的每一个属性（field）上。

- 指定field对应的key名称：@JSONField(name = “NaMe”)
- 对于时间字段，指定其格式：@JSONField(format = “yyyy-MM-dd HH:mm:ss”)
- 不序列化某些字段：@JSONField(serialize = false)
- 指定顺序：@JSONField(ordinal = 1)
- 以上属性可以同时使用。

