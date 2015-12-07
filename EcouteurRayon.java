import java.awt.event.*;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EcouteurRayon implements ChangeListener {
	
	private Affichage fen;
	Particule particule;
	
	public EcouteurRayon(Affichage fen){
		this.fen=fen;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		int rayon=fen.getRayon();
		particule=fen.getJComboItem();
		particule.setRayon(rayon);
	}

}
