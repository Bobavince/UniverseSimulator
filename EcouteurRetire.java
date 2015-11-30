import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class EcouteurRetire implements ActionListener{
	private FenetreRetrait fenR;

	public EcouteurRetire(FenetreRetrait fenR){
		this.fenR = fenR;
	}

	public void ActionListener(ActionEvent ae){
		LinkedList<JCheckBox> listeBoutons = fenR.getListeBoutons();
		for (int i=0; i<listeBoutons.size(); i++){
//			if (listeBoutons[i].getState()){ //ERREUR ICI
//				listeDesParticules.sortirParticule(i); // ??? //ERREUR ICI
//			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
