package backtracking;

public class Rat {
	
	String name = "Rat";
	
	public Rat(String name) {
		this.name = name;
		System.out.println("A new rat, named " + this.name +  " was born!");
	}
	
	public enum Movement {
		UP, DOWN, RIGHT, LEFT
	}
	
	public void start(Maze maze) {
		if (findPath(maze, 0, 0, Movement.DOWN)) {
			System.out.println("FOUND");
		} else {
			System.out.println("NO PATH FOUND");
		}
	}
	
	public boolean findPath(Maze maze, int rat_x, int rat_y, Movement mv) {
		if (rat_x == maze.cheese_x && rat_y == maze.cheese_y) {
			return true;
		}
		
		if (maze.allowedPosition(rat_x, rat_y)) {
			System.out.println("x=" + rat_x + "| y=" + rat_y);
			if (mv != Movement.DOWN && findPath(maze, 
					rat_x - 1, rat_y, Movement.UP)) {
				return true;
			}
			if (mv != Movement.UP &&findPath(maze, 
					rat_x + 1, rat_y, Movement.DOWN)) {
				return true;
			}
			if (mv != Movement.RIGHT && findPath(maze, 
					rat_x, rat_y - 1, Movement.LEFT)) {
				return true;
			}
			if (mv != Movement.LEFT && findPath(maze, 
					rat_x, rat_y + 1, Movement.RIGHT)) {
				return true;
			}
		}
		return false;
	}
}
