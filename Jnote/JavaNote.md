##java基本语法
+ 对于所有的类来说，==类名的首字母应该大写==。如果类名由若干单词组成，那么每个单词的首字母应该大写.
+ 所有的方法名都应该以小写字母开头。
+ 源文件名必须和类名相同。
+ ==java大小写敏感==
+ 所有的 Java 程序由 public static void main(String[] args) 方法开始执行。
+ Java 所有的组成部分都需要名字。类名、变量名以及方法名都被称为标识符。
+ ==所有的标识符都应该以字母（A-Z 或者 a-z）,美元符（$）、或者下划线（_）开始==
+ ==标识符由字母、美元符、下划线和数字组成==

####常量
- final 关键字可以用于声明属性（常量），方法和类。当 final 修饰属性时，代表该属性一旦被分配内存空间就必须初始化，它的含义是“这是无法改变的”或者“终态的”。
- 字符串是常量，它们的值在创建之后不能更改。
```java
//String对象初始化格式。
String s0 = "abc";
String s1 = new String("abd");
```
- String 是无法被修改的，对 String 的修改，其实是新建了一个 String 对象。如果需要修改字符串的内容，可以使用 StringBuilder。它相当于一个存储字符的容器。

###关系运算符

* == 和 != 适用于所有的基本数据类型，其他关系运算符不适用于 boolean，因为 boolean 值只有 true 和 false，比较没有任何意义。
* == 和 != 也适用于所有对象，可以比较对象的引用是否相同。

==引用：Java 中一切都是对象，但操作的标识符实际是对象的一个引用。==

###数组
```java
数据类型[ ] 数组名;   //或者: 数据类型 数组名[ ];  
int ages[];      //存放年龄的数组，类型为整型  
char symbol[];   //存放符号的数组，类型为字符型  
String [] name;  //存放名称的数组，类型为字符串型  
```

###对象
新建对象实例：
```java
Object object=new Object();//变量object保存的是Object对象的引用。

Object object1 = new Object();
Object object2 = object1;
System.out.println(object1 == object2);
```
运行得到的结果为 true，说明 object1 和 object2 的内存地址相同。
java中创建对象的5种方法：
- new关键字
- Class.newInstance(运用反射创建对象时最常用的方法)
```java
public class Main {
    public static void main(String[] args) throws Exception {
        Person person = Person.class.newInstance();
        System.out.println(person); // Person{name='null', age=null}
    }

}
```
Class类的newInstance使用的是类的public的无参构造器。因此也就是说使用此方法创建对象的前提是必须有public的无参构造器。
- Constructor.newInstance
- Clone方法
- 反序列化
java创建对象的5种方式
https://cloud.tencent.com/developer/article/1497720

### static 
####静态成员
- Java 中被 static 修饰的成员称为静态成员或类成员。
- 被 static 修饰的成员属于整个类所有，即被类的所有对象所共享。
- 静态成员除了可以使用对象名进行访问外还可以使用类名直接访问。
####静态方法
- 被 static 修饰的方法是静态方法。
- 静态方法不需要将类实例化就可以调用
- 不能有this
- 不能访问非静态成员和非静态方法

### final
- final 修饰类，则该类不允许被继承，为最终类。
- final 修饰方法，则该方法不允许被覆盖（重写）。
- final 修饰属性：则该类的属性不会进行隐式的初始化。
- final 修饰变量，则该变量的值只能赋一次值，即常量。

##常用类
**Arrays**
- 方法：int binarySearch(Object[] a, Object key)
  对==排序后==的数组使用==二分法==查找数据，
  
**Calendar和DateFormat**
问题：
```java
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
    public static void main(String[] args) {
        System.out.println("完整显示日期时间：");
        // 字符串转换日期格式
        DateFormat fdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = fdate.format(new Date());
        System.out.println(str);

        // 创建 Calendar 对象
        Calendar calendar = Calendar.getInstance();
        // 初始化 Calendar 对象，但并不必要，除非需要重置时间
        calendar.setTime(new Date());

        // 显示年份
        System.out.println("年： " + calendar.get(Calendar.YEAR));

        // 显示月份 (从0开始, 实际显示要加一)
        System.out.println("月： " + calendar.get(Calendar.MONTH));


        // 当前分钟数
        System.out.println("分钟： " + calendar.get(Calendar.MINUTE));

        // 今年的第 N 天
        System.out.println("今年的第 " + calendar.get(Calendar.DAY_OF_YEAR) + "天");

        // 本月第 N 天
        System.out.println("本月的第 " + calendar.get(Calendar.DAY_OF_MONTH) + "天");

        // 3小时以后
        calendar.add(Calendar.HOUR_OF_DAY, 3);
        System.out.println("三小时以后的时间： " + calendar.getTime());
        // 格式化显示
        str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime());
        System.out.println(str);

        // 重置 Calendar 显示当前时间
        calendar.setTime(new Date());
        str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime());
        System.out.println(str);

        // 创建一个 Calendar 用于比较时间
        Calendar calendarNew = Calendar.getInstance();

        // 设定为 5 小时以前，后者大，显示 -1
        calendarNew.add(Calendar.HOUR, -5);
        System.out.println("时间比较：" + calendarNew.compareTo(calendar));

        // 设定7小时以后，前者大，显示 1
        calendarNew.add(Calendar.HOUR, +7);
        System.out.println("时间比较：" + calendarNew.compareTo(calendar));

        // 退回 2 小时，时间相同，显示0
        calendarNew.add(Calendar.HOUR, -2);
        System.out.println("时间比较：" + calendarNew.compareTo(calendar));

        // calendarNew创建时间点
        System.out.println((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendarNew.getTime()));
        // calendar创建时间点
        System.out.println((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime()));
        System.out.println("时间比较：" + calendarNew.compareTo(calendar));
    }
}
```
==最后一个的输出为什么有时是 0 ，有时是 1?==

