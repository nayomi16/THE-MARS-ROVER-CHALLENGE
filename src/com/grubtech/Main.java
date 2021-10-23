package com.grubtech;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the Coordinates of the Plateau : X Y");
        String coordinates = scan.nextLine();

        int i = 1;
        while(true)
        {
            System.out.println("Enter the Rover "+i+" position : X Y P");
            String roverPosition = scan.nextLine();

            System.out.println("Enter the Rover "+i+" explore instructions : LMMLMR");
            String exploreInstructions = scan.nextLine();
            i++;


        }

    }
}
