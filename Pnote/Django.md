#MVC
<!--MVC即Model、View、Controller即模型、视图、控制器。
MVC要实现的目标是将软件用户界面和业务逻辑分离以使代码可扩展性、可复用性、可维护性、灵活性加强。
View层是界面，Model层是业务逻辑，Controller层用来调度View层和Model层，将用户界面和业务逻辑合理的组织在一起，起粘合剂的效果。所以Controller中的内容能少则少，这样才能提供最大的灵活性。

控制器的作用仅仅是将不同的View和不同的Model组织在一起，顺便替双方传递消息。

组成MVC的三个模式分别是==组合模式、策咯模式、观察者模式==，MVC在软件开发中发挥的威力，最终离不开这三个模式的默契配合。 

-组合模式
-组合模式，又叫部分整体模式，是用于把一组相似的对象当作一个单一的对象。组合模式依据树形结构来组合对象，用来表示部分以及整体层次。这种类型的设计模式属于结构型模式，它创建了对象组的树形结构。-->

MVC 模式
MVC 模式代表 Model-View-Controller（模型-视图-控制器） 模式。这种模式用于应用程序的分层开发。

Model（模型） - 模型代表一个存取数据的对象或 JAVA POJO。它也可以带有逻辑，在数据变化时更新控制器。
View（视图） - 视图代表模型包含的数据的可视化。
Controller（控制器） - 控制器作用于模型和视图上。它控制数据流向模型对象，并在数据变化时更新视图。它使视图与模型分离开。

#Django
查看Django版本：
```
 py -m django --version
```
##创建项目
第一次使用 Django 的话,需要打开命令行，cd 到一个你想放置你代码的目录，然后运行以下命令：
```
django-admin startproject mysite
```
以后可以直接用pycharm创建项目。
可能有用的链接：
https://www.cnblogs.com/mayugang/p/10401191.html#:~:text=1.%E9%A6%96%E5%85%88%EF%BC%8C%E5%90%AF%E5%8A%A8pycharm%EF%BC%8C%E7%82%B9%E5%87%BBFile-%3ENew%20Project%EF%BC%8C%E5%A6%82%E4%B8%8B%E5%9B%BE%E6%89%80%E7%A4%BA%E3%80%82,2.%E5%9C%A8New%20Project%E5%AF%B9%E8%AF%9D%E6%A1%86%E4%B8%AD%EF%BC%8C%E9%80%89%E6%8B%A9Django%EF%BC%8C%E5%9C%A8Location%E4%B8%AD%E8%AE%BE%E7%BD%AE%E9%A1%B9%E7%9B%AE%E8%B7%AF%E5%BE%84%E4%BB%A5%E5%8F%8A%E9%A1%B9%E7%9B%AE%E5%90%8D%E7%A7%B0%EF%BC%8C%E5%9C%A8Application%20name%E4%B8%AD%E8%BE%93%E5%85%A5%E6%96%B0%E5%BB%BAApp%E7%9A%84%E5%90%8D%E7%A7%B0%EF%BC%8C%E7%82%B9%E5%87%BB%E3%80%90create%E3%80%91%E5%90%8E%E5%8D%B3%E4%BC%9A%E5%88%9B%E5%BB%BA%E4%B8%80%E4%B8%AA%E4%BB%A5mysite20190219%E4%B8%BA%E9%A1%B9%E7%9B%AE%E5%90%8D%E7%A7%B0%E3%80%81zhuce%E4%B8%BA%E5%BA%94%E7%94%A8%E5%90%8D%E7%9A%84%E9%A1%B9%E7%9B%AE%EF%BC%8C%E5%A6%82%E4%B8%8B%E5%9B%BE%E6%89%80%E7%A4%BA%E3%80%82

如果工程中没有Template,则需要自己建立：
![本地图片](Django_Tem.png "7种基本程序")

Django连接已有的数据库：
https://blog.csdn.net/changyana/article/details/122790568

