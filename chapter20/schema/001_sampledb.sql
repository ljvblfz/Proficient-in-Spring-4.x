DROP DATABASE IF EXISTS sampledb;
CREATE DATABASE sampledb DEFAULT CHARACTER SET utf8;
USE sampledb;

DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user (
   user_id   INT AUTO_INCREMENT PRIMARY KEY,
   user_name VARCHAR(30),
   password  VARCHAR(32),
   credit    INT,
   last_visit datetime,
   last_ip  VARCHAR(23)
)ENGINE=InnoDB;

DROP TABLE IF EXISTS t_login_log;
CREATE TABLE t_login_log (
   login_log_id  INT AUTO_INCREMENT PRIMARY KEY,
   user_id   INT,
   ip  VARCHAR(23),
   login_datetime datetime
)ENGINE=InnoDB; 