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




#笔记
**4.3**
基于lambda表达式的比较器
```java
strList.sort((a, b) -> (a + b).compareTo(b + a));
```