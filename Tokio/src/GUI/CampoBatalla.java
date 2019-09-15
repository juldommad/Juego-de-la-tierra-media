package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class CampoBatalla {
	private JList<String> jlist;
	private JScrollPane jscr;
	private static DefaultListModel<String> dml;
	
	/**
	 * Constructor
	 */
	CampoBatalla(){
		dml=new DefaultListModel<String>();
	}
	
	/**
	 * Creo el panel
	 */
	public JPanel GetJPanel(){
		//Seteo las principales caracteristicas del panel
		JPanel j1=new JPanel();
		JPanel jp=new JPanel();
		j1.setLayout(new BorderLayout());
		jp.setLayout(new GridLayout(3,1));
		j1.setSize(800, 300);
		
		//Creo los distintos componentes
		jlist=new JList<String>(dml);
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jscr=new JScrollPane(jlist);

		//Añado los componentes al panel
		j1.add(jscr,BorderLayout.CENTER);
		return j1;
	}
	
	/**
	 * Añado una linea de texto por pantalla
	 * @param a
	 */
	public static void addLinea(String a){
		dml.addElement(a);
	}
	
	/**
	 * Limpio el campo para que no se celebren varias guerras y se vean varios resultados
	 */
	public static void clearCampo(){
		dml.clear();
	}
}
