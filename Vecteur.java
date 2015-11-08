public class Vecteur{
	
	private double x; // ou tableau de 3 cases ?
	private double y;
	private double z;
	
	public Vecteur(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getComposante(char comp){
		double res;
		if (comp == 'x'){
			res = x;
		} else if (comp == 'y'){
			res = y;
		} else {
			res = z;
		}
		return res;
	}
	
	public boolean equals(Vecteur param){
		boolean res = (x == param.getComposante('x'))
						&& (y == param.getComposante('y'))
						&& (z == param.getComposante('z'));
		return res;
	}
	
	public String toString(){
		return "("+x+","+y+","+z+")";
	}
	
	public Vecteur addition(Vecteur param){ // Vecteur ou void ? modif irréversible du vecteur ?
		double resx = x + param.getComposante('x');
		double resy = y + param.getComposante('y');
		double resz = z + param.getComposante('z');
		Vecteur res = new Vecteur(resx, resy, resz);
		return res;
	}
	
	public Vecteur soustraction(Vecteur param){
		double resx = x - param.getComposante('x');
		double resy = y - param.getComposante('y');
		double resz = z - param.getComposante('z');
		Vecteur res = new Vecteur(resx, resy, resz);
		return res;
	}
	
	public Vecteur multScalaire(double a){
		Vecteur res = new Vecteur(x*a, y*a, z*a);
		return res;
	}
	
	public double prodScalaire(Vecteur param){
		double res = x*param.getComposante('x') 
						+ y*param.getComposante('y')
						+ z*param.getComposante('z');	
		return res;
	}
	
	public double moduleCarre(){
		return x*x + y*y + z*z;
	}
	
	public double module(){
		return Math.sqrt(this.moduleCarre());
	}
	
}
