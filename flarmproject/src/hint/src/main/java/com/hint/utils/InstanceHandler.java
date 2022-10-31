
package com.hint.utils;
import com.hint.program.Competition;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class InstanceHandler implements Runnable {

    Competition competition;

    protected long time;

    public InstanceHandler(Competition competition) {
        this.competition = competition;
        this.time = System.currentTimeMillis();
    }

    Utils utils = new Utils(competition);


    @Override
    public void run() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < competition.getCompetion().size(); i++) {
			String flarmId = (String) competition.getCompetion().keySet().toArray()[i];
			Runnable sg = new searchGlider(flarmId,this.competition); // N thred di ricerca OGN che blocca il terminale 
            Runnable mg = new ThermicHandler(this.competition,flarmId); // N thread di calcolo di termica che blocca 
			executor.execute(sg);
            executor.execute(mg);
		}
        Runnable lg= new DirectionHandler(this.competition); 
        executor.execute(lg);

		// shut down the executor service now
		executor.shutdown();
        try {
			if (!executor.awaitTermination(200000, TimeUnit.MILLISECONDS)) {
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			executor.shutdownNow();
		}
    
    }

    public static void main(String[] args) {
        Competition competition = new Competition();
        competition.registerCompetitor("4B4485", "Gionata", "Donati");
        competition.registerCompetitor("4B4316", "Giona", "Donati");
        competition.registerCompetitor("4B3294", "Gion", "Donati");

       
        InstanceHandler instanceHandler = new InstanceHandler(competition);
        Thread thread = new Thread(instanceHandler);
        thread.start();
    }
}