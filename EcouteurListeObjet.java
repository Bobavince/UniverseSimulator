import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class EcouteurListeObjet implements ActionListener{

	private Affichage fenetreAffichage;
	private Particule particuleSelectedBefore;

	public EcouteurListeObjet(Affichage fenetreAffichage){
		this.fenetreAffichage=fenetreAffichage;
	}

	public void actionPerformed(ActionEvent ae){
	
	}
	
	public void itemStateChanged(ItemEvent event) {
       if (event.getStateChange() == ItemEvent.SELECTED) {
   			fenetreAffichage.mettreAJourChamps();
   		}
    }     
	
}

