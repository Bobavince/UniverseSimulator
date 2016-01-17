import java.awt.Graphics;
import java.util.LinkedList;

/** Classe qui gère la Liste des Objets géré par le programme : c'est cette classe qui comporte la liste de tous les objets, qui gère leur affichage et leurs modifications groupées.
 */
public class ListeObjet {

	/** LA LISTE DES PARTICULES
	 */
	private LinkedList<Particule> listeParticule;

	/** Constructeur de ListeObjet
	 */
	public ListeObjet() {
		listeParticule= new LinkedList<Particule>();
	}

	/** Méthode qui permet d'ajouter une particule à la liste, proprement.
	 * @param p : la particule à ajouter à la liste
	 */
	public void ajouterParticule(Particule p){
		if(!listeParticule.add(p)){
			System.out.println("La particule n'a pas pu etre ajoutée.");
		} else {
			System.out.println("Particule ajoutée : " + p.toStringComplet());
		}

		// DEBUG //
		if(Affichage.debug){System.out.println("LISTE OBJET : Ajout particule dans la liste : " + this.toString());}
		// DEBUG - AFFICHAGE LISTE MODIFIE //
	}

	/** Méthode qui permet de sortir une particule proprement
	 * @param p : la particule à retirer
	 */
	public void sortirParticule(Particule p){
		if(!listeParticule.remove(p)){
			System.out.println("La particule n'a pas pu etre retirée.");
		} else {
			System.out.println("Particule retirée : " + p.toStringComplet());
		}

		// DEBUG //
		if(Affichage.debug){System.out.println(this.toString());}
		// DEBUG - AFFICHAGE LISTE MODIFIE //
	}

	/** Méthode qui permet de dessiner la liste de toutes les particules gérées par la liste dans le Graphics passé en paramètre.
	 * @param g : le Graphics où les particules seront dessinées
	 * @param coefficient : le coefficient de mise à l'échelle calculé ailleurs, qui permet de faire tenir toutes les particules dans une unique vue.
	 * @param dessinX : la taille horizontale de la zone de dessin.
	 * @param dessinY : la taille vertical de la zone de dessin.
	 */
	public void dessinerListe(Graphics g, double[] coefficient, int dessinX, int dessinY){
		//DEBUG // 
		if(Affichage.debug){System.out.println("LISTEOBJET : longeur Liste qui va être dessiné : " + listeParticule.size());}
		//DEBUG//
		for (int i=0; i< this.listeParticule.size(); i++){
			this.listeParticule.get(i).dessiner(g, coefficient, dessinX, dessinY);
			//DEBUG //
			if(Affichage.debug){System.out.println("LISTEOBJET : La particule N°" + i + " a été dessiné : " + listeParticule.get(i).toString());}
			//DEBUG//
		}
	}

	/** Méthode qui renvois le xmin, ymin, XMAX, YMAX de toutes les particules ensembles sous forme d'un tableau de 4 double.
	 * @return le tableau de 4 doubles dans l'ordre : minX minY MAXX MAXY
	 */
	public double[] getEncadrementListe(){

		double[] tableauMinimaMaxima = new double[4];

		if(listeParticule.size()>=2){
			int minX, minY, MAXX, MAXY;
			//Le X de la première particule va dans le MAX X
			MAXX = (int) listeParticule.get(0).getCoordonnees().getTabVecteur()[0];
			//Le Y de la première particule va dans le MAX Y
			MAXY = (int) listeParticule.get(0).getCoordonnees().getTabVecteur()[1];
			//Le X de la première particule va dans le min x
			minX = MAXX;
			//Le Y de la première particule va dans le min y
			minY = MAXY;

			for(int i=0 ; i < listeParticule.size(); i++ ){
				int xCourantGauche = (int) (listeParticule.get(i).getCoordonnees().getTabVecteur()[0]-listeParticule.get(i).getRayon());
				int yCourantHaut = (int) (listeParticule.get(i).getCoordonnees().getTabVecteur()[1]-listeParticule.get(i).getRayon());
				int xCourantDroite = (int) (listeParticule.get(i).getCoordonnees().getTabVecteur()[0]+listeParticule.get(i).getRayon());
				int yCourantBas = (int) (listeParticule.get(i).getCoordonnees().getTabVecteur()[1]+listeParticule.get(i).getRayon());

				// Modification des Maximums
				if(MAXX<xCourantGauche){
					MAXX=xCourantGauche;
				}
				if(MAXY<yCourantHaut){
					MAXY=yCourantHaut;
				}
				if(MAXX<xCourantDroite){
					MAXX=xCourantDroite;
				}
				if(MAXY<yCourantBas){
					MAXY=yCourantBas;
				}
				
				// Modification des minimums
				if(minX>xCourantGauche){
					minX=xCourantGauche;
				}
				if(minY>yCourantHaut){
					minY=yCourantHaut;
				}
				if(minX>xCourantDroite){
					minX=xCourantDroite;
				}
				if(minY>yCourantBas){
					minY=yCourantBas;
				}
			}

			// On range dans le tableau
			tableauMinimaMaxima[0]=minX;
			tableauMinimaMaxima[1]=minY;
			tableauMinimaMaxima[2]=MAXX;
			tableauMinimaMaxima[3]=MAXY;
			//DEBUG //
			if(Affichage.debug){System.out.println("LISTEOBJET Maxima/minima calculés : min X " + minX + " minY : " + minY + " MAXX " + MAXX + " MAXY " + MAXY);}
			//DEBUG//
		} else {
			// On range dans le tableau
			tableauMinimaMaxima[0]=0;
			tableauMinimaMaxima[1]=0;
			tableauMinimaMaxima[2]=1000;
			tableauMinimaMaxima[3]=1000;
			//DEBUG //
			if(Affichage.debug){System.out.println("LISTEOBJET Maxima/minima calculés : par défauts ");}
			//DEBUG//
		}

		return tableauMinimaMaxima;
	}

	/* Méthode standard d'écriture de chaque particule composant la liste, géré par la classe à un instant T.
	 */
	public String toString(){
		String res="";

		if(listeParticule.size()==0){
			res = "Vous n'avez pas ajouté de particules.";
		} else {
			for(int i=0; i<listeParticule.size(); i++){
				res+="\n Particule N°" + i +listeParticule.get(i).toStringComplet();
			}
		}

		return res;
	}

	// ---- GETTEUR -----
	/** Getteur de la liste des particules (LinkedList) géré par la classe.
	 * @return : la LinkedList des Particules gérées.
	 */
	public LinkedList<Particule> getListeParticule() {
		return listeParticule;
	}

	/** Méthode pour passer à l'état futur toutes les particules après les calculs.
	 */
	public void  mettreAJourEtat(){
		for(int i=0; i<listeParticule.size(); i++){
			listeParticule.get(i).passerEtatFutur();
		}		
	}

}
