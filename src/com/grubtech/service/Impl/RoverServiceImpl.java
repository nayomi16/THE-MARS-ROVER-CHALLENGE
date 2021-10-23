package com.grubtech.service.Impl;

import com.grubtech.service.RoverService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RoverServiceImpl implements RoverService {
    private int[] plateauCoordinates=new int[2];
    private String[] roverPositionArry = new String[3];
    private String[] roverExploreInstructions = {};
    private int x = 0;
    private int y = 0;
    private String position = "N";
    private Map<String, String> leftMap = new HashMap<>();
    private Map<String, String> rightMap = new HashMap<>();
    Scanner _scan;

    public RoverServiceImpl()
    {
        _scan = new Scanner(System.in);
    }
    @Override
    public String getCoordinates() {
        try {
            System.out.println("Enter the Coordinates of the Plateau : X Y");
            String coordinates = _scan.nextLine();
            if(coordinates.equals(null) ||  coordinates.equals(""))
            {
                System.out.println("coordinates can not be null or empty");
                throw new IllegalArgumentException("coordinates can not be null or empty");
            }
            return coordinates;
        }catch (Exception ex){
            System.out.println("An error occur when getting getCoordinates from user");
            System.out.println(ex.getMessage());
            throw ex;
        }

    }

    @Override
    public String getPosition(int i) {
        try {
            System.out.println("Enter the Rover "+i+" position : X Y P");
            String roverPosition = _scan.nextLine();

            if(roverPosition.equals(null) ||  roverPosition.equals(""))
            {
                System.out.println("roverPosition can not be null or empty");
                throw new IllegalArgumentException("roverPosition can not be null or empty");
            }

            return roverPosition;
        }catch (Exception ex){
            System.out.println("An error occur when getting getPosition from user");
            System.out.println(ex.getMessage());
            throw ex;
        }

    }

    @Override
    public String getInstructions(int i) {
        try {
            System.out.println("Enter the Rover "+i+" explore instructions : LMMLMR");
            String exploreInstructions = _scan.nextLine();
            return exploreInstructions;
        }catch (Exception ex){
            System.out.println("An error occur when getting getInstructions from user");
            System.out.println(ex.getMessage());
            throw ex;
        }

    }

    @Override
    public void getfinalCoordinatesAndHeading(String coordinates, String roverPosition, String exploreInstructions) {
        try
        {
            roverExploreInstructions = getRoverexploreInstructions(exploreInstructions);
            plateauCoordinates = getPlateauCoordinates(coordinates);
            roverPositionArry = getRoverPosition(roverPosition);
            x = Integer.parseInt(roverPositionArry[0]);
            y = Integer.parseInt(roverPositionArry[1]);
            position = roverPositionArry[2];

            leftMap = getLeftPositionMap();
            rightMap = getRightPositionMap();

            for(int i = 0 ; i< roverExploreInstructions.length;i++)
            {
                if(x<=plateauCoordinates[0] && y<=plateauCoordinates[1])
                {
                    switch (roverExploreInstructions[i])
                    {
                        case "L" :
                            position = leftMap.get(position);
                            break;
                        case "R":
                            position = rightMap.get(position);
                            break;
                        case "M":
                            moveRover(position);
                            break;
                        default: throw new IllegalArgumentException("Invalid!!Instructions only can be L, M or R : "+roverExploreInstructions[i]);
                    }
                }else
                {
                    System.out.println("can not go outside from the plateau");
                }
            }
            System.out.println(x+" "+y+" "+position);

        }
        catch (Exception ex){
            System.out.println("An error occur when getting finalCoordinatesAndHeading");
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    private int[] getPlateauCoordinates(String coordinates)
    {
        try
        {
            return Arrays.stream(coordinates.split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        catch (Exception ex)
        {
            System.out.println("An error occur when getPlateauCoordinates");
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    private String[] getRoverPosition(String roverPosition)
    {
        try
        {
                return roverPosition.split(" ");
        }
        catch (Exception ex)
        {
            System.out.println("An error occur when getting RoverPosition array");
            System.out.println(ex.getMessage());
            throw ex;
        }
    }


    private String[] getRoverexploreInstructions(String exploreInstructions)
    {
        try
        {
                return exploreInstructions.split("");

        }
        catch (Exception ex)
        {
            System.out.println("An error occur when getting RoverexploreInstructions array");
            System.out.println(ex.getMessage());
            throw ex;
        }
    }


    private void moveRover(String pos)
    {
        try{
            switch (pos)
            {
                case "N":
                    y = y + 1;
                    break;
                case "E":
                    x = x + 1;
                    break;
                case "S":
                    y = y - 1;
                    break;
                case "W":
                    x = x - 1;
                    break;
            }
        }catch (Exception ex){
            System.out.println("An error occur when moveRover");
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    private Map<String,String> getLeftPositionMap()
    {
        try {
            Map<String, String> map = new HashMap<>();
            map.put("N","W");
            map.put("E","N");
            map.put("S","E");
            map.put("W","S");
            return map;

        }catch (Exception ex){
            System.out.println("An error occur when getLeftPositionMap");
            System.out.println(ex.getMessage());
            throw ex;
        }

    }

    private Map<String,String> getRightPositionMap()
    {
        try {
            Map<String, String> map = new HashMap<>();
            map.put("N","E");
            map.put("E","S");
            map.put("S","W");
            map.put("W","N");
            return map;

        }catch (Exception ex){
            System.out.println("An error occur when getRightPositionMap");
            System.out.println(ex.getMessage());
            throw ex;
        }
    }
}
