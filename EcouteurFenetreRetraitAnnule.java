import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcouteurFenetreRetraitAnnule implements ActionListener{
	
	private FenetreRetrait fenetreRetrait;
	 
	public EcouteurFenetreRetraitAnnule(FenetreRetrait fenR) {
		this.fenetreRetrait = fenR;
	}

	public void actionPerformed(ActionEvent ae){
		fenetreRetrait.dispose();
	}

}
