package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

import Pesonajes.*;

public class RegistradorSoldado {
	private JLabel vida,nombre,armadura,type;
	private JTextField vidaT,nombreT,armaduraT;
	private JComboBox<String> jComboBox1;
	private String name;
	private String[] opciones;
	private ListaEjercito listitaAsociada;
	
	/**
	 * Constructor
	 * @param name
	 * @param e
	 */
	RegistradorSoldado(String name,ListaEjercito e){
		this.name=name;
		if(this.name.toUpperCase().equals("HÉROE")) {
			opciones=new String[] { "Elfo", "Humano", "Hobbit" };
		}else {
			opciones=new String[] { "Orco", "Trasgo" };
		}
		this.listitaAsociada=e;
	}
	
	/**
	 * Crea el panel que registra los soldados
	 * @return
	 */
	public JPanel GetJPanel(){
		//Seteo las caracteristicas del panel
		JPanel j1=new JPanel();
		JPanel jbase=new JPanel();
		JPanel jpSur=new JPanel();
		j1.setLayout(new BorderLayout());
		jbase.setLayout(new GridLayout(4, 2));
		j1.setSize(200, 250);
		
		//Creo los componentes que componen el panel
		jComboBox1= new JComboBox<String>();
		vida=new JLabel("Vida:");
		nombre=new JLabel("Nombre:");
		armadura=new JLabel("Armadura:");
		type=new JLabel("Tipo:");
		vidaT=new JTextField(15);
		nombreT=new JTextField(15);
		armaduraT=new JTextField(15);
		jComboBox1.setModel(new DefaultComboBoxModel<>(opciones));
		JButton boton =new JButton("Crear "+this.name);
		
		//Doy funcionalidad al boton 
		boton.addActionListener(e->{
			int error=validar();
			Personaje aux = null;
			if(error==0) {
				
				String tipoSoldado=((String)jComboBox1.getSelectedItem());
				switch(tipoSoldado.toUpperCase()) {
				case "ORCO":
					aux=new Orco(nombreT.getText(), Integer.valueOf(vidaT.getText()), Integer.valueOf(armaduraT.getText()));
					break;
				case "TRASGO":
					aux=new Trasgo(nombreT.getText(), Integer.valueOf(vidaT.getText()), Integer.valueOf(armaduraT.getText()));
					break;
				case "HUMANO":
					aux=new Humano(nombreT.getText(), Integer.valueOf(vidaT.getText()), Integer.valueOf(armaduraT.getText()));
					break;
				case "HOBBIT":
					aux=new Hobbit(nombreT.getText(), Integer.valueOf(vidaT.getText()), Integer.valueOf(armaduraT.getText()));
					break;
				case "ELFO":
					aux=new Elfo(nombreT.getText(), Integer.valueOf(vidaT.getText()), Integer.valueOf(armaduraT.getText()));
					break;
				}
				//Ejer.addSoilder(aux);
				listitaAsociada.pintaSoldado(aux);
			}else {
				muestraError(error);
				}
			}
		);
		
		//Añado los componentes al panel
		jbase.add(nombre);jbase.add(nombreT);
		jbase.add(vida);jbase.add(vidaT);
		jbase.add(type);jbase.add(jComboBox1);
		jbase.add(armadura);jbase.add(armaduraT);
		jpSur.add(boton);
		j1.add(jbase,BorderLayout.CENTER);
		j1.add(jpSur,BorderLayout.SOUTH);
		j1.setBorder(BorderFactory.createTitledBorder(name));
		 return j1;
	}
	
	/**
	 * Creo una lista de mensajes que se van a mostrar en popUps en caso de que los datos se introduzcan mal
	 * @param error
	 */
	private void muestraError(int error) {
		switch(error) {
		case 1:
			JOptionPane.showMessageDialog(null,"Añade un nombre válido"); 
			break;
		case 2:
			JOptionPane.showMessageDialog(null,"Añade un valor para la  vida válida (enteros)"); 
			break;
		case 3:
			JOptionPane.showMessageDialog(null,"Añade un valor para la armadura válida (enteros)"); 
			break;
		case 4:
			JOptionPane.showMessageDialog(null,"Añade un nombre, y  un valor para la  vida válida (enteros)"); 
			break;
		case 5:
			JOptionPane.showMessageDialog(null,"Añade un nombre, y  un valor para la  armadura válida (enteros)"); 
			break;
		case 6:
			JOptionPane.showMessageDialog(null,"Añade un valor para la  vida y  un valor para la  armadura válida (enteros)"); 
			break;
		case 7:
			JOptionPane.showMessageDialog(null,"Añade  valores al nombre,a la  vida (enteros), y a la armadura (enteros) que sean  válidos "); 
			break;
		}
		
	}
	
	/**
	 * Valido los parametros de entrada, el valor que devuelve es el numero de error
	 * @return
	 */
	private int validar() {
		int error=0;
		if(nombreT.getText()==null || nombreT.getText().equals("")) { //si el nombre introducido no es valido
			error=1;//nombre malo
		}
		if(vidaT.getText()==null || vidaT.getText().equals("")) {// si la vida inttroducida no es valida
			if(error==1) {
				error=4;//nombre y vida malos
			}else {
				error=2;//vida malo
			}
		}else {
			try {
				Integer.valueOf(vidaT.getText());
			}catch(Exception e){
				if(error==1) {
					error=4;//nombre y vida malos
				}else {
					error=2;//vida malo
				}
			}
		}
		if(armaduraT.getText()==null || armaduraT.getText().equals("")) {// si la armadura inttroducida no es valida
			if(error==1) {
				error=5;//nombre y armadura malos
			}else if(error==2){
				error=6;//vida y armadura malos
			}else if(error==4)	{
				error=7;//nombre, vida y armadura malos
			}else {
				error=3;//solo armadura malos
			}
		}else {
			try {
				Integer.valueOf(armaduraT.getText());
			}catch(Exception e){
				if(error==1) {
					error=5;//nombre y armadura malos
				}else if(error==2){
					error=6;//vida y armadura malos
				}else if(error==4)	{
					error=7;//nombre, vida y armadura malos
				}else {
					error=3;//solo armadura malos
				}
			}
		}
		return error;
	}

}
