package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

public class Tools extends JPanel {

    private JToolBar toolBar;
    private JButton openFileButton;
    private JButton saveFileButton;
    private JButton zoomInButton;
    private JButton zoomOutButton;
    private JButton color1Button;
    private JButton color2Button;

    private JLabel mouseInfo;

    private Mouse mouse;

    private JFileChooser fileChooser;
    private File selectedFile;

    private BufferedImage image;

    private Image zoomInImage;
    private Image zoomOutImage;
    private File zoomInFile;
    private File zoomOutFile;

    public static Color color1;
    public static Color color2;
    public static Color currColor;

    public static int scale = 1;
    private int countScale = 0;

    Iterator iter;

    public Tools(){

        zoomInFile = new File("res/zoom-in.png");
        zoomOutFile = new File("res/zoom-out.png");
        try {
            zoomInImage = ImageIO.read(zoomInFile);
            zoomOutImage = ImageIO.read(zoomOutFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


        fileChooser = new JFileChooser();

        mouse = new Mouse();
        toolBar = new JToolBar();
        openFileButton = new JButton("OPEN FILE");
        saveFileButton = new JButton("SAVE FILE");
        zoomInButton = new JButton();
        zoomInButton.setIcon(new ImageIcon(zoomInImage));
        zoomOutButton = new JButton();
        zoomOutButton.setIcon(new ImageIcon(zoomOutImage));
        mouseInfo = new JLabel();

        color1 = new Color(0,0,0);
        color2 = new Color(255,255,255);
        currColor = color1;

        color1Button = new JButton();
        color1Button.setBackground(color1);
        color1Button.setText("Color 1");

        color2Button = new JButton();
        color2Button.setBackground(color2);
        color2Button.setText("Color 2");

        addMouseMotionListener(mouse);
        addMouseListener(mouse);
        setLayout(new BorderLayout());
        add(mouseInfo, BorderLayout.SOUTH);
        add(toolBar, BorderLayout.NORTH);

        openFileButton.addActionListener(e -> {

            int c = fileChooser.showOpenDialog(null);
            if(c == JFileChooser.APPROVE_OPTION){
                selectedFile = fileChooser.getSelectedFile();
            try {
                image = ImageIO.read(new File(selectedFile.getPath()));
                repaint();
            } catch (IOException e1) {
                e1.printStackTrace();
            }}
        });

        saveFileButton.addActionListener(e -> {
            if (image != null){

                int c = fileChooser.showSaveDialog(null);
                if (c == JFileChooser.APPROVE_OPTION){
                    selectedFile = fileChooser.getSelectedFile();
                    try {
                        ImageIO.write(image, getFileExtension(selectedFile), selectedFile);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        zoomInButton.addActionListener(e -> {
            if (image != null)
                if (countScale < 3) {
                    scale *= 2;
                    countScale++;
                    repaint();
                }
        });


        zoomOutButton.addActionListener(e -> {
            if (image != null)
                if (countScale > 0) {
                    scale /= 2;
                    countScale--;
                    repaint();
                }
        });

        color1Button.addActionListener(e -> {
            Color returnColor = JColorChooser.showDialog(null, "Pick your color", color1);

            if (returnColor != null){
                color1 = returnColor;
                color1Button.setBackground(color1);
            }
        });


        color2Button.addActionListener(e -> {
            Color returnColor = JColorChooser.showDialog(null, "Pick your color", color2);

            if (returnColor != null){
                color2 = returnColor;
                color2Button.setBackground(color2);
            }
        });

        toolBar.add(openFileButton);
        toolBar.add(saveFileButton);
        toolBar.add(zoomInButton);
        toolBar.add(zoomOutButton);
        toolBar.add(color1Button);
        toolBar.add(color2Button);
        toolBar.setFloatable(false);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(255,255,243));
        g.fillRect(0,0,800,600);

        if (image != null)
            g.drawImage(image,0,toolBar.getHeight()+1, scale * image.getWidth(), scale * image.getHeight(), null);

        Vector<Pixel> V = mouse.getLinePoints();
        Vector<Pixel> W = mouse.getPixelPoints();
        
        if (image != null)
            g = image.createGraphics();

        if(V != null && !V.isEmpty()) {
            iter = V.iterator();

            Pixel prev = (Pixel) iter.next();

            g.setColor(prev.getColor());


            while(iter.hasNext()){

                Pixel p = (Pixel) iter.next();

                if (p.getX() == -1 && p.getY() == -1){
                    if (iter.hasNext()){

                        //we meet new line
                        prev = (Pixel) iter.next();

                        //so we maybe have to change a color
                        if (p.getColor() != prev.getColor())
                            g.setColor(prev.getColor());
                    }
                }

                else{
                    g.drawLine(prev.getX() / prev.getScale(), (prev.getY() - (toolBar.getHeight()+1))/prev.getScale(), p.getX()/p.getScale(), (p.getY() - (toolBar.getHeight()+1))/p.getScale());
                    prev = p;
                }
            }
        }

        if (W != null && !W.isEmpty()){

            for (Pixel px : W){
                g.setColor(px.getColor());
                g.drawRect(px.getX()/px.getScale(), (px.getY() - (toolBar.getHeight()+1))/px.getScale(),1,1);
            }
        }

    }

    public void update(){
        mouseInfo.setText(Integer.toString(mouse.getX()) + " " + Integer.toString(mouse.getY()));
        repaint();
    }

    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf + 1);
    }
}
