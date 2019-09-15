package Pesonajes;

public class Trasgo extends Bestia {

	/**
	 * Constructor
	 * @param nombre
	 * @param vida
	 * @param armadura
	 */
	public Trasgo(String nombre, int vida, int armadura) {
		super(nombre,vida,armadura);
	}
	
	/**
	 * Nos devuelve un String con la informacion del personaje, se le añade el tipo de personaje que es
	 */
	public String toString() {
		String resultado=super.toString()+"-> Trasgo";
		return resultado;
	}
}
