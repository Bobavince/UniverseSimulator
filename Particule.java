/**
 * @author Vincent F
 *
 */
public class Particule {
	
	Vecteur coordonnes;
	Vecteur vitesse;
	Vecteur acceleration;
	double rayon;
	
	/**
	 * @return the rayon
	 */
	public double getRayon() {
		return rayon;
	}


	/**
	 * @return the vitesse
	 */
	public Vecteur getVitesse() {
		return vitesse;
	}


	/**
	 * @return the acceleration
	 */
	public Vecteur getAcceleration() {
		return acceleration;
	}


	/**
	 * @param acceleration the acceleration to set
	 */
	public void setAcceleration(Vecteur acceleration) {
		this.acceleration = acceleration;
	}


	Vecteur vitesseFuture;
	
	/**
	 * @param vitesseFuture the vitesseFuture to set
	 */
	public void setVitesseFuture(Vecteur vitesseFuture) {
		this.vitesseFuture = vitesseFuture;
	}


	/**
	 * @return the coordonnes
	 */
	public Vecteur getCoordonnes() {
		return coordonnes;
	}


	/**
	 * @return the masse
	 */
	public double getMasse() {
		return masse;
	}


	double masse;
	double charge;
	
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
	public Particule(double x,double y, double z, double vx, double vy, double vz, double ax, double ay, double az){
		
	}
	
}
