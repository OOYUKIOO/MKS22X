public class MyLinkedList{

    LNode start;
    int size;


    public int add(){
	return 0;
    }

    public int get(){
	return 0;
    }

    public void set(){

    }

    public String toString(){
	return "";
    }


    //inner class
    private class LNode{
	int value;
	int next;

	public LNode(int value, int next){
	    this.value = value;
	    this.next = next;
	}

	public int getValue(){
	    return value;
	}

	public int getNext(){
	    return next;
	}

    }



}
