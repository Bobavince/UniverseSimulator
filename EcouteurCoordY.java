import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**Classe Ecouteur du champ masse de la fenêtre Affichage
 */
public class EcouteurCoordY implements ChangeListener {

	private Affichage fenetreAffichage;

	/** Constructeur de l'écouteur du champ CoordY
	 * @param fenetreAffichage : la fenêtre Affichage parente qui contient le champ CoordY
	 */
	public EcouteurCoordY(Affichage fenetreAffichage){
		this.fenetreAffichage=fenetreAffichage;
	}

	/* Méthode de standard de traitement d'actions.
	 */
	@Override
	public void stateChanged(ChangeEvent arg0) {
		if(fenetreAffichage.getJComboBox().getSelectedItem() instanceof Particule){

			// On récupère la particule courante sélectionnée
			Particule particule = (Particule)(fenetreAffichage.getJComboBox().getSelectedItem());

			if(!fenetreAffichage.getBoutonStartPause().isSelected()){
				// On lui attribue de nouvelles coordonnées : sa coordonnée y depuis la fenetre principale et sa coordonnées x inchangée
				particule.setCoordonnees(particule.getCoordonneeX(),fenetreAffichage.getCoordY(),0.0);
			} else {
				System.out.println("Vous ne pouvez pas changer le rayon en cours d'execution !");
			}

			//DEBUG // 
			System.out.println("COORDONNES Y DE LA PARTICULE : \n" + particule.toStringComplet() + " \n changée");
			//DEBUG - Pour savoir si la coordonnées à été changée effectivement. //
		} else {
			System.out.println("Il n'y a pas de particule sélectionnée !");
		}
	}

}

