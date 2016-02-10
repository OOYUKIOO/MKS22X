public class nqueen{

    //variable
    int size;
    int[][] board;

    //constructor
    public nqueen(int size){
	this.size = size;
	board = new int[size][size];
    }

    //returns value for size
    public int getSize(){
	return size;
    }


    //add queen
    public void addQueen(int row, int col){

    }

    //for testing purpose
    public String chessboard(){
	String visual = "";
	for(int row = 0; row < size; row++){
	    for (int col = 0; col < size; col++){
		visual += board[row][col]+" ";
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
    }


}
