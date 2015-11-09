import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Affichage extends JFrame {
	public Affichage() {
		setSize(800,800); //Dimension initiales
		setMinimumSize(new Dimension(600, 600)); // dimensions minimales
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //
		this.setLocationRelativeTo(null); //Centre la fenêtre à l'écran
		this.setTitle("Universe Simulator"); //Entête de la fenêtre
		setVisible(true); //Afficher la fenêtre
	}


}
