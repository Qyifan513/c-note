
### java命名规范
内容参考：https://cloud.tencent.com/developer/article/1896438
#### *包：* 
##### 将功能相似或相关的类或接口进行分组管理。便于类的定位和查找，可以使用包来==避免类名的冲突==和==访问控制==。
- 一般采用顶级域名作为前缀。[域名由两组或两组以上的ASCII或各国语言字符构成，各组字符间由点号分隔开。最右边的字符组称为顶级域名或一级域名、倒数第二组称为二级域名、倒数第三组称为三级域名。]
- 随后紧跟公司/组织/个人名称以及功能模块名称。
- **包名使用小写英文字母进行命名**
- 使用“.”进行分割，每个被分割的单元只能包含一个名词。

#### *类：* 
- 首字母大写
- 通常采用名词进行命名
- 建议使用驼峰命名法书写类名
- 不建议使用缩写，除了约定俗成的
#### *接口：*
- 符合类名书写规范, 但是通常采用形容词或动词来描述接口的动作行为。
- 在Spring Framework标准库中，通常采用名词+动词/形容词的组合方式来命名接口
- 不建议使用大写的“I”作为接口前缀
#### *抽象类:*
- 与普通类的命名规范相当。
- 会以“Abstract”/“Base”作为类名的前缀

#### *异常类:*
- 使用“Exception”作为其后缀。
- 非检查异常,使用“Error”作为其后缀。
#### *方法：*
- 动词 或 动词 + 名词
- 驼峰命名法
eg.
```java
// 获取
public String getUserName(){
    
}
public List<Integer> getUserIds(){
    
}
public User getOne(){
    
} 
//查询 find query
public List<User> findOne(Integer id){
    
}
public List<Integer> findAll(){
    
}
public List<String> queryOrders(){
    
}
//条件 By With
public User findByUsername(String username){
    
}
public List<Integer> getUserIdsWithState(boolean state){
    
}
public List<User> findAllByUsernameOrderByIdDesc(String username){
    
}
//设置 
public void setName(String name){
    
}
public User insert(User user){
    
}
public void update(User user){
    
}
public void clearAll(){
    
}
//如果一个方法用于获取某组数据的长度或数量，则该方法应该使用length或size命名；如果方法的返回值为布尔类型(Boolean)，则该方法应该使用“is”或”has”作为前缀；

public long length(){
    
}
public int size(){
    
}
public boolean isOpen(){
    
}
public boolean isNotEmpty(){
    
}
public boolean hasLength(){
    
}
public Set<Integer> mapToSet(Map map){
    
}
public UserDto convertTo(User user){
    
}
public String toString(Object obj){
    
}
```
#### *变量：*
- 通常以小写字母开头
- 从第二个单词起首字母需要大写
- 不建议使用“_”作为前缀或者单词之间的分割符号。

#### *常量:*
- 全部大写的英文单词
- 单词之间统一使用“_”进行分割
#### **枚举:**
- 遵循普通类的命名约束条件
- 枚举类中定义的值的名称遵循常量的命名规范
- 枚举值的名称需要与类名有一定的关联性

eg.
```java
public enum ElementType{
    TYPE,
    FIELD,
    METHOD,
    PARAMETER,
    CONSTRUCTOR,
    LOCAL_VARIABLE,
    ANNOTATION_TYPE,
    PACKAGE,
    TYPE_PARAMETER,
    TYPE_USE;
}
```
#### *数组:*
```java
int[] array = new int[10];
int[] idArray ={1,2,3,4,5};
String[] nameArray = {"First","Yellow","Big"}

public List<String> getNameById(Integer[] ids){
    
}

public List<String> getNameById(Integer...ids){
    
}
```
#### 一个变量用于描述多个数据时，尽量使用单词的复数形式进行书写

#### *泛型类:*
- E [表示Element] 用于集合
- ID 表示对象的唯一标识符类型
- T 指代类
- K, V 通常用于Map
- N 表示数值类型
- ？表示不确定的Java类型
- X 表示异常
- U,S表示任意的类型。

```java
public class HashSet<E> extends AbstractSet<E>{
    
}
public class HashMap<K,V> extends AbstractMap<K,V>{
    
}
public class ThreadLocal<T>{
    
}
public interface Functor<T,X extends Throwable>{
    T val() throws X;
}
public class Container<K,V>{
    private K key;
    private V value;
    Container(K key,V value){
        this.key = key;
        this.value = value;
    }
    
}

public interface BaseRepository<T,ID>{
    T findById(ID id);

    void update(T t);

    List<T> findByIds(ID...ids);
}

public static <T> List<T> methodName(Class<T> clz){
    List<T> dataList = getByClz(clz);
    return dataList;
}
```
#### 接口实现类常用"Impl"作后缀
#### *测试类和测试方法:*
- 测试类采用被测试业务模块名/被测试接口/被测试类+“Test”
- 测试函数采用“test”+用例操作_状态

```java
public class UserServiceTest{

    public void testFindByUsernameAndPassword(){
        
    }

    public void testUsernameExist_notExist(){
        
    }

    public void testDeleteById_isOk(){
        
    }
}
```
#### BO DTO DAO PO  POJP    VO
![本地路径](./img/Object.png) 