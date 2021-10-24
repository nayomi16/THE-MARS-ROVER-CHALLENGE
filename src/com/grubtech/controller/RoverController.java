package com.grubtech.controller;

import com.grubtech.service.Impl.RoverServiceImpl;
import com.grubtech.service.RoverService;


public class RoverController {

    RoverService roverService;

    public RoverController() {
        roverService = new RoverServiceImpl();
    }

    public void start() {
        String coordinates = "";
        int i = 1;
        String roverPosition = "";
        String exploreInstructions = "";
        boolean exc = false;
        boolean exc1 = false;

        while (!exc) {
            try {
                coordinates = roverService.getCoordinates();
                exc = true;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                continue;
            } catch (Exception ex) {
                System.out.println("An error occurred when getting coordinates from user : " + ex.getMessage());
                continue;
            }
        }

        while (true) {
            try {
                try {
                    roverPosition = roverService.getPosition(i);
                    exc1 = false;
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                    continue;
                } catch (Exception ex) {
                    System.out.println("An error occurred when getting roverPosition from user :" + ex.getMessage());
                    continue;
                }
                while (!exc1) {
                    try {
                        exploreInstructions = roverService.getInstructions(i);
                        roverService.getfinalCoordinatesAndHeading(coordinates, roverPosition, exploreInstructions);
                        exc1 = true;
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        continue;
                    } catch (Exception ex) {
                        System.out.println("An error occurred when getting exploreInstructions from user :" + ex.getMessage());
                        continue;
                    }
                }
                i++;

            } catch (Exception ex) {
                System.out.println("An error occurred!! Try again Rover No :" + i);
            }
        }
    }
}
