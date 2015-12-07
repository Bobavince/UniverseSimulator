import java.awt.event.*;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EcouteurMasse implements ChangeListener {

	private Affichage fen;
	Particule particule;

	public EcouteurMasse(Affichage fen){
		this.fen=fen;

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int masse=fen.getMasse();

		particule=fen.getJComboItem();

		particule.setMasse(masse);


	}

}
