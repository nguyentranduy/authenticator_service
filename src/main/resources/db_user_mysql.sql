 create database userservice;
 
 use userservice;
 
 create table `user`
 (
	id				bigint			primary key auto_increment,
    `username`		varchar(20)		not null unique,
    `password`		varchar(20)		not null,
    email			varchar(255)	not null unique
 );
 
 insert into `user`(`username`, `password`, email) values
 ('duy',	'123',		'nguyentranduy94@gmail.com'),
 ('tom',	'123',		'tomcat@gmail.com');
 
 select * from `user`;