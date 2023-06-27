## Windows 下redis安装

博客：https://blog.csdn.net/veryitman/article/details/109705691
- 安装地址：https://github.com/MicrosoftArchive/redis/releases
- 下载Redis-x64-版本号.zip
- 压缩包解压到任意目录
cmd进入刚才解压文件的根目录下，然后执行如下命令
```bash
redis-server.exe redis.windows.conf
```
**日志文件**
在 Redis 解压后的根目录，新建 Logs 目录，然后在该目录下新建 redis_log.txt 文件。
```
redis-cli.exe
```
```
shutdown

exit
```
**设置 Redis 成 Windows 服务**

```
redis-server.exe --service-install redis.windows-service.conf --loglevel verbose --service-name Redis
```
```
redis-server.exe --service-start
```

##ERROR记录
- Redis连接——Could not connect to Redis at 127.0.0.1:6379: Connection refused
这个问题一般是关闭了服务端导致客户端打不开，最简单快捷解决办法就是先开启服务端，再去连接客户端！

- 启动redis服务报错：windows无法启动redis服务（位于 本地计算机上），错误：1067：进程意外终止。
检查端口是否被占用。
解决的博客:
https://www.cnblogs.com/MagicAsa/p/10407049.html#:~:text=Windows%20%E4%B8%8B%20Redis%20%E6%9C%8D%E5%8A%A1%E6%97%A0%E6%B3%95%E5%90%AF%E5%8A%A8%EF%BC%8C%E9%94%99%E8%AF%AF%201067%20%E8%BF%9B%E7%A8%8B%E6%84%8F%E5%A4%96%E7%BB%88%E6%AD%A2%E8%A7%A3%E5%86%B3%E6%96%B9%E6%A1%88%201.%E6%A3%80%E6%9F%A5%E7%AB%AF%E5%8F%A3%E6%98%AF%E5%90%A6%E8%A2%AB%E5%8D%A0%E7%94%A8,2.%E4%BF%AE%E6%94%B9%20Windows%20%E6%9C%8D%E5%8A%A1%E9%87%8C%E7%9A%84%20Redis%20%E6%9C%8D%E5%8A%A1%E4%B8%BA%20%E6%9C%AC%E5%9C%B0%E7%B3%BB%E7%BB%9F%20%E6%9C%8D%E5%8A%A1%EF%BC%88%E4%BF%AE%E6%94%B9%E6%96%B9%E5%BC%8F%E8%A7%81%E4%B8%8B%E6%96%87%EF%BC%89

## java连接redis
**连接池** 连接池（Connection Pool）是一种常见的数据库连接管理技术，它通过事先创建并维护一定数量的数据库连接，以便在应用程序需要时快速地获取连接，提高数据库的访问效率。接池技术可以提高数据库的访问效率和性能，适用于高并发访问的应用程序。

**Spring Boot 整合 Redis 案例**
- 一、缓存
缓存就是一个存储器，在技术选型中，常用 Redis 作为缓存数据库。比如常见的电商场景，根据商品 ID 获取商品信息时，店铺信息和商品详情信息就可以缓存在 Redis，直接从 Redis 获取。减少了去数据库查询的次数。
- 二、**更新缓存的策略** http://coolshell.cn/articles/17416.html
更新缓存的的Design Pattern有四种：Cache aside, Read through, Write through, Write behind caching.
Cache Aside Pattern:
失效：应用程序先从cache取数据，没有得到，则从数据库中取数据，成功后，放到缓存中。
命中：应用程序从cache中取数据，取到后返回。
更新：先把数据存到数据库中，成功后，再让缓存失效。
Read/Write Through Pattern:
可以理解为，应用认为后端就是一个单一的存储，而存储自己维护自己的Cache。

Write behind caching:
Write Back套路，一句说就是，在更新数据的时候，只更新缓存，不更新数据库，而我们的缓存会异步地批量更新数据库。这个设计的好处就是让数据的I/O操作飞快无比。

redis连接可视化工具
https://blog.csdn.net/qq_39715000/article/details/120724800



