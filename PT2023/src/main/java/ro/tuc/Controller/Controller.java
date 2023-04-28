package ro.tuc.Controller;

import ro.tuc.View.View;
import ro.tuc.View.View2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
   private View view;
    private int arrivalMin;
    private int arrivalMax;
    private int serviceMin;
    private int serviceMax;
    private int nbQueues;
    private int simulationDuration;
    private int nbClients;

    public Controller(View view)
    {
        this.view=view;
        this.view.addCreateListener(new CreateListener());
    }
    class CreateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                View2 view2=new View2();
    nbClients=Integer.parseInt(view.getclientstextField());
                nbQueues=Integer.parseInt(view.getqueuestextField());
                simulationDuration=Integer.parseInt(view.getsimulationtextField());
                serviceMax=Integer.parseInt(view.getservicetextField2());
                serviceMin=Integer.parseInt(view.getservicetextField());
                arrivalMin=Integer.parseInt(view.getarrivaltextField());
                arrivalMax=Integer.parseInt(view.getarrivaltextField2());
                Controller2 controller2=new Controller2(view2,arrivalMin,arrivalMax,serviceMin,serviceMax,nbQueues,simulationDuration,nbClients);


            } catch (Exception ex) {
                view.showMessage("Something went wrong!");
            }
        }
    }

}
