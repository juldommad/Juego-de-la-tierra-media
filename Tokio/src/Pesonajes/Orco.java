package Pesonajes;

public class Orco extends Bestia {
	private float porcentajeReduccionArmadura=0.10f;

	/**
	 * Constructor
	 * @param nombre
	 * @param vida
	 * @param armadura
	 */
	public Orco(String nombre, int vida, int armadura) {
		super(nombre,vida,armadura);
	}

	/**
	 * Nos devuelve cuanto reduce el poder de la defensa del enemigo
	 * @return
	 */
	public float getPorcentajeReduccionArmadura() {
		return porcentajeReduccionArmadura;
	}
	
	/**
	 * Nos devuelve un String con la informacion del personaje, se le añade el tipo de personaje que es
	 */
	public String toString() {
		String resultado=super.toString()+"-> Orco";
		return resultado;
	}

	
}
