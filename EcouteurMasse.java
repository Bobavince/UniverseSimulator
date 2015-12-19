import java.awt.event.*;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EcouteurMasse implements ChangeListener {

	private Affichage fenetreAffichage;
	
	public EcouteurMasse(Affichage fenetreAffichage){
		this.fenetreAffichage=fenetreAffichage;
	}

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
