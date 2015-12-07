import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class EcouteurVitesY implements ChangeListener {
	private Affichage fen;
	Particule particule;

	public EcouteurVitesY(Affichage fen){
		this.fen=fen;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int vitesY=fen.getVitesY();
		particule=fen.getJComboItem();
		particule.setVitesse(particule.getVitesseX(),vitesY,0.0);
	}
}
