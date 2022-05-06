CREATE OR REPLACE PROCEDURE GETSHIPVALUES(ident IN ship.id_ship%TYPE, nombre OUT ship.name%TYPE, costeMetal OUT ship.metal_cost%TYPE,
costeCristal OUT ship.crystal_cost%TYPE, costeDeuterio OUT ship.deuterium_crystal%TYPE, armaduraInicial OUT ship.initial_Armor%TYPE,
armadura OUT ship.armor%TYPE, dañoBase OUT ship.base_damage%TYPE, velocidad OUT ship.speed%TYPE, residuos OUT ship.generatewastings%TYPE)

/*Se le entra un id variable IN pero el resto de variables que obtiene son de salida*/

IS
/*Ident es la variable que se entrara a partir de la cual se haran las busquedas*/

BEGIN
SELECT name, metal_Cost, crystal_cost, deuterium_crystal, initial_armor, armor, base_damage, speed, generatewarnings INTO nombre, costeMetal, costeCristal, costeDeuterio, armaduraInicial, armadura, dañoBase, velocidad, residuos
FROM defense
WHERE id_defense = ident;

/*Estas variables son las que se entregarian a Java, se le entra ident y nos devolveria los valores, Java trabajaria con estos valores
El tema es como devolverlos o recogerlos 

Primero aseguremonos de poder recoger las variables, si sobra tiempo, podriamos probar con un rowtype*/

END;