SET SERVEROUTPUT ON

DECLARE
id_Entrada defense.id_defense%TYPE;
nombre defense.name%TYPE;
costeMetal defense.metal_cost%TYPE;
costeDeuterio defense.deuterium_cost%TYPE;
costeCristal defense.crystal_cost%TYPE;
armaduraInicial defense.initialArmor%TYPE;
armadura defense.armor%TYPE; 
dañoBase defense.baseDamage%TYPE;
velocidad defense.speed%TYPE;
residuos defense.generateWasting%TYPE;

BEGIN
id_Entrada := 1;

GET_DEFENSE(id_Entrada, nombre, costeMetal,costeDeuterio, 
costeCristal, armaduraInicial, armadura, 
dañoBase, velocidad,residuos);

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

END;