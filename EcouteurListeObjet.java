import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class EcouteurListeObjet implements ActionListener{

	private Affichage fenetreAffichage;

	public EcouteurListeObjet(Affichage fenetreAffichage){
		this.fenetreAffichage=fenetreAffichage;
	}

	public void actionPerformed(ActionEvent ae){

		if(fenetreAffichage.getJComboBox().getSelectedItem() instanceof Particule){
			Particule particule  = (Particule) this.fenetreAffichage.getJComboBox().getSelectedItem();

			// On change tous les JSpinner de la fenêtre principale.
			this.fenetreAffichage.setCoordX(particule.getCoordonnees().getTabVecteur()[0]);
			this.fenetreAffichage.setCoordY(particule.getCoordonnees().getTabVecteur()[1]);
			this.fenetreAffichage.setVitesX(particule.getVitesse().getTabVecteur()[0]);
			this.fenetreAffichage.setVitesY(particule.getVitesse().getTabVecteur()[1]);
			this.fenetreAffichage.setAccelX(particule.getAcceleration().getTabVecteur()[0]);
			this.fenetreAffichage.setAccelY(particule.getAcceleration().getTabVecteur()[1]);
			this.fenetreAffichage.setMasse(particule.getMasse());
			this.fenetreAffichage.setRayon(particule.getRayon());

		} else {
			System.out.println("Pas de particule dans la liste déroulante sélectionnée");
		}
	}

}

