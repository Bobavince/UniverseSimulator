import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcouteurRetirerParticule implements ActionListener{
	private Affichage fen = new Affichage();
	
	public EcouteurRetirerParticule(Affichage fen){
		this.fen = fen;
	}
	
	public void actionPerformed(ActionEvent ae){
		new FenetreRetrait(fen.getListeObjets());
	}
	
}
