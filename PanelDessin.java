import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PanelDessin extends JPanel {
	private Affichage fenetreParente;
	int maxX=0, maxY=0, minX=0, minY=0;
	
	public PanelDessin(Affichage fenetreParente){
		this.fenetreParente = fenetreParente;
		setBackground(Color.BLACK); //Le Fond en noir pour faire Spatial
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent( g ); //Appel de la fonction nécessaire pour commencer à dessiner la zone de dessin
		
		for(int i=0 ; i<fenetreParente.getListeObjets().getListeParticule().size() ; i++){
			fenetreParente.getListeObjets().dessinerListe(g, maxX, maxY, minX, minY, this.getWidth(), this.getHeight());
		}

	}
	

	public void transmissionCoordonnesDessin(int maxX, int maxY, int minX, int minY){
		this.maxX=maxX; 
		this.maxY=maxY; 
		this.minX=minX;
		this.minY=minY;
	}
}
