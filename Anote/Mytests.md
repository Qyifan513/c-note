###3.28百度
+ 数据库更新操作格式
```SQL
UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;
```
+ KMP模式串匹配  
  
  KMP 算法永不回退 txt 的指针 i，不走回头路（不会重复扫描 txt），而是借助 dp 数组中储存的信息把 pat 移到正确的位置继续匹配，时间复杂度只需 O(N)，用空间换时间，所以我认为它是一种动态规划算法。
  ![RUNOOB 图标](\kmp1.png)

  dp 数组，只和 pat 串有关。
+ 