SET SERVEROUTPUT ON

DECLARE

tablas_Existen BOOLEAN := false;

BEGIN
tablas_Existen := check_TablasExisten;

IF tablas_Existen = TRUE THEN
DBMS_OUTPUT.PUT_LINE('Tablas encontradas');
END IF;

EXCEPTION

WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('Ha saltado la excepcion');
DBMS_OUTPUT.PUT_LINE(SQLERRM);
DBMS_OUTPUT.PUT_LINE('Ejecuta los procedures 01, 02 y 03');

END;