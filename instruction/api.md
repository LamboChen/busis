## 返回格式说明

##### 返回JSON字符串示例

    {
        "code" : "1",
        "message" : "成功",
        "data" : {}
    }

##### 返回参数说明

    code(请求状态返回码)
        1 : 请求成功
        0 ：请求失败
        
    message(请求结果说明)
        请求成功时描述请求成功
        请求数据失败时则描述请求失败原因
        
    data(请求数据)
        请求成功时返回请求数据
        请求失败时为空

##### 说明

本系统所返回数据均以以上描述固定格式

后续仅对data数据进行说明



## 接口详细说明

#### 用户相关API

##### 一、用户登录

1、接口URL

    http://120.77.170.124:8080/busis/user/login.do（注：部署到服务器后更改IP地址）

2、参数说明

    account(string)：用户登录帐号（手机号码或用户名）(必填)
    password(string)：用户密码(必填)
    
3、返回（JSON格式字符串）

    user_id：用户登录成功返回用户ID
    username：用户姓名
    password：用户密码（鉴于安全，一般为空）
    gender：用户性别
    birthday：用户出生日期
    head_portrail：用户头像图片路径
    introduce：用户介绍
    telphone：用户电话号码
    authority: 用户权限等级
    （注：若登录失败，返回为空）

4、请求方式
    
    POST/GET
    
5、示例

通过用户名和密码进行登录验证

    http://120.77.170.124:8080/busis/user/login.do?account=Bob&password=123123

通过电话号码和密码进行登录验证

    http://120.77.170.124:8080/busis/user/login.do?account=13008142300&password=123456


##### 二、用户注册

1、接口URL

    http://120.77.170.124:8080/busis/user/register.do

2、参数说明

    username(string)：用户姓名(必填)
    password(string)：用户密码(必填)
    telphone(string)：用户电话号码(必填)
    gender(string)：用户性别
    birthday(string)：用户出生日期(yyyy-MM-dd)
    introduce(string)：用户介绍

3、返回（JSON格式字符串）

    user_id：用户注册成功返回用户ID
    username：用户姓名
    password：用户密码（鉴于安全，一般为空）
    gender：用户性别
    birthday：用户出生日期
    head_portrail：用户头像图片文件路径
    introduce：用户介绍
    telphone：用户电话号码
    authority: 用户权限等级
    （注：若注册成功，返回值均为数据库中查询当前注册用户所得。若注册失败，返回为空）

4、示例

    http://120.77.170.124:8080/busis/user/register.do?username=Alice&password=123456&gender=0&birthday=1999-1-1
        &introduce=good&telphone=13008142300

##### 三、修改用户基本信息（姓名、密码、性别、出生日期、介绍、电话号码）

1、接口URL

    http://120.77.170.124:8080/busis/user/modify.do

2、参数说明

    user_id(int)：用户ID(必填)
    username(string)：用户姓名
    password(string)：用户密码
    gender(string)：用户性别
    birthday(string)：用户出生日期(yyyy-MM-dd)
    introduce(string)：用户介绍
    telphone(string)：用户电话号码

3、返回（JSON字符串）

    1）修改成功返回用户更新后的基本信息
        user_id：用户注册成功返回用户ID
        username：用户姓名
        password：用户密码（鉴于安全，一般为空）
        gender：用户性别
        birthday：用户出生日期
        head_portrail：用户头像图片文件路径
        introduce：用户介绍
        telphone：用户电话号码
        authority: 用户权限等级
    2）修改失败返回为空
   

4、示例

    http://120.77.170.124:8080/busis/user/modify.do?user_id=4&username=Alice&password=123123&gender=girl
        &birthday=1999-1-31&introduce=I am a good girl&telphone=13008142301


##### 四、修改用户头像(未进行测试)

1、接口URL

    http://120.77.170.124:8080/busis/user/modify/head_portrail.do

2、参数说明

    user_id(int)：用户ID(必填)
    head_portrail(MultipartFile):用户新头像图片文件（必填）

3、返回（JSON字符串）

    空
    
4、示例


##### 五、修改用户权限

1、接口URL

    http://120.77.170.124:8080/busis/user/modify/authority.do

2、参数说明

    user_id(int)：用户ID(必填)
    modifyUser_id(int):欲修改权限用户的ID（必填）
    modifyAuthority(char)：新权限（必填）

3、返回（JSON字符串）

    空

4、示例

    http://120.77.170.124:8080/busis/user/modify/authority.do?user_id=1&modifyUser_id=4&modifyAuthority=2


#### 历史路线相关API

##### 六、添加历史路线

1、接口URL

    http://120.77.170.124:8080/busis/history/add.do

2、参数说明

    start_point(string): 路线起点名称
    end_point(string) : 路线终点名称
    start_longitude(string) : 起点经度
    start_latitude(string) : 起点经度
    end_longitude(string) : 终点经度
    end_latitude(string) : 终点纬度
    history_time(string) : 路线时间（yyyy-MM-dd HH:mm:ss）
    area(string) : 所在区域
    route_information(string) : 路线信息 （必填）
    user_id(int) : 用户ID（必填）

3、返回（JSON字符串）

    空

4、示例

    http://120.77.170.124:8080/busis/history/add.do?start_point=西华大学&end_point=天府广场&start_longitude=1.1
        &start_latitude=2.2&end_longitude=3.3&end_latitude=4.4&history_time=1999-01-01 12:01:01&area=四川成都
        &route_information=route-information test&user_id=1
    
    
