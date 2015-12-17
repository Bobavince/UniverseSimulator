
public class Terre extends Particule {
	
	public Terre(double x,double y,double z,double vx,double vy,double vz,double ax,double ay,double az, boolean vraiParticule){
		super(x,y,z,vx,vy,vz,ax,ay,az,5.9,"Terre",6371000.0, vraiParticule);
	}
	
	public String toString(){
		return super.toString();
	}

}
