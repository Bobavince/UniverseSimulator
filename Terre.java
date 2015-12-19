import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Terre extends Particule {
	
	public Terre(double x,double y,double z,double vx,double vy,double vz,double ax,double ay,double az, boolean vraiParticule){
		super(x,y,z,vx,vy,vz,ax,ay,az,5.9,"Terre",6371000.0, vraiParticule);
	}
	
	protected void dessiner(Graphics g, double[] coefficient, int dessinX, int dessinY){
		//g.setColor(couleur);
		// FAIRE x*coefficient y*coefficient
		int rayonBonneEchelle = (int)(rayon*coefficient[0]);
		int coordXBonneEchelle = (int)(((this.getCoordonneeX()*coefficient[0])+coefficient[1])-rayonBonneEchelle);
		int coordYBonneEchelle = (int)(((this.getCoordonneeY()*coefficient[0])+coefficient[1])-rayonBonneEchelle);
		System.out.println("DESSIN TERRE");
		//DEBUG //
		if(Affichage.debug){System.out.println("PARTICULE : Coordonnes Particule : " + this.toString() + " en : x " + (int)(this.getCoordonneeX()) + " y " + (int)(this.getCoordonneeY()));}
		if(Affichage.debug){System.out.println("PARTICULE : Tentative de dessin de : " + this.toString() + " en : x " + (int)(this.getCoordonneeX()-this.rayon) + " y " + (int)(this.getCoordonneeY()-this.rayon) + " de rayon " + (int)rayon + " " +(int)rayon);}
		if(Affichage.debug){System.out.println("PARTICULE : Coefficient transmis : " + coefficient[0] + " et " + coefficient[1]);}
		if(Affichage.debug){System.out.println("PARTICULE : Coordonnes du DESSIN A L'ECHELLE : " + this.toString() + " en : x " + coordXBonneEchelle + " y " + coordYBonneEchelle + " rayon " + rayonBonneEchelle );}
		//DEBUG //
		
		//Tente une image
		BufferedImage sourceImage = null;
		
		try {
			sourceImage = ImageIO.read(new File("C:/Users/Bobavince/Desktop/Earth.png"));
			System.out.println("IMAGE IMPORTé ! ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Image img = sourceImage.getScaledInstance(rayonBonneEchelle*2, rayonBonneEchelle*2, Image.SCALE_SMOOTH);
		g.drawImage(img,coordXBonneEchelle,coordYBonneEchelle,null);
		
		//g.fillOval(coordXBonneEchelle, coordYBonneEchelle ,rayonBonneEchelle*2, rayonBonneEchelle*2);
	}
	
	public String toString(){
		return super.toString();
	}

}
