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


    //test
    /*
    public static void main(String[]args){
	nqueen x = new nqueen(4);
	String a = x.chessboard();
	System.out.println(a);

	x.addQueen(0,2);
	String b = x.chessboard();
	System.out.println(b);

	x.addQueen(2,3);
	String c = x.chessboard();
	System.out.println(c);

	x.removeQueen(2,3);
	String d = x.chessboard();
	System.out.println(d);
    }
    */

public static void main(String[]args){
	nqueen b = new nqueen(5);
        System.out.println(b);
	b.addQueen(3,0);
	b.addQueen(0,1);
        System.out.println(b);
	b.removeQueen(3,0);
        System.out.println(b);
}

}
