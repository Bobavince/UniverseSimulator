import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EcouteurAccelX implements ChangeListener{
	
	private Affichage fen;
	Particule particule;
	
	public EcouteurAccelX(Affichage fen){
		this.fen=fen;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		int accelX=fen.getAccelX();
		particule=fen.getJComboItem();
		particule.setAcceleration(accelX,particule.getAccelerationY(),0.0);
		
	} 

}
