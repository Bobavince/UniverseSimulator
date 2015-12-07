import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EcouteurAccelY implements ChangeListener {
	
	private Affichage fen;
	Particule particule;
	
	public EcouteurAccelY(Affichage fen){
		this.fen=fen;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int accelY=fen.getAccelY();
		particule=fen.getJComboItem();
		particule.setAcceleration(particule.getAccelerationX(),accelY,0.0);
	}

}
