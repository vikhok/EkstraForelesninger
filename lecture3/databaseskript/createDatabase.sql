create database Lecture3;

use Lecture3;

create table Users
(
    Id         integer PRIMARY KEY auto_increment,
    First_name varchar(25),
    Last_name  varchar(25),
    Email      varchar(25) UNIQUE,
    Password   varchar(50),
    Admin      boolean default false
);