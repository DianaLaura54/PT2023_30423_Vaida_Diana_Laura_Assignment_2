package ro.tuc.Controller;

import ro.tuc.Model.Generator;
import ro.tuc.Model.Server;
import ro.tuc.Model.Strategy;
import ro.tuc.View.View2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import ro.tuc.Model.Task;

public class Controller2 implements Runnable {

    private View2 view2;
    private int arrivalMin;
    private int arrivalMax;
    private int serviceMin;
    private int serviceMax;
    private int nbQueues;
    private Generator generator;

    private Strategy strategy;

    private Clock clock;
    private Thread controllerThread;
    private ArrayList<Server> myQueues;
    private ArrayList<Task> myClients;
    private int nbClients;

    private int maxClientsAtaTime = 0;
    int index = 0;
    int index2 = 0;
    private int peakHour = 0;
    private float totalServiceTime = 0;
    private float totalWaitingTime = 0;
    private int simulationDuration;

    public Controller2(View2 view2, int arrivalMin, int arrivalMax, int serviceMin, int serviceMax, int nbQueues, int simulationDuration, int nbClients) {
        this.myClients = new ArrayList<Task>(nbClients);
        this.myQueues = new ArrayList<Server>(nbQueues);
        this.nbQueues = nbQueues;
        this.strategy = new Strategy(nbQueues, myQueues);
        this.view2 = view2;
        this.nbClients = nbClients;
        this.generator = new Generator(serviceMin, serviceMax, arrivalMin, arrivalMax);
        this.arrivalMin = arrivalMin;
        this.arrivalMax = arrivalMax;
        this.serviceMin = serviceMin;
        this.serviceMax = serviceMax;
        this.simulationDuration = simulationDuration;
        start();

    }

    public void start() {

        view2.setVisible(true);
        initialize();
        clock = new Clock(view2);
        controllerThread = new Thread(this);

    }

    public void initialize() {
        view2.addCreateListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < nbQueues; i++) {
                    Server server = new Server(i, clock, view2,simulationDuration);
                    myQueues.add(i, server);
                }
                System.out.println("Starting clock");
                clock.startClock();
                controllerThread.start();

            }
        });
    }

    public int getMaxOfClients() {
        int nrClients = 0;
        for (int i = 0; i < myQueues.size(); i++) {
            nrClients = nrClients + myQueues.get(i).getNumberOfClientsInQueue();
        }
        return nrClients;
    }


    public ArrayList<Task> sort(ArrayList<Task> myClients) {
        for (int i = 0; i < myClients.size(); i++) {
            for (int j = 0; j < myClients.size(); j++) {
                if (myClients.get(i).getArrivalTime() <= myClients.get(j).getArrivalTime()) {
                    int x = myClients.get(i).getArrivalTime();
                    myClients.get(i).setArrivalTime(myClients.get(j).getArrivalTime());
                    myClients.get(j).setArrivalTime(x);
                }
            }
        }
        return myClients;

    }

    @Override
    public void run() {
        if (clock.getTime() == 0) {
            while (index < nbClients) {
                Task newClient = generator.generatortime();
                myClients.add(index, newClient);
                this.index++;
            }
            myClients = sort(myClients);
            for (int i = 0; i < nbClients; i++) {
                view2.setlogtextArea("(" + (i + 1) + "," + myClients.get(i).getArrivalTime() + "," + myClients.get(i).getServiceTime() + ")");
            }
            index = 0;
        }

        while (clock.getTime() < simulationDuration) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }

            for (Task currentClient : myClients) {
                if (currentClient.getArrivalTime() == clock.getTime()) {
                    int minQIndex = strategy.getShortestQueue();
                    totalServiceTime = totalServiceTime + currentClient.getServiceTime();
                    myQueues.get(minQIndex).addClient(currentClient);
                    index++;
                }
            }

            int max = getMaxOfClients();
            if (maxClientsAtaTime < max) {
                this.maxClientsAtaTime = max;
                this.peakHour = clock.getTime();
            }
        }
        if (index != nbClients + 1) {
            for (int i = index; i < nbClients; i++) {
                view2.setlogtextArea("The client:" + myClients.get(i).getClientId() + "are still waiting ");
            }
        }
        System.out.println("Stopping simulation : ");
        for (int i = 0; i < myQueues.size(); i++) {
            myQueues.get(i).stop();
            System.out.println("Stopping queue number " + myQueues.get(i).getQueueIndex());
        }
        totalServiceTime = totalServiceTime / index;

        view2.setaveragetextArea2(totalServiceTime + " ");
        view2.setpeaktextArea("Peak hour : " + peakHour + " with " + maxClientsAtaTime + " clients.");
        clock.stopClock();
        System.out.println("Stopping clock.");
        System.out.println("STOP");

    }
}

