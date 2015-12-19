import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Classe Ecouteur du bouton annuler de la fenêtre d'ajout des particules
 */
public class EcouteurFenetreAjoutAnnuler implements ActionListener {

	FenetreAjout fenetreAjout;

	/** Constructeur de l'écouteur du bouton Annuler
	 * @param fenetreAjout : la fenêtre Ajout parente qui contient le bouton annuler
	 */
	public EcouteurFenetreAjoutAnnuler(FenetreAjout fenetreAjout){
		this.fenetreAjout=fenetreAjout;	
	}

	/* Méthode de standard de traitement d'actions.
	 */
	public void actionPerformed(ActionEvent ae) {
		fenetreAjout.dispose();
	}

}
