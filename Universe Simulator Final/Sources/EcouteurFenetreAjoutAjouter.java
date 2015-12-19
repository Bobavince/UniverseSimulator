import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Classe écouteut du bouton Ajouter de la fenpetre "ajouter particule"
 */
public class EcouteurFenetreAjoutAjouter implements ActionListener {

	FenetreAjout fenetreAjout;

	/** Constructeur de l'écouteur
	 * @param fenetreAjout : Fenêtre parente "Fenetre Ajout" conteant le bouton "Ajouter"
	 */
	public EcouteurFenetreAjoutAjouter(FenetreAjout fenetreAjout){
		this.fenetreAjout=fenetreAjout;
	}

	/*  Méthode standard de réaction
	 */
	public void actionPerformed(ActionEvent ae) {
		if(fenetreAjout.getMasse()!=0 && fenetreAjout.getRayon()>0){
			//On réagit différemment suivant le type de particule sélectionné.
			switch(fenetreAjout.getTypeParticule()){
			case "Terre" :
				// On créé la particule avec les données de la fenêtre et on l'ajoute à la fenetre principale qui se charge du reste
				Terre maTerre = new Terre(fenetreAjout.getCoordX(), fenetreAjout.getCoordY(),0, fenetreAjout.getVitX(), fenetreAjout.getVitY(),0,fenetreAjout.getAccX(), fenetreAjout.getAccY(), 0, fenetreAjout.getMasse(), fenetreAjout.getRayon(),true);
				fenetreAjout.getFenAffichage().ajouterParticule(maTerre);
				fenetreAjout.getFenAffichage().getZoneDessin().repaint();
				//On cache la fenetre d'ajout de particule
				fenetreAjout.dispose();

				//DEBUG //
				if(Affichage.debug){System.out.println(" ECOUTEUR LANCEMENT (Ajout d'une particule TERRE) coordX " + fenetreAjout.getCoordX() + " coordY " +  fenetreAjout.getCoordY() + "coordZ " + 0 + " vitesX " +  fenetreAjout.getVitX() + " vitesY " +  fenetreAjout.getVitY() + "vitesZ " + 0 + " accelX " + fenetreAjout.getAccX() + " accelY " +  fenetreAjout.getAccY() + " accelZ " + 0 + " masse " + fenetreAjout.getMasse() + " type " +  fenetreAjout.getTypeParticule() + "rayon " +  fenetreAjout.getRayon() + " couleur " + fenetreAjout.getCouleurParticule());}
				//DEBUG - Connaitre les particules effectivement ajouté// 
				break;
			case "Naine rouge" :
				// On créé la particule avec les données de la fenêtre et on l'ajoute à la fenetre principale qui se charge du reste
				EtoileNaineRouge monEtoileNaine = new EtoileNaineRouge(fenetreAjout.getCoordX(), fenetreAjout.getCoordY(),0, fenetreAjout.getVitX(), fenetreAjout.getVitY(),0,fenetreAjout.getAccX(), fenetreAjout.getAccY(), 0, fenetreAjout.getMasse(), fenetreAjout.getRayon(),true);
				fenetreAjout.getFenAffichage().ajouterParticule(monEtoileNaine);
				fenetreAjout.getFenAffichage().getZoneDessin().repaint();
				//On cache la fenetre d'ajout de particule
				fenetreAjout.dispose();

				//DEBUG //
				if(Affichage.debug){System.out.println(" ECOUTEUR LANCEMENT (Ajout d'une particule Naine Rouge) coordX " + fenetreAjout.getCoordX() + " coordY " +  fenetreAjout.getCoordY() + "coordZ " + 0 + " vitesX " +  fenetreAjout.getVitX() + " vitesY " +  fenetreAjout.getVitY() + "vitesZ " + 0 + " accelX " + fenetreAjout.getAccX() + " accelY " +  fenetreAjout.getAccY() + " accelZ " + 0 + " masse " + fenetreAjout.getMasse() + " type " +  fenetreAjout.getTypeParticule() + "rayon " +  fenetreAjout.getRayon() + " couleur " + fenetreAjout.getCouleurParticule());}
				//DEBUG - Connaitre les particules effectivement ajouté// 
				break;
			case "Meteorite Tcheliabinsk" :
				// On créé la particule avec les données de la fenêtre et on l'ajoute à la fenetre principale qui se charge du reste
				Meteorite maMeteorite = new Meteorite(fenetreAjout.getCoordX(), fenetreAjout.getCoordY(),0, fenetreAjout.getVitX(), fenetreAjout.getVitY(),0,fenetreAjout.getAccX(), fenetreAjout.getAccY(), 0, fenetreAjout.getMasse(), fenetreAjout.getRayon(),true);
				fenetreAjout.getFenAffichage().ajouterParticule(maMeteorite);
				fenetreAjout.getFenAffichage().getZoneDessin().repaint();
				//On cache la fenetre d'ajout de particule
				fenetreAjout.dispose();

				//DEBUG //
				if(Affichage.debug){System.out.println(" ECOUTEUR LANCEMENT (Ajout d'une particule Meteorite) coordX " + fenetreAjout.getCoordX() + " coordY " +  fenetreAjout.getCoordY() + "coordZ " + 0 + " vitesX " +  fenetreAjout.getVitX() + " vitesY " +  fenetreAjout.getVitY() + "vitesZ " + 0 + " accelX " + fenetreAjout.getAccX() + " accelY " +  fenetreAjout.getAccY() + " accelZ " + 0 + " masse " + fenetreAjout.getMasse() + " type " +  fenetreAjout.getTypeParticule() + "rayon " +  fenetreAjout.getRayon() + " couleur " + fenetreAjout.getCouleurParticule());}
				//DEBUG - Connaitre les particules effectivement ajouté//
				break;
			default :
				// On créé la particule avec les données de la fenêtre et on l'ajoute à la fenetre principale qui se charge du reste
				Particule maParticule = new Particule(fenetreAjout.getCoordX(), fenetreAjout.getCoordY(),0, fenetreAjout.getVitX(), fenetreAjout.getVitY(),0,fenetreAjout.getAccX(), fenetreAjout.getAccY(),0,fenetreAjout.getMasse(),fenetreAjout.getTypeParticule(), fenetreAjout.getRayon(),fenetreAjout.getCouleurParticule(), true);
				fenetreAjout.getFenAffichage().ajouterParticule(maParticule);
				fenetreAjout.getFenAffichage().getZoneDessin().repaint();
				//On cache la fenetre d'ajout de particule
				fenetreAjout.dispose();

				//DEBUG //
				if(Affichage.debug){System.out.println(" ECOUTEUR LANCEMENT (Ajout d'une particule par défaut) coordX " + fenetreAjout.getCoordX() + " coordY " +  fenetreAjout.getCoordY() + "coordZ " + 0 + " vitesX " +  fenetreAjout.getVitX() + " vitesY " +  fenetreAjout.getVitY() + "vitesZ " + 0 + " accelX " + fenetreAjout.getAccX() + " accelY " +  fenetreAjout.getAccY() + " accelZ " + 0 + " masse " + fenetreAjout.getMasse() + " type " +  fenetreAjout.getTypeParticule() + "rayon " +  fenetreAjout.getRayon() + " couleur " + fenetreAjout.getCouleurParticule());}
				//DEBUG - Connaitre les particules effectivement ajouté// 
				break;
			}

		} else {
			System.out.println("La particule doit obligatoirement avoir une masse et un rayon positif.");

			//DEBUG // 
			if(Affichage.debug){System.out.println("ECOUTEUR LANCEMENT : " + fenetreAjout.getMasse() +" "+ fenetreAjout.getRayon());}
			//DEBUG//
		}

	}
}
