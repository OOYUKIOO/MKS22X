import java.util.*;
import java.io.*;

public class BetterMaze{

    private char[][] maze;
    private int[]    solution;
    private int solutionLen;
    private Node ref;
    private int      startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean  animate;//default to false

   /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
    **/
    public int[] solutionCoordinates(){
	solutionLen = solutionLen*2;
	solution = new int[solutionLen];
	int[] ans = new int[solutionLen];
	int index = 0;
	while(ref != null){
	    solution[index] = ref.getValue()[0];
	    solution[index+1] = ref.getValue()[1];
	    /*
	    if(ref.getPrev()!=null){
		System.out.println("added " +
				   ref.getPrev().getValue()[0] + ", "
				   +ref.getPrev().getValue()[1]);
	    }
	    */
	    index+=2;
	    ref = ref.getPrev();
	}
	for(int i = solutionLen-1; i >= 0; i--){
	    int coordIndex = (solutionLen-1)-i;
	    if(coordIndex % 2 == 1){
		coordIndex --;
	    }else{
		coordIndex ++;
	    }
	    ans[i] = solution[coordIndex];
	}
	return ans;
    }    

    public String printSolution(){
	String ans = "";
	int[] x = solutionCoordinates();
	System.out.println(x.length);
	for(int i = 0; i < x.length; i++){
	    ans += x[i]+",";
	}
	return ans.substring(0,ans.length()-1);
    }


    /**initialize the frontier as a queue and call solve
    **/
    public boolean solveBFS(){  
	placesToGo = new FrontierQueue<Node>();
	return solve();        
    }   


   /**initialize the frontier as a stack and call solve
    */ 
    public boolean solveDFS(){  
        placesToGo = new FrontierStack<Node>();
	return solve();
    }    

   /**Search for the end of the maze using the frontier. 
      Keep going until you find a solution or run out of elements on the frontier.
   **/
    private boolean solve(){  
	int[] coord = {startRow,startCol};
	return solveH(coord,null);
    }    


    //solve helper function
    private boolean solveH(int[] coord, Node prev){
	solutionLen++;
	//    System.out.println(coord[0]+", "+coord[1]);
	maze[coord[0]][coord[1]] = '.';
	for(int i = 0; i < 4; i++){
	    int[] newCoord;
	    // 0 = move left
	    if(i == 0){
		//		    System.out.println("left");
		newCoord = moveLeft(coord);
		// 1 = move right
	    }else if(i == 1){
		//		    System.out.println("right");
		newCoord = moveRight(coord);
		// 2 = move up
	    }else if(i == 2){
		//		    System.out.println("up");
		newCoord = moveUp(coord);
		// 3 = move down
	    }else{
		//		    System.out.println("down");
		newCoord = moveDown(coord);
	    }
	    //if worthy of adding
	    if(canMove(newCoord) && placesToGo != null){
		Node toAdd = new Node(newCoord, prev);

		if(goal(newCoord)){
		    ref = toAdd;
		    /*
		    System.out.println("prev one" +
				       ref.getPrev().getValue()[0] + ", "
				       +ref.getPrev().getValue()[1]);
		    */
		    return true;
		}
		placesToGo.add(toAdd);
	    }


	}
	//next spot
	if(placesToGo.hasNext()){
	    Node nextSpot = placesToGo.next();
	    return solveH(nextSpot.getValue(),nextSpot);
	}
	return false;

    }

    private boolean goal(int[] coord){
	char current = maze[coord[0]][coord[1]];
	if(current == 'E'){
	    return true;
	}
	return false;
    }

    private boolean canMove(int[] coord){
    char next = maze[coord[0]][coord[1]];
	if(next == ' ' || next == 'E'){
	    return true;
	}
	return false;
    }
     
    private int[] moveLeft(int[] coord){
	int row = coord[0];
	int col = coord[1]-1;
	if(col < maze[0].length && col >= 0){
	    int[] ans = {row,col};
	    return ans;
	}else{
	    int[] ans = new int[0];
	    return ans;
	}
    }

    private int[] moveRight(int[] coord){
	int row = coord[0];
	int col = coord[1]+1;
	if(col < maze[0].length && col >= 0){
	    int[] ans = {row,col};
	    return ans;
	}else{
	    int[] ans = new int[0];
	    return ans;
	}
    }

    private int[] moveUp(int[] coord){
	int row = coord[0]-1;
	int col = coord[1];
	if(row < maze.length && row >= 0){
	    int[] ans = {row,col};
	    return ans;
	}else{
	    int[] ans = new int[0];
	    return ans;
	}
    }


    private int[] moveDown(int[] coord){
	int row = coord[0]+1;
	int col = coord[1];
	if(row < maze.length && row >= 0){
	    int[] ans = {row,col};
	    return ans;
	}else{
	    int[] ans = new int[0];
	    return ans;
	}
    }





   /**mutator for the animate variable  **/
    public void setAnimate(boolean b){ animate = b; }    


    public BetterMaze(String filename){
	animate = false;
	int maxc = 0;
	int maxr = 0;
	startRow = -1;
	startCol = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxr == 0){
		    //calculate width of the maze
		    maxc = line.length();
		}
		//every new line add 1 to the height of the maze
		maxr++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	System.out.println(maxr+" "+maxc);
	maze = new char[maxr][maxc];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i / maxc][i % maxc] = c;
	    if(c == 'S'){
		startCol = i % maxc;
		startRow = i / maxc;
	    }
	}
    }







    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	}else{
	    return ans + color(37,40) + "\n";
	}
    } 
    

    public static void main(String[]args){
	BetterMaze a = new BetterMaze("data1.dat");
	a.setAnimate(true);
	if(a.solveDFS()){
	    System.out.println(a);
	    //System.out.println(a.printSolution());
	}
    }
       
    
    

}
