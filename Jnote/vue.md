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

**Vue (发音为 /vjuː/，类似 view) 是一款用于构建用户界面的 JavaScript 框架。**

## Vue Router
- <a>标签
<a> 标签定义超链接，用于从一个页面链接到另一个页面。
<a> 元素最重要的属性是 href 属性，它指定链接的目标。
- <div>
  
<div> 标签定义 HTML 文档中的一个分隔区块或者一个区域部分。
<div>标签常用于组合块级元素，以便通过 CSS 来对这些元素进行格式化。
- <p>
<p> 标签定义段落。
<p>元素会自动在其前后创建一些空白。浏览器会自动添加这些空间，您也可以在样式表中规定。

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
- computed vs methods
我们可以使用 methods 来替代 computed，效果上两个都是一样的，但是 computed 是基于它的依赖缓存，只有相关依赖发生改变时才会重新取值。而使用 methods ，在重新渲染的时候，函数总会重新调用执行。

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