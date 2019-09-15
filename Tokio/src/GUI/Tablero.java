package GUI;

import java.awt.*;
import javax.swing.*;

import Guerra.Lucha;

public class Tablero {

	/**
	 * Constructor
	 * 
	 * Presenta en un tablero los distintos modulos que coomponen el tablero final
	 */
	public Tablero() {
		// Seteo el frame que hace la base del tablero
		JFrame j1 = new JFrame("Juego por la tierra media");
		j1.setSize(800, 600);
		j1.setLayout(new GridLayout(3, 1));
		j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// elijo los paneles que compondran las distintas partes del tablero
		JPanel jpSeleccionador = new JPanel();
		JPanel jpEjercitos = new JPanel();
		JPanel jpCampo = new JPanel();

		// Elijo las propiedades de los paneles
		jpSeleccionador.setLayout(new GridLayout(1, 2));
		jpEjercitos.setLayout(new GridLayout(1, 2));
		jpCampo.setLayout(new BorderLayout());

		// Creo los paneles de Ejercitos y creador de soldados, y el campo de batalla
		ListaEjercito listaH = new ListaEjercito("Ejército de Heroes");
		ListaEjercito listaB = new ListaEjercito("Ejército de Bestias");
		RegistradorSoldado registroH = new RegistradorSoldado("Héroe", listaH);
		RegistradorSoldado registroB = new RegistradorSoldado("Bestia", listaB);
		CampoBatalla campo = new CampoBatalla();

		// Creo el boton que hace que empiece el combate
		JButton start = new JButton("Lucha");
		start.addActionListener(e -> {
			CampoBatalla.clearCampo();
			if (listaB.getEjercito().getSize() > 0 && listaH.getEjercito().getSize() > 0) {
				Lucha.setMalo(listaB.getEjercito());
				Lucha.setBueno(listaH.getEjercito());
				Lucha.startGuerra();
				listaH.repinta();
				listaB.repinta();
			} else {
				JOptionPane.showMessageDialog(null,"Los ejercitos no estan bien formados"); 
			}
		});

		// Añado los componentes al tablero
		jpSeleccionador.add(registroH.GetJPanel());
		jpSeleccionador.add(registroB.GetJPanel());
		jpEjercitos.add(listaH.GetJPanel());
		jpEjercitos.add(listaB.GetJPanel());
		jpCampo.add(start, BorderLayout.NORTH);
		jpCampo.add(campo.GetJPanel(), BorderLayout.CENTER);
		j1.add(jpSeleccionador);
		j1.add(jpEjercitos);
		j1.add(jpCampo);
		j1.setVisible(true);
	}

}
