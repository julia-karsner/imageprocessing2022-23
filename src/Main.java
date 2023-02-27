import processing.core.PApplet;
import java.util.Random;

import java.util.ArrayList;
public class Main extends PApplet { //subclass definition
    final int NUM_PANELS_HORIZONTAL = 4; // the horizontal quantity of panels;
    final int NUM_PANELS_VERTICAL = 4; // the vertical quantity of panels
    private ArrayList < Panel > panels;
    public static PApplet app; //`if(key=='s'), panels.add(0,lastPanel);panels.add(firstPanel)
    ;
    //doSwap}else if(key=='r')
    public Main() {
        super();
        app = this;
    }

    public void keyPressed() {

        if (key == 's') {
                Panel hello = panels.remove(0);
                Panel goodBye = panels.remove(panels.size() - 1);
                panels.add( 0, goodBye);
                panels.add(hello);
                int goodByeX = goodBye.getX();
                int goodByeY = goodBye.getY();
                int helloX = hello.getX();
                int helloY = hello.getY();
                hello.setX(goodByeX);
                hello.setY(goodByeY);
                goodBye.setX(helloX);
                goodBye.setY(helloY);//hi

            } else if (key == 'r') {

                Random rand= new Random();
                int i = rand.nextInt(panels.size());
                Panel p = panels.remove(i);
                Panel s;
                if (p instanceof ContrastedPanel) {
                    s = new RotatingPanel(p.getX(), p.getY(), p.getWidth(), p.getHeight());
                } else {
                    s = new ContrastedPanel(p.getX(), p.getY(), p.getWidth(), p.getHeight());

                }
                //s.setupImage("data/bunny.png");//what i got rid of
                s.setupImage("data/Bubble-Tea-Transparent-Background.png");//what i changed
                panels.add(i, s);

                //Replace the element at that index with an element with a different appearance (hint: use instanceof to determine the type of the element).

            }
        }


        public static void main(String[] args) { //static method
            PApplet.main("Main");
        }
        public void settings() {
            size(600, 600);
        }
        public void setup() {
            size(600, 600);
            panels = new ArrayList < Panel > ();
            //[NUM_PANELS_HORIZONTAL * NUM_PANELS_VERTICAL];

            int index = 0;
            for (int i = 0; i < NUM_PANELS_VERTICAL; i++) {
                for (int j = 0; j < NUM_PANELS_HORIZONTAL; j++) {
                    int w = width / NUM_PANELS_HORIZONTAL;
                    int h = height / NUM_PANELS_VERTICAL;
                    int x = j * w;
                    int y = i * h;
                    Panel s;
                    if (i % 4 == 0) {
                        s = new Panel(x, y, w, h);
                    } else if (i % 4 == 1) {
                        s = new TintedPanel(x, y, w, h);
                    } else if (i % 4 == 2) {
                        s = new ContrastedPanel(x, y, w, h);
                    } else {
                        s = new RotatingPanel(x, y, w, h);
                    }
                    s.setupImage("data/Bubble-Tea-Transparent-Background.png");
                    panels.add(s);
                    index++;
                }
            }
        }


    public void draw() {
        fancyBackground();

        for (Panel j: panels) {
            j.display();
            // for (int i = 0; i < panels.size(); i++){
            //   Panel s = panels.get(i);
            //   s.display();
        }
    }

    public void mouseClicked() {
        for (Panel p: panels) {
            p.handleMouseClicked(mouseX, mouseY);

        }

        // for (int i = 0; i < panels.size(); i++){
        //      Panel s = panels.get(i);
        //     s.handleMouseClicked(mouseX, mouseY);
    }

    private void fancyBackground() {
        loadPixels();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {

                int loc = x + y * width;

                if (x % 2 == 0) {
                    pixels[loc] = color(255);
                } else {
                    pixels[loc] = color(0);
                }
            }
        }

        updatePixels();
    }
}