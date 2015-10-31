package backtracking;

/**
 * This will represent the mace for our mice, 1s show allowed positions!
 * @author Georg Kasper
 * @date   10/27/2015
 */
public class Maze {
	
	int [][] maze = 
		{ // y = 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16  
				{1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // x = 0
				{1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1}, // x = 1
				{1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1}, // x = 2
				{1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, // x = 3
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // x = 4
		};
	
	public int cheese_x = 2;
	public int cheese_y = 10;
	
	public Maze() {}
	public Maze(int[][] maze, int cheese_x_pos, int cheese_y_pos) {
		this.maze = maze;
		this.cheese_x = cheese_x_pos;
		this.cheese_y = cheese_y_pos;
	}
	
	public boolean allowedPosition(int x, int y) {
		if (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length 
				&& maze[x][y] != 0) {
			return true;
		}
		return false;
	}
}

