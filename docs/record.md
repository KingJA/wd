1.全局异常捕捉
2.全局返回ApiResult,ResultEmum
3.处理null返回
4.JPA
了解查询规则
@Table(name = "user")
@Column(name = "username")
user_id=>userId


Spring boot jpa 在数据库设置时间默认值不生效解决方案
1.在entity中添加注解 @EntityListeners(AuditingEntityListener.class)
2.在时间字段增加 @CreatedDate
3.在自动更新时间戳字段增加 @LastModifiedDate
4.在Spring boot启动类增加注解 @EnableJpaAuditing

5.数据修改和删除，需要显示声明事务，否则会报错，一个是在调用的方法上添加注解 @Transactional，或者直接在repository api的接口上添加注解 @Transactional


Bitvise SSH Client
FileZilla FTP Client
PuTTY


