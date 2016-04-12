public class Node{

    private int id;
    private Node prev;

    public Node(){
	this(0,null);
    }

    public Node(int id, Node prev){
	this.id = id;
	this.prev = prev;
    }




}
