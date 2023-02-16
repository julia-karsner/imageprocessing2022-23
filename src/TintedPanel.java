public class TintedPanel extends Panel {//subclass

    public TintedPanel(int _x, int _y, int _width, int _height){//constructor
        super(_x, _y, _width, _height);// calling the super/parent class constructor
    }

    // overriding the inherited display method
    public void display(){
        Main.app.tint(85, 148, 250, 200);//85, 148, 250
        super.display(); // calling the inherited display method
        Main.app.noTint();// turns off tint effect after the image is displayed
    }
}


