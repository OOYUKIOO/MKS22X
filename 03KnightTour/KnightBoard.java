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

	return false;
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
	KnightBoard a = new KnightBoard(3);
	a.printSolution();
    }


}
