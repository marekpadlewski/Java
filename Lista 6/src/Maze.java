import java.awt.*;
import java.util.*;

public class Maze {

    public int height, width;
    private int[][] maze;
    private int[][] moves;
    public Point startPoint;
    public Point endPoint;
    private int maxPath = 0;


    public Maze(int height, int width) {
        this.height = height;
        this.width = width;
        maze = new int[height][width];
        moves = new int[height][width];
        startPoint = new Point();
        endPoint = new Point(1,width - 2);

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                moves[i][j] = 0;

    }

    public int[][] generateMaze() {

        // initialize
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                maze[i][j] = 1;

        //starting point in right top corner
        int r = 1;
        int c = width - 2;

        maze[r][c] = 0;

        dfs(r, c);

        return maze;
    }

    private void dfs(int r, int c) {

        //counting path with max length
        if (moves[r][c] > maxPath){
            maxPath = moves[r][c];
            startPoint.x = r;
            startPoint.y = c;
        }

        // 4 random directions
        Integer[] randDirs = genRandDirs();

        //Examine each directions
        for (Integer randDir : randDirs) {

            switch (randDir) {
                case 1:
                    //whether 2 cells up is out or not
                    if (r - 2 <= 0)
                        continue;

                    if (maze[r - 2][c] == 1) {
                        maze[r - 2][c] = 0;
                        maze[r - 1][c] = 0;

                        moves[r - 1][c] = moves[r][c] + 1;
                        moves[r - 2][c] = moves[r - 1][c] + 1;

                        dfs(r - 2, c);
                    }
                    break;
                case 2:
                    //whether 2 cells right is out or not
                    if (c + 2 >= width - 1)
                        continue;

                    if (maze[r][c + 2] == 1) {
                        maze[r][c + 2] = 0;
                        maze[r][c + 1] = 0;

                        moves[r][c + 1] = moves[r][c] + 1;
                        moves[r][c + 2] = moves[r][c + 1] + 1;

                        dfs(r, c + 2);
                    }
                    break;
                case 3:
                    //whether 2 cells left is out or not
                    if (c - 2 <= 0)
                        continue;

                    if (maze[r][c - 2] == 1) {
                        maze[r][c - 2] = 0;
                        maze[r][c - 1] = 0;

                        moves[r][c - 1] = moves[r][c] + 1;
                        moves[r][c - 2] = moves[r][c - 1] + 1;

                        dfs(r, c - 2);
                    }
                    break;
                case 4:
                    //whether 2 cells down is out or not
                    if (r + 2 >= height - 1)
                        continue;

                    if (maze[r + 2][c] == 1) {

                        maze[r + 2][c] = 0;
                        maze[r + 1][c] = 0;

                        moves[r + 1][c] = moves[r][c] + 1;
                        moves[r + 2][c] = moves[r + 1][c] + 1;

                        dfs(r + 2, c);
                    }
                    break;
            }
        }

    }

    private Integer[] genRandDirs() {
        ArrayList<Integer> rands = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            rands.add(i + 1);
        }
        Collections.shuffle(rands);

        return rands.toArray(new Integer[4]);

    }
}