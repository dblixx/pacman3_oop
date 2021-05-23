package pacman.wormholes;

import java.util.HashSet;
import java.util.Set;

import pacman.Square;

public class ArrivalPortal {

	Square arriveSquare;
	Set<Wormhole> wormholes = new HashSet<>();
	
	public Square getSquare() { return arriveSquare;}
	
	public Set<Wormhole> getWormholes(){ return Set.copyOf(wormholes);}
	
	public ArrivalPortal(Square arriveSquare) {
		this.arriveSquare = arriveSquare;
	}

}
