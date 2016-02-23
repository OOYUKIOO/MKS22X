import java.util.Scanner;
import java.io.*;
public class lakeMaking{
    int row;
    int col;
    int depth;
    int commands;
    int[] heights;
    Scanner input;

    //read in file input
    public lakeMaking(){
	try{
	    input = new Scanner(new File("input.txt"));
	}catch(FileNotFoundException e){
	    System.out.println("oops");
	}
    }


    //testing
    public static void main(String[]args){
	lakeMaking x = new lakeMaking();
    }



}
