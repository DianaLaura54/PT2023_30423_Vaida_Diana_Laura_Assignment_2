package ro.tuc.Model;

import ro.tuc.View.View2;
import ro.tuc.Controller.Clock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {

    private BlockingQueue<Task> tasks;
    private int queueIndex;
    private AtomicBoolean isRunning = new AtomicBoolean(false);
    private AtomicInteger total = new AtomicInteger(0);
    private int totalWaitingTime;
    private Clock clock;
    private Thread queueThread;
    private View2 view;
    private int simulation;

    public Server(int index, Clock timer, View2 view,int simulation) {

        this.tasks = new java.util.concurrent.LinkedBlockingQueue<>();
        this.queueIndex = index;
        this.totalWaitingTime = 0;
        this.clock = timer;
        this.queueThread = new Thread(this);
        this.view = view;
        this.simulation=simulation;
        start();
    }

    public List<Task> gettasks() {
        return (List<Task>) this.tasks;
    }

    public int getNumberOfClientsInQueue() {
        return this.tasks.size();
    }

    public int getQueueIndex() {
        return this.queueIndex;
    }

    public void addClient(Task task) {
       /*int oldValue = total.getAndIncrement();
       int newValue = oldValue + 1;
        total.set(newValue);*/
        this.tasks.add(task);
        String logMessage = "Client " + task.getClientId() + " arrived at queue " + (this.queueIndex + 1) + " at moment " + clock.getTime();
        view.setlogtextArea(logMessage + " ");
    }

    public void removeClient(Task task) {

    this.tasks.remove(task);
    String logMessage = "Client " + task.getClientId() + " left queue " + (this.queueIndex + 1) + " at moment " + clock.getTime();
    view.setlogtextArea(logMessage + " ");


    }


    @Override
    public void run() {
        while (isRunning.get() == true) {
            if (tasks.isEmpty() == false) {
                Task currentClient = this.tasks.peek();
                int serviceTime = currentClient.getServiceTime();
                try {
                    Thread.sleep(serviceTime * 1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                removeClient(currentClient);
            } else {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }
    }


    public void start() {
        isRunning.set(true);
        queueThread.start();
    }

    public void stop() {
        isRunning.set(false);
    }


}