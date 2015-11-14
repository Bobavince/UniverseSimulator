public class Vecteur{
	
	private double[] vect = new double[3];
	
	public Vecteur(double x, double y, double z){
		vect[0] = x;
		vect[1] = y;
		vect[2] = z;
	}
	
	public double[] getTabVecteur(){
		return vect;
	}
	
	public void setComposante(int composante,double a){
		vect[composante] = a;
	}
	
	public boolean equals(Vecteur param){
		boolean res = false;
		if (param != null){
			res = (vect[0] == param.getTabVecteur()[0])
					&& (vect[1] == param.getTabVecteur()[1])
					&& (vect[2] == param.getTabVecteur()[2]);
		}
		return res;
	}
	
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	public String toString(){
		return "("+vect[0]+","+vect[1]+","+vect[2]+")";
	}
	
	public Vecteur addition(Vecteur param){ // Vecteur ou void ? modif irréversible du vecteur ?
		Vecteur res = new Vecteur(0,0,0);
		if (param != null){
			res.setComposante(0, vect[0] + param.getTabVecteur()[0]);
			res.setComposante(1, vect[1] + param.getTabVecteur()[1]);
			res.setComposante(2, vect[2] + param.getTabVecteur()[2]);
		}
		return res;
	}
	
	public Vecteur soustraction(Vecteur param){
		Vecteur res = new Vecteur(0,0,0);
		if (param != null){
			res.setComposante(0, vect[0] - param.getTabVecteur()[0]);
			res.setComposante(1, vect[1] - param.getTabVecteur()[1]);
			res.setComposante(2, vect[2] - param.getTabVecteur()[2]);
		}
		return res;
	}
	
	public Vecteur multScalaire(double a){
		Vecteur res = new Vecteur(vect[0]*a, vect[1]*a, vect[2]*a);
		return res;
	}
	
	public double prodScalaire(Vecteur param){
		double res =0;
		if (param != null){
			res = vect[0]*param.getTabVecteur()[0]
					+ vect[1]*param.getTabVecteur()[1]
					+ vect[2]*param.getTabVecteur()[2];
		}
		return res;
	}
	
	public double moduleCarre(){
		return vect[0]*vect[0] + vect[1]*vect[1] + vect[2]*vect[2];
	}
	
	public double module(){
		return Math.sqrt(this.moduleCarre());
	}
	
	public Vecteur normalise(){
		return this.multScalaire(1/this.module());
	}
	
}
