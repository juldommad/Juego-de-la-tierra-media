package Dado;

import java.util.Random;

public final class Dado {

	/**
	 * Es el resultado que da lanzar un dado, lo hago estatico ya que no es necesario crear una instancia  de dado cada vez que se quiera usar.
	 * 
	 * 
	 * @return
	 */
	public static int lanzar(int maxValue) {
		Random random = new Random();
		int valorDado = random.nextInt(maxValue) + 1;
		return valorDado;
	}
}
