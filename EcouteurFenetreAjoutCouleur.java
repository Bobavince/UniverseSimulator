import java.util.LinkedList;
import javax.swing.*;
import java.awt.event.*;

import java.awt.*;

public class EcouteurFenetreAjoutCouleur implements ActionListener {
	
	FenetreAjout fenetreAjout;
	
	public EcouteurFenetreAjoutCouleur(FenetreAjout fenetreAjout){
		this.fenetreAjout=fenetreAjout;
	}
	
	public void actionPerformed(ActionEvent ae) {
		Color c =JColorChooser.showDialog(null, "Choix couleur",null);
		fenetreAjout.setCouleurParticule(c);
	}
	
}

