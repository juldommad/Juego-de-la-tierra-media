package Dado;

public final class Tirada {
	/**
	 * Realizar tirada
	 * 
	 * @param numeroDados
	 * @param maximoValor
	 * @return
	 */
	public static int[] hacerTirada(int numeroDados, int maximoValor) {
		int[] array = new int[numeroDados];// hago el simil de que tirar varios dados es lo mismo que tirar uno varias

		for (int i = 0; i < array.length; i++) {
			array[i] = Dado.lanzar(maximoValor);
		}
		return array;
	}

	/**
	 * Calcula el maximo del array
	 * 
	 * @param array
	 * @return
	 */
	public static int verMax(int[] array) {
		int maximo = 0;
		for (int x : array) {
			if (x > maximo) {
				maximo = x;
			}
		}
		return maximo;
	}
}