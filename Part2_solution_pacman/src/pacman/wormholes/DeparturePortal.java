package pacman.wormholes;

import java.util.Set;

import pacman.Square;

public class DeparturePortal {

	Square departSquare;
	Set<Wormhole> wormholes;
	
	public Square getSquare() { return departSquare;}
	
	public Set<Wormhole> getWormholes(){ return Set.copyOf(wormholes);}
	
	public DeparturePortal(Square departSquare) {
		this.departSquare = departSquare;
	}
	
}
