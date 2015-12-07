import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurAccelX implements ActionListener{
	
	private Affichage fen;
	Particule particule;
	
	public EcouteurAccelX(Affichage fen){
		this.fen=fen;
	}
	
	public void actionPerformed(ActionEvent ae){
		int accelX=fen.getAccelX();
		particule=fen.getJComboItem();
		particule.setAcceleration(accelX,particule.getAccelerationY(),0.0);
	} 

}
