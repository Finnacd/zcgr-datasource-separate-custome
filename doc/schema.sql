
create database common_base_01;
use common_base_01;
create table mb_member(
    member_id bigint(20) not null primary key auto_increment,
    member_name varchar(64) not null ,
    member_password varchar(64) not null
) engine = innodb default charset utf8;

drop table if exists mb_member_account;
create table mb_member_account(
    member_account_id bigint(20)  not null primary key auto_increment,
    member_id       bigint(20)  not null
) engine = innodb default charset utf8;


create database common_base_02;
use common_base_02;
create table mb_member(
  member_id bigint(20) not null primary key auto_increment,
  member_name varchar(64) not null ,
  member_password varchar(64) not null
) engine = innodb default charset utf8;


create table mb_member_account(
  member_account_id bigint(20)  not null primary key auto_increment,
  member_id       bigint(20)  not null
) engine = innodb default charset utf8;

