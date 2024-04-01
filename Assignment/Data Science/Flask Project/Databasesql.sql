create database registration_db;
use registration_db; 
create table users(
id int auto_increment primary key ,
student_name varchar(50),
father_name varchar(50),
student_mother_name varchar(50),
phone_number int ,
email varchar(50),
date_of_birth varchar(50),
student_address varchar(100),
blood_group varchar(5),
department varchar(50),
course varchar(50),
password varchar(10)
) ;
select * from users;
