package ro.tuc.Model;

import java.util.ArrayList;

public class Strategy {
    private ArrayList<Server> myQueues;
    private int nbQueues;

    public Strategy(int nbQueues, ArrayList<Server> myQueues) {
        this.myQueues = myQueues;
        this.nbQueues = nbQueues;
    }

    public int getShortestQueue() {
        int minIndex = 0;
        int min = myQueues.get(0).getNumberOfClientsInQueue();
        for (int i = 0; i < myQueues.size(); i++) {
            if (myQueues.get(i).getNumberOfClientsInQueue() < min) {
                min = myQueues.get(i).getNumberOfClientsInQueue();
                minIndex = i;
            }
        }
        return minIndex;
    }
}
