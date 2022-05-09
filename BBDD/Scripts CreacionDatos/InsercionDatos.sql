/*
INSERT INTO SHIP VALUES(1, 'Light Hunter', 3000, 0, 50, 400, null, 80, 3, 20);
INSERT INTO SHIP VALUES(2, 'Heavy Hunter', 6500, 0, 50, 1000, null, 150, 7, 30);
INSERT INTO SHIP VALUES(3, 'Battle Ship', 45000, 0, 7000, 6000, null, 1000, 45, 60);
INSERT INTO SHIP VALUES(4, 'Armored Ship', 30000, 0, 15000, 8000, null, 700, 70, 75);

INSERT INTO DEFENSE VALUES (1, 'Missile Launcher', 2000, 0, 0, 200, null, 80, 5, 10);
INSERT INTO DEFENSE VALUES(2, 'Ion Cannon', 4000, 0, 500, 1200, null, 250, 12, 25);
INSERT INTO DEFENSE VALUES(3, 'PLasma Cannon', 50000, 0, 5000, 7000, null, 2000, 30, 50);
*/

INSERT INTO "USER" VALUES(1, 'Manolo', '1234', TO_DATE('12/4/1990', 'DD/MM/YYYY'));
INSERT INTO "USER" VALUES(2, 'Pepe', 'qwerty', TO_DATE('2/1/1992', 'DD/MM/YYYY'));
INSERT INTO "USER" VALUES(3, 'Pepe2', 'qwerty', TO_DATE('2/1/1992', 'DD/MM/YYYY'));
/*
UPDATE "USER"
SET username = 'pepito', password = 'qwerty', birth_date ='12/3/1989'
WHERE id_user = 1
*/