/**
 * @author Vincent F
 *
 */
public class Moteur {
	
	public static double coefGravite;
	
	public Moteur(double coefGravite){
		this.coefGravite = coefGravite;
	}
	/**
	 * @param objetUn
	 * @param objetDeux
	 */
	public void interactionParticule(Particule objetUn, Particule objetDeux){
		//Calcul de la force d'interaction entre les deux objets : F = (m1*m2*G)/d� 
		double valeurforce = ((objetUn.getMasse() + objetDeux.getMasse())*coefGravite)/(distance(objetUn,objetDeux).moduleCarre());
		
		//On fait force * vecteur directeur 
		Vecteur vecteurForce = distance(objetUn,objetDeux).normalise().multScalaire(valeurforce);
		
		// On sait que acc�l�ration = force/masseObjet car F = m.a
		Vecteur acceleration = vecteurForce.multScalaire((1/objetUn.getMasse()));
		
		//Mise � jour de l'acc�l�ration de l'objet : 
		
	}
	
	/** Coordonn�es objet A - Coordonn�es objet B
	 * @param objetUn
	 * @param objetDeux
	 */
	public Vecteur distance (Particule objetUn, Particule objetDeux){
		
		return objetUn.getCoordonnes().soustraction(objetDeux.getCoordonnes()); // Coordonn�es Objets A - Coordonn�es Objet 2    Soustrait les deux coordonn�es des objets 2 et 1 
		
	}
	
	/**
	 * @param objetUn
	 * @param objetDeux
	 */
	public void collisionParitcules(Particule objetUn, Particule objetDeux){
		
	}
	

	/**
	 * @param objetUn
	 * @param objetDeux
	 */
	public void miseAJourParticules(ListeObjet listeDesObjets){
		
		for(int i = 0; i< listeDesObjets.getListeParticule().size() ; i++ ){ //possible crash si l'utilisateur change le nombre d'objets durant l'execution. Mettre la pause avant de virer des objets.
			
		}
	}
}
