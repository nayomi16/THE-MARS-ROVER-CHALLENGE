package com.grubtech.controller;

import com.grubtech.service.Impl.RoverServiceImpl;
import com.grubtech.service.RoverService;

import java.util.Scanner;


public class RoverController {

    RoverService _roverService;


    public RoverController()
    {
        _roverService = new RoverServiceImpl();
    }

    public void start() {


        String coordinates = _roverService.getCoordinates();

        int i = 1;
        while(true)
        {
            String roverPosition = _roverService.getPosition(i);

            String exploreInstructions = _roverService.getInstructions(i);

            _roverService.getfinalCoordinatesAndHeading(coordinates, roverPosition, exploreInstructions);

            i++;


        }



    }



}
