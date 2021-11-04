create database Lecture4;

use Lecture4;

create table Users
(
    Id         integer PRIMARY KEY auto_increment,
    First_name varchar(25),
    Last_name  varchar(25),
    Email      varchar(25) UNIQUE,
    Password   varchar(50),
    Admin      boolean default false
);

INSERT INTO Users (First_name, Last_name, Email, Password, Admin)
VALUES ('Ammar', 'Haddad', 'ammar96haddad@gmail.com', '12345', 1);