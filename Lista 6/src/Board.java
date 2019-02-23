import java.awt.*;
import java.io.File;
import java.io.IOException;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.imageio.ImageIO;

public class Board extends Canvas{

    private Explorer explorer;
    private Maze maze;
    public static int[][] grid;
    private File pathFile;
    private File wallFile;
    private File exitFile;
    private File endFile;
    private Image pathImg;
    private Image wallImg;
    private Image exitImg;
    private Image endImg;
    public static int cellSize = 38;
    public static int wallID = 1;

    private boolean finished = false;


    public Board() {

        maze = new Maze(19,19);
        grid = maze.generateMaze();

        explorer = new Explorer(maze.startPoint.y * cellSize, maze.startPoint.x * cellSize);

        try {
            pathFile = new File("res/path.jpg");
            wallFile = new File("res/wall.png");
            exitFile = new File("res/exit.png");
            endFile = new File("res/end.png");
            pathImg = ImageIO.read(pathFile);
            wallImg = ImageIO.read(wallFile);
            exitImg = ImageIO.read(exitFile);
            endImg = ImageIO.read(endFile);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        addKeyListener(new TAdapter());

    }

    public void paint(Graphics g){
        //calling super class method paint
        super.paint(g);

        //drawing background
        for (int i = 0 ; i < maze.height ; i++){
            for (int j = 0 ; j < maze.width ; j++){
                g.drawImage(pathImg, j*cellSize, i*cellSize, this);

                if (grid[i][j] == 1)
                    g.drawImage(wallImg, j * cellSize, i * cellSize, this);

            }
        }

        //drawing end point
        g.drawImage(exitImg, maze.endPoint.y * cellSize, maze.endPoint.x * cellSize, this);

        //drawing explorer
        if (!finished)
            explorer.paint(g);

        if (finished)
            g.drawImage(endImg,0,0, this);

        Toolkit.getDefaultToolkit().sync();

    }


    private void action() {

        if (!finished && explorer.currID.getX() == maze.endPoint.y && explorer.currID.getY() == maze.endPoint.x){
            finished = true;
            repaint();
        }


        if (!finished)
            repaint(explorer.getX() - 5,explorer.getY() - 5,50,50);

    }

    private class TAdapter extends KeyAdapter {


        @Override
        public void keyPressed(KeyEvent e) {
            explorer.keyPressed(e);
            action();
        }
    }
}
