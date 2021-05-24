package pacman.wormholes;

import java.util.HashSet;
import java.util.Set;

import pacman.Square;

/**
 * @invar | getSquare() != null
 * @invar | getWormholes() != null
 * @invar | getWormholes().stream().allMatch(wormhole -> wormhole != null && wormhole.getDeparturePortal().equals(this))
 */

public class DeparturePortal {
	
	/**
	 * @invar | departSquare != null
	 */
	Square departSquare;
	
	/**
	 * @invar | wormholes != null
	 * @invar | wormholes.stream().allMatch(wormhole -> wormhole != null && wormhole.getDeparturePortal().equals(this))
	 * @representationObject
	 * @peerObjects
	 */	
	Set<Wormhole> wormholes = new HashSet<>();
	
	public Square getSquare() { return departSquare;}
	
	/**
	 * @basic
	 * @creates | result
	 * @peerObjects
	 */
	public Set<Wormhole> getWormholes(){ return Set.copyOf(wormholes);}
	
	/**
	 * @mutates_properties | this.getSquare()
	 * @throws IllegalArugumentException | departSquare == null
	 * @post | getSquare() == departSquare
	 * @post | getWormholes().isEmpty()
	 */
	public DeparturePortal(Square departSquare) {
		if(departSquare == null)
			throw new IllegalArgumentException("The departSquare is null");
		
		this.departSquare = departSquare;
	}
	
}
