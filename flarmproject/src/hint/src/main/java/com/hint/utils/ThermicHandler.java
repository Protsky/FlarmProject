package com.hint.utils;


import com.hint.objects.InstancePosition;
import com.hint.program.Competition;

public class ThermicHandler implements Runnable {
  private Competition competition;
  private String id;

  public ThermicHandler(Competition competition, String id) {
    this.competition = competition;
    this.id = id;
  }

  @Override
  public void run() {
    while (true) {

      try {

        if (timer() == 0) {

          float media = 0;
          int dimension = 0;

          for (InstancePosition x: competition.getCompetion().get(id).getPositions()) {
            media += x.getVerticalSpeed();
            dimension += 1;
          }

          if(dimension != 0){
            media = media / dimension;
            System.out.println("Aliante con " + id + " ha nella memoria temporanea di 20secondi " + dimension + " posizioni con una media di " + media );

            if (media <= 0) {
              System.out.println("User " + competition.getCompetion().get(id).getAirplane() + " is descending");
            } else if (media > 0.5) {
              System.out.println("User " + competition.getCompetion().get(id).getAirplane() + " is climbing");
              System.out.println(" Avrage vario last 20s " + media + " m/s");
              if(id != competition.getMySelf()){
                competition.getClimbAllert().put(id, competition.getCompetion().get(id).getPositions().get(competition.getCompetion().get(id).getPositions().size()-1));
              }
              
            }
            competition.getClimbAllert().put(competition.getMySelf(), competition.getCompetion().get(id).getPositions().get(competition.getCompetion().get(id).getPositions().size()-1));
            competition.getCompetion().get(id).getPositions().clear();
            media = 0;
            dimension = 0;
          }
          else{
            System.out.print("No data recived in the last 20 seconds...");
          }

        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public int timer() throws InterruptedException {
    int timet = 5;
    long delay = timet * 1000;

    do {
      Thread.sleep(1000);

      timet = timet - 1;
      delay = delay - 1000;

    }
    while (delay != 0);

    return 0;
  }

  public static void main(String[] args) throws InterruptedException {

  }
}