
public class EtoileNaineRouge extends Particule {

	public EtoileNaineRouge(double x,double y,double z,double vx,double vy,double vz,double ax,double ay,double az, boolean vraiParticule){
		super(x,y,z,vx,vy,vz,ax,ay,az,4000000.0,"Naine rouge",100000.0, vraiParticule);
	}
	
	public String toString(){
		return super.toString();
	}
}
