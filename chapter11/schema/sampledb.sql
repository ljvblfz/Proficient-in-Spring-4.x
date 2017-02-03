
DROP DATABASE IF EXISTS sampledb;
CREATE DATABASE sampledb DEFAULT CHARACTER SET utf8;
USE sampledb;
/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015-4-17 10:41:45                           */
/*==============================================================*/

drop table if exists t_forum;

drop table if exists t_post;

drop table if exists t_topic;

drop table if exists t_post_id;

/*==============================================================*/
/* Table: t_post_id                                             */
/*==============================================================*/
create table t_post_id
(
   sequence_id  int
)
type = MYISAM;
 insert into t_post_id values(0);

/*==============================================================*/
/* Table: t_forum                                               */
/*==============================================================*/
create table t_forum
(
   forum_id             int(11) not null auto_increment,
   forum_name           varchar(150) not null default '',
   forum_desc           varchar(255) default NULL,
   primary key (forum_id, forum_name)
)
;

/*==============================================================*/
/* Table: t_post                                                */
/*==============================================================*/
create table t_post
(
   post_id              int(11) not null auto_increment,
   topic_id             int(11) not null default 0,
   forum_id             int(11) not null default 0,
   user_id              int(11) not null default 0,
   post_text            text,
   post_attach          blob,
   post_time            datetime default NULL,
   primary key (post_id)
);

/*==============================================================*/
/* Index: IDX_POST_TOPIC_ID                                     */
/*==============================================================*/
create index IDX_POST_TOPIC_ID on t_post
(
   topic_id
);

/*==============================================================*/
/* Table: t_topic                                               */
/*==============================================================*/
create table t_topic
(
   topic_id             int(11) not null auto_increment,
   forum_id             int(11) not null default 0,
   topic_title          varchar(100) not null default '',
   user_id              int(11) not null default 0,
   topic_time           datetime default NULL,
   topic_views          int(11) default 1,
   topic_replies        int(11) default 0,
   primary key (topic_id)
);

/*==============================================================*/
/* Index: IDX_TOPIC_USER_ID                                     */
/*==============================================================*/
create index IDX_TOPIC_USER_ID on t_topic
(
   user_id
);

/*==============================================================*/
/* Index: IDX_TOPIC_TITLE                                       */
/*==============================================================*/
create index IDX_TOPIC_TITLE on t_topic
(
   topic_title
);


insert into t_topic (forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (2, '主题1', 1, '1-1-1 0:0:1', 166, 1);

insert into t_topic (forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (1, '主题2', 1, '1-1-1 0:0:0', 100, 49);

insert into t_topic (forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (3, '主题3', 1, '1-1-1 0:0:1', 130, 70);

insert into t_topic (forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (0, '主题4', 2, '1-1-1 0:0:2', 166, 22);
