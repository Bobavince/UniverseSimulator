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
	public Particule(double x,double y, double z, double vx, double vy, double vz, double ax, double ay, double az,double masse, String type, double rayon){
		coordonnees= new Vecteur(x,y,z);
		vitesse= new Vecteur(vx,vy,vz);
		acceleration = new Vecteur(ax,ay,az);
		this.masse= masse;
		this.type= type;
		compteur++;
		num=compteur;
		this.rayon= rayon;
	}
	
	public Particule (Vecteur coord, Vecteur vit, Vecteur acc, double rayon){
		coordonnees=coord;
		vitesse=vit;
		acceleration=acc;
		masse=10;
		type="particule";
		compteur++;
		num=compteur;
		this.rayon=rayon;
	}

	public double getMasse() {
		return masse;
	}

	public void setMasse(double masse) {
		this.masse = masse;
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
	
	public Vecteur getVitesseFuture(){
		return vitesseFuture;
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

	public String toString(){
		return "Votre particule est un(e) "+type+" , de masse "+masse+". Ses coordonn�es sont: " +coordonnees.toString()+" , sa vitesse "+ vitesse.toString()+" , son acc�l�ration: "+acceleration;
	}
	
	public boolean equals(Object o){
		
		if(o==null){
			return false;
		}
		if(!(o instanceof Particule)){
			return false;
		} else {
			Particule p= (Particule) o;
			return vitesse.equals(p.vitesse)&&coordonnees.equals(p.coordonnees)&&acceleration.equals(p.acceleration)&&masse==p.masse&&type.equals(p.type);
		}
	}
	
}
