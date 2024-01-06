  ##### java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '136' for key 'unique_fileid'


  报错原因：Duplicate entry ‘XXX’ for key ‘XXX’，表示插入的值在表中有重复的数据。这个key是唯一索引。
  解决方法：
  - 取消唯一索引
  - 在后端判断是否已存在这个数据，如果有把它挡住，不让它进行插入。

`唯一索引不能有值为空会破坏唯一性。`

HTTP 500 内部服务器报错
HTTP 503
404
200

##### springCould整合feign提示required a bean of type xxx that could not be found

报错原因：FeignClients 要单独设置需要注解的路径和bean，才能交到spring那里托管。@EnableFeignClients不知道去哪里扫描FeignClients，需要传参。

解决方法：
- 直接注解对应的class

  @EnableFeignClients(basePackageClasses=FeignTestClient.class)

- 扫描路径

 @EnableFeignClients(basePackages="com.example.*")






