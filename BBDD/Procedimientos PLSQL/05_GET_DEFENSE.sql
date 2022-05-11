CREATE OR REPLACE PROCEDURE GET_DEFENSE(id_Entrada IN defense.id_defense%TYPE, nombre OUT defense.name%TYPE, 
costeMetal OUT defense.metal_cost%TYPE, costeDeuterio OUT defense.deuterium_cost%TYPE, 
costeCristal OUT defense.crystal_cost%TYPE, armaduraInicial OUT defense.initialArmor%TYPE, 
armadura OUT defense.armor%TYPE, danoBase OUT defense.baseDamage%TYPE, 
velocidad OUT defense.speed%TYPE, residuos OUT defense.generateWasting%TYPE)

/*
Id_entrada es la variable que se entrara a partir de la cual se haran las busquedas, es de salida
El resto son las variables que nos devolvera
*/

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

BEGIN
SELECT COUNT(id_Defense) INTO id_Encontrada
FROM DEFENSE
WHERE id_Defense = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

SELECT name, metal_Cost, crystal_Cost, deuterium_Cost, initialArmor, armor, baseDamage, speed, generateWasting 
INTO nombre, costeMetal, costeCristal, costeDeuterio, armaduraInicial, armadura, danoBase, velocidad, residuos
FROM defense
WHERE id_defense = id_Entrada;

/*
Estos prints son de prueba
DBMS_OUTPUT.PUT_LINE('ID Defensa: '||id_Entrada);
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
DBMS_OUTPUT.PUT_LINE('Error en el proceso GET_DEFENSE:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);

END;