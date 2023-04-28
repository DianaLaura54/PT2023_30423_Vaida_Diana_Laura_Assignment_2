package ro.tuc.Model;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {
    private Task task;
    private int serviceMin;

    private int serviceMax;
    private int arrivalMax;
    private int arrivalMin;
    private static int counter=0;
    private static final ThreadLocalRandom random2= ThreadLocalRandom.current();
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();
    public Generator(int serviceMin,int serviceMax,int arrivalMin,int arrivalMax) {

        this.arrivalMin = arrivalMin;
        this.arrivalMax = arrivalMax;
        this.serviceMin = serviceMin;
        this.serviceMax = serviceMax;
    }

    public Task generatortime() {
        int service=random.nextInt(serviceMax-serviceMin+1)+serviceMin;
        int time = random2.nextInt(arrivalMax-arrivalMin+1)+arrivalMin;
        counter++;
        Task current = new Task(time, service, counter);

        return current;
    }
}
