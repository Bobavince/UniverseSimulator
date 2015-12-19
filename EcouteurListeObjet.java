import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class EcouteurListeObjet implements ItemListener{

	private Affichage fenetreAffichage;

	public EcouteurListeObjet(Affichage fenetreAffichage){
		this.fenetreAffichage=fenetreAffichage;
	}
	
	public void itemStateChanged(ItemEvent event) {
       // The item affected by the event.
       Particule item = (Particule) event.getItem();

       System.out.println("ECOUTEURLISTE OBJET : Affected items: " + item.toString());

       if (event.getStateChange() == ItemEvent.SELECTED) {
    	   System.out.println("ECOUTEURLISTE OBJET :  " + item.toString() + " selected.");
    	   fenetreAffichage.mettreAJourChamps();
       }

       if (event.getStateChange() == ItemEvent.DESELECTED) {
    	   System.out.println("ECOUTEURLISTE OBJET :  " + item.toString() + " deselected.");
       }
    }     
	
}

