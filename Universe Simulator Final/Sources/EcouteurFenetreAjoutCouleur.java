import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

/** Classe Ecouteur du bouton Couleur de la fenêtre d'Ajout des particules
 */
public class EcouteurFenetreAjoutCouleur implements ActionListener {
	
	FenetreAjout fenetreAjout;
	
	/**Constructeur de l'écouteur du bouton Couleur
	 * @param fenetreAjout : la fenêtre Ajout parente qui contient le bouton Couleur
	 */
	public EcouteurFenetreAjoutCouleur(FenetreAjout fenetreAjout){
		this.fenetreAjout=fenetreAjout;
	}

	/* Méthode de standard de traitement d'actions.
	 */
	public void actionPerformed(ActionEvent ae) {
		Color c =JColorChooser.showDialog(null, "Choix couleur",null);
		fenetreAjout.setCouleurParticule(c);
	}
	
}

