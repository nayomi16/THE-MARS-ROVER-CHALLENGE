package com.grubtech;

import com.grubtech.controller.RoverController;



public class Main {

    public static void main(String[] args) {
        //getting an object from the Controller class
        RoverController roverController = new RoverController();
        roverController.start();

    }
}
