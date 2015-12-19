import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**Classe Ecouteur du champ rayon de la fenêtre d'Affichage
 */
public class EcouteurRayon implements ChangeListener {

	private Affichage fenetreAffichage;

	/** Constructeur de l'écouteur du champ rayon
	 * @param fenetreAffichage : la fenêtre Affichage parente qui contient le champ rayon
	 */
	public EcouteurRayon(Affichage fenetreAffichage){
		this.fenetreAffichage=fenetreAffichage;
	}

	/* Méthode de standard de traitement d'actions.
	 */
	@Override
	public void stateChanged(ChangeEvent e) {

		if(fenetreAffichage.getJComboBox().getSelectedItem() instanceof Particule){

			// On récupère la particule courante sélectionnée
			Particule particule = (Particule)(fenetreAffichage.getJComboBox().getSelectedItem());

			if(!fenetreAffichage.getBoutonStartPause().isSelected() && fenetreAffichage.getRayon()>0){
				// On lui attribue son nouveau rayon
				particule.setRayon(fenetreAffichage.getRayon());
			} else {
				System.out.println("Vous ne pouvez pas changer le rayon en cours d'execution ! Ni mettre un rayon négatif ! ");
			}

			//DEBUG // 
			if(Affichage.debug){System.out.println("RAYON DE LA PARTICULE : \n" + particule.toStringComplet() + " \n changée ");}
			//DEBUG - Pour savoir si la rayon été changée effectivement. //
		} else {
			System.out.println("Il n'y a pas de particule sélectionnée !");
		}
	}

}
