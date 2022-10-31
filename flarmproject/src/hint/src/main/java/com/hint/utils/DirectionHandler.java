package com.hint.utils;

import com.hint.objects.InstancePosition;
import com.hint.program.Competition;

public class DirectionHandler implements Runnable {

    Competition competition;


    public DirectionHandler(Competition competition) {
        this.competition = competition;
    }


    @Override
    public void run() {
        
        while(true){
            try {
                if(timer() == 0){
                    System.out.println("Panoramica delle ultime salite dei concorrenti");
                    competition.getClimbAllert().forEach((k,v)->{
                        System.out.println(k);
                        System.out.println("Latitudine: " + v.getLatitude());
                        System.out.println("Longitudine: " + v.getLongitude());
                        System.out.println("Track: " + v.getBearing());
                        System.out.println("Time: " + v.getTime());
                    
                    });



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

    public void headingToFollow(InstancePosition a){

        double adminHeading = competition.getClimbAllert().get(competition.getMySelf()).getBearing();
        
        double geographicHeading = bearing(a.getLatitude(), a.getLongitude(), competition.getClimbAllert().get(competition.getMySelf()).getLatitude(), competition.getClimbAllert().get(competition.getMySelf()).getLongitude());
        
        System.out.println(adminHeading-geographicHeading);
        
    }

    public double bearing(double lat1, double lon1, double lat2, double lon2){
        double longitude1 = lon1;
        double longitude2 = lon2;
        double latitude1 = Math.toRadians(lat1);
        double latitude2 = Math.toRadians(lat2);
        double longDiff= Math.toRadians(longitude2-longitude1);
        double y= Math.sin(longDiff)*Math.cos(latitude2);
        double x=Math.cos(latitude1)*Math.sin(latitude2)-Math.sin(latitude1)*Math.cos(latitude2)*Math.cos(longDiff);
        double resultDegree=(Math.toDegrees(Math.atan2(y, x))+360)%360;
       
        return resultDegree;
    
    }

    public Competition getCompetition() {
        return this.competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }


    

    
}
