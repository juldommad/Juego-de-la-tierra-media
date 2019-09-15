package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

import Guerra.Ejercito;
import Pesonajes.Personaje;

public class ListaEjercito {
	private Ejercito ejercito;
	private JPanel j1;
	private JPanel jp;
	private String name;
	private DefaultListModel<String> dml;
	private JList<String> jlist;
	private JScrollPane jscr;

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	ListaEjercito(String name) {
		this.name = name;
		this.ejercito = new Ejercito();
	}

	/**
	 * Creo el panel
	 */
	public JPanel GetJPanel() {
		// SEteo las principales caracteristicas del panel
		j1 = new JPanel();
		jp = new JPanel();
		j1.setLayout(new BorderLayout());
		jp.setLayout(new GridLayout(3, 1));
		j1.setSize(800, 300);

		// Creo los distintos componentes
		dml = new DefaultListModel<String>();
		for (int i = 0; i < this.ejercito.getSize(); i++) {
			dml.addElement(this.ejercito.getSoldier(i).toString());
		}
		jlist = new JList<String>(dml);
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jscr = new JScrollPane(jlist);
		JButton botonSubir = new JButton("Subir");
		JButton botonBajar = new JButton("Bajar");
		JButton botonEliminar = new JButton("Eliminar");

		// Añado funcionalidades
		botonSubir.addActionListener(e -> {
			int indiceSeleccionado = jlist.getSelectedIndex();
			if (this.ejercito.getSize() > 1 && indiceSeleccionado != -1) {
				this.ejercito.upPositionSoldier(indiceSeleccionado);
				repinta();
			} else {
				JOptionPane.showMessageDialog(null,
						"No has seleccionado a un soldado o no hay suficientes soldados para esta operación ");
			}
		});
		botonBajar.addActionListener(e -> {
			int indiceSeleccionado = jlist.getSelectedIndex();
			if (this.ejercito.getSize() > 1 && indiceSeleccionado != -1) {
				this.ejercito.downPositionSoldier(indiceSeleccionado);
				repinta();
			} else {
				JOptionPane.showMessageDialog(null,
						"No has seleccionado a un soldado o no hay suficientes soldados para esta operación ");
			}
		});
		botonEliminar.addActionListener(e -> {
			int indiceSeleccionado = jlist.getSelectedIndex();
			if (this.ejercito.getSize() > 0 && indiceSeleccionado != -1) {
				this.ejercito.removeSoilder(indiceSeleccionado);
				repinta();
			} else {
				JOptionPane.showMessageDialog(null,
						"No has seleccionado a un soldado o no hay suficientes soldados para esta operación ");
			}
		});

		// Añado los componentes al panel
		jp.add(botonSubir);
		jp.add(botonBajar);
		jp.add(botonEliminar);
		j1.add(jscr, BorderLayout.CENTER);
		j1.add(jp, BorderLayout.EAST);
		j1.setBorder(BorderFactory.createTitledBorder(name));
		return j1;
	}

	/**
	 * Getter me devuelve el ejercito
	 * 
	 * @return
	 */
	public Ejercito getEjercito() {
		return ejercito;
	}

	/**
	 * Muestra al soldado añadido por pantalla, y lo añade al ejercito
	 * 
	 * @return
	 */
	public void pintaSoldado(Personaje aux) {
		ejercito.addSoilder(aux);
		dml.addElement(aux.toString());
		jlist.repaint();
	}

	/**
	 * Pinta los datos nuevos por pantalla, para eso borra los anteriores
	 */
	public void repinta() {
		dml.clear();
		for (int i = 0; i < this.ejercito.getSize(); i++) {
			dml.addElement(this.ejercito.getSoldier(i).toString());
		}
		jlist.repaint();
	}
}
