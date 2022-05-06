SET SERVEROUTPUT ON

DECLARE

existe_Ships NUMBER(1);
existe_Users NUMBER(1);
existe_Defense NUMBER(1);
existe_Planet NUMBER(1);
existe_Registre NUMBER(1);

BEGIN

DROP_TABLES;

DBMS_OUTPUT.PUT_LINE('');

CREATE_TABLES;

DBMS_OUTPUT.PUT_LINE('');

/*Insert data, el procedimiento que inserta los datos de las defensas y las naves
da un ERROR, reconoce de alguna forma el paquete en la BBDD pero no lo puede utilizar*/

/*
INSERT_DATA;
*/

EXCEPTION

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Error en el proceso INITIALIZE:');
DBMS_OUTPUT.PUT_LINE('Descripcion del error: '||SQLERRM);

END;