
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

/*==============================================================*/
/* Table: t_forum                                               */
/*==============================================================*/
create table t_forum
(
   forum_id             int(11) not null ,
   forum_name           varchar(150) not null default 'forum',
   forum_desc           varchar(255) default NULL,
   primary key (forum_id)
)
;

/*==============================================================*/
/* Table: t_post                                                */
/*==============================================================*/
create table t_post
(
   post_id              int(11) not null ,
   topic_id             int(11) not null default 0,
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
   topic_id             int(11) not null ,
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

insert into t_forum(forum_id,forum_name,forum_desc) values(1,'forum1','desc1');
insert into t_forum(forum_id,forum_name,forum_desc) values(2,'forum2','desc2');

insert into t_topic (topic_id,forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (1,1, '主题1', 1, '1-1-1 0:0:1', 166, 1);
insert into t_topic (topic_id,forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (2,1, '主题2', 1, '1-1-1 0:0:0', 100, 49);
insert into t_topic (topic_id,forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (3,2, '主题3', 1, '1-1-1 0:0:1', 130, 70);
insert into t_topic (topic_id,forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (4,2, '主题4', 2, '1-1-1 0:0:2', 166, 22);
commit;
