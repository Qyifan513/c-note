##NVM管理nodejs
### 使用 nvm 管理不同版本的 node 与 npm
首先最重要的是：一定要卸载已安装的 NodeJS，否则会发生冲突。然后下载 nvm-windows 最新安装包https://github.com/coreybutler/nvm-windows/releases，直接安装即可。

官方文档：https://cn.vuejs.org/guide/quick-start.html#creating-a-vue-application

window下安装并使用nvm（含卸载node、卸载nvm、全局安装npm）：
https://blog.csdn.net/HuangsTing/article/details/113857145

nvm教程:https://liushiming.cn/article/nodejs-version-manager-nvm-tutorial.html#%E7%94%A8%E7%89%B9%E5%AE%9A%E7%9A%84_nodejs_%E7%89%88%E6%9C%AC%E8%BF%90%E8%A1%8C%E5%BA%94%E7%94%A8


#### Windows中如何在windows中卸载完整的NVM
https://cloud.tencent.com/developer/ask/sof/106894317
```
nvm list
//要卸载特定的NodeJs包，运行
nvm uninstall v16.13.0
//卸载所有软件包后，转到目录：
C:\Users\YOUR USER\AppData\Roaming\nvm
//执行unins***.exe
```

**nvm常用命令**
- nvm // 会提示nvw下的相关命令
- nvm ls // 查看已安装node版本
- nvm install vXX // 安装对应vXX版本的node
- nvm uninstall> vXX // 卸载对应vXX版本的-  - node
- nvm use xxx // 选择使用XXX版本

**npm install 安装出错时尝试过的方法**

https://blog.csdn.net/cc18868876837/article/details/81542282

### 如何从Windows中删除Node.js：
1.从卸载程序卸载程序和功能。

2.重新启动（或者您可能会从任务管理器中杀死所有与节点相关的进程）。

3.寻找这些文件夹并删除它们（及其内容）（如果还有）。根据您安装的版本，UAC设置和CPU架构，这些可能或可能不存在：
```
C:\Program Files (x86)\Nodejs
C:\Program Files\Nodejs
C:\Users\{User}\AppData\Roaming\npm（或%appdata%\npm）
C:\Users\{User}\AppData\Roaming\npm-cache（或%appdata%\npm-cache）
```
4.检查您的%PATH%环境变量以确保没有引用Nodejs或npm存在。

5.如果仍然没有卸载，请where node在命令提示符下键入，您将看到它所在的位置 - 删除（也可能是父目录）。

6.重新启动，很好的措施。
- 如何查看项目中采用的node版本

https://www.cnblogs.com/wang715100018066/p/16613457.html

- 如何查看项目的vue版本
https://blog.csdn.net/zhanduo0118/article/details/115407048
##Vue
**Vue (发音为 /vjuː/，类似 view) 是一款用于构建用户界面的 JavaScript 框架。**

###Vue的生命周期
- 开始创建
- 初始化数据
- 编译模板
- 挂载DOM
- 渲染 -》 更新 -》 渲染
- 卸载
## 标签笔记
- <a>标签
<a> 标签定义超链接，用于从一个页面链接到另一个页面。
<a> 元素最重要的属性是 href 属性，它指定链接的目标。
- <div>
  
<div> 标签定义 HTML 文档中的一个分隔区块或者一个区域部分。
<div>标签常用于组合块级元素，以便通过 CSS 来对这些元素进行格式化。
- <p>
<p> 标签定义段落。
<p>元素会自动在其前后创建一些空白。浏览器会自动添加这些空间，您也可以在样式表中规定。


- computed vs methods
我们可以使用 methods 来替代 computed，效果上两个都是一样的，但是 computed 是基于它的依赖缓存，只有相关依赖发生改变时才会重新取值。而使用 methods ，在重新渲染的时候，函数总会重新调用执行。

**vuex**
vuex是实现组件全局状态（数据）管理的一种机制，可以方便组件之间的数据共享。
- template中this.$store.state.count中this可以省略
- mutatuon:
只有mutation中定义的函数有权利修改state中的数据
不要在mutation中执行异步操作->利用Action

