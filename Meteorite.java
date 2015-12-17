
public class Meteorite extends Particule {
	
	public Meteorite(double x,double y,double z,double vx,double vy,double vz,double ax,double ay,double az, boolean vraiParticule){
		super(x,y,z,vx,vy,vz,ax,ay,az,0.000000007,"Meteorite Tcheliabinsk",10.200000,  vraiParticule);
	}
	
	public String toString(){
		return super.toString();
	}
	

}
