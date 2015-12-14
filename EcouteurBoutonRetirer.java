import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcouteurBoutonRetirer implements ActionListener{
	private Affichage fen;
	
	public EcouteurBoutonRetirer(Affichage fen){
		this.fen = fen;
	}
	
	public void actionPerformed(ActionEvent ae){
		new FenetreRetrait(fen.getListeObjets());
	}
	
}
