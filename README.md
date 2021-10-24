# THE-MARS-ROVER-CHALLENGE

 

To find the position of the Rover on a plateau on Mars.

 

### Requirements
 
* Operating System : Any(Windows/Linux/Mac)
* JDK 1.8
* IDE used: IntelliJ IDEA. 

### How to bootstrap
* Need to run the Main class (com.grubtech). You can be used any IDE

### INPUT
* The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are 
  assumed to be 0,0.
  
* The rest of the input is information pertaining to the rovers that have been deployed. Each rover has 
  two lines of input. The first line gives the rover’s position, and the second line is a series of instructions 
  telling the rover how to explore the plateau.
  
* The position is made up of two integers and a letter separated by spaces, corresponding to the x and 
  y co-ordinates and the rover’s orientation.

* Each rover will be finished sequentially, which means that the second rover won’t start to move until 
   the first one has finished moving.
   

### OUTPUT
* The output for each rover should be its final co-ordinates and heading.

```
Enter the Coordinates of the Plateau : X Y
5 5
Enter the Rover 1 position : X Y P
1 2 N
Enter the Rover 1 explore instructions : LMMLMR
LMLMLMLMM
final co-ordinates and heading : 1 3 N
Enter the Rover 2 position : X Y P
3 3 E
Enter the Rover 2 explore instructions : LMMLMR
MMRMMRMRRM
final co-ordinates and heading : 5 1 E
Enter the Rover 3 position : X Y P
```

