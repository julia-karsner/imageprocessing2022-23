import processing.core.PImage;
public class Panel {//class definition
    // private instance variables
    private PImage img;
    private int x;
    private int y;
    private int w;
    private int h;


    public Panel(int _x, int _y, int _w, int _h) {//constructor
        x = _x;
        y = _y;
        w = _w;
        h = _h;
    }

    public void setupImage(String imageName) {
        img = Main.app.loadImage(imageName);
    }//method

    public void display() {
        Main.app.image(img, x, y, w, h);
    }//method

    public void handleMouseClicked(int _x, int _y) {
        System.out.println("Mouse clicked ");
    }//method

    public PImage getImageCopy() {
        return img.copy();
    }//getter method


    public int getX() {
        return x;
    }//getter method

    public int getY() {
        return y;
    }//getter method

    public void setX(int _x) {
        x = _x;
    }//setter method

    public void setY(int _y) {
        y = _y;
    }//setter method

    public int getWidth() {
        return w;
    }//getter method

    public int getHeight() {
        return h;
    }//getter method
}