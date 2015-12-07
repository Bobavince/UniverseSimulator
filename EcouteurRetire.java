import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class EcouteurRetire implements ActionListener{
	private FenetreRetrait fenR;

	public EcouteurRetire(FenetreRetrait fenR){
		this.fenR = fenR;
	}

	public void actionPerformed(ActionEvent ae){
		LinkedList<Particule> listePart = fenR.getListePart();
		//		LinkedList<JCheckBox> listeBoutons = fenR.getListeBoutons(); //Erreur de type entre JCombo et LinkedList 
		//		for (int i=0; i<listeBoutons.size(); i++){
		//			if (listeBoutons.get(i).getState()){ //méthode getState() non définie
		//				fenR.getListeDesParticules().sortirParticule(i); //à tester
		//			}
	}
}

