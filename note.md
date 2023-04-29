#c++基础
##变量
变量和对象一般可以互换使用。对象是指一块能存储数据并==具有某种类型==的==内存空间==。
- 初始值
初始化：对象在创建时获得了一个特定的值。对象的名字随着定义也就马上可以使用了，可以用先定义的变量值去初始化后定义的其他变量。
```c++
//正确：price先被定义并赋值，随后被用于初始化discount
double price = 109.99,discount = price*0.16;
//正确
double salePrice = applyDiscount(price,discount);
```
==初始化不是赋值，初始化的含义是创建变量时赋予其一个初始值，而赋值的含义是把对象的当前值擦除，而以一个新值来替代==
==例子==:定义一个名为units_sold的int类型变量并初始化为0，则有四种实现方式：
```c++
//四种初始化方法
int units_sold = 0;
int units_sold = {0};
int units_sold{0};//列表初始化
int units_sold(0);
```
- 列表初始化
==如果使用列表初始化且初始值存在丢失信息的风险，则编译器将报错==
初始化时，如果提供的是初始元素值的列表，则只能把初始值都放在花括号里进行列表初始化，而不能放在圆括号里。以vector的初始化为例：
```c++
vector<string> v1{"a","an","the"};//列表初始化
vector<string> v2("a","an","the");//错误
```
- 默认初始化
如果变量在定义时没有指定初值，则变量被默认初始化。定义于任何函数体之外的变量被初始化为0。定义于函数体内的内置类型对象如果没有初始化则其值未定义。类的对象如果没有显式地初始化，则其值由类确定。
==建议初始化每一个内置类型变量==
- 变量命名规范
1、标识符要能够体现实际含义
2、变量名一般用小写字母
3、用户自定义类名一般以大写字母开头
4、如果标识符由多个单词组成，单词之间要有明显区分
用户自定义的标识符不能连续出现两个下划线，也不能以下划线加大写字母开头。定义在函数体外的标识符不能以下划线开头。
- 声明与定义==extern==
如果想要声明一个变量而非定义它，就在变量名前添加关键字extern，而且不要显式地初始化变量。
```c++
extern int i;//声明i,而非定义i
int j;//声明并定义j
extern double pi = 3.1416;//定义
```
在函数体内部，视图初始化一个由extern关键字标记的变量将引发错误。
- 作用域
C++语言中大部分作用域都以花括号分隔。名字的有效区域始于名字的声明语句，以声明语句所在的作用域末端为结束。
作用域之间能够彼此包含。被包含的作用域叫内层作用域，包含别的作用域的作用域叫外层作用域。允许在内层作用域重新定义外层中作用域中已经有的名字。==当作用域操作符::的左侧为空时，向全局作用域发出请求获取::右侧名字对应的变量。如果函数有可能用到某全局变量，则不宜再定义一个同名的局部变量。==
##类型转换
c++定义了一套包括算术类型和空类型在内的基本数据类型。算术类型又分为整型和浮点型两类。其中整型包括了字符和布尔类型。
- 选择类型
```
明确知晓数值不可能为负时，选择无符号类型。
使用int执行整数运算，如果数值超过了int的表示范围，则选用long long
算术表达式中不使用bool或char
选择double执行浮点数运算
```
- 赋值时的类型转换
==类型所能表示的值的范围决定了转换的过程==
1、浮点数赋值给整数类型时，结果仅仅保留浮点数中小数点之前的部分
2、整数值赋值给浮点类型时，小数部分记0。如果整数所占空间超过了浮点类型的容量，精度可能会有损失。
3、赋给无符号类型一个超过其表示范围的值时，结果是初始值对无符号类型表示数值总数取模后的余数。
4、赋给带符号类型一个超过其表示范围的值时，结果是未定义的。
- 隐式转换：自动执行的，无需程序员介入
==算术转换==：
1、整数提升：负责把小整数类型转换成较大的整数类型（转换后的类型能够容纳原来类型所有可能的值）
2、整数提升后，如果一个运算对象是无符号类型另一个是带符号类型：a，无符号类型不小于带符号类型，则带符号类型转换成无符号类型运算；b,无符号类型小于带符号类型，转换结果依赖于机器。
==指针的转换==
```
常量整数值0或者字面值nullptr能转换成任意指针类型；指向任意非常量的指针能够转换成void*；指向任意对象的指针能够转换成const void*
```
- 显式转换
==强制类型转换本质上是非常危险的==。强烈建议避免强制转换，尤其是reinterpret_cast。在有重载的函数中使用const_cast，无可厚非，但在其他地方使用意味着程序存在某种涉及缺陷。
格式：
```c++
cast-name<type>(expression);
//type:转换的目标类型
//expression:要转换的值
//cast-name：static_cast,const_cast,dynamic_cast和reinterpret_cast中的一种。
```
1、static_cast:任何具有明确定义的类型转换，只要不包含底层const,都可以使用static_cast。在把较大算术类型赋值给较小算术类型时非常有用。相当于告诉程序的读者和编译器，我们知道且不在意精度损失。
对于编译器无法自动执行的类型转换也很有用，例如：
```c++
//找回存在于void*指针中的值
void *p = &d;
double *dp = static_cast<double*>(p);//必须确保转换后所得类型就是指针所指的类型，一旦不符将产生未定义后果。
```
2、const_cast值能改变运算对象的底层const。
```c++
如果对象是常量，使用cnst_cast执行写操作会产生未定义后果
```
3、reinterpret_cast:为运算对象的位模式提供较低层次上的重新解释。
##复合类型
- 引用和指针
引用常指左值引言，引用本身不是一个对象，不能定义引用的引用。引用也没有实际地址不能定义指向引用的指针。
==除了两种特殊情况，引用的类型都得和与之绑定的对象严格匹配。指针也是如此。==
==空指针==
```c++
//生成空指针的方法:
int *p1 = nullptr;//nullptr可以被转换成任意其他指针类型。
int *p2 = 0;
//需要先#include cstdlib
int *p3 = NULL; 
```
==即使int类型变量的值等于0，也不能把int变量直接赋给指针。建议初始化所有指针==
```c++
int i = 42;
int *p1 = 0;//p1被初始化，但没有指向任何对象
int *p2 = &i;
p2 = 0;//现在p2不指向任何对象了。
```
任何非0指针对应的条件都是true。
void*可以用于存放任意对象的地址，但是不能直接操作其所指对象。
- 指向指针的引用
```c++
int i = 42;
int *p;
int *&r = p；//r是一个对指针的引用
r = &i;//令p指向i
```
==理解r的类型：从右往左看，离变量名最近的符号对变量类型具有最直接的影响。==
- const
const对象必须初始化，利用一个对象去初始化另外一个对象时，它们是不是const都无关紧要。
默认情况下const对象仅在文件内有效。当const变量需要在文件中共享时，可以对const变量不论声明还是定义都加extern关键字。
==初始化常量引用时允许用任意表达式作为初值，只要该表达式的结果能够转换成引用的类型即可==
```c++
const int ci = 1024;
int cj = 1024;
const int &r1 = ci;//正确
int &r2 = ci;//错误：试图让非常量引用指向一个常量对象
const int &r3 = cj;//正确，但无法通过常量引用修改cj对象
```
==严格来说并不存在常量引用。因为引用不是一个对象，我们没法让引用本身保持不变。==
- 指向常量的指针和常量指针
1、指向常量的指针（底层const)：不能用于改变其所指对象的值。==允许一个指向常量的指针指向非常量对象，但是无法用该指针改变所指对象的值。==
2、const指针（顶层const):把指针本身定为常量，必须初始化。==把*放在const关键字之前==指针本身是一个常量并不意味着不能通过指针修改其所指向的对象。
```c++
int errNumb = 0;
int *const curErr = &errNumb;
if(*curErr){
    *curErr = 0;//正确，把curErr所指对象的值重置
}
const double pi = 3.14159;
const double *const pip = &pi;
*pip = 2.71;//错误：pip是一个指向常量的常量指针。
```
- constexpr
常量表达式：在编译过程就能得到计算结果的值不会改变的表达式。声明为constexpr的变量一定是一个常量，且必须用常量表达式初始化constexpr类型。==一个constexpr指针的初始值必须是nullptr或者是0,或者是存储于某个固定地址中的对象。==cnstexpr把它所定义的对象置为了顶层const。
```c++
const int *p = nullptr;//指向整型常量的指针
constexpr int *q = nullptr;//指向整数的常量指针
```
- 类型别名
1、typedef
2、using
```c++
typedef double wages;
typedef wages base,*p;
using SI = Sales_item;
//等号左侧规定为右侧的别名
typedef char *pstring;
const pstring cstr = 0;//cstr是指向char的常量之指针
const pstring *ps;//ps是一个指针，它的对象是指向char的常量指针。
```
- auto
auto定义的变量必须有初始值。编译器通过初始值来推算变量类型。
1、auto一般忽略顶层const,保留底层const
```c++
int i = 0, &r = i;
auto a = r;//a是整数
const int ci = i, &cr = r;
auto b = ci;//b是整数
auto d = &i;//d是指向整数的指针
auto e = &ci;//e是指向整数常量的指针
auto &g = 42;//错误
const auto &h = 42;//正确，只能为常量引用绑定字面值
```
- decltype:选择并返回操作数的类型
1、如果decltype使用的表达式是一个变量，其返回该变量包括顶层const和引用在内的类型。==引用在decltype处不作为其所指对象的同义词出现==


