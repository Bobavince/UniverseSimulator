import java.awt.Color;
import java.awt.event.*;

import javax.swing.JColorChooser;

/**
 * 
 */

/**
 * @author Vincent F
 *
 */
public class EcouteurCouleur implements ActionListener {

	public EcouteurCouleur(Affichage maFen){
		
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Color maCouleur = JColorChooser.showDialog(null,"Choix de couleur", null);
		//GetParticuleCourante.setCouleur(maCouleur);
	}

}

