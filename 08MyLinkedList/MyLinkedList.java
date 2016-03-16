public class MyLinkedList{

    LNode start;
    int size;

    //constructor
    public MyLinkedList(int size){
	this.size = size;
	MyLinkedListH(size);
    }

    public void MyLinkedListH(int size){
	if(size == 0 ){
	    start = null;
	}else{
	    start.setValue(0);
	    //	    MyLinkedList newStart = new MyLinkedList(size-1);
	    start.setNext(new MyLinkedList(size-1).start);
	}
    }

    public int add(){
	return 0;
    }

    public int get(){
	return 0;
    }

    public void set(){

    }

    public String toString(){
	String ans = toString(start,"");
	return ans;
    }

    public String toString(LNode node, String ans){
	if (size > 0){
	    ans += node.getValue();
	    if(node.getNext() != null){
		toString(node.getNext(),ans);
	    }
	}
	return ans;
    }


    //inner class
    private class LNode{
	int value;
	LNode next;

	public LNode(int value){
	    this.value = value;
	}

	public int getValue(){
	    return value;
	}

	public LNode getNext(){
	    return next;
	}

	public void setValue(int newValue){
	    value = newValue;
	}

	public void setNext(LNode newNext){
	    next = newNext;
	}

    }



}
