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

    //stomping!
    public void stomp(int x, int y, int dep){
	if (x <= 0 || x > row - 2 || y <= 0 || y > col - 2){
	    System.out.println ("Out of stomping range");
	}else{
	    int highest = Integer.MIN_VALUE;
	    for(int row = x - 1; row < x + 2; row++){
		for(int col = y - 1; col < y +2; col++){
		    highest = Math.max(highest, heights[row][col]);
		}
	    }
	    int newGround = highest - dep;
	    for(int row = x - 1; row < x + 2; row ++){
		for (int col = y - 1; col < y + 2; col ++){
		    if(heights[row][col] > newGround){
			heights[row][col] = newGround;
		    }
		}
	    }
	}
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
	x.stomp(2,1,3);
	System.out.println(x);
    }



}