**System**
```java
//从指定的源数组中复制一个数组，从源数组指定的位置开始，到目标数组指定的位置
public static void arraycopy(Object src,int srcPos, Object dest,int desPos,int length)
//返回以毫秒为单位的当前时间(从1970年到现在的毫秒数)
public static long currentTimeMillis()
//终止当前正在运行的Java虚拟机，status为 0时退出
public static void exit(int status)
//  运行垃圾收集器
public static void gc()
// 取得当前系统的全部属性
public static Properties getProperties()
//获取指定键的系统属性
public static String  getProperty(String key)
```
##泛型和集合
Java 使用集合来组织和管理对象。
定义泛型的规则：
- 只能是引用类型，不能是简单数据类型。
- 泛型参数可以有多个。
- 可以用使用 extends 语句或者 super 语句 如 <T extends superClass> 表示类型的上界，T 只能是 superClass 或其子类， <K super childClass> 表示类型的下界，K 只能是 childClass 或其父类。
- 可以是通配符类型，比如常见的 Class<?>。单独使用 ? 可以表示任意类型。也可以结合 extends 和 super 来进行限制。
- 父类定义的类型参数不能被子类继承。
- 使用通配符实现多态：
```java
import java.util.List;
import java.util.ArrayList;

public class Test {

  // List<?> 表示接受一个元素为任意类型的列表 List。
    public void testDemo(List<?> s){
        for(Object obj:s){
            System.out.println("我的类型是" + obj.getClass().getName());
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test test = new Test();
        Dog a0 = new Dog();
        Animal a1 = new Animal();
    // 声明一个接收元素类型是 Animal 的列表 List s。
    // 然后创建一个元素类型是 Animal 的 ArrayList 赋值给 s。
        List<Animal> s = new ArrayList<Animal>();
    // Dog a0 是 Animal 的子类，可以向上转型为 Animal 类型
        s.add(a0);
        s.add(a1);
        test.testDemo(s);
    }
}
java 教程网页a:
https://www.w3schools.cn/java/
```
**Arrays**
- public StringBuilder replace​(int start, int end, String str)
当你需要对一个 StringBuilder 对象中的一段特定的字符序列进行替换时，可以使用 replace 方法。该方法可以接受三个参数：start、end 和 str。

start 表示要替换的起始索引位置，__end 表示要替换的结束索引位置（不包括该索引位置对应的字符）__，str 表示用于替换的字符串。
```java
StringBuilder sb = new StringBuilder("Hello, world!");
sb.replace(0, 5, "Hi");
System.out.println(sb.toString()); // 输出 "Hi, world!"
```
**Java 接口**
接口（英文：Interface），在JAVA编程语言中是一个抽象类型，是抽象方法的集合，接口通常以**interface**来声明。一个类通过继承接口的方式，从而来继承接口的抽象方法。
###集合框架
集合框架是一个用来代表和操纵集合的统一架构。
**List**

**Deque**
https://blog.csdn.net/devnn/article/details/82716447


#笔记
**4.3**
基于lambda表达式的比较器
```java
strList.sort((a, b) -> (a + b).compareTo(b + a));
```
**lambda**
final 和 effectively final 的区别



### java类型转换
- 简单数据类型之间的转换
- 字符串与其它数据类型的转换
- 其它实用数据类型转换

**构造方法是不能继承的**
IDEA快捷键：Alt + insert 
Ctrl + Alt +M
Ctrl + Alt + t
- JVM虚拟机启动后会自动启动多条线程，其中有一条main线程调用main方法
- java采用抢占式调度

**守护线程**
其他非守护线程执行完毕后，守护线程会陆续结束
- yield

