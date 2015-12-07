import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EcouteurCoordX implements ChangeListener {
	
	private Affichage fen;
	Particule particule;
	
	public EcouteurCoordX(Affichage fen){
		this.fen=fen;
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		int coordX=fen.getX();
		particule=fen.getJComboItem();
		particule.setCoordonnees(coordX,particule.getCoordonneeY(),0.0);
	}

}
