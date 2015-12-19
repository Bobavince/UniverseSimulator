import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/** Classe enfant de Particule qui gère les particules du type "Etoile Naines Rouges"
 */
public class EtoileNaineRouge extends Particule {

	/** Constructeur premier de EtoileNaineRouge, créant une particule avec les données pré-enrengistrées
	 * @param x : Coordonnées X (gauche/droite) de création de la particule
	 * @param y : Coordonnées Y (haut/bas) de création de la particule
	 * @param z : Coordonnée Z (profondeur) de création de la particule NON UTILISE
	 * @param vx : Vitesse X (gauche/droite) de création de la particule
	 * @param vy : Vitesse Y (haut/bas) de création de la particule
	 * @param vz : Vitesse Z (profondeur) de création de la particule NON UTILISE
	 * @param ax : Acceleration X (gauche/droite) de création de la particule
	 * @param ay : Acceleration Y (haut/bas) de création de la particule
	 * @param az : Acceleration Z (profondeur) de création de la particule NON UTILISE
	 * @param vraiParticule : Boolean qui gère si la particule créé sera effectivement ajouté à la liste des particules du programme ou non.
	 */
	public EtoileNaineRouge(double x,double y,double z,double vx,double vy,double vz,double ax,double ay,double az, boolean vraiParticule){
		super(x,y,z,vx,vy,vz,ax,ay,az,4000000.0,"Naine rouge",100000.0, vraiParticule);
	}

	/** Constructeur second de EtoileNaineRouge, créant une particule avec les données de l'utilisateur
	 * @param x : Coordonnées X (gauche/droite) de création de la particule
	 * @param y : Coordonnées Y (haut/bas) de création de la particule
	 * @param z : Coordonnée Z (profondeur) de création de la particule NON UTILISE
	 * @param vx : Vitesse X (gauche/droite) de création de la particule
	 * @param vy : Vitesse Y (haut/bas) de création de la particule
	 * @param vz : Vitesse Z (profondeur) de création de la particule NON UTILISE
	 * @param ax : Acceleration X (gauche/droite) de création de la particule
	 * @param ay : Acceleration Y (haut/bas) de création de la particule
	 * @param az : Acceleration Z (profondeur) de création de la particule NON UTILISE
	 * @param masse : masse de la particule définie par l'utilisateur
	 * @param rayon : rayon de la particule définie par l'utilisateur
	 * @param vraiParticule : Boolean qui gère si la particule créé sera effectivement ajouté à la liste des particules du programme ou non.
	 */
	public EtoileNaineRouge(double x,double y,double z,double vx,double vy,double vz,double ax,double ay,double az,double masse, double rayon, boolean vraiParticule){
		super(x,y,z,vx,vy,vz,ax,ay,az,masse,"Naine rouge",rayon, vraiParticule);
	}

	/* Méthode qui dessiner la particule selon des règles précises.
	 * Les arguments sont : le graphics où la particule se dessinera, le coefficient de mise à l'échelle pour le dessin, et les largeur/hauteur de la zone de dessin.
	 */
	protected void dessiner(Graphics g, double[] coefficient, int dessinX, int dessinY){

		// FAIRE x*coefficient y*coefficient
		int rayonBonneEchelle = (int)(rayon*coefficient[0]);
		int coordXBonneEchelle = (int)(((this.getCoordonneeX()*coefficient[0])+coefficient[1])-rayonBonneEchelle);
		int coordYBonneEchelle = (int)(((this.getCoordonneeY()*coefficient[0])+coefficient[1])-rayonBonneEchelle);
		if(Affichage.debug){System.out.println("DESSIN NAINE ROUGE");};

		//DEBUG //
		if(Affichage.debug){System.out.println("PARTICULE : Coordonnes Particule : " + this.toString() + " en : x " + (int)(this.getCoordonneeX()) + " y " + (int)(this.getCoordonneeY()));}
		if(Affichage.debug){System.out.println("PARTICULE : Tentative de dessin de : " + this.toString() + " en : x " + (int)(this.getCoordonneeX()-this.rayon) + " y " + (int)(this.getCoordonneeY()-this.rayon) + " de rayon " + (int)rayon + " " +(int)rayon);}
		if(Affichage.debug){System.out.println("PARTICULE : Coefficient transmis : " + coefficient[0] + " et " + coefficient[1]);}
		if(Affichage.debug){System.out.println("PARTICULE : Coordonnes du DESSIN A L'ECHELLE : " + this.toString() + " en : x " + coordXBonneEchelle + " y " + coordYBonneEchelle + " rayon " + rayonBonneEchelle );}
		//DEBUG //

		//On la dessine en tant qu'image : 
		BufferedImage sourceImage = null;

		//On tente d'importer l'image
		try {
			sourceImage = ImageIO.read(new File("NaineRougeF.png"));
			if(Affichage.debug){System.out.println("Naine ROUGE : image importée successful ");};
			//On tente de dessiner l'image.
			g.drawImage(sourceImage,coordXBonneEchelle,coordYBonneEchelle,rayonBonneEchelle*2,rayonBonneEchelle*2,null);

		} catch (IOException e) {
			e.printStackTrace();
			//ça a échoué lamentablement, donc on dessiner avec une pauvre petite bouboule de couleur.
			g.setColor(couleur);
			g.fillOval(coordXBonneEchelle, coordYBonneEchelle ,rayonBonneEchelle*2, rayonBonneEchelle*2);
		}
	}

	/* Méthode standard de la particule
	 */
	public String toString(){
		return super.toString();
	}
}
