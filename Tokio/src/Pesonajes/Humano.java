package Pesonajes;

public class Humano extends Heroe {
	
	/**
	 * Constructor
	 * @param nombre
	 * @param vida
	 * @param armadura
	 */
	public Humano(String nombre, int vida, int armadura) {
		super(nombre,vida,armadura);
	}
	
	/**
	 * Nos devuelve un String con la informacion del personaje, se le añade el tipo de personaje que es
	 */
	public String toString() {
		String resultado=super.toString()+"-> Humano";
		return resultado;
	}
}
