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

	return false;
    }

    public void printSolution(){

    }

}
