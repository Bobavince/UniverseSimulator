import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**Classe Ecouteur le bouton Next de la fenêtre Affichage
 */
public class EcouteurBoutonNext implements ActionListener {
	private Affichage fenetreAffichage;

	/** Constructeur de l'écouteur le bouton Next
	 * @param fenetreAffichage : la fenêtre Affichage parente qui contient le bouton Next
	 */
	public EcouteurBoutonNext(Affichage fenetreAffichage){
		this.fenetreAffichage = fenetreAffichage;
	}

	/* Méthode de standard de traitement d'actions.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//On compute toutes les interactions en appellant le moteur et en lui envoyant la liste des objets (la classe qui g�re tout �a)
		fenetreAffichage.getMoteur().miseAJourParticules(fenetreAffichage.getListeObjets());

		//On fait passer toutes les particules � leur �tat futur gr�ce � ListeObjet
		fenetreAffichage.getListeObjets().mettreAJourEtat();

		//On repaint la fenetre puisque la position des objets a chang�.
		fenetreAffichage.getZoneDessin().repaint();
	}

}