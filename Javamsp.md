- Java Map初始化

```java
public void demo(){
	private Map<String, String> mMap = new HashMap<String, String>();
	mMap.put("k1","v1");
	mMap.put("k2","v2");
}
```

- java8新特性-双括号初始化

```java
public void demo(){
	private Map<String, String> mMap = new HashMap<String, String>(){{
	put("k1","v1");
	put("k2","v2");
}}
}
```
- HashMap 转换成JSONObject

```java
 		HashMap<String,Object> problems = new HashMap<>();
        problems.put("title","问题数量");

        JSONObject jsonObject = new JSONObject();
        jsonObject.putAll(problems);
        
        return jsonObject;
```
Feign实现原理
```
启动后会会根据配置在启动类上的@SpringBootApplication去扫描贴了@FeignClient注解的类，并为其创建代理对象。
通过反射拿到代理类实现的接口：ProductFeignApi。
通过反射拿到接口上注解并且将注解中心的name属性拿出来：product-service。
通过反射拿到接口中的方法，并且拿到接口中方法上的注解@RequestMapping，并且把值拿出来：/product。
将方法中参数注解中的值也拿出来，这个是我们传进来的参数：productId。
拼接出路径：http://product-service/product?productId=1。
根据本地的服务清单去找对应的节点信息。
根据你配置的ribbon负载均衡策略去选择节点。
将product-service替换成对应的节点信息和端口。
使用RestTemplate发送请求。
```
Feign 使用步骤：
https://blog.csdn.net/Jzandth/article/details/109096862