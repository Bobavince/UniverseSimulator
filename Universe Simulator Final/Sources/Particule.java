import java.awt.Color;
import java.awt.Graphics;

/** Classe parentes de toutes les particules qui gère les principales fonctions associées aux particules gérées par le programme.
 */
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

	/** Constructeur premier de Particule, créant une particule avec les données de l'utilisateur
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
	 * @param type : type de la particule défini par l'utilisateur
	 * @param rayon : rayon de la particule définie par l'utilisateur
	 * @param couleur : Couleur de la particule définie par l'utilisateur
	 * @param vraiParticule : Boolean qui gère si la particule créé sera effectivement ajouté à la liste des particules du programme ou non.
	 */
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

	/** Constructeur second de Particule, créant une particule avec les données de l'utilisateur
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
	 * @param type : type de la particule défini par l'utilisateur
	 * @param rayon : rayon de la particule définie par l'utilisateur
	 * @param vraiParticule : Boolean qui gère si la particule créé sera effectivement ajouté à la liste des particules du programme ou non.
	 */
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

	/** Constructeur troisième de Particule, créant une particule avec les données de l'utilisateur
	 * @param coord : Coordonnées (gauche/droite) de création de la particule
	 * @param vit : Vitesse (gauche/droite) de création de la particule
	 * @param acc : Acceleration (gauche/droite) de création de la particule
	 * @param vraiParticule : Boolean qui gère si la particule créé sera effectivement ajouté à la liste des particules du programme ou non.
	 */
	public Particule(Vecteur coord, Vecteur vit, Vecteur acc, boolean vraiParticule){
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
	/** Getteur du vecteur coordonnées de la particule
	 * @return le vecteur coordonnées de la particule
	 */
	public Vecteur getCoordonnees(){
		return coordonnees;
	}

	/** Getteur de la CoordX de la particule
	 * @return la coordonnées X de la particule
	 */
	public double getCoordonneeX(){
		return coordonnees.getTabVecteur()[0];
	}

	/** Getteur de la CoordY de la particule
	 * @return la coordonnées Y  de la particule
	 */
	public double getCoordonneeY(){
		return coordonnees.getTabVecteur()[1];
	}

	//ENSEMBLE DE GETTEURS VITESSE
	/** Getteur du vecteur vitesse de la particule
	 * @return le vecteur vitesse de la particule
	 */
	public Vecteur getVitesse(){
		return vitesse;
	}

	/** Getteur de la VitesX de la particule
	 * @return la vitesse X de la particule
	 */
	public double getVitesseX(){
		return vitesse.getTabVecteur()[0];
	}

	/** Getteur de la VitesY de la particule
	 * @return la vitesseY de la particule
	 */
	public double getVitesseY(){
		return vitesse.getTabVecteur()[1];
	}

	/** Getteur du vecteur vitesse FUTURE de la particule
	 * @return le vecteur vitesse FUTURE de la particule
	 */
	public Vecteur getVitesseFuture(){
		return vitesseFuture;
	}

	//ENSEMBLE DE GETTEURS ACCELERATION	
	/** Getteur du vecteur acceleration de la particule
	 * @return le vecteur acceleration de la particule
	 */
	public Vecteur getAcceleration(){
		return acceleration;
	}	

	/** Getteur de la AccelX de la particule
	 * @return la acceleration X de la particule
	 */
	public double getAccelerationX(){
		return acceleration.getTabVecteur()[0];
	}

	/** Getteur de la AccelY de la particule
	 * @return la acceleration Y de la particule
	 */
	public double getAccelerationY(){
		return acceleration.getTabVecteur()[1];
	}

	//ESEMBLES DE GETTEUR AUTRES ESSENTIELS
	/** Getteur du rayon de la particule
	 * @return le rayon de la particule
	 */
	public double getRayon(){
		return this.rayon;
	}

	/** Getteur de la masse de la particule
	 * @return la masse de la particule
	 */
	public double getMasse() {
		return masse;
	}

	/** Getteur du numéro de la particule
	 * @return numéro de la particule
	 */
	public int getNum(){
		return num;
	}

	/** Getteur du type de la particule
	 * @return type de la particule
	 */
	public String getType(){
		return type;
	}

	/** Getteur de la couleur de la particule
	 * @return couleur de la particule
	 */
	public Color getCouleur() {
		return couleur;
	}

	//ENSEMBLE DE SETTEURS ESSENTIELLS

	/** Setteur de la masse de la particule
	 * @param masse : masse de la particule à setter
	 */
	public void setMasse(double masse) {
		this.masse = masse;
	}

	/** Setteur de la couleur de la particule
	 * @param c : couleur de la particule à setter
	 */
	public void setCouleur(Color c){
		couleur=c;
	}

	/** Setteur du rayon de la particule
	 * @param ray : rayon de la particule à setter
	 */
	public void setRayon(double ray){
		this.rayon=ray;
	}

	//SETTEURS COORDONNES

	/**Setteur des coordonnées de la particule
	 * @param X : coordonnée X de la particule à setter
	 * @param Y : coordonnée Y de la particule à setter
	 * @param Z : coordonnée Z de la particule à setter
	 */
	public void setCoordonnees(double X, double Y, double Z){
		coordonnees = new Vecteur(X,Y,Z);
	}

	/** Setteur des coordonnées de la particule
	 * @param coord : Vecteur coordonnées de la particule à setter
	 */
	public void setCoordonnees(Vecteur coord){
		coordonnees=coord;
	}

	//SETTEURS VITESSE
	/**Setteur des vitesse de la particule
	 * @param X : vitesse X de la particule à setter
	 * @param Y : vitesse Y de la particule à setter
	 * @param Z : vitesse Z de la particule à setter
	 */
	public void setVitesse(double X, double Y, double Z){
		vitesse = new Vecteur(X,Y,Z);
	}

	/** Setteur des vitesses de la particule
	 * @param vit : Vecteur vitesses de la particule à setter
	 */
	public void setVitesse(Vecteur vit){
		vitesse= vit;
	}

	/** Setteur des vitesses de la particule
	 * @param v : Vecteur vitesses Futur de la particule à setter
	 */
	public void setVitesseFuture(Vecteur v){
		vitesseFuture=v;
	}

	//SETTEURS ACCELERATION
	/**Setteur des Accelerations de la particule
	 * @param X : Acceleration X de la particule à setter
	 * @param Y : Acceleration Y de la particule à setter
	 * @param Z : Acceleration Z de la particule à setter
	 */
	public void setAcceleration(double X, double Y, double Z){
		acceleration = new Vecteur(X,Y,Z);;
	}

	/** Setteur des accelerations de la particule
	 * @param acc : Vecteur accelerations Futur de la particule à setter
	 */
	public void setAcceleration(Vecteur acc){
		acceleration=acc;
	}

	//ENSEMBLE DE METHODES UTILES

	/** Méthode qui permet de passer à l'état futur la particule, en faisant "Vitesse = VitesseFutur".
	 */
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

	/** Méthode qui permet de dessiner la particule dans le Graphics passé en paramètre.
	 * @param g : Graphics où la particule se dessinera.
	 * @param coefficient : coefficient de dilatation/mise à l'échelle calculé ailleurs qui permet de faire tenir la particule dans le cadre de dessin
	 * @param dessinX : largeur de la zone de dessin.
	 * @param dessinY : hauteur de la zone de dessin.
	 */
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
	/** Méthode standard modifiée pour afficher un toString complet (de toutes les caractéristiques) sur la sortie standard.
	 * @return la chaine de caractère contenant toutes les informations sur la particule.
	 */
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

	/* Méthode standard d'affichage textuel de la particule.
	 */
	public String toString(){
		return "Particule: "+ type;
	}

	/*  Méthode standard de test unitaires d'égalités.a
	 */
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
