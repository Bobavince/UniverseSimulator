import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Classe Ecouteur de la liste des particules prédéfiniesde la fenêtre de ajout des particules
 */
public class EcouteurParticulesPredefinies implements ActionListener{
	private FenetreAjout fen;

	/** Constructeur de l'écouteur du bouton Annuler
	 * @param fen : la fenêtre Ajout parente qui contient la liste des particules prédéfinies.
	 */
	public EcouteurParticulesPredefinies(FenetreAjout fen) {
		this.fen=fen;
	}

	/* Méthode de standard de traitement d'actions.
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		Particule p= fen.getSelectedParticule();
		fen.setMasse(""+p.getMasse());
		fen.setRayon(""+p.getRayon());
		fen.setType(""+p.getType());

	}
}
