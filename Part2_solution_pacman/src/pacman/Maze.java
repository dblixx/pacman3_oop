package pacman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import pacman.wormholes.ArrivalPortal;
import pacman.wormholes.DeparturePortal;
import pacman.wormholes.Wormhole;

public class Maze {
	
	private Random random;
	private MazeMap map;
	private PacMan pacMan;
	private Ghost[] ghosts;
	private FoodItem[] foodItems;
	private List<DeparturePortal> departurePortals;
	private List<ArrivalPortal> arrivalPortals;
	private List<Wormhole> wormholes = new ArrayList<>();
	
	public MazeMap getMap() { return map; }
	
	public PacMan getPacMan() { return pacMan; }
	
	public Ghost[] getGhosts() { return ghosts.clone(); }
	
	public FoodItem[] getFoodItems() { return foodItems.clone(); }
	
	public DeparturePortal[] getDeparturePortals() { return (DeparturePortal[]) departurePortals.toArray(new DeparturePortal[0]); }
	
	public ArrivalPortal[] getArrivalPortals() { return (ArrivalPortal[]) arrivalPortals.toArray(new ArrivalPortal[0]); }
	
	public Wormhole[] getWormholes(){ return (Wormhole[]) wormholes.toArray(new Wormhole[0]); }
	
	public Maze(Random random, MazeMap map, PacMan pacMan, Ghost[] ghosts, FoodItem[] foodItems, DeparturePortal[] dps, ArrivalPortal[] aps) {
		this.random = random;
		this.map = map;
		this.pacMan = pacMan;
		this.ghosts = ghosts.clone();
		this.foodItems = foodItems.clone();
		this.departurePortals = Arrays.asList(dps);
		this.arrivalPortals = Arrays.asList(aps);
	}
	
	public boolean isCompleted() {
		return foodItems.length == 0;
	}
	
	private void checkPacManDamage() {
		for (Ghost ghost : ghosts)
			if (ghost.getSquare().equals(pacMan.getSquare()))
				ghost.hitBy(pacMan);
	}
	
	public void moveGhosts() {
		for (Ghost ghost : ghosts)
			ghost.move(random);
		checkPacManDamage();
	}
	
	public void pacManAtePowerPellet() {
		for (Ghost ghost : ghosts)
			ghost.pacManAtePowerPellet();
	}
	
	private void removeFoodItemsAtIndex(int index) {
		FoodItem[] newFoodItems = new FoodItem[foodItems.length - 1];
		System.arraycopy(foodItems, 0, newFoodItems, 0, index);
		System.arraycopy(foodItems, index + 1, newFoodItems, index, newFoodItems.length - index);
		foodItems = newFoodItems;
	}
	
	private void checkFoodItemCollision(Square square) {
		for (int i = 0; i < foodItems.length; i++) {
			if (foodItems[i].getSquare().equals(square)) {
				foodItems[i].eatenByPacMan(this);
				removeFoodItemsAtIndex(i);
				return;
			}
		}
	}
	
	public void movePacMan(Direction direction) {
		Square newSquare = pacMan.getSquare().getNeighbor(direction);
		if (newSquare.isPassable()) {
			for(DeparturePortal dp: departurePortals) {
				if(dp.getSquare().equals(newSquare)) {
					if(!(dp.getWormholes().isEmpty())) {
						Wormhole[] wormholeArray = (Wormhole[]) dp.getWormholes().toArray(new Wormhole[0]);
						Wormhole chosenWormhole = wormholeArray[random.nextInt(wormholeArray.length)];
						newSquare = chosenWormhole.getArrivalPortal().getSquare();
						checkPacManDamage();
					}
				}
			}
			pacMan.setSquare(newSquare);
			checkFoodItemCollision(newSquare);
			checkPacManDamage();
		}
	}
	
	public void addWormhole(Wormhole wormhole) {
		if(!(this.departurePortals.contains(wormhole.getDeparturePortal())))
			throw new IllegalArgumentException("The departure portals are not consistent.");
		if(!(this.arrivalPortals.contains(wormhole.getArrivalPortal())))
			throw new IllegalArgumentException("The arrival portals are not consistent.");
		this.wormholes.add(wormhole);
	}
	
}
