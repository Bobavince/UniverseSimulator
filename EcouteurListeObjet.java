import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcouteurListeObjet implements ActionListener{
	
	private Affichage aff;
	
	public EcouteurListeObjet(Affichage aff){
		this.aff=aff;
	}
	
	public void actionPerformed(ActionEvent ae){
		Particule particule  = this.getJComboItem();
		double xPart=particule.getCoordonnees().getTabVecteur()[0];
		double yPart=particule.getCoordonnees().getTabVecteur()[1];
		double vitXPart=particule.getVitesse().getTabVecteur()[0];
		double vitYPart=particule.getVitesse().getTabVecteur()[1];
		double accXPart=particule.getAcceleration().getTabVecteur()[0];
		double accYPart=particule.getAcceleration().getTabVecteur()[1];
		double massePart=particule.getMasse();
		double rayonPart=particule.getRayon();
		
		this.aff.setCoordX(xPart);
		this.aff.setCoordY(yPart);
		this.aff.setVitesX(vitXPart);
		this.aff.setVitesY(vitYPart);
		this.aff.setAccelX(accXPart);
		this.aff.setAccelY(accYPart);
		this.aff.setMasse(massePart);
		this.aff.setRayon(rayonPart);
		
		
		
		
		
		//pzrt get 
		//fen.x.set 
		
	}

	/**
	 * @return
	 */
	private Particule getJComboItem() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

