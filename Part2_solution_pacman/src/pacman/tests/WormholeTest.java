package pacman.tests;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import pacman.MazeMap;
import pacman.wormholes.ArrivalPortal;
import pacman.wormholes.DeparturePortal;
import pacman.wormholes.Wormhole;
import pacman.Square;

class WormholeTest extends TestCase {
	
	MazeMap mazeMap = new MazeMap(4, 3, new boolean[] {
			true, false, true, true,
			true, true, false, true,
			false, true, true, true
	});
	
	@Test
	void test() {
		Square s1 = Square.of(mazeMap, 0, 1);
		Square s2 = Square.of(mazeMap, 0, 0);
		Square s3 = Square.of(mazeMap, 1, 2);
		Square s4 = Square.of(mazeMap, 2, 3);
		
		DeparturePortal dp1 = new DeparturePortal(s1);
		assertEquals(dp1.getSquare(), s1);
		assertTrue(dp1.getWormholes().isEmpty());
		
		ArrivalPortal ap1 = new ArrivalPortal(s2);
		assertEquals(ap1.getSquare(), s2);
		assertTrue(ap1.getWormholes().isEmpty());
		
		DeparturePortal dp2 = new DeparturePortal(s3);
		ArrivalPortal ap2 = new ArrivalPortal(s4);
		
		Wormhole w1 = new Wormhole(dp1, ap1);
		assertEquals(dp1, w1.getDeparturePortal());
		assertEquals(ap1, w1.getArrivalPortal());
		assertTrue(dp1.getWormholes().contains(w1));
		assertTrue(ap1.getWormholes().contains(w1));
		
		w1.setArrivalPortal(ap2);
		assertEquals(ap2, w1.getArrivalPortal());
		assertTrue(ap2.getWormholes().contains(w1));
		
		w1.setDeparturePortal(dp2);
		assertEquals(dp2, w1.getDeparturePortal());
		assertTrue(dp2.getWormholes().contains(w1));
		
	}
	
}
