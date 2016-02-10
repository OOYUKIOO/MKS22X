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
    public void addQueen(int row, int col){
 	for(int pcol = 0; pcol < size; pcol++){
	    board[row][pcol] = board[row][pcol]-1;
	}
	for(int prow = 0; prow < size; prow++){
	    board[prow][col] = board[prow][col]-1;
	}
	board[row][col] = 1;
    }

    //remove queen
    public void removeQueen(int row, int col){
	for(int pcol = 0; pcol < size; pcol++){
	    board[row][pcol] = board[row][pcol]+1;
	}
	for (int prow = 0; prow < size; prow++){
	    board[prow][col] = board[prow][col]+1;
	}
	board[row][col] = 0;
    }

    //for testing purpose
    public String chessboard(){
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


}
