/*

CREACION DE LAS TABLAS

*/

CREATE TABLE USERS (
    User_ID number PRIMARY KEY,
    username VARCHAR(30) unique,
    birth_date date null,
    password VARCHAR(30) not null
);

CREATE TABLE SHIP(
    Id_Ship number not null,
    Name varchar(30) not null, 
    Metal_cost number,
    Crystal_Cost number,
    Deuterium_Crystal number,
    InitialArmor number,
    Armor number null,
    BaseDAmage number, 
    Speed number,
    GenerateWarnings number
);

CREATE TABLE DEFENSE(
    Id_Defense number not null,
    Name varchar(30) not null, 
    Metal_cost number,
    Crystal_Cost number,
    Deuterium_Crystal number,
    InitialArmor number,
    Armor number null,
    BaseDAmage number, 
    Speed number,
    GenerateWarnings number
);

CREATE TABLE PLANET(
    Id_Planet number,
    Name VARCHAR(30) not null,
    Id_Ship number,
    Id_Defensenumber
);

--cada batalla ha de ser de un usuario no de muchos
--
CREATE TABLE REGISTRE(
    Id_Battle number,
    Id_User number
    
);