import java.util.LinkedList;
import javax.swing.*;
import java.awt.event.*;

import java.awt.*;

public class EcouteurCouleurParticule implements ActionListener {
	
	FenetreAjout fen;
	
	public EcouteurCouleurParticule(FenetreAjout fen){
		this.fen=fen;
	}
	
	public void actionPerformed(ActionEvent ae) {
		Color c =JColorChooser.showDialog(null, "Choix couleur",null);
		fen.setCouleurParticule(c);
	}
	
}

