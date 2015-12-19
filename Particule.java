import java.awt.*;

public class Particule {

	// ATTRIBUTS ESSENTIELS
	private Vecteur coordonnees;
	private Vecteur vitesse;
	private Vecteur acceleration;
	private Vecteur vitesseFuture;
	private double masse;
	private double charge;
	private String type;
	
	//ATTRIBUTS PROTECTED POUR ENFANTS Y ACCEDENT
	protected double rayon;
	protected Color couleur;

	//VALEUR PAR DEFAUT
	private static String typeParDefaut= "Particule";
	private static int masseParDefaut= 10;
	private static int rayonParDefaut= 10;
	private static int chargeParDefaut=0;

	//NUMERO PARTICULE
	public static int compteur=0;
	private int num;

	public Particule(double x,double y, double z, double vx, double vy, double vz, double ax, double ay, double az,double masse, String type, double rayon, Color couleur, boolean vraiParticule){
		// ATTRIBUTS ESSENTIELS
		this.coordonnees= new Vecteur(x,y,z);
		this.vitesse= new Vecteur(vx,vy,vz);
		this.vitesseFuture = this.vitesse;
		this.acceleration = new Vecteur(ax,ay,az);
		this.masse= masse;
		this.type= type;
		this.rayon= rayon;
		this.charge= chargeParDefaut;
		this.couleur=couleur;

		//GESTION DU COMPTEUR DE PARTICULE
		if(vraiParticule){
			compteur++;
			this.num=compteur;
		}

	}

	public Particule(double x,double y, double z, double vx, double vy, double vz, double ax, double ay, double az,double masse, String type, double rayon, boolean vraiParticule){
		// ATTRIBUTS ESSENTIELS
		this.coordonnees= new Vecteur(x,y,z);
		this.vitesse= new Vecteur(vx,vy,vz);
		this.vitesseFuture = this.vitesse;
		this.acceleration = new Vecteur(ax,ay,az);
		this.masse= masse;
		this.type= type;
		this.rayon= rayon;
		this.charge= chargeParDefaut;
		this.couleur= Color.BLUE;

		//GESTION DU COMPTEUR DE PARTICULE
		if(vraiParticule){
			compteur++;
			this.num=compteur;
		}
	}

	public Particule (Vecteur coord, Vecteur vit, Vecteur acc, boolean vraiParticule){
		// ATTRIBUTS ESSENTIELS
		this.coordonnees=coord;
		this.vitesse=vit;
		this.vitesseFuture = this.vitesse;
		this.acceleration=acc;
		this.masse=masseParDefaut;
		this.type=typeParDefaut;
		this.rayon=rayonParDefaut;
		this.charge=chargeParDefaut;

		//GESTION DU COMPTEUR DE PARTICULE
		if(vraiParticule){
			compteur++;
			this.num=compteur;
		}
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
		return this.rayon;
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

	public Color getCouleur() {
		return couleur;
	}

	//ENSEMBLE DE SETTEURS ESSENTIELLS

	public void setMasse(double masse) {
		this.masse = masse;
	}

	public void setCouleur(Color c){
		couleur=c;
	}

	public void setRayon(double ray){
		this.rayon=ray;
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

		//DEBUG//
		if(Affichage.debug){System.out.println("PARTICULE " +  this.toString() + ": Passer état futur AVANT MODIF  :  acceleration" + this.getAcceleration().toString() + " vitesse " + this.getVitesse().toString() + " coordonnées " + this.getCoordonnees().toString());}
		//DEBUG//
		if(vitesse != vitesseFuture){
			vitesse = vitesseFuture; 
		} else {
			vitesse = vitesse.addition(acceleration);  
		}
		//DEBUG//
		if(Affichage.debug){System.out.println("PARTICULE " +  this.toString() + ": Passer état futur (vitesse modifiée) COURANT MODIF  :  acceleration" + this.getAcceleration().toString() + " vitesse " + this.getVitesse().toString() + " coordonnées " + this.getCoordonnees().toString());}
		//DEBUG//
		vitesseFuture = vitesse;
		coordonnees=coordonnees.addition(vitesse);
		//DEBUG//
		if(Affichage.debug){System.out.println("PARTICULE " +  this.toString() + ": Passer état futur APRES (coordonnées modifiée) MODIF  :  acceleration" + this.getAcceleration().toString() + " vitesse " + this.getVitesse().toString() + " coordonnées " + this.getCoordonnees().toString());}
		//DEBUG//
	}

	protected void dessiner(Graphics g, double[] coefficient, int dessinX, int dessinY){
		g.setColor(couleur);
		//AJOUTER LA GESTION DU COEFFICIENT : 
		// FAIRE x*coefficient y*coefficient
		int rayonBonneEchelle = (int)(rayon*coefficient[0]);
		int coordXBonneEchelle = (int)(((this.getCoordonneeX()*coefficient[0])+coefficient[1])-rayonBonneEchelle);
		int coordYBonneEchelle = (int)(((this.getCoordonneeY()*coefficient[0])+coefficient[1])-rayonBonneEchelle);

		//DEBUG //
		if(Affichage.debug){System.out.println("PARTICULE : Coordonnes Particule : " + this.toString() + " en : x " + (int)(this.getCoordonneeX()) + " y " + (int)(this.getCoordonneeY()));}
		if(Affichage.debug){System.out.println("PARTICULE : Tentative de dessin de : " + this.toString() + " en : x " + (int)(this.getCoordonneeX()-this.rayon) + " y " + (int)(this.getCoordonneeY()-this.rayon) + " de rayon " + (int)rayon + " " +(int)rayon);}
		if(Affichage.debug){System.out.println("PARTICULE : Coefficient transmis : " + coefficient[0] + " et " + coefficient[1]);}
		if(Affichage.debug){System.out.println("PARTICULE : Coordonnes du DESSIN A L'ECHELLE : " + this.toString() + " en : x " + coordXBonneEchelle + " y " + coordYBonneEchelle + " rayon " + rayonBonneEchelle );}
		//DEBUG //

		g.fillOval(coordXBonneEchelle, coordYBonneEchelle ,rayonBonneEchelle*2, rayonBonneEchelle*2);
	}

	// ---- ENSEMBLE DE TOSTRING et EQUALS ----
	public String toStringComplet(){
		String answer = "";
		if(type!=null){
			answer+= "Particule :  " + type;
		}
		answer+= " de masse "+ masse;
		if(coordonnees!=null){
			answer+= " coordonnées : " + coordonnees.toString(); 
		}
		if(type!=null){
			answer+= " vitesse " + vitesse.toString();
		}
		if(acceleration!=null){
			answer += " accélération: " + acceleration ;
		}
		answer += " numéro " + num;

		return answer;
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
