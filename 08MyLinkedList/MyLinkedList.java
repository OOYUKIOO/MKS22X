public class MyLinkedList{

    LNode start;
    int size;

    /*
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
    */
    public boolean add(int value){
	if(start == null){
	    start = new LNode(value);
	}else{
	    LNode temp = start;
	    while(temp.getNext() != null){
		temp = temp.getNext();
	    }
	    temp.setNext(new LNode(value));
	}
	size++;
	return true;
    }

    public int get(){
	return 0;
    }

    public void set(){

    }

    public String toString(){
	String ans = "[";
	LNode temp = start;
	while(temp != null){
	    ans += temp.getValue();
	    if(temp.getNext() != null){
		ans+=", ";
	    }
	    temp = temp.getNext();
	}
	return ans+"]";
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

    //test
    public static void main(String[]args){
	MyLinkedList list = new MyLinkedList();
	for(int i = 0; i < 21; i ++){
	    list.add(i);
	}
	System.out.println(list);
    }


}
