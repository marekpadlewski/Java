package graphics;

import java.awt.*;

public class Pixel {

    private int x;
    private int y;
    private Color color;
    private int scale;

    public Pixel(int x, int y, Color color, int scale){
        this.x = x;
        this.y = y;
        this.color = color;
        this.scale = scale;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public int getScale(){
        return scale;
    }
}
