import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Classe Ecouteur du bouton annuler de la fenêtre de retrait des particules
 */
public class EcouteurFenetreRetraitAnnule implements ActionListener{
	
	private FenetreRetrait fenetreRetrait;
	 
	/** Constructeur de l'écouteur du bouton Annuler
	 * @param fenR : la fenêtre Retrait parente qui contient le bouton annuler
	 */
	public EcouteurFenetreRetraitAnnule(FenetreRetrait fenR) {
		this.fenetreRetrait = fenR;
	}

	/* Méthode de standard de traitement d'actions.
	 */
	@Override
	public void actionPerformed(ActionEvent ae){
		fenetreRetrait.dispose();
	}

}
