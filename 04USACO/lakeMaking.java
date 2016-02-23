import java.util.Scanner;
import java.io.*;
public class lakeMaking{
    int row;
    int col;
    int depth;
    int N;
    int[][] heights;
    int[][] commands;
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
	N = input.nextInt();
	heights = new int[row][col];
	for(int prow = 0; prow < row; prow ++){
	    for(int pcol = 0; pcol < col; pcol ++){
		heights[prow][pcol] = input.nextInt();
	    }
	}
	commands = new int[N][3];
	for (int x = 0; x < N; x++){
	    for(int y = 0; y < 3; y++){
		commands[x][y] = input.nextInt();
	    }
	}
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
	System.out.println(x);
    }



}
