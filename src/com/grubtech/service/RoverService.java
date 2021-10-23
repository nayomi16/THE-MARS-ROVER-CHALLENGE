package com.grubtech.service;

public interface RoverService {
    public String getCoordinates();
    public String getPosition(int i);
    public String getInstructions(int i);
    public void getfinalCoordinatesAndHeading(String coordinates, String roverPosition, String exploreInstructions);
}
