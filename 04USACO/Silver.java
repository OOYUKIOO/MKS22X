import java.util.Scanner;
import java.io.*;

public class Silver{
    int row,col,steps;
    int[][]pasture;
    int startx,starty,endx,endy;
    int[]coord = {0,1,0,-1,1,0,-1,0};
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
	pasture = new int[row+2][col+2];
	//make surrounding pad and tree -1
	for (int y = 0; y < pasture.length; y++){
	    for(int x = 0; x < pasture[y].length; x++){
		if(x==0 || y==0 || x==pasture[y].length-1 || y==pasture.length-1){
		    pasture[y][x] = -1;
		}
	    }
	    String rowElement = input.next();
	    for(int x = 0; x < rowElement.length(); x++){
		if(rowElement.charAt(x) == '*'){
		    pasture[y+1][x+1] = -1;
		}
	    }
	}
    }

    //to solve
    public int solve(){
	pasture[startx][starty] = 1;
	while(steps > 0){
	    int [] temp = new int [col*row - 1];
	    /*
	    for(int prow = 0; prow < pasture.length; prow++){
		for (int pcol = 0; pcol < pasture[prow].length; pcol++){
		    if(prow!=0 && prow!=pasture.length-1 && pcol!=0 && pcol!=pasture[prow].length-1){

		    }
		}
	    }
	    */
	    for(int i = 0; i < temp.length; i++){
		int sum = 0;
		int tempy = i/row + 1;
		int tempx = i%row + 1;
		for(int k = 0; k < coord.length/2; k++){

		}
	    }
	}
	return pasture[endx][endy];
    }

    //for debugging purpose
    public String toString(){
	String ans = "";
	for(int y = 0; y < pasture.length; y++){
	    for(int x = 0; x < pasture[y].length; x++){
		if(pasture[y][x]/10 == 0 && pasture[x][y] != -1){
		    ans += "0"+pasture[y][x]+" ";
		}else{
		ans += pasture[y][x] + " ";
		}
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
