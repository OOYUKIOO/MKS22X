import java.util.*;
public class FrontierStack<T> implements Frontier<T>{

    private int size;
    private T item;
    private MyLinkedList<T> stack;
    private boolean debugMatch = false;	

    public void DEBUG(String s){
	if(debugMatch){
	    System.out.println(s);
	}
    }

    public FrontierStack(){
	this(0);
    }
	
    public FrontierStack(int size){
	this.size = size;
	stack = new MyLinkedList<T>(size);
    }

    public void push(T item){
	stack.add(0,item);
	size++;
    }
	
	
    public T pop(){
	if(isEmpty()){
	    throw new NoSuchElementException();
	}else{
	    T ans = stack.get(0);
	    stack.remove(0);
	    size--;
	    return ans;
	}
    }
	
    public T peek(){
	if(isEmpty()){
	    throw new NoSuchElementException();
	}else{
	    return stack.get(0);
	}
    }
	
    public int size(){
	return size;
    }
	
    public boolean isEmpty(){
	if(size == 0){
	    return true;
	}else{
	    return false;
	}
    }
	
    public int indexOf(T item){
	return stack.indexOf(item);
    }



    public void add(T value){

    }

    public T next(){
	return null;
    }

    public boolean hasNext(){
	return true;
    }


    public String toString(){
	String ans = stack.toString();
	return ans;
    }
}
