
## 项目说明文档

### 用户划分

##### 一、游客

1、数据库中不存在用户基本信息

2、用户权限为 4 (最低)
    
3、提供服务

    1）线路查询
    2）站台查询
    3）换乘查询
    4）注册成为普通用户
    
##### 二、普通用户

1、用户基本信息

    user_id：用户ID
    username：用户姓名
    password：用户密码
    gender：用户性别
    birthday：用户出生日期 
    head_portrail：用户头像图片路径
    introduce：用户介绍
    telphone：用户电话号码
    authority: 用户权限等级

2、用户权限为 3

3、提供服务

    1）线路查询
    2）站台查询
    3）换乘查询
    4）特色服务（后边补充）
    5）登录、注册用户

##### 三、普通管理员用户

1、用户基本信息

    user_id：用户ID
    username：用户姓名
    password：用户密码
    gender：用户性别
    birthday：用户出生日期
    head_portrail：用户头像图片路径
    introduce：用户介绍
    telphone：用户电话号码
    authority: 用户权限等级

2、用户权限为 2

3、提供服务

     1）线路查询
     2）站台查询
     3）换乘查询
     4）特色服务（后边补充）
     5）登录普通管理员用户
     6）普通用户数据统计（后期补充）
     7）管理普通用户
     
 ##### 四、超级管理员
 
 1、用户基本信息
 
    user_id：用户ID
    username：用户姓名
    password：用户密码
    gender：用户性别
    birthday：用户出生日期
    head_portrail：用户头像图片路径
    introduce：用户介绍
    telphone：用户电话号码
    authority: 用户权限等级

2、用户权限为 3

3、提供服务

    1）线路查询
    2）站台查询
    3）换乘查询
    4）特色服务（后边补充）
    5）登录超级管理员用户
    6）管理普通管理员用户
    7）管理普通用户
    8）普通用户数据统计（后期补充）
    9）普通管理员用户数据统计（后期统计）



### 数据库说明

##### 1、tb_user(用户基本信息表)

    user_id(int,PK) : 用户ID
    username(varchar(10)) : 用户名
    telphone(varchar(13)) : 电话号码
    birthday(date) : 出生日期
    head_portrail(varchar(100)) : 用户头像图片存放路径
    password(varchar(20) : 用户密码
    gender(varchar(2)) : 性别
    authority(varchar(2)) : 用户权限等级
    introduce(varchar(200)) : 用户备注、介绍
    
 ##### 2、tb_history(历史路线表)
 
    history_id (int,PK): 历史路线ID
    start_point (varchar(20)): 起点名称
    end_point (varchar(20)): 终点名称
    start_longitude(varchar(15)): 起点经度
    start_latitude(varchar(15)): 起点纬度
    end_longitude(varchar(15)): 终点经度
    end_latitude(varchar(15)): 终点纬度
    history_time (datetime): 使用路线时间
    area(varchar(20)) : 区域
    route_information(varchar(200)) : 路线信息 
    user_id(int) : 用户ID
   
    
##### 3、tb_collection(收藏路线表)

    collection_id (int,PK): 收藏路线ID
    start_point (varchar(20)): 起点名称
    end_point (varchar(20)): 终点名称
    start_longitude(varchar(15)): 起点经度
    start_latitude(varchar(15)): 起点纬度
    end_longitude(varchar(15)): 终点经度
    end_latitude(varchar(15)): 终点纬度
    area (varchar(20)): 区域
    route_information(varchar(200)) : 路线信息 
    user_id（int) ：用户ID
     
    
##### 4、tb_location(位置收藏表)

    location_id (int,PK): 位置ID
    location_name (varchar(20)): 位置名称
    location_longitude (varchar(15)): 经度
    location_latitude (varchar(15)): 纬度
    location_type (varchar(15)): 位置类型
    area (varchar(20)): 区域
    user_id(int):user ID
    
##### 5、tb_bus_location(公交地点表)

    bus_location_id (int,PK): 公交地点ID
    bus_location_name (varchar(20)): 位置名称
    bus_location_longitude (varchar(15)): 经度
    bus_location_latitude (varchar(15)): 纬度
    area (varchar(20)): 区域

##### 6、tb_bus（公交信息表）

    bus_id (int,PK): 公交ID
    bus_via_station (varchar(300)): 途经站点(公交地点表中的id连接成字符串)
    area (varchar(20)): 区域
     
 


