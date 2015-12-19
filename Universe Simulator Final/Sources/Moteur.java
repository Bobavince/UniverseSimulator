/** Classe qui gère les interactions, collisions, etc .. les forces entre les particules, leurs vitesse, leur accélérations, et fonction des autres particules.
 */
public class Moteur {

	public static double coefGravite;
	public static Vecteur normeX = new Vecteur(-1,0,0);
	public static Vecteur normeY = new Vecteur(0,-1,0);
	public static Vecteur normeZ = new Vecteur(0,0,-1);

	/** Constructeur de la classe avec en argument le paramètre qui sera utilisé pour les calculs. 
	 * @param coefGravite : Le coefficient de gravitation utilisé. Note : Il faut que ce coefficient soit négatif pour avoir une attraction, positif pour des répulsions.
	 */
	public Moteur(double coefGravite){
		Moteur.coefGravite = coefGravite;
	}

	/** M�thode qui calcul l'interaction entre deux particules. 
	 * @param objetUn : Particule numéro 1 qui est incluse dans l'interaction
	 * @param objetDeux : Particule numéro 2 qui est incluse dans l'interaction
	 */
	public void interactionParticule(Particule objetUn, Particule objetDeux){
		//Calcul de la force d'interaction entre les deux objets : F = (m1*m2*G)/d� 
		double valeurforce = ((objetUn.getMasse() + objetDeux.getMasse())*coefGravite)/(distance(objetUn,objetDeux).moduleCarre());
		//DEBUG//
		if(Affichage.debug){System.out.println("MOTEUR : INTERACTION valeur force entre " + objetUn.toString() + " et " + objetDeux.toString() + " = " + valeurforce);}
		//DEBUG// 
		//On fait force * vecteur directeur 
		Vecteur vecteurForce = distance(objetUn,objetDeux).normalise().multScalaire(valeurforce);
		//DEBUG//
		if(Affichage.debug){System.out.println("MOTEUR : SI vecteurForceNormalisé " + vecteurForce);}
		//DEBUG// 
		// On sait que acc�l�ration = force/masseObjet car F = m.a
		Vecteur acceleration = vecteurForce.multScalaire((1/objetUn.getMasse()));
		//DEBUG//
		if(Affichage.debug){System.out.println("MOTEUR : SI acceleration " + acceleration );}
		//DEBUG// 
		//DEBUG//
		if(Affichage.debug){System.out.println("MOTEUR : SI acceleration de " + objetUn.toString() + " avant modif " + objetUn.getAcceleration().toString() );}
		//DEBUG//
		//Mise � jour de l'acc�l�ration de l'objet : 
		objetUn.setAcceleration(objetUn.getAcceleration().addition(acceleration));
		//DEBUG//
		if(Affichage.debug){System.out.println("MOTEUR : FIN INTERACTION acceleration de " + objetUn.toString() + " après modif " + objetUn.getAcceleration().toString() );}
		//DEBUG// 
	}

	/** Méthode qui gère la collision entre deux particules.
	 * @param objetUn : Particule numéro 1 qui est incluse dans la collision
	 * @param objetDeux : Particule numéro 2 qui est incluse dans la collision
	 */
	public void collisionParticules(Particule objetUn, Particule objetDeux){
		//on r�cup�re le vecteur unitaire axiale de direction AB
		Vecteur vecteurAxialeUnitaire = distance(objetUn,objetDeux).normalise();
		//DEBUG//
		if(Affichage.debug){System.out.println("MOTEUR : COLLISION de " + objetUn.toString() + " avec " + objetDeux.toString() + " vecteur axial unitaire " + vecteurAxialeUnitaire.toString());}
		//DEBUG// 

		//on projette le vecteur vitesse cart�sien de l'objet A sur le rep�re axiale, on r�cup�re la norme du vecteur : normeVitesseDeDirectionAB = VitesseObjetUn � (AB/DistanceAB)
		double normeVitesseAxiale = objetUn.getVitesse().prodScalaire(vecteurAxialeUnitaire);
		//DEBUG//
		if(Affichage.debug){System.out.println("MOTEUR : SC normeVitesseAxiale " + normeVitesseAxiale );}
		//DEBUG// 

		//On d�finit ensuite le vecteur vitesse axiale en multipliant la norme de la vitesse axiale par le vecteur unitaire de direction AB. VitesseAxialeDeA = normeVitesseDeDirectionAB * (AB/DistanceAB) 
		Vecteur vitesseAxiale = vecteurAxialeUnitaire.multScalaire(normeVitesseAxiale);
		//DEBUG//
		if(Affichage.debug){System.out.println("MOTEUR : SC vitesseAxiale " + vitesseAxiale.toString() );}
		//DEBUG// 

		//On r�cup�re la vitesse tangentielle � la collision, pour la remettre dans la vitesse de l'objet ensuite : VitesseTangentielle = VecteurVitesseA - VitesseAxialeDeA
		Vecteur vitesseTangentielle = objetUn.getVitesse().soustraction(vitesseAxiale);
		//DEBUG//
		if(Affichage.debug){System.out.println("MOTEUR : SC vitesseTangentielle " + vitesseTangentielle.toString() );}
		//DEBUG// 

		//On r�cup�re la vitesse axiale de l'objet en face (idem que A, on multiplie juste par -1 pour que la vitesse soit selon (-axe Axiale) 
		Vecteur vitesseAxialeDeux = vecteurAxialeUnitaire.multScalaire((-1)*objetDeux.getVitesse().prodScalaire(vecteurAxialeUnitaire));
		//DEBUG//
		if(Affichage.debug){System.out.println("MOTEUR : SC vitesseAxialeDeux " + vitesseAxialeDeux.toString() );}
		//DEBUG// 

		//on utilise la formule de collision �lastique (Wikip�dia) : ((vitesseAxiale*masseA)+(vitesseAxialeDeux*masseB) - (Diff�renceDesVitessesAxiales*masseB))/(MasseA + MasseB)
		Vecteur nouvelleVitesseAxiale = ( (vitesseAxiale.multScalaire(objetUn.getMasse())) .addition( (vitesseAxialeDeux.multScalaire(objetDeux.getMasse()) )) .soustraction( ((vitesseAxialeDeux.soustraction(vitesseAxiale)) .multScalaire (objetDeux.getMasse()) )) ).multScalaire( 1/(objetUn.getMasse() + objetDeux.getMasse()) );
		//DEBUG//
		if(Affichage.debug){System.out.println("MOTEUR : SC nouvelleVitesseAxiale " + nouvelleVitesseAxiale.toString() );}
		//DEBUG// 

		//On repasse la nouvelleVitesseAxiale dans le rep�re cart�sien. On fait Coordonn�eCart�sienneX = vecteurAxiale�unitaireX + VecteurTangentielle�unitaireY, Coordonn�esCart�sienneY = ... de m�me.
		Vecteur nouvelleVitesseCartesien = new Vecteur(normeX.prodScalaire(nouvelleVitesseAxiale)+ normeX.prodScalaire(vitesseTangentielle), normeY.prodScalaire(nouvelleVitesseAxiale)+ normeY.prodScalaire(vitesseTangentielle) , normeZ.prodScalaire(nouvelleVitesseAxiale)+ normeZ.prodScalaire(vitesseTangentielle) );
		//DEBUG//
		if(Affichage.debug){System.out.println("MOTEUR : SC nouvelleVitesseCartesien " + nouvelleVitesseCartesien.toString() );}
		//DEBUG// 

		//DEBUG//
		if(Affichage.debug){System.out.println("MOTEUR : SC vitesseAcutelle Particule " + objetUn.getVitesse() + " et vitesseFuture AVANT modif : " + objetUn.getVitesseFuture() );}
		//DEBUG// 
		objetUn.setVitesseFuture(nouvelleVitesseCartesien);
		//DEBUG//
		if(Affichage.debug){System.out.println("MOTEUR FIN COLLISION : vitesseAcutelle Particule "  + objetUn.getVitesse() + " et vitesseFuture APRES modif : " + objetUn.getVitesseFuture() );}
		//DEBUG// 
	}

