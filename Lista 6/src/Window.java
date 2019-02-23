import java.awt.*;

public class Window extends Frame {

    public Window(){
        super("Maze Game");
        setSize(722,750);
        setLocationRelativeTo(null);
        setResizable(false);
        Board board = new Board();
        add(board);
        setVisible(true);
    }

}
