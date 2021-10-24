package com.grubtech.service;

public interface RoverService {
    public String getCoordinates() throws Exception;
    public String getPosition(int i) throws Exception;
    public String getInstructions(int i) throws Exception;
    public void getfinalCoordinatesAndHeading(String coordinates, String roverPosition, String exploreInstructions);
}
