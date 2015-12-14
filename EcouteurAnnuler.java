import java.util.LinkedList;
import javax.swing.*;
import java.awt.event.*;



public class EcouteurAnnuler implements ActionListener {
	
	FenetreAjout fen;
	
	public EcouteurAnnuler(FenetreAjout fen){
		this.fen=fen;	
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		fen.dispose();
		
	}
}
