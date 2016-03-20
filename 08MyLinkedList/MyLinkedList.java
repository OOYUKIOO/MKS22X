public class MyLinkedList{

    LNode start;
    LNode end;
    int size;


    static boolean debug = true;
    public static void DEBUG(String s){
	if(debug){
	    System.out.println(s);
	}
	    }
   
    //constructor
    public MyLinkedList(int length){
	//this.size = size;
	if(length != 0){
	    int iLength = 0;
	    start = new LNode(0);
	    end = start;
	    while(iLength != length-1){
		add(0);
		DEBUG("got through one");
		iLength++;
		end = end.getNext();
	    }
	    size++;
	}
    }

    public String getSize(){
	return ""+size;
    }

    public boolean add(int value){
	end.setNext(new LNode(value));
	//	start.setNext(end);
	size++;
	return true;
    }

    public boolean add(int pos, int value){
	LNode newNode = new LNode(value);
	LNode temp = start;
	LNode after;
	int index = 0;
	while(index < pos-1){
	    temp = temp.getNext();
	    index++;
	}
	if(pos == 0){
	    after = temp;
	    start = newNode;
	    start.setNext(after);
	}else{
	    after = temp.getNext();
	    temp.setNext(newNode);
	    newNode.setNext(after);
	}
	size++;
	/*
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
	*/
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
	MyLinkedList list = new MyLinkedList(10);
	list.add(4,5);
	System.out.println(list);
	DEBUG(list.getSize());
	//	System.out.println(list.get(4));
    }


}
