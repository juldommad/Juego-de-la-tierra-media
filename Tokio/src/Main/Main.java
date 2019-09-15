package Main;

import javax.swing.SwingUtilities;

import GUI.Tablero;

public class Main {
	
	/**
	 * Crea el tablero para que se pueda ejecutar el juego
	 * @param args
	 */
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Tablero();
			}
		});
	}
}
