import java.util.LinkedList;
import javax.swing.*;
import java.awt.event.*;



public class EcouteurFenetreAjoutAjouter implements ActionListener {
	
	FenetreAjout fen;
	
	public EcouteurFenetreAjoutAjouter(FenetreAjout fenetreAjout){
		this.fen=fenetreAjout;
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(fen.getMasse()!=0 && fen.getRayon()!=0){
			
			// On créé la particule avec les données de la fenêtre et on l'ajoute à la fenetre principale qui se charge du reste
			Particule maParticule= new Particule(fen.getCoordX(), fen.getCoordY(),0, fen.getVitX(), fen.getVitY(),0,fen.getAccX(), fen.getAccY(),0,fen.getMasse(),fen.getTypeParticule(), fen.getRayon(),fen.getCouleurParticule());
			fen.getFenAffichage().ajouterParticule(maParticule);
			
			//On cache la fenetre d'ajout de particule
			fen.dispose();
			
			//DEBUG //
			System.out.println(" ECOUTEUR LANCEMENT (Ajout d'une particule) coordX " + fen.getCoordX() + " coordY " +  fen.getCoordY() + "coordZ " + 0 + " vitesX " +  fen.getVitX() + " vitesY " +  fen.getVitY() + "vitesZ " + 0 + " accelX " + fen.getAccX() + " accelY " +  fen.getAccY() + " accelZ " + 0 + " masse " + fen.getMasse() + " type " +  fen.getTypeParticule() + "rayon " +  fen.getRayon() + " couleur " + fen.getCouleurParticule());
			//DEBUG - Connaitre les particules effectivement ajouté// 
		} else {
			System.out.println("La particule doit obligatoirement avoir une masse et un rayon.");
			
			//DEBUG // 
			System.out.println(fen.getMasse() +" "+ fen.getRayon());
			//DEBUG//
		}
		
	}
}
