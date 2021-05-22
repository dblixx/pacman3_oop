package pacman.wormholes;

public class Wormhole {

	ArrivalPortal ap;
	DeparturePortal dp;
	
	public DeparturePortal getDeparturePortal() { return dp; }
	
	public ArrivalPortal getArrivalPortal() { return ap; }
	
	public void setArrivalPortal(ArrivalPortal ap) { this.ap = ap; }
	
	public void setDeparturePortal(DeparturePortal dp) { this.dp = dp; }
	
	public Wormhole(ArrivalPortal ap, DeparturePortal dp) {
		this.ap = ap;
		this.dp = dp;
	}
	
}
