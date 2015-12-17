import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class EcouteurFenetreRetraitRetirer implements ActionListener{
	private FenetreRetrait fenetreRetrait;
	private Affichage fenetreAffichage;

	public EcouteurFenetreRetraitRetirer(FenetreRetrait fenetreRetrait, Affichage fenetreAffichage){
		this.fenetreRetrait = fenetreRetrait;
		this.fenetreAffichage = fenetreAffichage;
	}

	public void actionPerformed(ActionEvent ae){
		//Récupération de la liste courante de particules (type LinkedList)
		LinkedList<Particule> listeParticules = fenetreRetrait.getListeParticules();
		LinkedList<JCheckBox> listeJCheckBox = fenetreRetrait.getListeJCheckBox();
		//Analyse de l'état des JCheckBox
		for (int i=0; i<listeParticules.size(); i++){
			if(listeJCheckBox.get(i).isSelected()){
				//Suppression de la particule sélectionnée
				fenetreAffichage.retirerParticule(listeParticules.get(i));
			}
		}
		fenetreRetrait.dispose();
	}
}
