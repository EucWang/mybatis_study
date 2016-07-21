drop database if exists simple_shop;
create database simple_shop;
grant all on simple_shop.* to 'wxn'@'localhost';
## 密码是wxn123
use simple_shop;

create table s_user(
	id int(11) primary key auto_increment,
	username varchar(100),
	password varchar(100),
	age int(5),
	type int(5)
);

create table s_address(
	id int(11) primary key auto_increment,
	name varchar(255),
	phone varchar(100),
	postcode varchar(100),
	reciver varchar(100),
	user_id int(11),
	constraint foreign key (user_id) references s_user(id)
);

create table s_order(
	id int(11) primary key auto_increment,
	buy_date datetime,
	pay_date datetime,
	confirm_date datetime,
	status int(5),
	user_id int(11),
	address_id int(11),
	constraint foreign key (user_id) references s_user(id),
	constraint foreign key (address_id) references s_address(id)
);

create table s_category(
	id int(11) primary key auto_increment,
	name varchar(100)	
);

create table s_merchandise(
	id int(11) primary key auto_increment,
	name varchar(100),
	price double,
	intro text,
	img varchar(255),
	stock int(10),
	category_id int(11),
	constraint foreign key (category_id) references s_category(id)
);

create table s_merchandise_orders(
	id int(11) primary key auto_increment,
	merchandise_id int(11),
	orders_id int(11),
	constraint foreign key (merchandise_id) references s_merchandise(id),
	constraint foreign key (orders_id) references s_order(id)	
);