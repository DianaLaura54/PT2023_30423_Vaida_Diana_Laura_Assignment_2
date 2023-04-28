package ro.tuc.Controller;

import ro.tuc.View.View2;

public class Clock implements Runnable {

    private Thread clockThread;
    private int timer;
    private boolean isRunning;
    private View2 view2;

    public Clock(View2 view) {
        clockThread = new Thread(this);
        isRunning = false;
        timer = 0;
       view2=view;
    }

    public void startClock() {
        isRunning = true;
        timer = 0;
        clockThread.start();
    }


    public int getTime() {
        return this.timer;
    }

    @Override
    public void run() {

        while (isRunning == true) {
            try {
                int currentTime = this.getTime();
                String curTime = ""+currentTime;
                view2.settimertextArea(curTime);
                Thread.sleep(1000);
            } catch (Exception ex) {
                System.out.println("ERROR");
                ex.printStackTrace();
            }
            timer++;

        }
    }
    public void stopClock() {
        isRunning = false;
    }
}