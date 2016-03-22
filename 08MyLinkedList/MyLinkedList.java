import java.util.*;
public class MyLinkedList<T>{

    LNode start;
    LNode end;
    T item;
    int size;


    static boolean debug = false;
    public static void DEBUG(String s){
	if(debug){
	    System.out.println(s);
	}
	    }
   
    //constructor
    public MyLinkedList(int length){
	size = 0;
	if(length != 0){
	    start = new LNode(item);
	    end = start;
	    while(getSize() < length-1){
		add(item);
		end = end.getNext();
	    }
	}
    }

    public int getSize(){
	return size;
    }

    public boolean add(T value){
	if(getSize() == 0){
	    start = new LNode(item);
	    start.setValue(value);
	    size++;
	}else{
	    end.setNext(new LNode(value));
	    size++;
	}
	return true;
    }

    public boolean add(int pos, T value){
	LNode newNode = new LNode(value);
	LNode temp = start;
	LNode after;
	int index = 0;
	if(pos >= 0 && pos<=getSize()){
	    if(getSize() == 0){
		add(value);
	    }else{
		while(index < pos-1){
		    temp = temp.getNext();
		    index++;
		}
		if(pos == 0){
		    after = temp;
		    start = newNode;
		    start.setNext(after);
		}else if (pos == size-1){
		    add(value);
		}else{
		    after = temp.getNext();
		    temp.setNext(newNode);
		    newNode.setNext(after);

		}
		//	    start = temp;
		size++;
	    }
	    return true;
	}else{
	    throw new IndexOutOfBoundsException();
	}
    }

    public T remove(int pos){
	int index = 0;
	LNode temp = start;
	T removed;
	if (size == 0){
	    throw new NoSuchElementException();
	}
	if(pos < 0 || pos >= getSize()){
	    throw new IndexOutOfBoundsException();
	}
	while(index < pos-1){
	    temp = temp.getNext();
	    index++;
	}
	if(pos == 0){
	    removed = start.getValue();
	    start = start.getNext();
	}else{
	    removed = temp.getNext().getValue();
	    temp.setNext(temp.getNext().getNext());
	}
	return removed;
    }

    public T get(int pos){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	if(pos < 0 || pos >= getSize()){
	    throw new IndexOutOfBoundsException();
	}
	int index = 0;
	LNode temp = start;
	while(index != pos){
	    index++;
	    temp = temp.getNext();
	}
	return temp.getValue();
    }

    public void set(int pos, T value){
	int index = 0;
	LNode temp = start;
	if(size == 0){
	    throw new NoSuchElementException();
	}
	if(pos < 0 || pos >= getSize()){
	    DEBUG("out of bound");
	    throw new IndexOutOfBoundsException();
	}
	while(index != pos){
	    index++;
	    temp = temp.getNext();
	}
	temp.setValue(value);
    }

    public int indexOf(T value){
	LNode temp = start;
	int index = 0;
	while(index < getSize()){
	    DEBUG(""+index);
	    if(temp.getValue().equals(value)){
		return index;
	    }else{
		temp = temp.getNext();
		index ++;
	    }
	}
	    return -1;
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

    public String toString(boolean extra){
	if(extra){
	    return toString()+" head:"+start.getValue()+" tail:";
	}else{
	    return toString();
	}
    }



    //inner class
    private class LNode{
	T value;
	LNode next;

	public LNode(T value){
	    this.value = value;
	}

	public T getValue(){
	    return value;
	}

	public LNode getNext(){
	    return next;
	}

	public void setValue(T newValue){
	    value = newValue;
	}

	public void setNext(LNode newNext){
	    next = newNext;
	}

    }

    //test
    public static void main(String[]args){
	
	MyLinkedList<Integer> list = new MyLinkedList<Integer>(0);
	System.out.println(list);
	list.add(0,new Integer(5));
	System.out.println(list);
	System.out.println(list.getSize());
	System.out.println(list.toString(true));
	

	/*
	System.out.println(list.indexOf(0));
	System.out.println(list.indexOf(8));
	System.out.println(list.indexOf(20));
	*/
    }


}
