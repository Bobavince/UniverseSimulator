import java.awt.event.*;

public class EcouteurRayon implements ActionListener {
	
	private Affichage fen;
	Particule particule;
	
	public EcouteurRayon(Affichage fen){
		this.fen=fen;
	}
	
	public void actionPerformed(ActionEvent ae) {
		int rayon=fen.getRayon();
		particule=fen.getJComboItem();
		particule.setRayon(rayon);
	}

}
