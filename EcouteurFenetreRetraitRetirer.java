import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class EcouteurFenetreRetraitRetirer implements ActionListener{
	private FenetreRetrait fenR;

	public EcouteurFenetreRetraitRetirer(FenetreRetrait fenR){
		this.fenR = fenR;
	}

	public void actionPerformed(ActionEvent ae){
		//Récupération de la liste courante de particules (type LinkedList)
		LinkedList<Particule> listePart = fenR.getListePart();
		LinkedList<JCheckBox> listeBoutons = fenR.getListeBoutons();
		//Analyse de l'état des JCheckBox
		for (int i=0; i<listePart.size(); i++){
			if(listeBoutons.get(i).isSelected()){
				//Suppression de la particule sélectionnée
				listePart.remove(i);
			}
		}
		fenR.dispose();
	}
}
