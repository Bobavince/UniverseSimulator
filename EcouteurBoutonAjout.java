import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

/**
 * 
 */

/**
 * @author Vincent F
 *
 */
public class EcouteurBoutonAjout implements ActionListener {

	Affichage fen;
	public void EcouteurBoutonAjout(Affichage fen){
		this.fen = fen;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//FenetreAjout(this.fen);

	}

}