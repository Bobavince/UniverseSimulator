import javax.swing.*;

import java.awt.*;
import java.util.*;

public class PanelDessin extends JPanel {
	private Affichage fenetreParente;
	double coefficient = 1;
	
	public PanelDessin(Affichage fenetreParente){
		this.fenetreParente = fenetreParente;
		setBackground(Color.BLACK); //Le Fond en noir pour faire Spatial
	}

	@Override
	protected void paintComponent(Graphics g) {
		//Appel de la fonction n�cessaire pour commencer � dessiner la zone de dessin
		super.paintComponent(g); 
		
		//On demande à la liste des Objets de dessiner toutes les particules
		fenetreParente.getListeObjets().dessinerListe(g, coefficient, this.getWidth(), this.getHeight());
		
		//DEBUG // 
		System.out.println("DANS PANEL DESSIN : coefficient, getWidht, getHeight " + coefficient + " " + this.getWidth() + " " + this.getHeight());
		//DEBUG // 

	}
	

	public void setCoefficient(double coefficient){
		this.coefficient = coefficient;
	}
}
