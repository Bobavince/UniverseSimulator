import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcouteurAnnule implements ActionListener{
	private FenetreRetrait fenR;

	/**
	 * @param fenetreRetrait
	 */
	public EcouteurAnnule(FenetreRetrait fenetreRetrait) {
		this.fenR = fenR;
	}

	public void ActionListener(ActionEvent ae){
		fenR.dispose();
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
