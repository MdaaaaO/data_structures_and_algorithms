package backtracking;

public class MazeRatMain {

	public static void main(String[] args) {
		Maze maze = new Maze();
		Rat rat = new Rat("Sniffy");
		rat.start(maze);
	}
}
