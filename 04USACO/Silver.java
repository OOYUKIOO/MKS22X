import java.util.Scanner;
import java.io.*;

public class Silver{
    int row,col,steps;
    int[][]pasture;
    int startx,starty,endx,endy;

    //constructor
    public Silver(){
	Scanner input;
	try{
	    input = new Scanner(new File("cowTravelling.in"));
	}catch(FileNotFoundException e){
	    System.out.println("Input file not found!");
	}
	row = input.nextInt();
	col = input.nextInt();

}
