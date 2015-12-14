import java.awt.*;

public class Particule {

	// ATTRIBUTS ESSENTIELS
	private Vecteur coordonnees;
	private Vecteur vitesse;
	private Vecteur acceleration;
	private Vecteur vitesseFuture;
	private double masse;
	private double rayon;
	private double charge;
	private Color couleur;
	private String type;

	//VALEUR PAR DEFAUT
	private static String typeParDefaut= "Particule";
	private static int masseParDefaut= 10;
	private static int rayonParDefaut= 10;
	private static int chargeParDefaut=0;

	//NUMERO PARTICULE
	private static int compteur=0;
	private int num;

	public Particule(double x,double y, double z, double vx, double vy, double vz, double ax, double ay, double az,double masse, String type, double rayon, Color couleur){
		// ATTRIBUTS ESSENTIELS
		this.coordonnees= new Vecteur(x,y,z);
		this.vitesse= new Vecteur(vx,vy,vz);
		this.acceleration = new Vecteur(ax,ay,az);
		this.masse= masse;
		this.type= type;
		this.rayon= rayon;
		this.charge= chargeParDefaut;
		this.couleur=couleur;

		//GESTION DU COMPTEUR DE PARTICULE
		compteur++;
		this.num=compteur;
	}

	public Particule(double x,double y, double z, double vx, double vy, double vz, double ax, double ay, double az,double masse, String type, double rayon){
		// ATTRIBUTS ESSENTIELS
		this.coordonnees= new Vecteur(x,y,z);
		this.vitesse= new Vecteur(vx,vy,vz);
		this.acceleration = new Vecteur(ax,ay,az);
		this.masse= masse;
		this.type= type;
		this.rayon= rayon;
		this.charge= chargeParDefaut;
		this.couleur= Color.BLUE;

		//GESTION DU COMPTEUR DE PARTICULE
		compteur++;
		this.num=compteur;
	}

	public Particule (Vecteur coord, Vecteur vit, Vecteur acc){
		// ATTRIBUTS ESSENTIELS
		this.coordonnees=coord;
		this.vitesse=vit;
		this.acceleration=acc;
		this.masse=masseParDefaut;
		this.type=typeParDefaut;
		this.rayon=rayonParDefaut;
		this.charge=chargeParDefaut;

		//GESTION DU COMPTEUR DE PARTICULE
		compteur++;
		this.num=compteur;
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

	public Vecteur getVitesseFuture(){
		return vitesseFuture;
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

	//ESEMBLES DE GETTEUR AUTRES ESSENTIELS
	public double getRayon(){
		return rayon;
	}

	public double getMasse() {
		return masse;
	}

	public int getNum(){
		return num;
	}
	
	public String getType(){
		return type;
	}

	//ENSEMBLE DE SETTEURS ESSENTIELLS

	public void setMasse(double masse) {
		this.masse = masse;
	}

	public void setCouleur(Color c){
		couleur=c;
	}

	public void setRayon(double ray){
		rayon=ray;
	}

	//SETTEURS COORDONNES
	public void setCoordonnees(double X, double Y, double Z){
		coordonnees = new Vecteur(X,Y,Z);
	}

	public void setCoordonnees(Vecteur coord){
		coordonnees=coord;
	}

	//SETTEURS VITESSE
	public void setVitesse(double X, double Y, double Z){
		vitesse = new Vecteur(X,Y,Z);
	}
	
	public void setVitesse(Vecteur vit){
		vitesse= vit;
	}

	public void setVitesseFuture(Vecteur v){
		vitesseFuture=v;
	}

	//SETTEURS ACCELERATION
	public void setAcceleration(double X, double Y, double Z){
		acceleration = new Vecteur(X,Y,Z);;
	}

	public void setAcceleration(Vecteur acc){
		acceleration=acc;
	}

	//ENSEMBLE DE METHODES UTILES

	public void passerEtatFutur(){
		if(vitesse != vitesseFuture){
			vitesse = vitesseFuture; 
		} else {
			vitesse = vitesse.addition(acceleration);  
		}

		vitesseFuture = vitesse;
		coordonnees=coordonnees.addition(vitesse);
	}
	
	protected void dessiner(Graphics g, int maxX, int maxY, int minX, int minY, int dessinX, int dessinY){
		g.setColor(couleur);
		int corrigeCentreX = map((int)(this.getCoordonneeX()-this.rayon), minX, maxX, 0, dessinX);
		int corrigeCentreY = map((int)(this.getCoordonneeY()-this.rayon), minY, maxY, 0, dessinY); // FAIT DES OVALES ! A CORRIGER ! 
		int corrigeRayon = map((int)(rayon), minY, maxY, 0, dessinY); // LIGNE A CORRIGER
		
		//LIGNE DE DEBUG
		g.fillOval((int)this.getCoordonneeX(), (int)this.getCoordonneeY(),(int)rayon, (int)rayon);
		
		//g.fillOval(corrigeCentreX, corrigeCentreY,corrigeRayon, corrigeRayon);
		System.out.println("PARTICULE :  i, maxX, maxyn minx, minY, getWidht, getHeight" + maxX + " " + maxY + " " + minX + " " + minY + " " + dessinX +  " " + dessinY);
		System.out.println("PARTICULE : corrigeX, corrigeY, corrigeRayon" + corrigeCentreX + " " + corrigeCentreY  + " " +  corrigeRayon) ;


	}
	
	protected void dessiner(Graphics g, double coefficient, int dessinX, int dessinY){
		g.setColor(couleur);
		//AJOUTER LA GESTION DU COEFFICIENT : 
		// FAIRE x*coefficient y*coefficient
		
		//DEBUG //
		System.out.println("Coordonnes Particule : " + this.toString() + " en : x " + (int)(this.getCoordonneeX()) + " y " + (int)(this.getCoordonneeY()));
		System.out.println("Tentative de dessin de : " + this.toString() + " en : x " + (int)(this.getCoordonneeX()-this.rayon) + " y " + (int)(this.getCoordonneeY()-this.rayon) + " de rayon " + (int)rayon + " " +(int)rayon);
		//DEBUG //
		g.fillOval((int)(this.getCoordonneeX()-(this.rayon/2)), (int)(this.getCoordonneeY()-(this.rayon/2)),(int)rayon, (int)rayon);
	}
	
	

	//M�thode map pour changer valeurs - A METTRE DANS PARTICULE
	int map(int x, int in_min, int in_max, int out_min, int out_max)
	{
		return (int) ((x*(out_max-out_min))/(double)(in_min-in_max));
		//return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;

	}


	//ENSEMBLE DE TOSTRING et EQUALS
	public String toStringComplet(){
		// NOTE ERREUR ICI IL FAUT VERIFIER SI ILS EXISTENT ! 
		return "Particule :  "+ type +" , de masse "+ masse +". coordonnées : " + coordonnees.toString()+" , vitesse "+ vitesse.toString() +" , accélération: "+ acceleration + " numéro " + num;
	}

	public String toString(){
		return "Particule: "+ type;
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

}
