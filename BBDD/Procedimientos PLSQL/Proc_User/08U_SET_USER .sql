CREATE OR REPLACE PROCEDURE SET_USER(id_Entrada IN NUMBER, 
nombre IN VARCHAR, 
contras IN VARCHAR, 
fecha_Nac IN DATE)

IS
nombre_Insertar VARCHAR (30);
contras_Insertar VARCHAR (30);
fecha_Nac_Insertar DATE;

id_Encontrada NUMBER(1);
excepcion_Id EXCEPTION;

update_Script VARCHAR(300);

BEGIN
SELECT COUNT(id_user) INTO id_Encontrada
FROM "USER"
WHERE id_User = id_Entrada;

IF id_Encontrada =0 THEN 
RAISE excepcion_Id;
END IF;

IF nombre IS NULL THEN
SELECT username INTO nombre_Insertar
FROM "USER"
WHERE id_User = id_Entrada;
ELSE
nombre_Insertar := nombre;
END IF;

IF contras IS NULL THEN
SELECT password INTO contras_Insertar
FROM "USER"
WHERE id_User = id_Entrada;
ELSE 
contras_Insertar := contras;
END IF;

IF fecha_Nac IS NULL THEN
SELECT birth_Date INTO fecha_Nac_Insertar
FROM "USER"
WHERE id_User = id_Entrada;
ELSE
fecha_Nac_Insertar :=fecha_Nac;
END IF;

update_Script:= 'UPDATE "USER"
SET username = '''||nombre_Insertar||''', 
password = '''||contras_Insertar||''', 
birth_date ='''||fecha_Nac_Insertar||'''
WHERE id_user = '||id_Entrada||'';

execute immediate update_Script;

DBMS_OUTPUT.PUT_LINE('Actualizada la entrada '||id_Entrada||' de la base de datos USER con estos nuevos valores:');
DBMS_OUTPUT.PUT_LINE('Nombre: '||nombre_Insertar);
DBMS_OUTPUT.PUT_LINE('Contraseña: '||contras_Insertar);
DBMS_OUTPUT.PUT_LINE('Fecha de nacimiento: '||fecha_Nac_Insertar);

COMMIT;

EXCEPTION

WHEN excepcion_Id THEN
DBMS_OUTPUT.PUT_LINE('No se ha encontrado esta ID en la base de datos');
ROLLBACK;

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso SET_USER:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);
ROLLBACK;

END;