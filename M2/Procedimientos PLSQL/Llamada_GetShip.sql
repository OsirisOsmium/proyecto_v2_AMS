SET SERVEROUTPUT ON

DECLARE
id_Entrada ship.id_ship%TYPE;
nombre ship.name%TYPE;
costeMetal ship.metal_cost%TYPE;
costeDeuterio ship.deuterium_cost%TYPE;
costeCristal ship.crystal_cost%TYPE;
armaduraInicial ship.initialArmor%TYPE;
armadura ship.armor%TYPE; 
dañoBase ship.baseDamage%TYPE;
velocidad ship.speed%TYPE;
residuos ship.generateWasting%TYPE;

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