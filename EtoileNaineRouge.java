import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class EtoileNaineRouge extends Particule {

	public EtoileNaineRouge(double x,double y,double z,double vx,double vy,double vz,double ax,double ay,double az, boolean vraiParticule){
		super(x,y,z,vx,vy,vz,ax,ay,az,4000000.0,"Naine rouge",100000.0, vraiParticule);
	}
	public EtoileNaineRouge(double x,double y,double z,double vx,double vy,double vz,double ax,double ay,double az,double masse, double rayon, boolean vraiParticule){
		super(x,y,z,vx,vy,vz,ax,ay,az,masse,"Naine rouge",rayon, vraiParticule);
	}

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
	
	public String toString(){
		return super.toString();
	}
}
