import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EcouteurAccelY implements ChangeListener {
	
	private Affichage fenetreAffichage;
	
	public EcouteurAccelY(Affichage fenetreAffichage){
		this.fenetreAffichage=fenetreAffichage;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		if(fenetreAffichage.getJComboBox().getSelectedItem() instanceof Particule){

			// On récupère la particule courante sélectionnée
			Particule particule = (Particule)(fenetreAffichage.getJComboBox().getSelectedItem());
			
			if(!fenetreAffichage.getBoutonStartPause().isSelected()){
				// On lui attribue de nouvelles coordonnées : sa acceleration y depuis la fenetre principale et sa vitesse x inchangée
				particule.setAcceleration(particule.getAccelerationX(),fenetreAffichage.getVitesY(),0.0);
			} else {
				System.out.println("Vous ne pouvez pas changer les Accélérations en cours d'execution !");
			}
			
			//DEBUG // 
			System.out.println("ACCELERATION Y DE LA PARTICULE : \n" + particule.toStringComplet() + " \n changée");
			//DEBUG - Pour savoir si la acceleration Y à été changée effectivement. //
		} else {
			System.out.println("Il n'y a pas de particule sélectionnée !");
		}
	}

}
