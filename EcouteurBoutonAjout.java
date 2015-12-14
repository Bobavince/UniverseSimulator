import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Ecouteur du bouton Ajouter dans la fenêtre principale
 * Ouvre une fenetre de gestion d'ajout des particules.
 */

public class EcouteurBoutonAjout implements ActionListener {
	Affichage fenetreAffichage;
	FenetreAjout fenetreAjout;

	public EcouteurBoutonAjout(Affichage fen){
		this.fenetreAffichage=fen;
	}
	
	public void actionPerformed(ActionEvent e) {
		fenetreAjout = new FenetreAjout(fenetreAffichage);
	}
	
}
