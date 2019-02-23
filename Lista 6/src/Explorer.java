import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Explorer {

    private int posX;
    private int posY;
    private int vel;

    private int height;
    private int width;

    public Point currID;

    private File playerFile;
    private Image playerImg;


    public Explorer(int startX, int startY){
        posX = startX;
        posY = startY;
        vel = 5;
        currID = new Point();

        try {

            playerFile = new File("res/buka_smaller.png");
            playerImg = ImageIO.read(playerFile);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        height = playerImg.getHeight(null);
        width = playerImg.getWidth(null);

    }

    public void paint(Graphics g){
        g.drawImage(playerImg, posX, posY, null);
    }


    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        //ID of current cell
        currID.x = (int) Math.floor(posX / Board.cellSize);
        currID.y = (int) Math.floor(posY / Board.cellSize);

        // distance bt right end of explorer and cell od the right
        int distXL = Math.abs(posX - currID.x * Board.cellSize);
        int distXR = Math.abs(posX + width - (currID.x + 1) * Board.cellSize);
        int distYU = Math.abs(posY - currID.y * Board.cellSize);
        int distYD = Math.abs(posY + height - (currID.y + 1) * Board.cellSize);


        if (key == KeyEvent.VK_LEFT) {

            if (distXL < vel && Board.grid[currID.y][currID.x - 1] == Board.wallID){
                posX += -distXL;
            }

            else
                posX += -vel;

        }

        if (key == KeyEvent.VK_RIGHT) {

            if (distXR < vel && Board.grid[currID.y][currID.x + 1] == Board.wallID){
                posX += distXR;
            }

            else
                posX += vel;
        }

        if (key == KeyEvent.VK_UP) {

            if (distYU < vel && Board.grid[currID.y - 1][currID.x] == Board.wallID){
                posY += -distYU;
            }

            else
                posY += -vel;
        }

        if (key == KeyEvent.VK_DOWN) {

            if (distYD < vel && Board.grid[currID.y + 1][currID.x] == Board.wallID){
                posY += distYD;
            }

            else
                posY += vel;
        }
    }

    public int getX(){
        return posX;
    }


    public int getY(){
        return posY;
    }

}
