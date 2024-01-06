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


Redis是完全开源免费的，遵守BSD协议，是一个高性能的key-value数据库。非关系型数据库。


Redis支持数据的持久化，可以将内存中的数据保存在磁盘中，重启的时候可以再次加载进行使用。

Redis不仅仅支持简单的key-value类型的数据，同时还提供list，set，zset，hash等数据结构的存储。

Redis支持数据的备份，即master-slave模式的数据备份。

- Redis 有 5 种基础数据结构，String、Hash、List、Set、SortedSet
### Redis 是如何实现数据不丢失的呢

Redis 数据是存储在内存中的，为了保证 Redis 数据不丢失，那就要把数据从内存存储到磁盘上，以便在服务器重启后还能够从磁盘中恢复原有数据，这就是 Redis 的数据持久化。Redis 数据持久化有三种方式。

1）AOF 日志（Append Only File，文件追加方式）：记录所有的操作命令，并以文本的形式追加到文件中。

2）RDB 快照（Redis DataBase）：将某一个时刻的内存数据，以二进制的方式写入磁盘。

3）混合持久化方式：Redis 4.0 新增了混合持久化的方式，集成了 RDB 和 AOF 的优点。

AOF 和 RDB 的实现原理:
AOF 采用的是写后日志的方式，Redis 先执行命令把数据写入内存，然后再记录日志到文件中。AOF 日志记录的是操作命令，不是实际的数据，如果采用 AOF 方法做故障恢复时需要将全量日志都执行一遍。

RDB 采用的是内存快照的方式，它记录的是某一时刻的数据，而不是操作，所以采用 RDB 方法做故障恢复时只需要直接把 RDB 文件读入内存即可，实现快速恢复。


Redis 提供了两个命令来生成 RDB 快照文件，分别是 save 和 bgsave。save 命令在主线程中执行，会导致阻塞。而 bgsave 命令则会创建一个子进程，用于写入 RDB 文件的操作，避免了对主线程的阻塞，这也是 Redis RDB 的默认配置。

**Redis 如何实现高可用**
主从复制、哨兵模式，以及 Redis 集群。

## 报错记录
- Creating Server ICP listening socket 127.0.0.1:6379:bind:No error
- 原因：6379端口已绑定。应该是因为上次服务没有关闭

解决方案：
```
redis-cli
shutdown
exit
redis-server redis.windows.conf
```
https://blog.csdn.net/qq_38220334/article/details/105527236