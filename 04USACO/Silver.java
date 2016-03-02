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
	}
	for (int y = 0; y < row; y++){
	    String rowElement = input.next();
	    for(int x = 0; x < rowElement.length(); x++){
		if(rowElement.charAt(x) == '*'){
		    pasture[y+1][x+1] = -1;
		}
	    }
	}
   	startx = input.nextInt();
	starty = input.nextInt();
	endy = input.nextInt();
	endx = input.nextInt();
	System.out.println(""+startx+", "+starty+", "+endy+", "+endx);
    }

    //to solve
    public int solve(){
	pasture[startx][starty] = 1;
	while(steps > 0){
	    int [] temp = new int [col*row];
	    for(int i = 0; i < temp.length; i++){
		int sum = 0;
		int tempy = i/col+1;
		int tempx = i%col+1;
		for(int k = 0; k < 4; k++){
		    if(pasture[tempy+coord[k*2]][tempx+coord[k*2+1]] != -1){
			sum += pasture[tempy+coord[k*2]][tempx+coord[k*2+1]];
		    }
		}
		temp[i] = sum;
	    }
	    for(int i = 0; i < temp.length; i++){
		if(pasture[i/col+1][i%col+1] != -1){
		    pasture[i/col+1][i%col+1] = temp[i];
		}
	    }
	    steps--;
	}
	return pasture[endy][endx];
    }

    //for debugging purpose
    public String toString(){
	String ans = "";
	for(int y = 0; y < pasture.length; y++){
	    for(int x = 0; x < pasture[y].length; x++){
		if(pasture[y][x]/10 == 0 && pasture[y][x] != -1){
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
	System.out.println();
	System.out.println(x.solve());
	System.out.println(x);
    } 
    
   
}
