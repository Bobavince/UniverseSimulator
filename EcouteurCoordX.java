import java.awt.event.*;

public class EcouteurCoordX implements ActionListener {
	
	private Affichage fen;
	Particule particule;
	
	public EcouteurCoordX(Affichage fen){
		this.fen=fen;
	}
	
	public void actionPerformed(ActionEvent ae){
		int coordX=fen.getX();
		particule=fen.getJComboItem();
		particule.setCoordonnees(coordX,fen.getY(),fen.getZ());
	}

}
