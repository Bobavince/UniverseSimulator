import java.awt.event.*;
public class EcouteurParticulesPredefinies implements ActionListener{
	private FenetreAjout fen;
	
	public EcouteurParticulesPredefinies(FenetreAjout fen) {
		this.fen=fen;
	}
	
	public void actionPerformed(ActionEvent ae) {
		Particule p= fen.getSelectedParticule();
		fen.setMasse(""+p.getMasse());
		fen.setRayon(""+p.getRayon());
		fen.setType(""+p.getType());
		
	}
}
