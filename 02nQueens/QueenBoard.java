public class QueenBoard{

    //variable
    int size;
    int[][] board;

    //constructor
    public QueenBoard(int size){
	this.size = size;
	board = new int[size][size];
    }


    //add queen
    public boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	col++;
	int offset = 1;
	while(col < board[row].length){
	    board[row][col]--;
	    if(row - offset >= 0){
		board[row-offset][col]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col]--;
	    }
	    col++;
	    offset++;
	}
	return true;
    }


    //remove queen
  public boolean removeQueen(int row, int col){
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = -1;
	col++;
	int offset = 1;
	while(col < board[row].length){
	    board[row][col]++;
	    if(row - offset >= 0){
		board[row-offset][col]++;
	    }
	    if(row + offset < board.length){
		board[row+offset][col]++;
	    }
	    col++;
	    offset++;
	}
	return true;
    }


    public boolean solve(){
	if(solveHelper(0)){
	    printSolution();
	    return true;
	}else{
	    return false;
	}
    }

    public boolean solveHelper(int col){
	if(col == size){
	    for(int i = 0; i < size; i++){
		if(board[i][col-1] == 1){
		    return true;
		}
	    }
	    return false;
	}
	for(int row = 0; row < size; row ++){
	    if(addQueen(row,col)){

		//printSolution();
		return solveHelper(col+1);
	    }
	    if(col == 0){
		return false;
	    }
	}
	for(int row = 0; row < size; row++){
	    if(removeQueen(row,col-1)){
		return solveHelper(col-1);
	    }
	}
	return false;
    }

    public void printSolution(){
	String chessBoard = "";
	for(int row = 0; row < size; row++){
	    for(int col = 0; col < size; col++){
		if(board[row][col] <= 0){
		    chessBoard+="_ ";
		}else{
		    chessBoard +="Q ";
		}
	    }
	    chessBoard+="\n";
	}
	System.out.println(chessBoard);
    }

    //for testing purpose
    public String toString(){
	String visual = "";
	for(int row = 0; row < size; row++){
	    for (int col = 0; col < size; col++){
		visual += board[row][col]+"  ";
	    }
	    visual+= "\n";
	}
	return visual;
    }


public static void main(String[]args){
    /* For testing
    for(int i = 0; i < 20; i++){
	QueenBoard a = new QueenBoard(i);
	System.out.println(""+i+"  \n"+a.solve());
    }
    */
}

}
