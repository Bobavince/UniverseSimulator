/** Classe gérant les vecteurs 3 lignes 1 colonne, pour toutes les opérations courantes.
 * Note : le programme ne devrait pas se servir des composantes sur Z.
 */ 
public class Vecteur{

	private double[] vect = new double[3];

	/** Constructeur d'un vecteur
	 * @param x : la composante sur X
	 * @param y : la composante sur Y
	 * @param z : la composante sur Z
	 */
	public Vecteur(double x, double y, double z){
		vect[0] = x;
		vect[1] = y;
		vect[2] = z;
	}

	/** Getteur du vecteur sous forme de tableau de double
	 * @return le tableau de double représentant le vecteur
	 */
	public double[] getTabVecteur(){
		return vect;
	}

	/** Setteur de composante pour un vecteur
	 * @param composante : 0, 1 ou 2 (ne fait rien sinon)
	 * @param a : la valeur à appliquer à la composante
	 */
	public void setComposante(int composante,double a){
		if(composante==0 || composante==1 || composante==2){
			vect[composante] = a;
		}
	}

	/** Méthode standard de comparaison de vecteurs entres eux.
	 * @param param : Veteur à comparer
	 * @return un boolean, true si les vecteurs sont identiques, false sinon.
	 */
	public boolean equals(Vecteur param){
		boolean res = false;
		if (param != null){
			res = (vect[0] == param.getTabVecteur()[0])
					&& (vect[1] == param.getTabVecteur()[1])
					&& (vect[2] == param.getTabVecteur()[2]);
		}
		return res;
	}

	/* Méthode standard du Vecteur
	 */
	public String toString(){
		return "("+vect[0]+","+vect[1]+","+vect[2]+")";
	}

	/** Méthode effectuant une addition d'un vecteur avec celui passé en paramètre, renvoyé sous forme d'un troisième vecteur
	 * @param param : le vecteur à additioner
	 * @return le vecteur somme
	 */
	public Vecteur addition(Vecteur param){ // Vecteur ou void ? modif irr�versible du vecteur ?
		Vecteur res = new Vecteur(0,0,0);
		if (param != null){
			res.setComposante(0, vect[0] + param.getTabVecteur()[0]);
			res.setComposante(1, vect[1] + param.getTabVecteur()[1]);
			res.setComposante(2, vect[2] + param.getTabVecteur()[2]);
		}
		return res;
	}

	/** Méthode effectuant une soustraction d'un vecteur avec celui passé en paramètre, renvoyé sous forme d'un troisième vecteur
	 * @param param : le vecteur à soustraire
	 * @return le vecteur différence
	 */
	public Vecteur soustraction(Vecteur param){
		Vecteur res = new Vecteur(0,0,0);
		if (param != null){
			res.setComposante(0, vect[0] - param.getTabVecteur()[0]);
			res.setComposante(1, vect[1] - param.getTabVecteur()[1]);
			res.setComposante(2, vect[2] - param.getTabVecteur()[2]);
		}
		return res;
	}

	/** Méthode effectuant la multiplication des composantes d'un vecteur par un scalaire
	 * @param a : le scalaire qui multipliera le vecteur résultat
	 * @return : le vecteur multiplié
	 */
	public Vecteur multScalaire(double a){
		Vecteur res = new Vecteur(vect[0]*a, vect[1]*a, vect[2]*a);
		return res;
	}

	/** Méthode effectuant un produit scalaire sur deux vecteurs et renvoyant le résultat en double.
	 * @param param : le vecteur qui sera le second memebre du produit scalaire
	 * @return le résultat du produit scalaire sous forme de double.
	 */
	public double prodScalaire(Vecteur param){
		double res =0;
		if (param != null){
			res = vect[0]*param.getTabVecteur()[0]
					+ vect[1]*param.getTabVecteur()[1]
							+ vect[2]*param.getTabVecteur()[2];
		}
		return res;
	}

	/** Méthode de calcul du module d'un vecteur au carré (sans utilisation de pow)
	 * @return : la norme du vecteur au carré
	 */
	public double moduleCarre(){
		return vect[0]*vect[0] + vect[1]*vect[1] + vect[2]*vect[2];
	}

	/** Méthode renvoyant le module d'un vecteur. (avec sqrt)
	 * @return : la norme du vecteur
	 */
	public double module(){
		return Math.sqrt(this.moduleCarre());
	}

	/** Méthode normalisant un vecteur (le divisant par sa norme)
	 * @return : le vecteur normalisé
	 */
	public Vecteur normalise(){
		return this.multScalaire(1/this.module());
	}

}
