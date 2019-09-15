package Guerra;

import GUI.CampoBatalla;
import Pesonajes.*;

public final class Lucha {
	private static Ejercito malo;
	private static Ejercito bueno;
	/**
	 * Elije ejercito de bestias
	 */
	public static void setMalo(Ejercito malo) {
		Lucha.malo = malo;
	}
	
	/**
	 * Elije ejercito de heroes
	 */
	public static void setBueno(Ejercito bueno) {
		Lucha.bueno = bueno;
	}

	/**
	 * Determina como se realiza el combate 1vs 1
	 */
	private static void combate(Personaje a, Personaje d) {//a es de atacante, d es de defensor
		float reduccionArmadura=1;
		int reduccionPotenciaOfensiva=0;
		int aumentoPotenciaOfensiva=0;
		if(a instanceof Orco) {
			CampoBatalla.addLinea("\t!!!!El poder de "+a.getNombre()+" hace que "+d.getNombre()+" reduzca su armadura un 10 %¡¡¡¡¡");
			reduccionArmadura=1-((Orco) a).getPorcentajeReduccionArmadura();
		}
		if(d instanceof Trasgo && a instanceof Hobbit) {
			CampoBatalla.addLinea("\t!!!!"+d.getNombre()+" asusta a "+ a.getNombre() +", se reduce en 5 puntos de potencia ofensiva¡¡¡¡¡");
			reduccionPotenciaOfensiva=((Hobbit) a).getPotenciaOfensivaTrasgos();
		}
		if(d instanceof Orco && a instanceof Elfo) {
			CampoBatalla.addLinea("\t!!!!!"+a.getNombre()+" se llena de rabia, aumenta en 10 puntos de potencia ofensiva¡¡¡¡¡");
			aumentoPotenciaOfensiva=((Elfo) a).getPotenciaOfensivaOrcos();
		}
		int dano=a.atacar()+reduccionPotenciaOfensiva+aumentoPotenciaOfensiva;
		float armadura=d.getArmadura()*reduccionArmadura;
		if(dano>armadura) {
			dano=(int)(dano-armadura);
			CampoBatalla.addLinea("\t"+a.getNombre()+ " dañó a "+d.getNombre()+" con un daño de "+dano );
			d.recibeDano(dano);
		}else {
			CampoBatalla.addLinea("\t"+d.getNombre()+ " esquivó el ataque de "+ a.getNombre());
		}
	}
	
	/**
	 * Empieza la sucesion de combates y de turnos
	 */
	public static void startGuerra(){
		int tamañoEjercitoHeroes=bueno.getSize();
		int tamañoEjercitoBestias=malo.getSize();
		int round=1;
		while(tamañoEjercitoHeroes>0 && tamañoEjercitoBestias>0) {
			CampoBatalla.addLinea("************************************* Ronda "+round +" *************************************" );
			int counter=0;
			CampoBatalla.addLinea(" ");
			while(counter<bueno.getSize() && counter<malo.getSize() ) {
				Personaje atacante =bueno.getSoldier(counter);
				Personaje defensor =malo.getSoldier(counter);
				CampoBatalla.addLinea("->  Combate "+(counter+1)+": "+atacante.toString()+" vs "+defensor.toString() );
				combate(atacante,defensor);
				combate(defensor,atacante);
				if(defensor.getVida()<=0) {
					CampoBatalla.addLinea("\t++++++++++ Muere "+defensor.getNombre()+" +++++++++++");
				}else if(atacante.getVida()<=0) {
					CampoBatalla.addLinea("\t++++++++++ Muere "+atacante.getNombre()+" +++++++++++");
				}
				counter++;			
				CampoBatalla.addLinea(" ");
				}
			eliminaMuertos();
			tamañoEjercitoHeroes=bueno.getSize();
			tamañoEjercitoBestias=malo.getSize();
			if(tamañoEjercitoHeroes==0 && tamañoEjercitoBestias ==0) {
				tablas();
				break;
			}
			if(tamañoEjercitoHeroes==0 && malo.getSoldier(0) instanceof Bestia) {
				ganaMalo();
				break;
			}else if (tamañoEjercitoHeroes==0 && malo.getSoldier(0) instanceof Heroe) {
				ganaBueno();
				break;
			}else if(tamañoEjercitoBestias==0 && bueno.getSoldier(0) instanceof Heroe) {
				ganaBueno();
				break;
			}else if(tamañoEjercitoBestias==0 && bueno.getSoldier(0) instanceof Bestia) {
				ganaMalo();
				break;
			}

			round++;
		}
	}
	
	/**
	 * Saca a los muertos del campo de combate
	 */
	private static void eliminaMuertos() {
		int a;
		for(int i=0;i<malo.getSize();i++) {
			a=malo.getSoldier(i).getVida();
			if(a<=0) {
				malo.removeSoilder(malo.getSoldier(i));
			}
		}
		for(int i=0;i<bueno.getSize();i++) {
			a=bueno.getSoldier(i).getVida();
			if(a<=0) {
				bueno.removeSoilder(bueno.getSoldier(i));
			}
		}
		
	}
	
	/**
	 * Muesta que han vencido las bestias
	 */
	private static void ganaMalo() {
		CampoBatalla.addLinea("**************************** Ganó el ejército de Bestias ****************************");
	}
	
	/**
	 * Muesta que han vencido los héroes
	 */
	private static void ganaBueno() {
		CampoBatalla.addLinea("**************************** Ganó el ejército de Héroes ****************************");
	}
	
	/**
	 * Muesta que han muerto los dos ejercitos
	 */
	private static void tablas() {
		CampoBatalla.addLinea("**************************** Murieron los dos ejercitos ****************************");
	}
}
