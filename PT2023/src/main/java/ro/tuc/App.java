package ro.tuc;

import ro.tuc.Controller.Controller;
import ro.tuc.Controller.Controller2;
import ro.tuc.View.View;
import ro.tuc.View.View2;

public class App 
{
    public static void main(String[] args) {
        View view=new View();
Controller controller=new Controller(view);
    }
}
