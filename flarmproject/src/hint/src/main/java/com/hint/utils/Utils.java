package com.hint.utils;

import com.hint.program.Competition;
import java.util.Optional;
import org.ogn.client.AircraftBeaconListener;
import org.ogn.client.OgnClient;
import org.ogn.client.OgnClientFactory;
import org.ogn.commons.beacon.AircraftBeacon;
import org.ogn.commons.beacon.AircraftDescriptor;
import org.ogn.commons.igc.IgcLogger;

public class Utils {
    private Competition competition;

    static IgcLogger	igcLogger	= new IgcLogger();

	// enable if you want to log to IGC files
	static boolean		logIGC		= false;

    public Utils(Competition competition) {
        this.competition = competition;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }


    public void printCompetitors(){
        competition.getCompetion().forEach((k,v) ->{
            System.out.println(v.getAirplane().getPilot());
        });
    }


    public void searchGlider(String flarmId) throws InterruptedException{

        
        final OgnClient client = OgnClientFactory.createClient();
        System.out.println("connecting to OGN network...");

        client.connect();
        System.out.println("Connected!"); 

		client.subscribeToAircraftBeacons(new AircraftBeaconListener() {

            @Override
		    public void onUpdate(AircraftBeacon beacon, Optional<AircraftDescriptor> descriptor) {

                if(beacon.getAddress().equals(flarmId)){

                    //System.out.println("Aircraft type: " + beacon.getAircraftType());
                    //System.out.println("Altitude: " + beacon.getAlt());
                    //System.out.println("Latitude: " + beacon.getLat());
                    //System.out.println("Longitude: " + beacon.getLon());
                    //System.out.println("Climb rate: " + beacon.getClimbRate());
                    competition.addAPosition(flarmId, beacon.getAlt(), beacon.getLon(), beacon.getLat(), beacon.getClimbRate(),beacon.getTrack(),beacon.getTimestamp());

                    //System.out.println("*********************************************");

                }

                
			
		}
        
        }
        );
        Thread.sleep(Long.MAX_VALUE);
        
    }

}
