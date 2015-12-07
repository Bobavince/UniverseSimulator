import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EcouteurCoordY implements ChangeListener {

	private Affichage fen;
	Particule particule;

	public EcouteurCoordY(Affichage fen){
		this.fen=fen;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int coordY=fen.getY();
		particule=fen.getJComboItem();
		particule.setCoordonnees(particule.getCoordonneeX(),coordY,0.0);

	}

}

