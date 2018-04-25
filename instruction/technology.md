

## 技术说明文档

#### 概述

在本项目中，主要采用Java语言编写。后台开发采用Spring、Spring MVC、MyBatis三大框架整合开发，数据库采用MySQL、
服务器使用阿里云服务器、Apache Tomcat，整个开发期间采用Junit 4进行单元测试。前后端完全分离开发、数据采用JSON格式进行传输。

#### 运行流程线

- 1、客户端发起请求
- 2、Spring MVC的DispatcherServlet进行拦截
- 3、DispatcherServlet查询HandlerMapping
- 4、DispatcherServlet将请求进行相应的处理并交付给Handler（Handler即Controller）
- 5、Handler按照请求URL进行相应的拦截处理，转入相应的Controller方法
- 6、Controller进行数据校验并做少量业务处理
- 7、Controller调用Service进行处理
- 8、Service进行业务逻辑的处理
- 9、Service调用Dao进行数据库的CRUD操作
- 10、数据库进行CRUD并返回结果
- 11、Dao返回数据库处理结果
- 12、Service对Dao返回数据进行业务封装处理
- 13、Service将结果返回Controller
- 14、Controller将Service结果进行包装处理
- 15、Controller将结果返回
- 16、DispatcherServlet将Handler返回的ModelAndView交由HandlerAdapter
- 17、HandlerAdapter进行处理Handler并将结果返回DispatcherServlet
- 18、DispatcherServlet将HandlerAdapter返回结果交由ViewResolver
- 19、ViewResolver生成视图并返回DispatcherServlet
- 20、DispatcherServlet将结果通过response对象返回客户端


#### 数据库相关

在本项目中主要采用管理型数据库MySQL进行开发，各个表之间采用外键进行关联。数据库设计大部分遵循第三范式，因考虑到性能优化方面，
部分数据库设计采用反范式设计，整个数据库按照主要按照功能的不同进行分表存储。
（注：项目中的SQL文件仅作为测试开发使用）

#### MyBatis

与数据库之间的交互，本项目主要采用MyBatis框架，并使用目前主流的Mapper代理开发。MyBatis是一个目前使用较为广泛的ORM框架，
该框架天然支持一级缓存，并且支持二级缓存，在JDBC的基础上进行了更进一步的封装处理，性能和实用性较优。其主要采用的是Java中方法和
SQL语句进行关联开发，开发者能够自己操纵SQL语句，较Hibernate框架更具有可操作性，更易于优化处理。

并且在数据库操作过程中采用了事务处理，使其更具合理性和规避一定的风险操作。

#### Spring MVC

在web层面，采用Spring MVC框架进行开发，在用户发送了请求后，Spring MVC中的DispatcherServlet（前端控制器）进行拦截并，
然后查询HandlerMapping，最后转发给相应的Handler（即为项目中的Controller），然后Controller调用相关Service进行数据处理。
前后端数据传送采用JSON格式字符串进行交互。

#### Spring

整个项目开发过程中，使用Spring框架进行整合Spring MVC、MyBatis开发，在Spring的整合开发后，简化了Spring MVC、MyBatis的配置
以及使用，本项目中主要采用的是Spring 的依赖注入（DI），以及控制反转（IOC）。

#### 设计模式

简单工厂模式、策略模式、单一职责原则、开发-封闭原则、依赖倒转原则、装饰模式、代理模式、迪米特法则、模板方法模式、备忘录模式、
组合模式、单例模式


