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


JAVA中JPA的主键自增长注解设置
　　JPA的注解来定义实体的时候，使用@Id来注解主键属性即可。如果数据库主键是自增长的，需要在增加一个注解@GeneratedValue，即：

1     @GeneratedValue(strategy=GenerationType.IDENTITY)
2     @Id
3     private String id;
 

PS：@GeneratedValue注解的strategy属性提供四种值：

–AUTO： 主键由程序控制，是默认选项，不设置即此项。

–IDENTITY：主键由数据库自动生成，即采用数据库ID自增长的方式，Oracle不支持这种方式。

–SEQUENCE：通过数据库的序列产生主键，通过@SequenceGenerator 注解指定序列名，mysql不支持这种方式。

–TABLE：通过特定的数据库表产生主键，使用该策略可以使应用更易于数据库移植。

JPG不允许数据库小驼峰命名，要下划线命名，不然报错