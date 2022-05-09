SET SERVEROUTPUT ON

DECLARE

BEGIN

DROP_TABLE;

CREATE_TABLE;

/*
INSERT_DATA, este procedimiento funciona por separado, 
pero salta un error (de integridad, por decirlo de algun modo) del paquete debido a que las tablas 
con las que trabaja son eliminadas en la ejecuci�n del proceso INITIALIZE, dentro del cual se ejecuta
INSER_DATA
*/
/*
INSERT_DATA;
*/

INSERT INTO SHIP VALUES(1, 'Light Hunter', 3000, 0, 50, 400, null, 80, 3, 20);
INSERT INTO SHIP VALUES(2, 'Heavy Hunter', 6500, 0, 50, 1000, null, 150, 7, 30);
INSERT INTO SHIP VALUES(3, 'Battle Ship', 45000, 0, 7000, 6000, null, 1000, 45, 60);
INSERT INTO SHIP VALUES(4, 'Armored Ship', 30000, 0, 15000, 8000, null, 700, 70, 75);

INSERT INTO DEFENSE VALUES (1, 'Missile Launcher', 2000, 0, 0, 200, null, 80, 5, 10);
INSERT INTO DEFENSE VALUES(2, 'Ion Cannon', 4000, 0, 500, 1200, null, 250, 12, 25);
INSERT INTO DEFENSE VALUES(3, 'PLasma Cannon', 50000, 0, 5000, 7000, null, 2000, 30, 50);

EXCEPTION

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INITIALIZE:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);


END;