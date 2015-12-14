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
	
	//ENSEMBLE DE GETTEURS COORDONNEES
	public Vecteur getCoordonnees(){
		return coordonnees;
	}
	
	public double getCoordonneeX(){
		return coordonnees.getTabVecteur()[0];
	}
	
	public double getCoordonneeY(){
		return coordonnees.getTabVecteur()[1];
	}
	
	//ENSEMBLE DE GETTEURS VITESSE
	public Vecteur getVitesse(){
		return vitesse;
	}
	
	public double getVitesseX(){
		return vitesse.getTabVecteur()[0];
	}
	
	public double getVitesseY(){
		return vitesse.getTabVecteur()[1];
	}
			
	//ENSEMBLE DE GETTEURS ACCELERATION	
	public Vecteur getAcceleration(){
		return acceleration;
	}	
	
	public double getAccelerationX(){
		return acceleration.getTabVecteur()[0];
	}
	
	public double getAccelerationY(){
		return acceleration.getTabVecteur()[1];
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
		
	
	public void setVitesse(double X, double Y, double Z){
		Vecteur v= new Vecteur(X,Y,Z);
		vitesse=v;
	}
	
	public void setCoordonnees(double X, double Y, double Z){
		Vecteur v= new Vecteur(X,Y,Z);
		coordonnees=v;
	}
	
	public void setAcceleration(double X, double Y, double Z){
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
	
	public String getType(){
		return type;
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
	//	return "Votre particule est un(e) "+type+" , de masse "+masse+". Ses coordonn�es sont: " +coordonnees.toString()+" , sa vitesse "+ vitesse.toString()+" , son acc�l�ration: "+acceleration;
	//}
	/*
	public String toString(){
		return "Particule "+num+" pr�te � �tre lanc�e !";
	}
	*/
	public String toString(){
		return "Particule: "+type;
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
	
	protected void dessiner(Graphics g, int maxX, int maxY, int minX, int minY, int dessinX, int dessinY){
		g.setColor(couleur);
		int corrigeCentreX = map((int)(this.getCentre().getX()), minX, maxX, 0, dessinX);
		int corrigeCentreY = map((int)(this.getCentre().getY()), minY, maxY, 0, dessinY); // FAIT DES OVALES ! A CORRIGER ! 
		int corrigeRayon = map((int)(rayon), minY, maxY, 0, dessinY); // LIGNE A CORRIGER
		g.fillOval(corrigeCentreX, corrigeCentreY,corrigeRayon, corrigeRayon);
		
	}
	
	//M�thode map pour changer valeurs - A METTRE DANS PARTICULE
	int map(int x, int in_min, int in_max, int out_min, int out_max)
	{
	  return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
	}
	
	
}
