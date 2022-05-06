
DROP TABLE USERS;
 
DROP TABLE SHIP;
 
DROP TABLE DEFENSE;
 
DROP TABLE PLANET;
 
DROP TABLE REGISTRE;

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
    Initial_Armor number,
    Armor number null,
    Base_Damage number, 
    Speed number,
    Generate_Warnings number
);

CREATE TABLE DEFENSE(
    Id_Defense number not null,
    Name varchar(30) not null, 
    Metal_Cost number,
    Crystal_Cost number,
    Deuterium_Cost number,
    Initial_Armor number,
    Armor number null,
    Base_Damage number, 
    Speed number,
    Generate_Warnings number
);

CREATE TABLE PLANET(
    Id_Planet number,
    Name VARCHAR(30) not null,
    Id_Ship number,
    Id_Defense number
);

--cada batalla ha de ser de un usuario no de muchos
--
CREATE TABLE REGISTRE(
    Id_Battle number,
    Id_User number

);


--insert into USER VALUES(1, 'prova', to_Date('04-05-2022','DD-MM-YYYY'), 'prova');

INSERT INTO SHIP VALUES(1, 'Light Hunter', 3000, 0, 50, 400, null, 80, 3, 20);
INSERT INTO SHIP VALUES(2, 'Heavy Hunter', 6500, 0, 50, 1000, null, 150, 7, 30);
INSERT INTO SHIP VALUES(3, 'Battle Ship', 45000, 0, 7000, 6000, null, 1000, 45, 60);
INSERT INTO SHIP VALUES(4, 'Armored Ship', 30000, 0, 15000, 8000, null, 700, 70, 75);

INSERT INTO DEFENSE VALUES (1, 'Missile Launcher', 2000, 0, 0, 200, null, 80, 5, 10);
INSERT INTO DEFENSE VALUES(2, 'Ion Cannon', 4000, 0, 500, 1200, null, 250, 12, 25);
INSERT INTO DEFENSE VALUES(3, 'PLasma Cannon', 50000, 0, 5000, 7000, null, 2000, 30, 50);

