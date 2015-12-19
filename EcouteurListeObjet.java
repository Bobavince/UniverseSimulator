import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/** Classe Ecouteur du champ masse de la fenêtre de retrait des particules
 */
public class EcouteurListeObjet implements ItemListener{

	private Affichage fenetreAffichage;

	/**Constructeur de l'écouteur de la liste des Objets
	 * @param fenetreAffichage : la fenêtre Affichage parente qui contient la liste des objets
	 */
	public EcouteurListeObjet(Affichage fenetreAffichage){
		this.fenetreAffichage=fenetreAffichage;
	}

	/* Méthode de standard de traitement d'actions.
	 */
	@Override
	public void itemStateChanged(ItemEvent event) {
		// The item affected by the event.
		Particule item = (Particule) event.getItem();

		System.out.println("ECOUTEURLISTE OBJET : Affected items: " + item.toString());

		if (event.getStateChange() == ItemEvent.SELECTED) {
			System.out.println("ECOUTEURLISTE OBJET :  " + item.toString() + " selected.");
			fenetreAffichage.mettreAJourChamps();
		}

		if (event.getStateChange() == ItemEvent.DESELECTED) {
			System.out.println("ECOUTEURLISTE OBJET :  " + item.toString() + " deselected.");
		}
	}     

}

