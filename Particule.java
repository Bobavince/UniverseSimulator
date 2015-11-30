import java.awt.Graphics;
import java.awt.Point; 
import java.awt.Graphics; 
import java.awt.*;

public class Particule {
	
	private Vecteur coordonnees;
	private Vecteur vitesse;
	private Vecteur acceleration;
	private double masse;
	private double charge;
	private String type;
	private static int compteur=0;
	private int num;
	private double rayon;
	private Vecteur vitesseFuture;
	private static int masseParDefaut= 10;
	private static int rayonParDefaut= 10;
	private static String typeParDefaut= "Particule";
	private static int chargeParDefaut=0;
	private Point centre;
	private Color couleur;
	
	/** Constructeur
	 * @param x
	 * @param y
	 * @param z
	 * @param vx
	 * @param vy
	 * @param vz
	 * @param ax
	 * @param ay
	 * @param az
	 */
	public Particule(double x,double y, double z, double vx, double vy, double vz, double ax, double ay, double az,double masse, String type, double rayon, Color couleur){
		coordonnees= new Vecteur(x,y,z);
		vitesse= new Vecteur(vx,vy,vz);
		acceleration = new Vecteur(ax,ay,az);
		this.masse= masse;
		this.type= type;
		compteur++;
		num=compteur;
		this.rayon= rayon;
		charge= chargeParDefaut;
		centre= new Point((int)(x+rayon),(int)(y+rayon));
		this.couleur=couleur;
	}
	
	public Particule(double x,double y, double z, double vx, double vy, double vz, double ax, double ay, double az,double masse, String type, double rayon){
		coordonnees= new Vecteur(x,y,z);
		vitesse= new Vecteur(vx,vy,vz);
		acceleration = new Vecteur(ax,ay,az);
		this.masse= masse;
		this.type= type;
		compteur++;
		num=compteur;
		this.rayon= rayon;
		charge= chargeParDefaut;
		centre= new Point((int)(x+rayon),(int)(y+rayon));
		this.couleur= Color.BLUE;
	}
	
	public Particule (Vecteur coord, Vecteur vit, Vecteur acc){
		coordonnees=coord;
		vitesse=vit;
		acceleration=acc;
		masse=masseParDefaut;
		type=typeParDefaut;
		compteur++;
		num=compteur;
		rayon=rayonParDefaut;
		charge=chargeParDefaut;
	}
	
	public Vecteur getCoordonnees(){
		return coordonnees;
	}
	
	public Vecteur getVitesse(){
		return vitesse;
	}
			
	public Vecteur getAcceleration(){
		return acceleration;
	}	
	
	public int getNum(){
		return num;
	}
	
	public double getRayon(){
		return rayon;
	}
	
	public double getMasse() {
		return masse;
	}
	
	public Point getCentre(){
		return centre;
	}
	
	public void setCentre(int x, int y){
		centre= new Point(x,y);
	}

	public void setMasse(double masse) {
		this.masse = masse;
	}
	
	public Vecteur getVitesseFuture(){
		return vitesseFuture;
	}
	
	public void setCouleur(Color c){
		couleur=c;
	}
		
	
	public void setVitesse(int X, int Y, int Z){
		Vecteur v= new Vecteur(X,Y,Z);
		vitesse=v;
	}
	
	public void setCoordonnees(int X, int Y, int Z){
		Vecteur v= new Vecteur(X,Y,Z);
		coordonnees=v;
	}
	
	public void setAcceleration(int X, int Y, int Z){
		Vecteur v= new Vecteur(X,Y,Z);
		acceleration=v;
	}
	
	public void setAcceleration(Vecteur acc){
		acceleration=acc;
	}
	
	public void setCoordonnees(Vecteur coord){
		coordonnees=coord;
	}
	
	public void setVitesse(Vecteur vit){
		vitesse= vit;
	}
	
	public void setRayon(int ray){
		rayon=ray;
	}
	
	public void setVitesseFuture(Vecteur v){
		vitesseFuture=v;
	}
	
	public void passerEtatFutur(){
		if(vitesse != vitesseFuture){
			vitesse = vitesseFuture; 
        } else {
			vitesse = vitesse.addition(acceleration);  
		}
		
		vitesseFuture = vitesse;
		coordonnees=coordonnees.addition(vitesse);
   }

	//public String toString(){
	//	return "Votre particule est un(e) "+type+" , de masse "+masse+". Ses coordonnées sont: " +coordonnees.toString()+" , sa vitesse "+ vitesse.toString()+" , son accélération: "+acceleration;
	//}
	
	public String toString(){
		return "Particule "+num+" prête à être lancée !";
	}
	
	public boolean equals(Object o){
		
		if(o==null){
			return false;
		}
		if(!(o instanceof Particule)){
			return false;
		}
		else{
			Particule p= (Particule) o;
			return vitesse.equals(p.vitesse)&&coordonnees.equals(p.coordonnees)&&acceleration.equals(p.acceleration)&&masse==p.masse&&type.equals(p.type)&&num==p.num&&rayon==p.rayon&&charge==p.charge;
		}
	}
	
	protected void dessiner( Graphics g){
		g.setColor(couleur);
		g.fillOval((int)(this.getCentre().getX()), (int)(this.getCentre().getY()),(int)(rayon), (int)(rayon));
		
	}
	
	
	
}
