import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PanelDessin extends JPanel {
	private Affichage fenetreParente;

	public PanelDessin(Affichage fenetreParente){
		this.fenetreParente = fenetreParente;
		setBackground(Color.BLACK); //Le Fond en noir pour faire Spatial
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent( g ); //Appel de la fonction nécessaire pour commencer à dessiner la zone de dessin
		
		for(int i=0 ; i<fenetreParente.getListeObjets().getListeParticule().size() ; i++){
			fenetreParente.getListeObjets().dessinerListe(g);
		}

	}
	
}
