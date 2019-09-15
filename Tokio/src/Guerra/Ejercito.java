package Guerra;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Pesonajes.*;

public class Ejercito {
	/**
	 * Esta clase se encarga de hacer que los soldados se reunan en ejercitos
	 */
	private ArrayList<Personaje> ejercito;
	
	/**
	 * Constructor
	 */
	public Ejercito () {
		ejercito=new ArrayList<Personaje>();
	}
	
	/**
	 * Añade un soldado ejercito
	 */
	public void addSoilder(Personaje e){
		ejercito.add(e);
	}
	
	/**
	 * Devuelve el tamaño del ejercito
	 */
	public int getSize(){
		return ejercito.size();
	}
	
	/**
	 * Elimina de las listas a los soldados fallecidos por el personaje que es
	 */
	public void removeSoilder(Personaje e){
		ejercito.remove(e);
	}
	
	/**
	 * Elimina de las listas a los soldados fallecidos por indice de lista
	 */
	public void removeSoilder(int index){
		ejercito.remove(index);
	}
	
	/**
	 * coloca al soldado una posicion adelantada para que entre antes en combate
	 */
	public void upPositionSoldier(int index) {
		Personaje a=ejercito.get(index);
		if(index>0) {
			Personaje b=ejercito.get(index-1);
			ejercito.set(index-1,a);
			ejercito.set(index,b);
		}else {
			JOptionPane.showMessageDialog(null,"No se puede subir posicion a "+ a.getNombre() +" porque ya esta en la posicion mas alta"); 
		}
	}
	
	/**
	 * coloca al soldado una posicion atrasada para que entre más tarde en combate
	 */
	public void downPositionSoldier(int index) {
		Personaje a=ejercito.get(index);
		if(index < ejercito.size()-1) {
			Personaje b=ejercito.get(index+1);
			ejercito.set(index+1,a);
			ejercito.set(index,b);
		}else {
			JOptionPane.showMessageDialog(null,"No se puede bajar de posicion a "+ a.getNombre() +" porque ya esta en la posicion mas baja"); 
		}
	}
	
	/**
	 * nos devuelve el personaje del ejercito por el indice
	 */
	public Personaje getSoldier(int index) {
		return ejercito.get(index);
	}
}
