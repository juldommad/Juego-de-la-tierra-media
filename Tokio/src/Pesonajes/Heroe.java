package Pesonajes;

public abstract class Heroe extends Personaje {
	/**
	 * Constructor
	 * @param nombre
	 * @param vida
	 * @param armadura
	 */
	public Heroe(String nombre, int vida, int armadura) {
		super(nombre,vida,armadura);
	}

	/**
	 * Defino los valores por defecto de los héroes
	 */
	{
		numeroDados = 2;
		maxValorDados = 100;
	}

}
