package Pesonajes;

public class Hobbit extends Heroe {
	private int potenciaOfensivaTrasgos= -5;

	/**
	 * Constructor
	 * @param nombre
	 * @param vida
	 * @param armadura
	 */
	public Hobbit(String nombre, int vida, int armadura) {
		super(nombre,vida,armadura);
	}

	/**
	 * Nos devuelve la potencia ofensiva que se ve reducida por el miedo que tienen los hobbits a los trasgos
	 * @return
	 */
	public int getPotenciaOfensivaTrasgos() {
		return potenciaOfensivaTrasgos;
	}

	/**
	 * Nos devuelve un String con la informacion del personaje, se le añade el tipo de personaje que es
	 */
	public String toString() {
		String resultado=super.toString()+"-> Hobbit";
		return resultado;
	}
}
