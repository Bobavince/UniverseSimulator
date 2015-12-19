import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**Classe Ecouteur le bouton retirer de la fenêtre Affichage
 */
public class EcouteurBoutonRetirer implements ActionListener{
	private Affichage fenetreAffichage;

	/** Constructeur de l'écouteur du bouton retirer
	 * @param fenetreAffichage : la fenêtre Affichage parente qui contient le bouton retirer
	 */
	public EcouteurBoutonRetirer(Affichage fenetreAffichage){
		this.fenetreAffichage = fenetreAffichage;
	}

	/* Méthode de standard de traitement d'actions.
	 */
	@Override
	public void actionPerformed(ActionEvent ae){
		new FenetreRetrait(fenetreAffichage.getListeObjets(), this.fenetreAffichage);
	}

}
