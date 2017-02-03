/*==============================================================*/
/* DBMS name:      ORACLE Version 9i2                           */
/* Created on:     2007-2-19 15:05:31                           */
/*==============================================================*/


drop index idx_post_topic_id;

drop index idx_topic_title;

drop index idx_topic_user_id;

drop table t_forum cascade constraints;

drop table t_post cascade constraints;

drop table t_topic cascade constraints;

drop sequence seq_post_id;

create sequence seq_post_id
increment by 1
start with 1;


drop sequence seq_forum_id;

create sequence seq_forum_id
increment by 1
start with 1;

/*==============================================================*/
/* Table: t_forum                                             */
/*==============================================================*/
create table t_forum  (
   forum_id           int                             not null,
   forum_name         varchar2(100)                  default '' not null,
   forum_desc         varchar2(100)                  default NULL,
   constraint pk_t_forum primary key (forum_id)
);

--创建触发器，以便为t_forum生成主键
create or replace trigger tri_forum_id
  before insert on t_forum for each row
declare
  -- local variables here
  nextID int;
  begin
	  select seq_forum_id.nextVal into nextID from dual;
	  :new.forum_id:=nextID;    
  end tri_forum_id;
  
/

/*==============================================================*/
/* Table: t_post                                              */
/*==============================================================*/
create table t_post  (
   post_id            int                             not null,
   topic_id           int                            default 0 not null,
   forum_id           int                            default 0 not null,
   user_id            int                            default 0 not null,
   post_text          clob,
   post_attach        BLOB,
   post_time          date                           default NULL,
   constraint pk_t_post primary key (post_id)
);

/*==============================================================*/
/* Index: idx_post_topic_id                                     */
/*==============================================================*/
create index idx_post_topic_id on t_post (
   topic_id ASC
);

/*==============================================================*/
/* Table: t_topic                                             */
/*==============================================================*/
create table t_topic  (
   topic_id           int                             not null,
   forum_id           int                            default 0 not null,
   topic_title        varchar2(100)                  default '' not null,
   user_id            int                            default 0 not null,
   topic_time         date                           default NULL,
   topic_views        int                            default 1,
   topic_replies      int                            default 0,
   constraint pk_t_topic primary key (topic_id)
);

/*==============================================================*/
/* Index: idx_topic_user_id                                     */
/*==============================================================*/
create index idx_topic_user_id on t_topic (
   user_id ASC
);

/*==============================================================*/
/* Index: idx_topic_title                                       */
/*==============================================================*/
create index idx_topic_title on t_topic (
   topic_title ASC
);


insert into t_topic (topic_id, forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (1, 2, '主题1', 1, null, 166, 1);
insert into t_topic (topic_id, forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (2, 1, '主题2', 1, null, 100, 49);
insert into t_topic (topic_id, forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (3, 3, '主题3', 1, null, 130, 70);
insert into t_topic (topic_id, forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (4, 0, '主题4', 2, null, 166, 22);
commit;

/**create procedure P_GET_TOPIC_NUM*/
drop procedure P_GET_TOPIC_NUM;
create or replace procedure P_GET_TOPIC_NUM(in_user_id IN  INT,out_num OUT  INT) is
begin
  SELECT COUNT(*) INTO out_num  FROM t_topic WHERE user_id = in_user_id;
end P_GET_TOPIC_NUM;

/