SET SERVEROUTPUT ON

DECLARE
/*Ident es la variable que se entrara a partir de la cual se haran las busquedas*/
ident defense.id_defense%TYPE;
nombre defense.name%TYPE;

costeMetal defense.metal_cost%TYPE;
costeCristal defense.crystal_cost%TYPE;
costeDeuterio defense.deuterium_cost%TYPE;

armaduraInicial defense.initial_Armor%TYPE;
armadura defense.armor%TYPE;
dañoBase defense.base_damage%TYPE;
velocidad defense.speed%TYPE;
advertencias defense.generate_warnins%TYPE;

BEGIN
SELECT * INTO ident, nombre, costeMetal, costeCristal, costeDeuterio, armaduraInicial, armadura, dañoBase, velocidad, advertencias
FROM defense
WHERE id_defense = ident;

/*Estas variables son las que se entregarian a Java, se le entra ident y nos devolveria los valores, Java trabajaria con estos valores
El tema es como devolverlos o recogerlos 

Primero aseguremonos de poder recoger las variables, si sobra tiempo, podriamos probar con un rowtype*/

END;