2、decltype((variable))的结果永远是引用.
```c++
const int ci = 0, &cj = ci;
decltype(ci) x = 0;
decltype(cj) y = x;//y的类型是const int&,y绑定到x。
decltype(cj) z;//错误，引用要初始化
int i = 42, *p = &i;
decltype(*p) c;//错误引用要初始化。
```

```c++
int i = 42;
decltype((i)) d;//错误，d 是int&类型必须初始化。
```
==20230328记录==
前提：结构体listnode构成链表，头节点为l1,不能使用l1++，指向下一个结点。
```c++
#include <iostream>

 struct ListNode {
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
};
int main()
{
    ListNode *l1, *l2;
    ListNode* p = new ListNode(3);
    l1 = p;
    p = new ListNode(4);
    p->next = l1;
    l1 = p;
    p = new ListNode(5);
    p->next = l1;
    l1 = p;
   /* p = new ListNode(4);
    l2 = p;
    p = new ListNode(6);
    p->next = l2;
    l2 = p;
    p = new ListNode(5);
    p->next = l2;
    l2 = p;*/
    ListNode* a = l1;
    while (l1 != nullptr) {
        std::cout << l1->val;
        //l1++;错误！！！！！
        l1 = l1 ->next;
    }
        return 0;
}
```


#c++标准库
#c++类设计者工具
