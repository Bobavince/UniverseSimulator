import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Affichage extends JFrame {
	public Affichage() {
		setSize(800,800); //Dimension initiales
		setMinimumSize(new Dimension(600, 600)); // dimensions minimales
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //
		this.setLocationRelativeTo(null); //Centre la fen�tre � l'�cran
		this.setTitle("Universe Simulator"); //Ent�te de la fen�tre
		setVisible(true); //Afficher la fen�tre
	}


}
