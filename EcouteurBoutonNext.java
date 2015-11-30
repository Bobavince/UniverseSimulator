import java.awt.event.*;
import javax.swing.*;

public class EcouteurBoutonNext implements ActionListener {
	private Affichage fenetreParente;
	
	public EcouteurBoutonNext(Affichage fenetreParente){
		this.fenetreParente = fenetreParente;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//On compute toutes les interactions en appellant le moteur et en lui envoyant la liste des objets (la classe qui g�re tout �a)
		fenetreParente.getMoteur().miseAJourParticules(fenetreParente.getListeObjets());
		
		//On fait passer toutes les particules � leur �tat futur gr�ce � ListeObjet
		fenetreParente.getListeObjets().mettreAJourEtat();
		
		//On r�cup�re les coordonn�es MAX/MIN selon x et y (Donc 4 variables) de l'ensemble des particules.
		int maxX = 0 , maxY = 0, minX = 0, minY = 0;
		
		for(int i=0 ; i < fenetreParente.getListeObjets().getListeParticule().size(); i++ ){
			if(i==0){
				maxX = (int) fenetreParente.getListeObjets().getListeParticule().get(i).getCoordonnees().getTabVecteur()[0];
				maxY = (int) fenetreParente.getListeObjets().getListeParticule().get(i).getCoordonnees().getTabVecteur()[1];
				minX = maxX;
				minY = maxY;
			}
			
			int xCourant = (int) fenetreParente.getListeObjets().getListeParticule().get(i).getCoordonnees().getTabVecteur()[0];
			int yCourant = (int) fenetreParente.getListeObjets().getListeParticule().get(i).getCoordonnees().getTabVecteur()[1];
			
			if(maxX<xCourant){
				maxX=xCourant;
			} else if(maxY<yCourant){
				maxY=yCourant;
			}
			
			if(minX>xCourant){
				minX=xCourant;
			} else if(minY>yCourant){
				minY=yCourant;
			}
		}
		/*
		//On r�cup�re la taille de la fenetre parente
		int fenHeight = fenetreParente.getZoneDessin().getHeight();
		int fenWidth = fenetreParente.getZoneDessin().getWidth();
		*/
		//On fait rentre les coordonn�es MAX/MIN dans la taille de la fenetre, par la multiplication par un coefficient (l'un des deux plus faibles, selon celui calcul� sur X et celui sur Y)
		
		
		//On transfmet le coefficient a la zone de dessin qui les transmettra aux objets.
		fenetreParente.getZoneDessin().transmissionCoordonnesDessin(maxX, maxY, minX, minY);
		//On repaint la fen�tre puisque la position des objets a chang�.
		fenetreParente.getZoneDessin().repaint();
	}

}