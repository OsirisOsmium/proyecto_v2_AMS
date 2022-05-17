CREATE OR REPLACE PROCEDURE GET_SHIP(id_Entrada IN ship.id_Ship%TYPE, 
nombre OUT ship.name%TYPE, 
costeMetal OUT ship.metal_cost%TYPE, 
costeDeuterio OUT ship.deuterium_cost%TYPE, 
costeCristal OUT ship.crystal_cost%TYPE, 
armaduraInicial OUT ship.initialArmor%TYPE, 
armadura OUT ship.armor%TYPE, 
danoBase OUT ship.baseDamage%TYPE, 
velocidad OUT ship.speed%TYPE, 
residuos OUT ship.generateWasting%TYPE)

/*
Id_entrada es la variable que se entrara a partir de la cual se haran las busquedas, es de salida
El resto son las variables que nos devolvera
*/

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

BEGIN
SELECT COUNT(id_Ship) INTO id_Encontrada
FROM SHIP
WHERE id_Ship = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

SELECT name, metal_Cost, crystal_Cost, deuterium_Cost, initialArmor, armor, baseDamage, speed, generateWasting 
INTO nombre, costeMetal, costeCristal, costeDeuterio, armaduraInicial, armadura, danoBase, velocidad, residuos
FROM ship
WHERE id_ship = id_Entrada;

/*Estos prints son de prueba
DBMS_OUTPUT.PUT_LINE('ID Nave: '||id_Ship);
DBMS_OUTPUT.PUT_LINE('Nombre Defensa: '||nombre);
DBMS_OUTPUT.PUT_LINE('Coste Metal: '||costeMetal);
DBMS_OUTPUT.PUT_LINE('Coste Cristal: '||costeCristal);
DBMS_OUTPUT.PUT_LINE('Coste Deuterio: '||costeDeuterio);
DBMS_OUTPUT.PUT_LINE('Armadura Inicial: '||armaduraInicial);
DBMS_OUTPUT.PUT_LINE('Armadura: '||armadura);
DBMS_OUTPUT.PUT_LINE('Daño Base: '||dañoBase);
DBMS_OUTPUT.PUT_LINE('Velocidad: '||velocidad);
DBMS_OUTPUT.PUT_LINE('Residuos: '||residuos);
*/

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INITIALIZE:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);

END;