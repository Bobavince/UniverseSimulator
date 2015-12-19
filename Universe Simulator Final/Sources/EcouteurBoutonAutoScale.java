import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

/**Classe Ecouteur du bouton Autoscale de la fenêtre Affichage
 */
public class EcouteurBoutonAutoScale implements ActionListener {
	private Affichage fenetreAffichage;

	/** Constructeur de l'écouteur du bouton Autoscale
	 * @param fenetreAffichage : la fenêtre Affichage parente qui contient le bouton Autoscale
	 */
	public EcouteurBoutonAutoScale(Affichage fenetreAffichage){
		this.fenetreAffichage = fenetreAffichage;
	}

	/* Méthode de standard de traitement d'actions.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JToggleButton boutonAutoScale = (JToggleButton)arg0.getSource();
		if (boutonAutoScale.isSelected()) {

			//DEBUG // 
			if(Affichage.debug){System.out.println("ECOUTEUR AUTOSCALE : bouton SELECTIONE");}
			//DEBUG - Pour savoir si la rayon été changée effectivement. //

		} else {

			//DEBUG // 
			if(Affichage.debug){System.out.println("ECOUTEUR AUTOSCALE : bouton NON SELECTIONE");}
			//DEBUG - Pour savoir si la rayon été changée effectivement. //
		}
	}
}
