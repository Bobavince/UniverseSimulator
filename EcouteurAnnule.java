import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcouteurAnnule implements ActionListener{
	
	private FenetreRetrait fenR;
	 
	public EcouteurAnnule(FenetreRetrait fenR) {
		this.fenR = fenR;
	}

	public void actionPerformed(ActionEvent ae){
		fenR.dispose();
	}

}
