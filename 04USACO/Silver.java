import java.util.Scanner;
import java.io.*;

public class Silver{
    int row,col,steps;
    int[][]pasture;
    int startx,starty,endx,endy;

    //constructor
    public Silver(){
	Scanner input = new Scanner("");
	try{
	    input = new Scanner(new File("cowTravelling.in"));
	}catch(FileNotFoundException e){
	    System.out.println("Input file not found!");
	}
	row = input.nextInt();
	col = input.nextInt();
	steps = input.nextInt();
	//	System.out.println("" + row + ", " + col + ", " + steps);
	pasture = new int[row][col];
	for (int y = 0; y < pasture.length; y++){
	    String rowElement = input.next();
	    for(int x = 0; x < rowElement.length(); x++){
		if(rowElement.charAt(x) == '*'){
		    pasture[y][x] = -1;
		}
	    }
	}

    }

    //for debugging purpose
    public String toString(){
	String ans = "";
	for(int y = 0; y < pasture.length; y++){
	    for(int x = 0; x < pasture[y].length; x++){
		ans += pasture[y][x] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    //testing
    public static void main(String[]args){
	Silver x = new Silver();
	System.out.println(x);
    } 

   
}
