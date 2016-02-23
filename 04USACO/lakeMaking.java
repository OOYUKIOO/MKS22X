import java.util.Scanner;
import java.io.*;
public class lakeMaking{
    int row;
    int col;
    int depth;
    int N;
    int[][] heights;
    int[] commands;
    Scanner input;

    //read in file input
    public lakeMaking(){
	try{
	    input = new Scanner(new File("makelake.in"));
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
	commands = new int[N*3];
	for (int x = 0; x < commands.length; x++){
	    commands[x] = input.nextInt();
	}
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

    //fill water
    public int calcCubics(){
	int cubics = 0;
	for (int row = 0; row < heights.length; row ++){
	    for (int col = 0; col < heights[row].length; col ++){
		heights[row][col] = heights[row][col] - depth;
		if (heights[row][col] < 0){
		    cubics += heights[row][col] * -1;
		}
	    }
	}
	cubics = cubics * 72 * 72;
	return cubics;
    }


    //stomp according to input
    public void timeToStomp(){
	for(int i = 0; i < N; i++){
	    stomp(commands[3*i],commands[3*i+1],commands[3*i+2]);
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
	
	//	System.out.println(x);
	x.timeToStomp();
	//	System.out.println(x);
	
	System.out.println(x.calcCubics()+", 6, Chen, Yuxuan");
    }



}
