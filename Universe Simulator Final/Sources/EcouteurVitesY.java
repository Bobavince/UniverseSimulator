import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**Classe Ecouteur du champ VitesYde la fenêtre Affichage
 */
public class EcouteurVitesY implements ChangeListener {
	private Affichage fenetreAffichage;

	/** Constructeur de la classe
	 * @param fenetreAffichage : fenêtre principale parente, conteant le bouton JSpinner "Vitesse Y" 
	 */
	public EcouteurVitesY(Affichage fenetreAffichage){
		this.fenetreAffichage=fenetreAffichage;
	}

	/* Méthode qui gère le changement d'état de l'écouteur.
	 */
	@Override
	public void stateChanged(ChangeEvent e) {

		if(fenetreAffichage.getJComboBox().getSelectedItem() instanceof Particule){
			// On récupère la particule courante sélectionnée
			Particule particule = (Particule)(fenetreAffichage.getJComboBox().getSelectedItem());

			if(!fenetreAffichage.getBoutonStartPause().isSelected()){
				// On lui attribue de nouvelles coordonnées : sa vitesse y depuis la fenetre principale et sa vitesse x inchangée
				particule.setVitesse(particule.getVitesseX(),fenetreAffichage.getVitesY(),0.0);
			} else {
				System.out.println("Vous ne pouvez pas changer les Vitesses en cours d'execution !");
			}

			//DEBUG // 
			System.out.println("VITESSE Y DE LA PARTICULE : \n" + particule.toStringComplet() + " \n changée");
			//DEBUG - Pour savoir si la vitesse Y à été changée effectivement. //
		} else {
			System.out.println("Il n'y a pas de particule sélectionnée !");
		}
	}
}
