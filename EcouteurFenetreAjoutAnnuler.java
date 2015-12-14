import java.util.LinkedList;
import javax.swing.*;
import java.awt.event.*;

public class EcouteurFenetreAjoutAnnuler implements ActionListener {
	
	FenetreAjout fenetreAjout;
	
	public EcouteurFenetreAjoutAnnuler(FenetreAjout fenetreAjout){
		this.fenetreAjout=fenetreAjout;	
	}
	
	public void actionPerformed(ActionEvent ae) {
		fenetreAjout.dispose();
	}
	
}
