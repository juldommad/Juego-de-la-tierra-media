package Pesonajes;

public abstract class Bestia extends Personaje {
	/**
	 * Constructor
	 * @param nombre
	 * @param vida
	 * @param armadura
	 */
	public Bestia(String nombre, int vida, int armadura) {
		super(nombre,vida,armadura);
	}

	/**
	 * Defino los valores por defecto de las bestias
	 */
	{
		numeroDados = 1;
		maxValorDados = 90;
	}

}
