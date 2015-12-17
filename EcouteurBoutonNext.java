import java.awt.event.*;
import javax.swing.*;

public class EcouteurBoutonNext implements ActionListener {
	private Affichage fenetreAffichage;
	
	public EcouteurBoutonNext(Affichage fenetreAffichage){
		this.fenetreAffichage = fenetreAffichage;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//On compute toutes les interactions en appellant le moteur et en lui envoyant la liste des objets (la classe qui g�re tout �a)
		fenetreAffichage.getMoteur().miseAJourParticules(fenetreAffichage.getListeObjets());
		
		//On fait passer toutes les particules � leur �tat futur gr�ce � ListeObjet
		fenetreAffichage.getListeObjets().mettreAJourEtat();
		
		//On récupère les l'encadrement des minima/maxima de tous les objets.
		double[] tableauMinimaMaxima = fenetreAffichage.getListeObjets().getEncadrementListe();

		//On r�cup�re la taille de la fenetre parente
		int fenHeight = fenetreAffichage.getZoneDessin().getHeight();
		int fenWidth = fenetreAffichage.getZoneDessin().getWidth();
		
		//On récupère le "coefficient de dilatation" pour le dessin
		double coefDilatation = getCoefficient(tableauMinimaMaxima,fenHeight,fenWidth);
		//DEBUG//
		if(Affichage.debug){System.out.println("Ecouteur NEXT :  coefDilatation " + coefDilatation); }
		// DEBUG // 
				
		//On transfmet le coefficient a la zone de dessin qui les transmettra aux objets.
		fenetreAffichage.getZoneDessin().setCoefficient(coefDilatation);
		
		//DEBUG//
		if(Affichage.debug){System.out.println("Ecouteur NEXT :  minX, minY, MAXX, MAXY" + tableauMinimaMaxima[0] + " " + tableauMinimaMaxima[1] + " " + tableauMinimaMaxima[2] + " " + tableauMinimaMaxima[3]); }
		// DEBUG // 
		
		//On repaint la fenetre puisque la position des objets a chang�.
		fenetreAffichage.getZoneDessin().repaint();
	}
	
	public double getCoefficient(double[] tableauMinimaMaxima, int fenHeight, int fenWidth){
		double answer=1;
		//On fait rentre les coordonn�es MAX/MIN dans la taille de la fenetre, par la multiplication par un coefficient (l'un des deux plus faibles, selon celui calcul� sur X et celui sur Y)
		
		//tableauMinimaMaxima[0]=minX;
		//tableauMinimaMaxima[1]=minY;
		//tableauMinimaMaxima[2]=MAXX;
		//tableauMinimaMaxima[3]=MAXY;
		
		// TOOOOOOOOOOOOOOOOOOOOOOOOOO DOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
		return answer;
	}

}