import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

/** Classe Ecouteur du bouton Couleur de la Principale
 */
public class EcouteurCouleur implements ActionListener {

	private Affichage fenetreAffichage;

	/** Constructeur de l'écouteur du bouton Couleur
	 * @param fenetreAffichage : la fenêtre Affichage parente qui contient le bouton couleur
	 */
	public EcouteurCouleur(Affichage fenetreAffichage){
		this.fenetreAffichage=fenetreAffichage;
	}

	/* Méthode de standard de traitement d'actions.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Color couleurChoisie = JColorChooser.showDialog(null,"Choix de couleur", null);

		if(fenetreAffichage.getJComboBox().getSelectedItem() instanceof Particule){

			// On récupère la particule courante sélectionnée
			Particule particule = (Particule)(fenetreAffichage.getJComboBox().getSelectedItem());
			// On lui attribue de nouvelles coordonnées : sa coordonnée X depuis la fenetre principale et sa coordonnées y inchangée
			particule.setCouleur(couleurChoisie);

			//On applique la couleur au bouton pour faire joli
			fenetreAffichage.mettreCouleurBouton(couleurChoisie);

			//DEBUG // 
			System.out.println("COULEUR DE LA PARTICULE : \n" + particule.toStringComplet() + " \n changée");
			//DEBUG - Pour savoir si la coordonnées à été changée effectivement. //
		} else {
			System.out.println("Il n'y a pas de particule sélectionnée !");
		}
	}

}

