package graphics;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

public class Mouse implements MouseMotionListener, MouseListener {

    private int x;
    private int y;

    private Vector<Pixel> v = new Vector<>(); //vector of points to make a lines
    private Vector<Pixel> w = new Vector<>(); //vector of points to make single pixels

    private boolean drag = false;

    public boolean left = false;
    public boolean right = false;


    public Mouse(){}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        drag = true;

        x = e.getX();
        y = e.getY();

        updateColor();

        Color c = Tools.currColor;
        v.add(new Pixel(x, y, c, Tools.scale));

        Main.tools.update();

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        Main.tools.update();
    }

    public Vector getLinePoints() { return v; }
    public Vector getPixelPoints() { return w;}

    @Override
    public void mouseReleased(MouseEvent e) {

        if (left)
            left = false;

        if (right)
            right = false;

        updateColor();


        if (drag){
            //If we finish line, add (-1,-1) to mark the finish
            v.add(new Pixel(-1, -1, v.get(v.size()-1).getColor(), v.get(v.size()-1).getScale()));
            drag = false;
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        Color c = Tools.currColor;
        w.add(new Pixel(x, y, c, Tools.scale));

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getButton() == MouseEvent.BUTTON1 && !right)
            left = true;
        if (e.getButton() == MouseEvent.BUTTON3 && !left)
            right = true;

        updateColor();


    }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    private void updateColor(){
        if (left)
            Tools.currColor = Tools.color1;

        if (right)
            Tools.currColor = Tools.color2;

    }
}
