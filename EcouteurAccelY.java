import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurAccelY implements ActionListener {
	
	private Affichage fen;
	Particule particule;
	
	public EcouteurAccelY(Affichage fen){
		this.fen=fen;
	}
	
	public void actionPerformed(ActionEvent ae){
		int accelY=fen.AccelY();
		particule=fen.getJComboItem();
		particule.setAcceleration(particule.getAccelerationX(),accelY,0.0);
	} 

}
