package pacman.wormholes;

import java.util.HashSet;
import java.util.Set;

import pacman.Square;

/**
 * @invar | getSquare() != null
 * @invar | getWormholes() != null
 * @invar | getWormholes().stream().allMatch(w -> w != null && w.getArrivalPortal().equals(this))
 *
 */
public class ArrivalPortal {

	/**
	 * @invar | arriveSquare != null
	 */
	Square arriveSquare;
	
	/**
	 * @invar | wormholes != null
	 * @invar | wormholes.stream().allMatch(w -> w != null && w.getArrivalPortal().equals(this))
	 * @representationObject
	 * @peerObjects
	 */
	Set<Wormhole> wormholes = new HashSet<>();
	
	public Square getSquare() { return arriveSquare;}
	
	/**
	 * @basic
	 * @creates | results
	 * @peerObjects
	 */
	public Set<Wormhole> getWormholes(){ return Set.copyOf(wormholes);}
	
	/**
	 * @mutates_properties | this.getSquare()
	 * @thows IllegalArgumentException | arriveSqaure == null
	 * @post | getSquare() == arriveSquare
	 * @post | getWormholes().isEmpty()
	 */
	public ArrivalPortal(Square arriveSquare) {
		if(arriveSquare == null)
			throw new IllegalArgumentException("The arriveSquare is null");
		this.arriveSquare = arriveSquare;
	}

}
