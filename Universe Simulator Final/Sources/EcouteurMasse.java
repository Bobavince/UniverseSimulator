import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**Classe Ecouteur du champ masse de la fenêtre Affichage
 */
public class EcouteurMasse implements ChangeListener {

	private Affichage fenetreAffichage;

	/** Constructeur de l'écouteur du champ masse
	 * @param fenetreAffichage : la fenêtre Affichage parente qui contient le champ masse
	 */
	public EcouteurMasse(Affichage fenetreAffichage){
		this.fenetreAffichage=fenetreAffichage;
	}

	/* Méthode de standard de traitement d'actions.
	 */
	@Override
	public void stateChanged(ChangeEvent e) {

		if(fenetreAffichage.getJComboBox().getSelectedItem() instanceof Particule){

			// On récupère la particule courante sélectionnée
			Particule particule = (Particule)(fenetreAffichage.getJComboBox().getSelectedItem());

			if(!fenetreAffichage.getBoutonStartPause().isSelected()){
				// On lui attribue sa nouvelle masse
				particule.setMasse(fenetreAffichage.getMasse());
			} else {
				System.out.println("Vous ne pouvez pas changer la masse en cours d'execution ! ");
			}

			//DEBUG // 
			if(Affichage.debug){System.out.println("MASSE DE LA PARTICULE : \n" + particule.toStringComplet() + " \n changée");}
			//DEBUG - Pour savoir si la masse été changée effectivement. //
		} else {
			System.out.println("Il n'y a pas de particule sélectionnée !");
		}

	}

}
