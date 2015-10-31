package backtracking;

import java.util.Iterator;
import java.util.Stack;

import com.sun.javafx.geom.Point2D;


public class Rat {
	
	private String name = "Rat";
	private Stack<Point2D> rat_path = new Stack();
	
	public Rat(String name) {
		this.name = name;
		System.out.println("A new rat, named " + this.name +  " was born!");
	}
	
	public enum Movement {
		UP, DOWN, RIGHT, LEFT
	}
	
	public void start(Maze maze) {
		if (findPath(maze, 0, 0, Movement.RIGHT)) {
			System.out.println("FOUND");
//			System.out.println(this.rat_path.toString());
		} else {
			System.out.println("NO PATH FOUND");
		}
	}
	
	private boolean contains_point(int x, int y) {
		Point2D point = new Point2D();
		point.x = x;
		point.y = y;
		for (Point2D point2d : rat_path) {
			if (point2d.x == point.x && point2d.y == point.y) {
				System.out.println("We were already HERE!!!" 
						+ " x=" + point.x 
						+ " y=" + point.y);
				return true;
			} 
		}
		return false;
	}
	
	
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
