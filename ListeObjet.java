import java.awt.Graphics;
import java.util.LinkedList;

public class ListeObjet {

	//LA LISTE DES PARTICULES
	private LinkedList<Particule> listeParticule;

	/**
	 *  Constructeur de ListeObjet
	 */
	public ListeObjet() {
		listeParticule= new LinkedList<Particule>();
	}

	/** Méthode pour ajouter une particule
	 * @param p : la particule à ajouter à la liste
	 */
	public void ajouterParticule(Particule p){
		if(!listeParticule.add(p)){
			System.out.println("La particule n'a pas pu etre ajoutée.");
		} else {
			System.out.println("Particule ajoutée : " + p.toStringComplet());
		}

		// DEBUG //
		if(Affichage.debug){System.out.println(this.toString());}
		// DEBUG - AFFICHAGE LISTE MODIFIE //
	}

	/** Sort une particule proprement
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

	public void dessinerListe(Graphics g, double coefficient, int dessinX, int dessinY){
		//DEBUG // 
		if(Affichage.debug){System.out.println("Arrivé dans la métode dessin de Liste");}
		if(Affichage.debug){System.out.println("Longeur Liste : " + listeParticule.size());}
		//DEBUG//
		for (int i=0; i< this.listeParticule.size(); i++){
			this.listeParticule.get(i).dessiner(g, coefficient, dessinX, dessinY);
			//DEBUG //
			if(Affichage.debug){System.out.println("La particule N°" + i + " a été dessiné : " + listeParticule.get(i).toString());}
			//DEBUG//
		}
	}

	/** Méthode qui renvois le xmin, ymin, XMAX, YMAX de toutes les particules ensembles sous forme d'un tableau de 4 double.
	 * @return le tableau de 4 doubles
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

				if(MAXX<xCourantGauche){
					MAXX=xCourantGauche;
				}
				if(MAXY<yCourantHaut){
					MAXY=yCourantHaut;
				}
				if(minX>xCourantGauche){
					minX=xCourantGauche;
				}
				if(minY>yCourantHaut){
					minY=yCourantHaut;
				}
				if(MAXX<xCourantDroite){
					MAXX=xCourantDroite;
				}
				if(MAXY<yCourantBas){
					MAXY=yCourantBas;
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
		} else {
			// On range dans le tableau
			tableauMinimaMaxima[0]=0;
			tableauMinimaMaxima[1]=0;
			tableauMinimaMaxima[2]=1000;
			tableauMinimaMaxima[3]=1000;
		}

		return tableauMinimaMaxima;
	}

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
	public LinkedList<Particule> getListeParticule() {
		return listeParticule;
	}

	/**
	 *  Méthode pour passer à l'état futur toutes les particules après les calculs.
	 */
	public void  mettreAJourEtat(){
		for(int i=0; i<listeParticule.size(); i++){
			listeParticule.get(i).passerEtatFutur();
		}		
	}

}