## javaScripts
**let**
在 ES2015 之前，JavaScript 是没有块作用域的。可以使用 let 关键词声明拥有块作用域的变量。
```js
{ 
  var x = 10; 
}
// 此处可以使用 x
{ 
  let y = 10;
}
// 此处不可以使用 y
```
**const**
不是真正的常数，它没有定义常量值。它定义了对值的常量引用。
我们不能更改常量原始值，但我们可以更改常量对象的属性。
```js
const PI = 3.141592653589793;
PI = 3.14;      // 会出错
PI = PI + 10;   // 也会出错

// 您可以创建 const 对象：
const car = {type:"porsche", model:"911", color:"Black"};

// 您可以更改属性：
car.color = "White";

// 您可以添加属性：
car.owner = "Bill";
```

**事件**
方法必须定义在vue的Method对象中。

**Vue绑定事件**
- v-on
- **v-model** 是 Vue.js 中用于双向数据绑定的指令。它可以将表单元素的值与 Vue 实例中的数据进行绑定，使得当表单元素的值发生变化时，Vue 实例中的数据也会随之更新，反之亦然。v-model 通常用于表单元素。
- jquery在线手册http://hemin.cn/jq/

**Axios** 是一个基于 promise 的网络请求库，可以用于浏览器和 node.js


**Vue中的methods方法**
我们可以使用 methods 属性给 Vue 定义方法，methods 的基本语法：
```
var vm = new Vue(
    methods:{
        // 在此时定义方法，方法之间使用逗号分隔
        方法名:function(){}
});

```
- 在 methods 方法中访问 data 的数据，可以直接通过 this.属性名 的形式来访问。
- 常用属性和方法：https://juejin.cn/post/6844903992196071432


## Vue Router


例子1：
```html
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/vue-router@4"></script>

<div id="app">
  <h1>Hello App!</h1>
  <p>
    <!--使用 router-link 组件进行导航 -->
    <!--通过传递 `to` 来指定链接 -->
    <!--`<router-link>` 将呈现一个带有正确 `href` 属性的 `<a>` 标签-->
    <router-link to="/">Go to Home</router-link>
    <router-link to="/about">Go to About</router-link>
  </p>
  <!-- 路由出口 -->
  <!-- 路由匹配到的组件将渲染在这里 -->
  <router-view></router-view>
</div>

```
```js
// 1. 定义路由组件.
// 也可以从其他文件导入
const Home = { template: '<div>Home</div>' }
const About = { template: '<div>About</div>' }

// 2. 定义一些路由
// 每个路由都需要映射到一个组件。
// 我们后面再讨论嵌套路由。
const routes = [
  { path: '/', component: Home },
  { path: '/about', component: About },
]

// 3. 创建路由实例并传递 `routes` 配置
// 你可以在这里输入更多的配置，但我们在这里
// 暂时保持简单
const router = VueRouter.createRouter({
  // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
  history: VueRouter.createWebHashHistory(),
  routes, // `routes: routes` 的缩写
})

// 5. 创建并挂载根实例
const app = Vue.createApp({})
//确保 _use_ 路由实例使
//整个应用支持路由。
app.use(router)

app.mount('#app')

// 现在，应用已经启动了！

```
vue步骤：
- 1、定义（路由）组件。
- 2、定义路由（eg.定义`routes` 配置）
- 3、创建 router 实例，然后传 `routes` 配置
- 4、创建和挂载根实例。通过 router 配置参数注入路由，从而让整个应用都有路由功能。

#### 带参数的动态路由匹配

- eg.路径参数 用冒号 : 表示。
```js
const User = {
  template: '<div>User</div>',
}

// 这些都会传递给 `createRouter`
const routes = [
  // 动态字段以冒号开始
  { path: '/users/:id', component: User },
]
```
- 一个路由被匹配时,它的 params 的值将在每个组件中以 this.$route.params 的形式暴露出来。$route.params

```js
const User = {
  template: '<div>User {{ $route.params.id }}</div>',
}
```
- 自定义的 路径参数 正则表达式

```js
const routes = [
  // 将匹配所有内容并将其放在 `$route.params.pathMatch` 下
  { path: '/:pathMatch(.*)*', name: 'NotFound', component: NotFound },
  // 将匹配以 `/user-` 开头的所有内容，并将其放在 `$route.params.afterUser` 下
  { path: '/user-:afterUser(.*)', component: UserGeneric },
]
```

