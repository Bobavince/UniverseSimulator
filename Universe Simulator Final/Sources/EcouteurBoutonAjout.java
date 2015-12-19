import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**Classe Ecouteur du bouton Ajouter Particule de la fenêtre Affichage
 */ 
public class EcouteurBoutonAjout implements ActionListener {
	Affichage fenetreAffichage;
	FenetreAjout fenetreAjout;
	
	/** Constructeur de l'écouteur du bouton Ajouter
	 * @param fenetreAffichage : la fenêtre Affichage parente qui contient le bouton Ajouter
	 */
	public EcouteurBoutonAjout(Affichage fenetreAffichage){
		this.fenetreAffichage=fenetreAffichage;
	}
	
	/* Méthode de standard de traitement d'actions.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		fenetreAjout = new FenetreAjout(fenetreAffichage);
	}

}
