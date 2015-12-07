import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurVitesX implements ActionListener {
	
	private Affichage fen;
	Particule particule;
	
	public EcouteurVitesX(Affichage fen){
		this.fen=fen;
	}
	
	public void actionPerformed(ActionEvent ae){
		int vitesX=fen.getVitesX();
		particule=fen.getJComboItem();
		particule.setVitesse(vitesX,particule.getVitesseY(),0.0);
	}

}


