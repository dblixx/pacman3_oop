package pacman.wormholes;

public class Wormhole {
	
	/**
	 * @invar | ap != null
	 * @invar | ap.wormholes.contains(this)
	 * @peerObject
	 */
	ArrivalPortal ap;
	
	/**
	 * @invar | dp != null
	 * @invar | dp.wormholes.contains(this)
	 * @peerObject
	 */
	DeparturePortal dp;
	
	/**
	 * @basic
	 * @peerObject
	 */
	public DeparturePortal getDeparturePortal() { return dp; }
	
	/**
	 * @basic
	 * @peerObject
	 */
	public ArrivalPortal getArrivalPortal() { return ap; }
	
	/**
	 * @throws IllegalArgumentException | ap == null
	 * @mutates_properties | ap.getWormholes(), this.getArrivalPortal()
	 * @post | this.getArrivalPortal() == ap
	 * @post | (ap == old(this.getArrivalPortal()) && ap == this.getArrivalPortal()) || ap == this.getArrivalPortal()
	 */
	public void setArrivalPortal(ArrivalPortal ap) { 
		if(ap == null)
			throw new IllegalArgumentException("The arrivalPortal is null");
		
		this.ap.wormholes.remove(this);
		this.ap = ap; 
		ap.wormholes.add(this);
	}
	
	/**
	 * @throws IllegalArgumentException | dp == null
	 * @mutates_properties | dp.getWormholes(), this.getDeparturePortal()
	 * @post | this.getDeparturePortal() == dp
	 * @post | (dp == old(this.getDeparturePortal()) && dp == this.getDeparturePortal()) || dp == this.getDeparturePortal()
	 */
	public void setDeparturePortal(DeparturePortal dp) { 
		if(dp == null)
			throw new IllegalArgumentException("The depaturePortal is null");
	
		this.dp.wormholes.remove(this);
		this.dp = dp; 
		dp.wormholes.add(this);
	}
	
	/**
	 * @throws IllegalArgumentException | dp == null
	 * @throws IllegalArgumentException | ap == null
	 * @mutates_properties | getDeparturePortal(), getArrivalPortal(), dp.getWormholes(), ap.getWormholes()
	 * @post | getDeparturePortal() == dp
	 * @post | getArrivalPortal() == ap
	 * @post | dp.getWormholes().contains(this)
	 * @post | ap.getWormholes().contains(this)
	 */
	public Wormhole(DeparturePortal dp, ArrivalPortal ap) {
		if(dp == null)
			throw new IllegalArgumentException("The departurePortal is null");
		if(ap == null)
			throw new IllegalArgumentException("The arrivalPortal is null");
		
		this.dp = dp;
		this.ap = ap;
		dp.wormholes.add(this);
		ap.wormholes.add(this);
	}
	
}
