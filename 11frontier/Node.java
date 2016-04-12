public class Node{

    private int[] coord;
    private Node prev;

    public Node(int[] coord, Node prev){
	this.coord = coord;
	this.prev = prev;
    }

    public int[] getValue(){
	return coord;
    }

    public Node getPrev(){
	return prev;
    }

}
