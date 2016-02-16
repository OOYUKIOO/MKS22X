public class KnightBoard{
    //variables
    public int[][]board;


    //constructor
    public KnightBoard(int size){
	board = new int[size][size];
	//initial all to -1, unvisitied
	for(int row = 0; row < board.length; row++){
	    for (int col = 0; col < board[row].length; col++){
		board[row][col] = -1;
	    }
	}
    }


    public boolean solve(){
	return solveHelper(0,0,0);
    }

    //helper function
    public boolean solveHelper(int row, int col, int move){
	if(row<0 || row>= board.length || col<0 || col>=board[row].length){
	    return false;
	}  
	if(board[row][col] != -1){
	    return false;
	}
	if(move == (board.length * board[row].length - 1)){
	    board[row][col] = move;
	    return true;
	}else{
	    board[row][col] = move;
	    //	    printSolution();

	    boolean temp = false;
	    temp = temp || solveHelper(row+1,col+2,move+1);
	    temp = temp || solveHelper(row+1,col-2,move+1);
	    temp = temp || solveHelper(row-1,col+2,move+1);
	    temp = temp || solveHelper(row-1,col-2,move+1);
	    temp = temp || solveHelper(row+2,col+1,move+1);
	    temp = temp || solveHelper(row+2,col-1,move+1);
	    temp = temp || solveHelper(row-2,col+1,move+1);
	    temp = temp || solveHelper(row-2,col-1,move+1);
	    if(temp){
		return true;
	    }else{
		board[row][col] = -1;
		//		printSolution();
		return false;
	    }
	}
    }

    public void printSolution(){
	String visual = "";
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board[row].length; col++){
		visual += board[row][col]+" ";
	    }
	    visual += "\n";
	}
	System.out.println(visual);
    }

    //testing
    public static void main(String[]args){
	KnightBoard a = new KnightBoard(6);
	a.solve();
	a.printSolution();
    }


}
