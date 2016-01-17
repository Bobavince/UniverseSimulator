import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/** Classe qui gère la zone de dessin dans la fenêtre principale.
 *
 */
public class PanelDessin extends JPanel {
	private Affichage fenetreAffichage;
	double[] coefficient = {1,0};
	double[] coefficientCourant={1,0};
	
	/** Constructeur de la zone de dessin.
	 * @param fenetreAffichage : Fenêtre principale, parente, conteant le JPanel de dessin.
	 */
	public PanelDessin(Affichage fenetreAffichage){
		this.fenetreAffichage = fenetreAffichage;
		setBackground(Color.BLACK); //Le Fond en noir pour faire Spatial
	}

	/* Méthode standard de dessin du JPanel
	 */
	@Override
	protected void paintComponent(Graphics g) {
		//Appel de la fonction n�cessaire pour commencer � dessiner la zone de dessin
		super.paintComponent(g); 

		//DEBUG // 
		if(Affichage.debug){System.out.println("DANS PANEL DESSIN : fenetre va être repeinte ! ");}
		//DEBUG // 

		//On récupère les l'encadrement des minima/maxima de tous les objets.
		double[] tableauMinimaMaxima = fenetreAffichage.getListeObjets().getEncadrementListe();

		//On r�cup�re la taille de la fenetre parente
		int fenHeight = this.getHeight();
		int fenWidth = this.getWidth();

		//On récupère le "coefficient de dilatation" pour le dessin
		double[] coefDilatation = getCoefficient(tableauMinimaMaxima,fenHeight,fenWidth);
		//DEBUG//
		if(Affichage.debug){System.out.println("DANS PANEL DESSIN  :  coefDilatation " + coefDilatation.toString()); }
		// DEBUG // 

		//On transfmet le coefficient a la zone de dessin qui les transmettra aux objets.
		this.setCoefficient(coefDilatation);

		//DEBUG//
		if(Affichage.debug){System.out.println("DANS PANEL DESSIN  :  minX, minY, MAXX, MAXY " + tableauMinimaMaxima[0] + " " + tableauMinimaMaxima[1] + " " + tableauMinimaMaxima[2] + " " + tableauMinimaMaxima[3]); }
		// DEBUG // 

		//On demande à la liste des Objets de dessiner toutes les particules
		fenetreAffichage.getListeObjets().dessinerListe(g, coefficient, this.getWidth(), this.getHeight());

		//DEBUG // 
		if(Affichage.debug){System.out.println("DANS PANEL DESSIN : coefficient, getWidht, getHeight " + coefficient + " " + this.getWidth() + " " + this.getHeight());}
		//DEBUG // 

		//On mets à jour tous les champs de l'interface.
		fenetreAffichage.mettreAJourChamps();

	}

	/** Méthode permettant de définir un coefficient de dilatation/rétractation/mise à l'échelle lors du dessin des particules.
	 * @param coefDilatation : Double sous la forme affine, a*X + b permettant de définir le coefficient et la constante de correction pour la mise à l'échelle de l'ensemble des particules lors de leur dessin.
	 */
	public void setCoefficient(double[] coefDilatation){
		this.coefficient = coefDilatation;
	}
	
	/** Méthode qui permet de récupérer le coefficient de mise à l'échelle pour la vue. On fait : (x-xMin)*Width/(xMax-xmin) : Produit en croix avec mise à l'échelle (en prenant un intervalle [0,Width] et [0, MAXX-minX] pour que ce soit plus facile.
	 * @param tableauMinimaMaxima : Tableau des Minima Maxima des coordonnées des particules sous la forme minx, minY, MAXX, MAXY
	 * @param fenHeight : hauteur de la zone de dessin
	 * @param fenWidth : largeur de la zone de dessin.
	 * @return le coefficient sous forme affine : x*a + b, on récupère le A dans la case 0 et le b dans la case 1. Par défaut il renvoi [1,0]
	 */
	public double[] getCoefficient(double[] tableauMinimaMaxima, int fenHeight, int fenWidth){
		double[] answer = {1,0};
		//On fait rentre les coordonn�es MAX/MIN dans la taille de la fenetre, par la multiplication par un coefficient (l'un des deux plus faibles, selon celui calcul� sur X et celui sur Y)

		if(fenetreAffichage.getBoutonAutoScale().isSelected()){
			double minX = tableauMinimaMaxima[0];
			double minY = tableauMinimaMaxima[1];
			double MAXX = tableauMinimaMaxima[2];
			double MAXY = tableauMinimaMaxima[3];

			// On calcul juste le coefficient devant le X ou le Y. Pour savoir qui a besoin de la plus grosse mise à l'échelle. (on ne parle pas de la translation ici)
			double coefX = fenWidth/(double)(MAXX-minX);
			double coefY = fenHeight/(double)(MAXY-minY);
			
			// On prend le plus petit des X ou des Y, sinon le coefX suffira. 
			if(coefX>coefY){
				answer[0] = coefY;
				answer[1] = -(minY*fenHeight)/(double)(MAXY-minY);
			} else if(coefX<coefY) {
				answer[0] = coefX;
				answer[1] = -(minX*fenWidth)/(double)(MAXX-minX);
			} else {
				answer[0] = coefX;
				answer[1] = -(minX*fenWidth)/(double)(MAXX-minX);
			}
			coefficientCourant = answer;
			//DEBUG//
			if(Affichage.debug){System.out.println("PANEL DESSIN :  coefficientCourant " + coefficientCourant.toString()); }
			// DEBUG // 
		} else {
			answer = coefficientCourant;
			//DEBUG//
			if(Affichage.debug){System.out.println("PANEL DESSIN :  coefficientCourant " + answer.toString()); }
			// DEBUG // 
		}

		return answer;
	}
}
