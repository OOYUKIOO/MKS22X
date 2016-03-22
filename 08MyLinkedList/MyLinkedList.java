import java.util.*;
public class MyLinkedList<T>{

    LNode start;
    LNode end;
    int size;


    static boolean debug = false;
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
	    T item;
	    start = new LNode(new T());
	    end = start;
	    while(iLength != length-1){
		add(item);
		iLength++;
		end = end.getNext();
	    }
	    size++;
	}
    }

    public int getSize(){
	return size;
    }

    public boolean add(T value){
	end.setNext(new LNode(value));
	//	start.setNext(end);
	size++;
	return true;
    }

    public boolean add(int pos, T value){
	LNode newNode = new LNode(value);
	LNode temp = start;
	LNode after;
	int index = 0;
	if(pos < 0 || pos >= getSize()){
	    throw new IndexOutOfBoundsException();
	    
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
	    size++;
	    return true;
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
	while(index < getSize()-1){
	    DEBUG(""+index);
	    if(temp.getValue() == value){
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
	MyLinkedList<Integer> list = new MyLinkedList<Integer>(10);
	//	list.add(5,new Integer(4));
	//	list.add(0,9);
	//	list.add(4,3);
	System.out.println(list);
	/*
	System.out.println(list.indexOf(0));
	System.out.println(list.indexOf(8));
	System.out.println(list.indexOf(20));
	*/
    }


}
