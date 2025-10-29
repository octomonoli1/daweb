drop database if exists daweb;
create database daweb;
use daweb;

create table alumno(
    id int primary key auto_increment,
    name varchar(200) not null,
    surname varchar(250),
    birth date
);

describe alumno;

insert into alumno (name, surname, birth) values
('Pepe','Sanchez Martin', '2000-01-01'),
('Maria', 'Sanchez Martin', '2001-02-02'),
('Laura', 'Sanchez Martin', '2001-02-02'),
('Olga','Rodriguez Gonzalez','2002-03-03');

select * from alumno;