**同步代码块**
- 同步方法（修饰符后加synchromized）：锁对象不能自己指定。对非静态方法，锁对象是this;对静态方法，锁对象是当前类的字节码文件对象。锁住方法里所有代码
- lock
eg.
```java
static Lock lock = new ReentrantLock();
```
### 线程池
线程池的主要参数：
1）corePoolSize（必需）：核心线程数。默认情况下，核心线程会一直存活，但是当将 allowCoreThreadTimeout 设置为 true 时，核心线程也会超时回收。
2）maximumPoolSize（必需）：线程池所能容纳的最大线程数。当活跃线程数达到该数值后，后续的新任务将会阻塞。
3）keepAliveTime（必需）：线程闲置超时时长。如果超过该时长，非核心线程就会被回收。如果将 allowCoreThreadTimeout 设置为 true 时，核心线程也会超时回收。
4）unit（必需）：指定 keepAliveTime 参数的时间单位。常用的有：TimeUnit.MILLISECONDS（毫秒）、TimeUnit.SECONDS（秒）、TimeUnit.MINUTES（分）。
5）workQueue（必需）：任务队列。通过线程池的 execute() 方法提交的 Runnable 对象将存储在该参数中。其采用阻塞队列实现。
6）threadFactory（可选）：线程工厂。用于指定为线程池创建新线程的方式（给线程指定名称）。
7）handler（可选）：拒绝策略。当达到最大线程数时需要执行的饱和策略。
- 线程池的执行流程
- 线程池的拒绝策略：
AbortPolicy默认：丢弃任务并抛出 RejectedExecutionException 异常。
CallerRunsPolicy：由调用线程处理
DiscardPolicy:丢弃任务，不抛异常
DiscardOldestPolicy:丢弃队列最早的未处理任务，然后重新尝试执行。

核心线程数的设置：
8020原则：按照80%的时间下，系统产生的任务数设计核心线程数；剩下的20%按照最大线程数处理。

如何合理估算线程池大小？
http://ifeve.com/how-to-calculate-threadpool-size/

线程池优化：
1）用ThreadPoolExecutor自定义线程池，看线程是的用途，如果任务量不大，可以用无界队列，如果任务量非常大，要用有界队列，防止OOM
2）如果任务量很大，还要求每个任务都处理成功，要对提交的任务进行阻塞提交，重写拒绝机制，改为阻塞提交。保证不抛弃一个任务
3）最大线程数一般设为2N+1最好，N是CPU核数
4）核心线程数，看应用，如果是任务，一天跑一次，设置为0，合适，因为跑完就停掉了，如果是常用线程池，看任务量，是保留一个核心还是几个核心线程数
5）如果要获取任务执行结果，用CompletionService，但是注意，获取任务的结果的要重新开一个线程获取，如果在主线程获取，就要等任务都提交后才获取，就会阻塞大量任务结果，队列过大OOM，所以最好异步开个线程获取结果。

**索引**
索引是一种能提高数据库查询效率的数据结构。
索引一般存储在磁盘的文件中，它是占用物理空间的。
适当的索引能提高查询效率，过多的索引会影响数据库表的插入和更新功能。

- 聚集索引
- 非聚集索引

聚簇索引并不是一种单独的索引类型，而是一种数据存储方式。它表示索引结构和数据一起存放的索引。非聚集索引是索引结构和数据分开存放的索引.

聚簇索引与非聚簇索引：在 InnoDB 中，聚簇索引又称主键索引，它的叶子节点存的是整行数据。主键查询主需要扫描主键索引。二级索引又称非主键索引，它的叶子节点内容是主键的值。通过二级索引需要扫描二级索引树，找到主键后再扫描主键索引。该过程称为回表。

**哪些场景不适合建立索引？**
数据量少的表，不适合加索引
更新比较频繁的也不适合加索引
区分度低的字段不适合加索引（如性别）
where、group by、order by等后面没有使用到的字段，不需要建立索引
已经有冗余的索引的情况（比如已经有a,b的联合索引，不需要再单独建立a索引）

**什么样的字段适合创建索引？什么情况下不宜建立索引?**

适合创建索引：

经常作查询选择的字段
经常作表连接的字段
经常出现在 order by, group by, distinct 后面的字段
不适合创建索引：

对于查询中很少涉及的列或者重复值比较多的列，不宜建立索引
对于一些特殊的数据类型，不宜建立索引，比如文本字段（text）等

**创建索引时需要注意什么？**

- 非空字段：应该指定列为 NOT NULL，除非你想存储 NULL。在 MySQL 中，含有空值的列很难进行查询优化，因为它们使得索引、索引的统计信息以及比较运算更加复杂。你应该用0、一个特殊的值或者一个空串代替空值
- 取值离散大的字段：（变量各个取值之间的差异程度）的列放到联合索引的前面，可以通过 count() 函数查看字段的差异值，返回值越大说明字段的唯一值越多字段的离散程度高
- 索引字段越小越好：数据库的数据存储以页为单位，一页存储的数据越多，一次 IO 操作获取的数据越大，效率越高

**乐观锁和悲观锁**

悲观锁：假定会发生并发冲突，屏蔽一切可能违反数据完整性的操作。其特点为特点是先获取锁，再进行业务操作。

乐观锁：假设不会发生并发冲突，只在提交操作时检查是否违反数据完整性。乐观锁的特点先进行业务操作，只在最后实际更新数据时进行检查数据是否被更新过，若未被更新过，则更新成功；否则，失败重试。乐观锁一般的做法是在需要锁的数据上增加一个版本号或者时间戳。

读多写少更适合用乐观锁，读少写多更适合用悲观锁。
### java基础知识


