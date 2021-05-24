package pacman.wormholes;

public class Wormhole {

	ArrivalPortal ap;
	DeparturePortal dp;
	
	public DeparturePortal getDeparturePortal() { return dp; }
	
	public ArrivalPortal getArrivalPortal() { return ap; }
	
	public void setArrivalPortal(ArrivalPortal ap) { 
		this.ap.wormholes.remove(this);
		this.ap = ap; 
		ap.wormholes.add(this);
	}
	
	public void setDeparturePortal(DeparturePortal dp) { 
		this.dp.wormholes.remove(this);
		this.dp = dp; 
		dp.wormholes.add(this);
	}
	
	public Wormhole(DeparturePortal dp, ArrivalPortal ap) {
		this.dp = dp;
		this.ap = ap;
		dp.wormholes.add(this);
		ap.wormholes.add(this);
	}
	
}
