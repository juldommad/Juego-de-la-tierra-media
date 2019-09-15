package Pesonajes;

import Dado.Tirada;

public abstract class Personaje {
	protected int vida, armadura;
	protected String nombre;
	protected int numeroDados, maxValorDados;
	
	/**
	 * Constructor
	 * @param nombre
	 * @param vida
	 * @param armadura
	 */
	public Personaje(String nombre, int vida,  int armadura) {
		this.vida=vida;
		this.nombre=nombre;
		this.armadura=armadura;
	}

	/**
	 * Un personaje puede atacar a un rival
	 * @param vida 
	 * @param nombre 
	 * @param armadura 
	 */
	public int atacar() {
		int[] array = Tirada.hacerTirada(numeroDados, maxValorDados);
		return Tirada.verMax(array);
	}

	/**
	 * @param dano es la cantidad de daño a ejercido un ataque sobre el personaje
	 *             Nos le resta vida al Personaje
	 */
	public void recibeDano(int dano) {
		this.vida = this.vida - dano;

	}

	/**
	 * Nos da el nombre del Personaje
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Nos da la vida del Personaje
	 */
	public int getVida() {
		return this.vida;
	}

	/**
	 * Nos da la armadura del Personaje
	 */
	public int getArmadura() {
		return this.armadura;
	}

	/**
	 * Nos escribre los valores del Personaje
	 */
	public String toString() {
		return this.nombre + " (vida: " + this.vida + ", armadura: " + this.armadura + ")";
	}
}
