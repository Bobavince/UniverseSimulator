import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EcouteurVitesX implements ChangeListener {
	
	private Affichage fen;
	Particule particule;
	
	public EcouteurVitesX(Affichage fen){
		this.fen=fen;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		int vitesX=fen.getVitesX();
		particule=fen.getJComboItem();
		particule.setVitesse(vitesX,particule.getVitesseY(),0.0);
	}


}


