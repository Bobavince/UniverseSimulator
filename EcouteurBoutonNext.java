import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**Classe Ecouteur le bouton Next de la fenêtre Affichage
 */
public class EcouteurBoutonNext implements ActionListener {
	private Affichage fenetreAffichage;
	double[] coefficientCourant={1,0};

	/** Constructeur de l'écouteur le bouton Next
	 * @param fenetreAffichage : la fenêtre Affichage parente qui contient le bouton Next
	 */
	public EcouteurBoutonNext(Affichage fenetreAffichage){
		this.fenetreAffichage = fenetreAffichage;
	}

	/* Méthode de standard de traitement d'actions.
	 */
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
		double[] coefDilatation = getCoefficient(tableauMinimaMaxima,fenHeight,fenWidth);
		//DEBUG//
		if(Affichage.debug){System.out.println("Ecouteur NEXT :  coefDilatation " + coefDilatation.toString()); }
		// DEBUG // 

		//On transfmet le coefficient a la zone de dessin qui les transmettra aux objets.
		fenetreAffichage.getZoneDessin().setCoefficient(coefDilatation);

		//DEBUG//
		if(Affichage.debug){System.out.println("Ecouteur NEXT :  minX, minY, MAXX, MAXY " + tableauMinimaMaxima[0] + " " + tableauMinimaMaxima[1] + " " + tableauMinimaMaxima[2] + " " + tableauMinimaMaxima[3]); }
		// DEBUG // 

		//On repaint la fenetre puisque la position des objets a chang�.
		fenetreAffichage.getZoneDessin().repaint();
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
		} else {
			answer = coefficientCourant;
		}

		return answer;
	}

}