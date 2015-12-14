import java.util.LinkedList;
import javax.swing.*;
import java.awt.event.*;



public class EcouteurLancement implements ActionListener {
	
	FenetreAjout fen;
	//Affichage fenAffichage;
	
	public EcouteurLancement(FenetreAjout fen){
		this.fen=fen;
		
	}
	
	public void actionPerformed(ActionEvent ae) {//plus de tests de nullité? vitesse? acc? couleur?
		if(fen.getMasse()!=0&&fen.getRayon()!=0){
			Particule maParticule= new Particule(fen.getCoordX(), fen.getCoordY(),0, fen.getVitX(), fen.getVitY(),0,fen.getAccX(), fen.getAccY(),0,fen.getMasse(),fen.getTypeParticule(), fen.getRayon(),fen.getCouleurParticule());//getteurs des autres ecouteurs;
			fen.getFenAffichage().getListeObjets().ajouterParticule(maParticule);
			fen.getFenAffichage().setListeObjets(maParticule);
			fen.dispose();
		}
		
		else{
			System.out.println("La particule doit obligatoirement avoir une masse et un rayon.");
		}
		
	}
}
