import java.awt.event.*;

public class EcouteurMasse implements ActionListener {
	
	private Affichage fen;
	Particule particule;

	public EcouteurMasse(Affichage fen){
		this.fen=fen;
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		int masse=fen.getMasse();
		
		particule=fen.getJComboItem();
		
		particule.setMasse(masse);
		
		
	}
	
}
