import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JCheckBox;

/** Classe Ecouteur du bouton retirer de la fenêtre de retrait des particules
 */
public class EcouteurFenetreRetraitRetirer implements ActionListener{
	private FenetreRetrait fenetreRetrait;
	private Affichage fenetreAffichage;

	/** Constructeur de l'écouteur du bouton Annuler
	 * @param fenetreRetrait : la fenêtre Retrait parente qui contient le bouton annuler
	 * @param fenetreAffichage : Fenêtre parente de la fenêtre de Retrait, contenant le bouton "Retirer une particule"
	 */
	public EcouteurFenetreRetraitRetirer(FenetreRetrait fenetreRetrait, Affichage fenetreAffichage){
		this.fenetreRetrait = fenetreRetrait;
		this.fenetreAffichage = fenetreAffichage;
	}


	/* Méthode de standard de traitement d'actions.
	 */
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
