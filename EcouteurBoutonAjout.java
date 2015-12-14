import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

public class EcouteurBoutonAjout implements ActionListener {
	Affichage fen;
	FenetreAjout fen2;
	
	
	public EcouteurBoutonAjout(Affichage fen){
		this.fen=fen;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		fen2= new FenetreAjout(fen);
	}
		

	

}
