CREATE OR REPLACE PROCEDURE INSERT_PLANET(id_Entrada IN planet.id_planet%TYPE, 
id_usuario IN planet.user_id_user%TYPE, 
nombre IN planet.planet_Name%TYPE, 
metal IN planet.quantity_metal%TYPE, 
cristal IN planet.quantity_crystal%TYPE,
deuterio IN planet.quantity_deuterium%TYPE, 
cazadores_L IN planet.num_LightHunter%TYPE, 
cazadores_H IN planet.num_HeavyHunter%TYPE, 
naves_Batalla IN planet.num_BattleShip%TYPE, 
acorazados IN planet.num_ArmoredShip%TYPE, 
lanzamisiles IN planet.num_MissileLauncher%TYPE, 
cañon_Iones IN planet.num_IonCannon%TYPE, 
cañon_Plasma IN planet.num_PlasmaCannon%TYPE,
nivelDefensa IN planet.current_LevelDefense%TYPe, 
coste_SubirDefensa IN planet.cost_AttackUp%TYPE,
nivelAtaque IN planet.current_LevelAttack%TYPE, 
coste_SubirAtaque IN planet.cost_DefenseUp%TYPE)

IS
id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

idUser_Encontrada NUMBER(1);
excepcion_IdUser EXCEPTION;

insert_Script VARCHAR(1000);

BEGIN
SELECT COUNT(id_Planet) INTO id_Encontrada
FROM PLANET
WHERE id_Planet = id_Entrada;

IF id_Encontrada =1 THEN 
RAISE excepcion_Id;
END IF;

SELECT COUNT(id_User) INTO idUser_Encontrada
FROM "USER"
WHERE id_User = id_Usuario;

IF idUser_Encontrada =0 THEN 
RAISE excepcion_IdUser;
END IF;

insert_Script := 'INSERT INTO PLANET
VALUES('''||id_Entrada||''', 
'''||id_Usuario||''', 
'''||nombre||''', 
'''||metal||''', 
'''||cristal||''', 
'''||deuterio||''', 
'''||cazadores_L||''', 
'''||cazadores_H||''', 
'''||naves_Batalla||''', 
'''||acorazados||''', 
'''||lanzamisiles||''', 
'''||cañon_iones||''', 
'''||cañon_plasma||''', 
'''||nivelDefensa||''', 
'''||coste_SubirDefensa||''', 
'''||nivelAtaque||''', 
'''||coste_SubirAtaque||''')';

execute immediate insert_Script;
DBMS_OUTPUT.PUT_LINE('Insertado un nuevo registro en la tabla USER');
DBMS_OUTPUT.PUT_LINE('ID_Usuario: '||id_Entrada);
DBMS_OUTPUT.PUT_LINE('Nombre Planeta: '||nombre);
DBMS_OUTPUT.PUT_LINE('Nombre: '||metal);
DBMS_OUTPUT.PUT_LINE('Nombre: '||cristal);
DBMS_OUTPUT.PUT_LINE('Nombre: '||deuterio);
DBMS_OUTPUT.PUT_LINE('Nombre: '||cazadores_L);
DBMS_OUTPUT.PUT_LINE('Nombre: '||cazadores_H);
DBMS_OUTPUT.PUT_LINE('Nombre: '||naves_Batalla);
DBMS_OUTPUT.PUT_LINE('Nombre: '||acorazados);
DBMS_OUTPUT.PUT_LINE('Nombre: '||lanzamisiles);
DBMS_OUTPUT.PUT_LINE('Nombre: '||cañon_iones);
DBMS_OUTPUT.PUT_LINE('Nombre: '||cañon_plasma);
DBMS_OUTPUT.PUT_LINE('Nombre: '||nivelDefensa);
DBMS_OUTPUT.PUT_LINE('Nombre: '||coste_SubirDefensa);
DBMS_OUTPUT.PUT_LINE('Nombre: '||nivelAtaque);
DBMS_OUTPUT.PUT_LINE('Nombre: '||coste_SubirAtaque);
COMMIT;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('Esta ID ya existe en la base de datos, no pueden haber IDs repetidas');
ROLLBACK;

WHEN excepcion_IdUser THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado este ID de usuario en la base de datos y no se puede asignar al planeta');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INSERT_PLANET:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;