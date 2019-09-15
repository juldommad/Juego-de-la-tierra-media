package Pesonajes;

public class Elfo extends Heroe {
	private int potenciaOfensivaOrcos= 10;
	/**
	 * Constructor
	 * @param nombre
	 * @param vida
	 * @param armadura
	 */
	public Elfo(String nombre, int vida, int armadura) {
		super(nombre,vida,armadura);
	}

	/**
	 * Getter nos da la potencia ofensiva que tiene un elfo frente a orcos
	 * @return
	 */
	public int getPotenciaOfensivaOrcos() {
		return potenciaOfensivaOrcos;
	}
	
	/**
	 * Nos devuelve un String con la informacion del personaje, se le añade el tipo de personaje que es
	 */
	public String toString() {
		String resultado=super.toString()+"-> Elfo";
		return resultado;
	}

}