path: '/:pathMatch(.*)*' 表示将匹配以斜杠开头的所有路径，并将路径参数放在 $route.params.pathMatch 下。
:pathMatch 是一个路径参数，表示匹配所有的路径。
(.*)* 是一个正则表达式，用于匹配零个或多个任意字符。这里使用了 .* 表示匹配任意字符，而后面的 * 表示可以匹配零个或多个字符，这样就可以匹配任意长度的路径了。

- 路由的匹配语法
- ? 修饰符(0 个或 1 个)；
*（0 个或多个）和 +（1 个或多个）将参数标记为可重复.
```js
const routes = [
  // /:chapters ->  匹配 /one, /one/two, /one/two/three, 等
  { path: '/:chapters+' },
  // /:chapters -> 匹配 /, /one, /one/two, /one/two/three, 等
  { path: '/:chapters*' },
]
```
```js
// 给定 { path: '/:chapters*', name: 'chapters' },
router.resolve({ name: 'chapters', params: { chapters: [] } }).href

// 给定 { path: '/:chapters+', name: 'chapters' },
router.resolve({ name: 'chapters', params: { chapters: [] } }).href
// 抛出错误，因为 `chapters` 为空
```
- 路由的Sensitive 与 strict
默认情况下，所有路由是不区分大小写的，并且能匹配带有或不带有尾部斜线的路由。例如，路由 /users 将匹配 /users、/users/、甚至 /Users/。这种行为可以通过 strict 和 sensitive 选项来修改。

- 导航：
- 1、使用 <router-link> 创建 a 标签来定义导航链接
- 借助 router 的实例方法，通过编写代码来实现

在 Vue 实例中，你可以通过 $router 访问路由实例。因此你可以调用 this.$router.push。
- `params` 不能与 `path` 一起使用

- 导航的三种方法：
声明式：<router-link :to="...">
编程式：
1、router.push(...) 向history 添加新记录
在传递给 router.push 的 routeLocation 中增加一个属性 replace: true ---》不向history 添加新记录
```js
router.push({ path: '/home', replace: true })
// 相当于
router.replace({ path: '/home' })
```
2、router.replace(...) 不向history 添加新记录

- 重定向!!看看视频

你的路由有参数 --> 路由的别名也应该包含参数

==将 props 传递给路由组件==
当 props 设置为 true 时，route.params 将被设置为组件的 props。

```js
const User = {
  // 请确保添加一个与路由参数完全相同的 prop 名
  props: ['id'],
  template: '<div>User {{ id }}</div>'
}
const routes = [{ path: '/user/:id', component: User, props: true }]
```

#### 导航守卫
vue-router 提供的导航守卫主要用来通过跳转或取消的方式守卫导航。
守卫方法接收两个参数:
to: 即将要进入的目标 用一种标准化的方式
from: 当前导航正要离开的路由 用一种标准化的方式

==查一查可选的第三个参数 next!==
守卫方法 返回值：
false: 取消当前的导航。如果浏览器的 URL 改变了(可能是用户手动或者浏览器后退按钮)，那么 URL 地址会重置到 from 路由对应的地址。

一个路由地址: 通过一个路由地址跳转到一个不同的地址，就像你调用 router.push() 一样，你可以设置诸如 replace: true 或 name: 'home' 之类的配置。当前的导航被中断，然后进行一个新的导航，就和 from 一样。
一、全局前置守卫
```js
const router = createRouter({ ... })

router.beforeEach((to, from) => {
  // ...
  // 返回 false 以取消导航
  return false
})
```
二、全局解析守卫
```
router.beforeResolve(async to => {
  if (to.meta.requiresCamera) {
    try {
      await askForCameraPermission()
    } catch (error) {
      if (error instanceof NotAllowedError) {
        // ... 处理错误，然后取消导航
        return false
      } else {
        // 意料之外的错误，取消导航并把错误传给全局处理器
        throw error
      }
    }
  }
})
```

全局后置钩子

三、单个路由独享的守卫
beforeEnter 守卫 只在进入路由时触发，不会在 params、query 或 hash 改变时触发。

路由配置上定义 beforeEnter 守卫eg.
```
const routes = [
  {
    path: '/users/:id',
    component: UserDetails,
    beforeEnter: (to, from) => {
      // reject the navigation
      return false
    },
  },
]
```

