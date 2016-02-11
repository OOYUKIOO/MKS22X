public class nqueen{

    //variable
    int size;
    int[][] board;

    //constructor
    public nqueen(int size){
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
	board[row][col] = 0;
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


    public boolean solved(){
	return solvedHelper(0,0);
    }

    public boolean solvedHelper(int row, int col){
	/*
	if(row == size){
	    return false;
	}
	if(row == size-1){
	    return (addQueen(row,col) || solvedHelper(row,col++));
	}
	if(col == size){
	    row ++;
	    col = 0;
	}
	if(addQueen(row,col) || solvedHelper(row,col++)){
	    return solvedHelper(row++,0);
	}else{
	    if(removeQueen(row--,col)){
		return solvedHelper(row--,col++);
	    }
	}
	*/
	return false;
    }

    /*
    public boolean solvedHelperH(int col){
	    
	}
    */


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
	nqueen b = new nqueen(2);
        System.out.println(b);
	b.addQueen(1,0);
	b.addQueen(0,1);
        System.out.println(b);
	b.removeQueen(1,0);
        System.out.println(b);
	System.out.println(b.solved());

}

}
