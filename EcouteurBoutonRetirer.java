import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcouteurBoutonRetirer implements ActionListener{
	private Affichage fenetreAffichage;
	
	public EcouteurBoutonRetirer(Affichage fenetreAffichage){
		this.fenetreAffichage = fenetreAffichage;
	}
	
	public void actionPerformed(ActionEvent ae){
		new FenetreRetrait(fenetreAffichage.getListeObjets(), this.fenetreAffichage);
	}
	
}
