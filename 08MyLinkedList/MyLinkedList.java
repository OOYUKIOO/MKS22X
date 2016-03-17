public class MyLinkedList{

    LNode start;
    int size;

   
    //constructor
    public MyLinkedList(int size){
	this.size = size;
	int length = 0;
	while(length != size){
	    add(0);
	    length++;
	}
    }

    /* public void MyLinkedListH(int size){
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

    public int get(int pos){
	int index = 0;
	LNode temp = start;
	while(index != pos){
	    index++;
	    temp = temp.getNext();
	}
	return temp.getValue();
    }

    public void set(int pos, int value){
	int index = 0;
	LNode temp = start;
	while(index != pos){
	    index++;
	    temp = temp.getNext();
	}
	temp.setValue(value);
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
	MyLinkedList list = new MyLinkedList(0);
	/*	for(int i = 0; i < 21; i ++){
	    list.add(i);
	}
	list.set(9,10);
	*/
	System.out.println(list);
	//	System.out.println(list.get(4));
    }


}
