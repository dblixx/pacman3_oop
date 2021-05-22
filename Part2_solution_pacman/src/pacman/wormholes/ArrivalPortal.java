package pacman.wormholes;

import java.util.Set;

import pacman.Square;

public class ArrivalPortal {

	Square arriveSquare;
	Set<Wormhole> wormholes;
	
	public Square getSquare() { return arriveSquare;}
	
	public Set<Wormhole> getWormholes(){ return Set.copyOf(wormholes);}
	
	public ArrivalPortal(Square arriveSquare) {
		this.arriveSquare = arriveSquare;
	}
	
}