四、组件级守卫

#### 完整的导航解析流程

导航被触发。
在失活的组件里调用 beforeRouteLeave 守卫。
调用全局的 beforeEach 守卫。
在重用的组件里调用 beforeRouteUpdate 守卫(2.2+)。
在路由配置里调用 beforeEnter。
解析异步路由组件。
在被激活的组件里调用 beforeRouteEnter。
调用全局的 beforeResolve 守卫(2.5+)。
导航被确认。
调用全局的 afterEach 钩子。
触发 DOM 更新。
调用 beforeRouteEnter 守卫中传给 next 的回调函数，创建好的组件实例会作为回调函数的参数传入。

### vue基础
- 插值表达式：{{}}
- 插值表达式只能用在元素的内容节点中，不能用在元素的属性节点中。
**属性绑定指令**
- v-bind

理解 @g-btn-click= "btnClick"
```
`@table-row-click` 是一个 Vue 组件中的事件绑定语法，它用于在表格中绑定一个行点击事件。`tableClick` 是一个在 Vue 实例中定义的方法名，它会在表格中的某一行被点击时被调用。这个方法可以接收一个参数，这个参数就是被点击的那一行的数据对象，我们可以在方法中对这个数据对象进行一些处理，比如弹出一个详情对话框，或者进行其他的操作。
```

```
`this.$route` 是 Vue.js 中的一个路由对象，它可以访问当前路由的相关信息。这个对象包含了当前路由的路径、参数、查询参数等信息，我们可以通过它来获取这些信息。

具体来说，`this.$route.path` 可以获取当前路由的路径，`this.$route.params` 可以获取当前路由的参数，`this.$route.query` 可以获取当前路由的查询参数。我们可以在 Vue 组件中使用 `$route` 对象来根据路由信息来动态渲染组件，或者根据路由信息来进行一些操作。
```

**vue2混入**

例子：
```js
// 定义一个混入对象
var myMixin = {
  created: function () {
    this.hello()
  },
  methods: {
    hello: function () {
      console.log('hello from mixin!')
    }
  }
}

// 定义一个使用混入对象的组件
var Component = Vue.extend({
  mixins: [myMixin]
})

var component = new Component() // => "hello from mixin!"
```
**插槽**
插槽是vue为组件封装者提供的能力。允许开发者把不确定、希望由用户指定的部分定义为插槽。
封装：为了实现ui结构复用
就像占位符
```js
<slot></slot>
```
**vue官方规定：每一个slot插槽，都要有一个name名称，如果省略了slot的name属性，则有一个默认的名称叫做default**
默认情况下，使用组件时提供的内容会被填充到名为default的插槽当中。
- 注意v-slot只能用在<template>或组件当中。
- <template>
- v-slot:插槽名 --> 将内容填充到指定名称的插槽当中。
- 简写： #
- slot默认内容：
```js
<slot>默认内容</slot>
```
- 利用slot，子组件向父组件传属性
```js
//子组件
//父组件可以访问到mag
<slot name="yy" msg="11"></slot>
```
//父组件
```js
<template #yy="obj">
<div>
  <p>
    {{obj}}
  </p>
</div>
</template>

```
效果：
"{"msg":"11"}"


**this.$refs**
this.$set是Vue中的一个实例方法，用于在Vue实例中设置响应式数据。它可以用于向Vue实例中添加新的属性或修改已有属性。
this.$set方法接受三个参数，分别是需要添加/修改的对象、属性名和属性值。例如：
```js
this.$set(this.userInfo, 'age', 25)
```

### vue3
#### setup:组合式API入口
setup:创建、使用函数->返回函数。
语法糖：封装简化代码

**ref和$refs的使用**
https://cloud.tencent.com/developer/article/1479575

**渲染函数（render）**

https://juejin.cn/post/7030362678199582734

**v-model**

v-model 是 v-model:value 的缩写，通常用于表单上的双向数据绑定（表单接受值 value，故v-model默认收集的就是 value ，所以缩写直接省略 value），可以实现子组件到父组件的双向数据动态绑定。数据不仅能从data流向页面，还可以从页面流向data。

https://blog.csdn.net/unlilalila/article/details/121234835


**vue组件传值**

https://blog.csdn.net/dan_seek/article/details/102641761

- nextTick()