	/** Méthode qui vérifie sur les objets sont en collision ou non. (Test du type : Distance inférieur rayon1+Rayon2
	 * @param objetUn : Particule numéro 1 qui est incluse dans le test
	 * @param objetDeux : Particule numéro 2 qui est incluse dans le test
	 * @return Un boolean : true si une collision est detectée, false si il n'y a pas de collision.
	 */
	public boolean sontEnCollision(Particule objetUn, Particule objetDeux){
		if(distance(objetUn,objetDeux).moduleCarre() <= (objetUn.getRayon()+objetDeux.getRayon())*(objetUn.getRayon()+objetDeux.getRayon()) ){
			//DEBUG//
			if(Affichage.debug){System.out.println("Collision détectée");}
			//DEBUG// 
			return true ;
		} else {
			//DEBUG//
			if(Affichage.debug){System.out.println("Pas de de collision");}
			//DEBUG//
			return false;
		}
	}	

	/** Vecteur distance : Coordonn�es objet A - Coordonn�es objet B
	 * @param objetUn : Particule numéro 1 qui est incluse dans le calcul de distance
	 * @param objetDeux : Particule numéro 2 qui est incluse dans le calcul de distance
	 * @return Le vecteur distance entre l'objetUn et l'objetDeux
	 */
	public Vecteur distance (Particule objetUn, Particule objetDeux){
		return objetUn.getCoordonnees().soustraction(objetDeux.getCoordonnees()); // Coordonn�es Objets A - Coordonn�es Objet 2    Soustrait les deux coordonn�es des objets 2 et 1 
	}


	/** Méthode qui met à jour la liste des Objets en calculant leurs interactions, leurs collisions ... et en mettant les objets à jour via leur attributs "VitesseFuture"
	 * @param listeDesObjets : la liste des Objets à calculer.
	 */
	public void miseAJourParticules(ListeObjet listeDesObjets){

		for(int i = 0; i< listeDesObjets.getListeParticule().size() ; i++ ){ //possible crash si l'utilisateur change le nombre d'objets durant l'execution. Mettre la pause avant de virer des objets.
			for(int j = 0; j< listeDesObjets.getListeParticule().size() ; j++ ){ //Double boucle pour les interactions de toutes les particules avec toutes les particules.

				if(i!=j){ // on �vite l'interaction de l'objet avec lui m�me.
					if(sontEnCollision(listeDesObjets.getListeParticule().get(i),listeDesObjets.getListeParticule().get(j))){
						collisionParticules(listeDesObjets.getListeParticule().get(i),listeDesObjets.getListeParticule().get(j));
						//DEBUG//
						if(Affichage.debug){System.out.println("Gestion collision de " + listeDesObjets.getListeParticule().get(i).toString() + " avec " + listeDesObjets.getListeParticule().get(j).toString());}
						//DEBUG//
					} else {
						interactionParticule(listeDesObjets.getListeParticule().get(i),listeDesObjets.getListeParticule().get(j));
						//DEBUG//
						if(Affichage.debug){System.out.println("Gestion interaction de " + listeDesObjets.getListeParticule().get(i).toString() + " avec  " + listeDesObjets.getListeParticule().get(j).toString());}
						//DEBUG//
					}
				} // fin du if de l'objet avec lui m�me
			}//Fin des for
		}
	}

}
