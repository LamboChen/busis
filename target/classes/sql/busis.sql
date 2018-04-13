
# 创建数据库
create database busis;

# 创建用户表
create table tb_user(user_id int primary key not null auto_increment,username varchar(10),
  telphone varchar(13) not null unique,birthday date,head_portrail varchar(30),password varchar(20) not null,
  gender varchar(2),authority VARCHAR(2) DEFAULT '3' not null,introduce VARCHAR(200));

# 插入用户表测试数据
insert into tb_user(username,telphone,head_portrail,password,gender,introduce)
  values('Bob','13008142300','C://1.jpg','123123','1','I am a good boy.');


# 创建历史路线表
CREATE TABLE tb_history(history_id INT PRIMARY KEY not NULL AUTO_INCREMENT,start_point VARCHAR(20),
  end_point VARCHAR(20) ,start_longitude VARCHAR(15) NOT NULL ,start_latitude VARCHAR(15) NOT NULL ,
  end_longitude VARCHAR(15) NOT NULL ,end_latitude VARCHAR(15) NOT NULL ,history_time DATETIME NOT NULL ,
  area VARCHAR(20) NOT NULL DEFAULT '四川成都',user_id int not NULL,route_information VARCHAR(200) NOT NULL );


# 创建收藏路线表
CREATE TABLE tb_collection(collection_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,start_point VARCHAR(20),
  end_point VARCHAR(20),start_longitude VARCHAR(15) NOT NULL ,start_latitude VARCHAR(15) NOT NULL ,
  end_longitude VARCHAR(15) NOT NULL ,end_latitude VARCHAR(15) NOT NULL ,
  area VARCHAR(20) NOT NULL DEFAULT '四川成都',route_information VARCHAR(200) not NULL,user_id int NOT NULL );


# 创建位置收藏表
CREATE TABLE tb_location(location_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,location_name VARCHAR(20) ,
  location_longitude VARCHAR(15) NOT NULL ,location_latitude VARCHAR(15) NOT NULL ,location_type VARCHAR(15),
  area VARCHAR(20) NOT NULL DEFAULT '四川成都',user_id int NOT NULL );


# 创建公交地点表
CREATE TABLE tb_bus_location(buc_location_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  bus_location_name VARCHAR(20),bus_location_longitude VARCHAR(15) NOT NULL ,
  bus_location_latitude VARCHAR(15) NOT NULL ,area VARCHAR(20) NOT NULL DEFAULT '四川成都');

#  创建公交信息表
CREATE TABLE tb_bus(bus_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,bus_via_station VARCHAR(300) NOT NULL ,
  area VARCHAR(20) NOT NULL DEFAULT '四川成都');

# 创建友情链接表
create table tb_link(link_id int not null primary key auto_increment,name varchar(20) not null,
  url varchar(50) not null,flag varchar(2) default 1,type varchar(20));

