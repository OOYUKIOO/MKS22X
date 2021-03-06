import java.util.*;
import java.io.*;

public class Maze{
    private char[][]maze;
    private int startx,starty;
    private boolean animate;

    /*Constructor loads a maze text file.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (only 1 per file)
      'S' - the location of the start(only 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found, print an error and exit the program.
    */
    public Maze(String filename, boolean ani){
	animate = ani;
	startx = -1;
	starty = -1;
	//find row & col of maze
	int row = 0;
	int col = 0;
	String preMaze = "";
	Scanner x = new Scanner("");
	try{
	    x = new Scanner(new File(filename));
	    while(x.hasNextLine()){
		row ++;
		String rowElements = x.nextLine();
		col = rowElements.length();
		//read into String
		preMaze+= rowElements;
	    }
	}catch(FileNotFoundException e){
	    System.out.println("Input file is not found!");
	    System.exit(0);
	}
	//create maze, add elements from String
	maze = new char[row][col];
	for(int prow = 0; prow < maze.length; prow++){
	    for(int pcol = 0; pcol < maze[prow].length; pcol++){
		maze[prow][pcol] = preMaze.charAt(prow*maze[0].length+pcol);
		if(maze[prow][pcol] == 'S'){
		    startx = prow;
		    starty = pcol;
		}
	    }
	}
    }


    /*Main Solve Function

      Things to note:
       When no S is contained in maze, print an error and return false.
    */
    public boolean solve(){
        if(startx < 0){
            System.out.println("No starting point 'S' found in maze.");
            return false;
        }else{
            maze[startx][starty] = ' ';
            return solve(startx,starty);
        }
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.
      The S is replaced with '@' but the 'E' is not.

      Postcondition:
        Returns true when the maze is solved,
        Returns false when the maze has no solution.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'

    */
    
    private boolean solve(int x, int y){
        if(animate){
            System.out.println(this);
            wait(20);
        }/*
	if(maze[x][y] != ' ' ||
	   x < 0 ||
	   x > maze.length ||
	   y < 0 ||
	   y > maze[0].length){
	    return false;
	}
	if(maze[x+1][y] == 'E' ||
	   maze[x][y-1] == 'E' ||
	   maze[x-1][y] == 'E' ||
	   maze[x][y+1] == 'E'){
	    maze[x][y] = '@';
	    return true;
	}
	if(maze[x+1][y] != ' ' &&
	   maze[x][y-1] != ' ' &&
	   maze[x-1][y] != ' ' &&
	   maze[x][y+1] != ' '){
	    maze[x][y] = '.';
	    return false;
	} 
	 */
	if(x < 0 || x > maze.length || y < 0 || y > maze[0].length ||
	   (maze[x][y] != 'E' && maze[x][y] != ' ')){
	    return false;
	}
	if(maze[x][y] == 'E'){
	    return true;
	}else{
	    maze[x][y] = '@';
	}
        if(solve(x-1,y) ||
	   solve(x+1,y) ||
	   solve(x,y+1) ||
	   solve(x,y-1)){
	    return true;
	}else{
	    maze[x][y] = '.';
	}
	return false;
	//        return false; //so it compiles
    }
    

    //FREE STUFF!!! *you should be aware of this*


    public void clearTerminal(){
        System.out.println(CLEAR_SCREEN);
    }

    public String toString(){
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maze.length + " by " + maze[0].length + "\n";
	}
	for (int prow = 0; prow < maze.length; prow ++){
	    for (int pcol = 0; pcol < maze[prow].length; pcol ++){
		if(maze[prow][pcol] == '#'){
		    ans += color(38,47);
		}else{
		    ans += color(33,40);
		}
		ans += maze[prow][pcol];
	    }
	    ans += "\n";
	}
	return HIDE_CURSOR + go(0,0) + ans + "\n" + SHOW_CURSOR + color(37,40);
    }


    //MORE FREE STUFF!!! *you can ignore all of this*

    //Terminal keycodes to clear the terminal, or hide/show the cursor
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    //terminal specific character to move the cursor
    private String go(int x,int y){
        return ("\033[" + x + ";" + y + "H");
    }

    private String color(int foreground,int background){
        return ("\033[0;" + foreground + ";" + background + "m");
    }

    private void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }    

    //END FREE STUFF



}
