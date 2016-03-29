import java.util.*;
public class MyStack<T>{
    private int size;
    private T item;
    private MyLinkedList<T> stack;
	
    public MyStack(){
	this(0);
    }
	
    public MyStack(int size){
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
	
    public String toString(){
	String ans = stack.toString();
	return ans;
    }
    
    public static void main(String[]args){	

	boolean debug = false;

	if(debug){
	    MyStack<Integer> x = new MyStack<Integer>();
	    System.out.println(x);
	    try{
		x.peek();
	    }catch(NoSuchElementException e){
		System.out.println("Gotcha!");
	    }
	    System.out.println(x.isEmpty());
	    for(int i = 0; i < 20; i ++){
		x.push(new Integer(i));
	    }
	    System.out.println(x);
	    System.out.println(x.pop());
	    System.out.println(x.pop());
	    System.out.println(x.pop());
	    System.out.println(x.peek());
	    System.out.println(x);
	    System.out.println(x.size());
	    System.out.println(x.isEmpty());
	}
    }
	
}