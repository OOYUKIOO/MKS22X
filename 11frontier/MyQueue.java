import java.util.*;
public class MyQueue<T>{
    private int size;
    private T item;
    private MyLinkedList<T> queue;

    public MyQueue(){
	this(0);
    }

    public MyQueue(int size){
	this.size = size;
	queue = new MyLinkedList<T>(size);
    }

    public void enqueue(T item){
	queue.add(item);
	size++;
    }

	
    public T dequeue(){
	if(isEmpty()){
	    throw new NoSuchElementException();
	}else{
	    T ans = queue.get(0);
	    queue.remove(0);
	    size--;
	    return ans;
	}
    }

    public T peek(){
	if(isEmpty()){
	    throw new NoSuchElementException();
	}else{
	    return queue.get(0);
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
	String ans = queue.toString();
	return ans;
    }

     public static void main(String[]args){
 	
	 boolean debug = false;
	 if(debug){
	    MyQueue<Integer> x = new MyQueue<Integer>();
	    System.out.println(x);
	    try{
		x.dequeue();
	    }catch(NoSuchElementException e){
		System.out.println("Gotcha!");
	    }
	    System.out.println(x.isEmpty());
	    for(int i = 0; i < 20; i ++){
		x.enqueue(new Integer(i));
	    }
	    System.out.println(x);
	    System.out.println(x.dequeue());
	    System.out.println(x.dequeue());
	    System.out.println(x.dequeue());
	    System.out.println(x.peek());
	    System.out.println(x);
	    System.out.println(x.size());
	    System.out.println(x.isEmpty());
 	}
     }
}
