/**
 * @author Vincent F
 *
 */
public class Moteur {
	
	public static double coefGravite;
	public static Vecteur normeX = new Vecteur(1,0,0);
	public static Vecteur normeY = new Vecteur(0,1,0);
	public static Vecteur normeZ = new Vecteur(0,0,1);

	public Moteur(double coefGravite){
		Moteur.coefGravite = coefGravite;
	}
	
	/** Méthode qui calcul l'interaction entre deux particules. 
	 * @param objetUn
	 * @param objetDeux
	 */
	public void interactionParticule(Particule objetUn, Particule objetDeux){
		//Calcul de la force d'interaction entre les deux objets : F = (m1*m2*G)/d² 
		double valeurforce = ((objetUn.getMasse() + objetDeux.getMasse())*coefGravite)/(distance(objetUn,objetDeux).moduleCarre());
		
		//On fait force * vecteur directeur 
		Vecteur vecteurForce = distance(objetUn,objetDeux).normalise().multScalaire(valeurforce);
		
		// On sait que accélération = force/masseObjet car F = m.a
		Vecteur acceleration = vecteurForce.multScalaire((1/objetUn.getMasse()));
		
		//Mise à jour de l'accélération de l'objet : 
		objetUn.setAcceleration(objetUn.getAcceleration().addition(acceleration));
	}
	
	/** Vecteur distance : Coordonnées objet A - Coordonnées objet B
	 * @param objetUn
	 * @param objetDeux
	 * @return Le vecteur distance entre l'objetUn et l'objetDeux
	 */
	public Vecteur distance (Particule objetUn, Particule objetDeux){
		return objetUn.getCoordonnees().soustraction(objetDeux.getCoordonnees()); // Coordonnées Objets A - Coordonnées Objet 2    Soustrait les deux coordonnées des objets 2 et 1 
	}
	
	/**
	 * @param objetUn
	 * @param objetDeux
	 */
	public void collisionParticules(Particule objetUn, Particule objetDeux){
		//on récupère le vecteur unitaire axiale de direction AB
		Vecteur vecteurAxialeUnitaire = distance(objetUn,objetDeux).normalise();
		
		//on projette le vecteur vitesse cartésien de l'objet A sur le repère axiale, on récupère la norme du vecteur : normeVitesseDeDirectionAB = VitesseObjetUn ° (AB/DistanceAB)
		double normeVitesseAxiale = objetUn.getVitesse().prodScalaire(vecteurAxialeUnitaire);
		//On définit ensuite le vecteur vitesse axiale en multipliant la norme de la vitesse axiale par le vecteur unitaire de direction AB. VitesseAxialeDeA = normeVitesseDeDirectionAB * (AB/DistanceAB) 
		Vecteur vitesseAxiale = vecteurAxialeUnitaire.multScalaire(normeVitesseAxiale);
		//On récupère la vitesse tangentielle à la collision, pour la remettre dans la vitesse de l'objet ensuite : VitesseTangentielle = VecteurVitesseA - VitesseAxialeDeA
		Vecteur vitesseTangentielle = objetUn.getVitesse().soustraction(vitesseAxiale);
		
		//On récupère la vitesse axiale de l'objet en face (idem que A, on multiplie juste par -1 pour que la vitesse soit selon (-axe Axiale) 
		Vecteur vitesseAxialeDeux = vecteurAxialeUnitaire.multScalaire((-1)*objetDeux.getVitesse().prodScalaire(vecteurAxialeUnitaire));
		
		//on utilise la formule de collision élastique (Wikipédia) : ((vitesseAxiale*masseA)+(vitesseAxialeDeux*masseB) - (DifférenceDesVitessesAxiales*masseB))/(MasseA + MasseB)
		Vecteur nouvelleVitesseAxiale = ( (vitesseAxiale.multScalaire(objetUn.getMasse())) .addition( (vitesseAxialeDeux.multScalaire(objetDeux.getMasse()) )) .soustraction( ((vitesseAxialeDeux.soustraction(vitesseAxiale)) .multScalaire (objetDeux.getMasse()) )) ).multScalaire( 1/(objetUn.getMasse() + objetDeux.getMasse()) );
		
		//On repasse la nouvelleVitesseAxiale dans le repère cartésien. On fait CoordonnéeCartésienneX = vecteurAxiale°unitaireX + VecteurTangentielle°unitaireY, CoordonnéesCartésienneY = ... de même.
		Vecteur nouvelleVitesseCartésien = new Vecteur(normeX.prodScalaire(nouvelleVitesseAxiale)+ normeX.prodScalaire(vitesseTangentielle), normeY.prodScalaire(nouvelleVitesseAxiale)+ normeY.prodScalaire(vitesseTangentielle) , normeZ.prodScalaire(nouvelleVitesseAxiale)+ normeZ.prodScalaire(vitesseTangentielle) );
		objetUn.setVitesseFuture(nouvelleVitesseCartésien);
	}
	
	
	/** Vérifie si les deux objets sont en collision ou non.
	 * @param objetUn
	 * @param objetDeux
	 * @return
	 */
	public boolean sontEnCollision(Particule objetUn, Particule objetDeux){
		if( distance(objetUn,objetDeux).moduleCarre() < (Math.pow((objetUn.getRayon()+objetDeux.getRayon()), 2)) ){
			return true ;
		} else {
			return false;
		}
	}
	
	/** Met à jour les accelerations de toutes les particules
	 * @param objetUn
	 * @param objetDeux
	 */
	public void miseAJourParticules(ListeObjet listeDesObjets){
		
		for(int i = 0; i< listeDesObjets.getListeParticule().size() ; i++ ){ //possible crash si l'utilisateur change le nombre d'objets durant l'execution. Mettre la pause avant de virer des objets.
			for(int j = 0; j< listeDesObjets.getListeParticule().size() ; j++ ){ //Double boucle pour les interactions de toutes les particules avec toutes les particules.
				
				if(i!=j){ // on évite l'interaction de l'objet avec lui même.
					if(sontEnCollision(listeDesObjets.getListeParticule().get(i),listeDesObjets.getListeParticule().get(j))){
						collisionParticules(listeDesObjets.getListeParticule().get(i),listeDesObjets.getListeParticule().get(j));
					} else {
						interactionParticule(listeDesObjets.getListeParticule().get(i),listeDesObjets.getListeParticule().get(j));
					}
				} // fin du if de l'objet avec lui même
				
			}//Fin des for
		}
		
	}
	
}
