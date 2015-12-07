import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurCoordY implements ActionListener {
	
	private Affichage fen;
	Particule particule;
	
	public EcouteurCoordY(Affichage fen){
		this.fen=fen;
	}
	
	public void actionPerformed(ActionEvent ae){
		int coordY=fen.getY();
		particule=fen.getJComboItem();
		particule.setCoordonnees(particule.getCoordonneeX(),coordY,0.0);
	}

}

