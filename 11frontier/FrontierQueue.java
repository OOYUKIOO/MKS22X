import java.util.*;
public class FrontierQueue<T> implements Frontier<T>{
    private int size;
    private T item;
    private MyLinkedList<T> queue;

    public FrontierQueue(){
	this(0);
    }

    public FrontierQueue(int size){
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

    public void add(T value){

    }

    public T next(){
	return null;
    }

    public boolean hasNext(){
	return true;
    }

}
