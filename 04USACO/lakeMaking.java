import java.util.Scanner;
import java.io.*;
public class lakeMaking{
    int row;
    int col;
    int depth;
    int commands;
    int[][] heights;
    Scanner input;

    //read in file input
    public lakeMaking(){
	try{
	    input = new Scanner(new File("input.txt"));
	}catch(FileNotFoundException e){
	    System.out.println("Input file does not exist!");
	}
	row = input.nextInt();
	col = input.nextInt();
	depth = input.nextInt();
	commands = input.nextInt();
	heights = new int[row][col];
	System.out.println(commands);
    }

    //print out array
    public String toString(){
	String output = "";
	for (int row = 0; row < heights.length; row ++){
	    for (int col = 0; col < heights[row].length; col ++){
		output += heights[row][col]+" ";
	    }
	    output += "\n";
	}
	return output;
    }


    //testing
    public static void main(String[]args){
	lakeMaking x = new lakeMaking();
    }



}
