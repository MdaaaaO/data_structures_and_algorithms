package backtracking;

import java.util.Stack;
import com.sun.javafx.geom.Point2D;


public class Rat {
	
	private String name = "Rat";
	private Stack<Point2D> rat_path = new Stack<Point2D>();
	
	/**
	 * Constructor which will give our rat name.
	 * @param name
	 */
	public Rat(String name) {
		this.name = name;
		System.out.println("A new rat, named " + this.name +  " was born!");
	}
	
	/**
	 * We will use this enums to move our rat around the maze.
	 * @author Kasper
	 *
	 */
	public enum Movement {
		UP, DOWN, RIGHT, LEFT
	}
	
	/**
	 * This method takes a maze as an input and starts the findPath() method
	 * which uses a recursive backtracking algorithm to find the cheese in the
	 * maze.
	 * @printout FOUND or NO PATH FOUND
	 * @param maze
	 */
	public void start(Maze maze) {
		if (findPath(maze, 0, 0, Movement.RIGHT)) {
			System.out.println("FOUND");
		} else {
			System.out.println("NO PATH FOUND");
		}
	}
	
	/**
	 * We use this method to check whether the next position of the rat is 
	 * already one where we have been.
	 * @param x
	 * @param y
	 * @return true if we were already there
	 */
	private boolean contains_point(int x, int y) {
		Point2D point = new Point2D();
		point.x = x;
		point.y = y;
		for (Point2D point2d : this.rat_path) {
			if (point2d.x == point.x && point2d.y == point.y) {
				System.out.println("We were already HERE!!!" 
						+ " x=" + point.x 
						+ " y=" + point.y);
				return true;
			} 
		}
		return false;
	}
	
	/**
	 * This is an recursive backtracking implementation, we start to check
	 * from our starting cell whether we can go UP - DOWN - LEFT - RIGHT, to
	 * avoid going UP and DOWN all the time we also check the last movement of
	 * our Rat.
	 * 
	 * 		Explanation: If we just moved UP, then we will skip the move DOWN 
	 * 					 step, etc.
	 * 
	 * We also want to avoid, that our Rat will move in a circle. That is why 
	 * we are using a stack to collect our visited cells. 
	 * 
	 * 		Explanation: If going LEFT will bring us to a visited cell, we won't
	 *            		 make this move.
	 * 
	 * We are also using an allowedPosition() method from our Maze implementation,
	 * to make sure that the next move is save for our rat. (We don't want to 
	 * hit a wall or move out of the maze)
	 * 
	 * @param Maze maze
	 * @param int rat_x
	 * @param int rat_y
	 * @param enum Movement
	 * @return true / false
	 */
	private boolean findPath(Maze maze, int rat_x, int rat_y, Movement mv) {
		
		if (maze.allowedPosition(rat_x, rat_y)) {
			System.out.println("x=" + rat_x + "| y=" + rat_y);
			Point2D xy_point = new Point2D();
			xy_point.x = rat_x;
			xy_point.y = rat_y;
			this.rat_path.push(xy_point);
			
			if (rat_x == maze.cheese_x && rat_y == maze.cheese_y) {
				return true;
			}

			if (mv != Movement.DOWN && !contains_point(rat_x - 1, rat_y) 
					&& findPath(maze, rat_x - 1, rat_y, Movement.UP)) {
				return true;
			}
			if (mv != Movement.UP && !contains_point(rat_x + 1, rat_y)
					&& findPath(maze, rat_x + 1, rat_y, Movement.DOWN)) {
				return true;
			}
			if (mv != Movement.RIGHT && !contains_point(rat_x, rat_y - 1)
					&& findPath(maze, rat_x, rat_y - 1, Movement.LEFT)) {
				return true;
			}
			if (mv != Movement.LEFT && !contains_point(rat_x, rat_y + 1) 
					&& findPath(maze, rat_x, rat_y + 1, Movement.RIGHT)) {
				return true;
			}
			// If no more movement is possible we go one cell back and pop the
			// current cell out of our mind.
			this.rat_path.pop();
		}
		return false;
	}
}
