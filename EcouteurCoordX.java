import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EcouteurCoordX implements ChangeListener {
	
	private Affichage fenetreAffichage;
	
	public EcouteurCoordX(Affichage fenetreAffichage){
		this.fenetreAffichage=fenetreAffichage;
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		if(fenetreAffichage.getJComboBox().getSelectedItem() instanceof Particule){
			
			// On récupère la particule courante sélectionnée
			Particule particule = (Particule)(fenetreAffichage.getJComboBox().getSelectedItem());
			// On lui attribue de nouvelles coordonnées : sa coordonnée X depuis la fenetre principale et sa coordonnées y inchangée
			particule.setCoordonnees(fenetreAffichage.getCoordX(),particule.getCoordonneeY(),0.0);
			
			//DEBUG // 
			System.out.println("COORDONNES X DE LA PARTICULE : \n" + particule.toStringComplet() + " \n changée");
			//DEBUG - Pour savoir si la coordonnées à été changée effectivement. //
		} else {
			System.out.println("Il n'y a pas de particule sélectionnée !");
		}
	}

}
