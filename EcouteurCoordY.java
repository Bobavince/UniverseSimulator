import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EcouteurCoordY implements ChangeListener {

	private Affichage fenetreAffichage;

	public EcouteurCoordY(Affichage fenetreAffichage){
		this.fenetreAffichage=fenetreAffichage;
	}

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