##### 七、获得历史路线信息列表

1、接口URL

    http://120.77.170.124:8080/busis/history/get.do

2、参数说明

    user_id(int) : 用户ID（必填）

3、返回（JSON字符串）

    history_id : 历史路线ID
    start_point: 路线起点名称
    end_point : 路线终点名称
    start_longitude : 起点经度
    start_latitude : 起点经度
    end_longitude : 终点经度
    end_latitude : 终点纬度
    history_time: 路线时间
    area : 所在区域
    route_information : 路线信息
    user_id: 用户ID
    （注：返回的是JSONArray形式）

4、示例

    http://120.77.170.124:8080/busis/history/get.do?user_id=1


#### 位置收藏相关API

##### 八、添加位置收藏

1、接口URL

    http://120.77.170.124:8080/busis/location/add.do

2、参数说明

    location_name(string): 位置名称
    location_longitude (string): 经度(必填）
    location_latitude (string): 纬度（必填）
    location_type (string): 位置类型
    area (string): 区域
    user_id(int):user ID(必填)

3、返回（JSON字符串）

    result:新增位置收藏ID，若添加失败（或用户已经收藏过该位置）则返回-1
    
4、示例

    http://120.77.170.124:8080/busis/location/add.do?location_name=xhu&location_longitude=1.1&location_latitude=2.2
        &location_type=xhu&area=成都&user_id=1
    
##### 九、删除收藏位置
 
1、接口URL

    http://120.77.170.124:8080/busis/location/delete.do

2、参数说明

    location_id(int):收藏位置ID

3、返回（JSON字符串）

    删除结果
    
4、示例

    http://120.77.170.124:8080/busis/location/delete.do?location_id=1


##### 十、查询用户收藏地点

1、接口URL

    http://120.77.170.124:8080/busis/location/query.do

2、参数说明

    user_id(int) : 用户ID（必填）
    
3、返回（JSON字符串）

    location_id : 位置信息ID
    location_name: 位置名称
    location_longitude : 经度
    location_latitude : 纬度
    location_type : 位置类型
    area : 区域
    user_id:user ID
    
    
4、示例

    http://120.77.170.124:8080/busis/location/query.do?user_id=1


##### 十一、统计某位置被多少用户收藏

1、接口URL

    http://120.77.170.124:8080/busis/location/total.do

2、参数说明

    location_name(string): 位置名称
    location_longitude (string): 经度(必填)
    location_latitude (string): 纬度(必填)
    location_type (string): 位置类型
    area (string): 区域
   

3、返回（JSON字符串）

    result : 查询结果
    
4、示例

    http://120.77.170.124:8080/busis/location/total.do?location_name=xhu&location_longitude=1.1&location_latitude=2.2
     


#### 路线收藏相关API

##### 十二、添加收藏路线信息

1、接口URL

    http://120.77.170.124:8080/busis/collection/add.do

2、参数说明

    start_point(string): 路线起点名称
    end_point(string) : 路线终点名称
    start_longitude(string) : 起点经度
    start_latitude(string) : 起点经度
    end_longitude(string) : 终点经度
    end_latitude(string) : 终点纬度
    area(string) : 所在区域
    route_information(string) : 路线信息 （必填）
    user_id(int) : 用户ID（必填）

3、返回（JSON字符串）

    result:添加结果(收藏路线ID)
    

4、示例

    http://120.77.170.124:8080/busis/collection/add.do?start_point=西华大学&end_point=天府广场&start_longitude=1.1
        &start_latitude=2.2&end_longitude=3.3&end_latitude=4.4&area=四川成都&route_information=route-information test&user_id=1

##### 十三、用户删除收藏路线信息

1、接口URL

    http://120.77.170.124:8080/busis/collection/delete.do

2、参数说明

    collection_id(int):收藏路线ID

3、返回（JSON字符串）

    空
    
4、示例

    http://120.77.170.124:8080/busis/collection/delete.do?collection_id=1


##### 十四、通过用户ID查询用户收藏路线

1、接口URL

    http://120.77.170.124:8080/busis/collection/query.do

2、参数说明

    user_id(int) : 用户ID (必填)
    
3、返回（JSON字符串）

    collection_id:收藏路线ID
    start_point: 路线起点名称
    end_point : 路线终点名称
    start_longitude : 起点经度
    start_latitude: 起点经度
    end_longitude : 终点经度
    end_latitude: 终点纬度
    area : 所在区域
    route_information : 路线信息
    user_id : 用户ID
    
4、示例

    http://120.77.170.124:8080/busis/collection/query.do?user_id=1
    
##### 十五、统计某路线被多少用户收藏

1、接口URL

    http://120.77.170.124:8080/busis/collection/total.do

2、参数说明

    start_point(string): 路线起点名称
    end_point(string) : 路线终点名称
    start_longitude(string) : 起点经度
    start_latitude(string) : 起点经度
    end_longitude(string) : 终点经度
    end_latitude(string) : 终点纬度
    area(string) : 所在区域
    route_information(varchar(200)) : 路线信息 （必填）

3、返回（JSON字符串）

    result:查询结果
  

4、示例

    http://120.77.170.124:8080/busis/collection/total.do?start_point=西华大学&end_point=天府广场&start_longitude=1.1
        &start_latitude=2.2&end_longitude=3.3&end_latitude=4.4&area=四川成都&route_information=route-information test

    





