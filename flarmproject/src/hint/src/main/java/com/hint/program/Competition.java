package com.hint.program;

import java.util.HashMap;
import java.util.Scanner;


import com.hint.objects.Airplane;
import com.hint.objects.Flight;
import com.hint.objects.InstancePosition;
import com.hint.objects.Pilot;

public class Competition {


    private String mySelf;
    private HashMap<String, Flight> competion = new HashMap<>();
    private HashMap<String,InstancePosition> climbAllert = new HashMap<>();

    public void registerCompetitor(String flarmId, String name, String lastname) {

        competion.put(flarmId,new Flight(new Airplane(flarmId,new Pilot(name,lastname))));

    }

    public void addAPosition(String flarmId,Float altitude, Double longitude, Double latitude, Float verticalSpeed, int track, double time){
        if(competion.containsKey(flarmId)){
            competion.get(flarmId).addInstance(
                    altitude,longitude,latitude,verticalSpeed,track,time
            );
            //System.out.println("Position added");
        }
        else{

            String name;
            String lastName;
            Scanner scanner = new Scanner(System.in);

            System.out.println("Competitor not exist on the competition please register a new pilot");
            System.out.println("Name");
            name = scanner.nextLine();
            System.out.println("Lastname");
            lastName = scanner.nextLine();
            System.out.println("Competitor added in the database");
            registerCompetitor(flarmId,name,lastName);
            competion.get(flarmId).addInstance(
                    altitude,longitude,latitude,verticalSpeed,track,time
            );
            System.out.println("Position added");


        }

    }


    public HashMap<String,InstancePosition> getClimbAllert() {
        return this.climbAllert;
    }

    public void setClimbAllert(HashMap<String,InstancePosition> climbAllert) {
        this.climbAllert = climbAllert;
    }


    public HashMap<String, Flight> getCompetion() {
        return competion;
    }


    public String getMySelf() {
        return this.mySelf;
    }

    public void setMySelf(String mySelf) {
        this.mySelf = mySelf;
    }
    public void setCompetion(HashMap<String,Flight> competion) {
        this.competion = competion;
    }



}
