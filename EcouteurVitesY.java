import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class EcouteurVitesY implements ActionListener {
	private Affichage fen;
	Particule particule;
	
	public EcouteurVitesY(Affichage fen){
		this.fen=fen;
	}
	
	public void actionPerformed(ActionEvent ae){
		int vitesY=fen.getVitesY();
		particule=fen.getJComboItem();
		particule.setVitesse(particule.getVitesseX(),vitesY,0.0);
	}

}
