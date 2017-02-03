DROP DATABASE IF EXISTS sampledb;
CREATE DATABASE sampledb DEFAULT CHARACTER SET utf8;
USE sampledb;

drop table t_user;
create table t_user(
   user_name varchar(30) not null primary key,
   password varchar(30) not null,
   score int,
   last_logon_time long
)ENGINE=InnoDB; 

insert into t_user(user_name,password,score,last_logon_time)
values('tom','123456',10,123213213);
commit;

/*drop table t_dept;
create table t_dept(
   dept_code varchar2(30) primary key,
   dept_name varchar2(30)
);   */
