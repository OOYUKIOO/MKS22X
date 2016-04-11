import java.util.*;
public class FrontierQueue<T> implements Frontier<T>{

    MyQueue<T> queue = new MyQueue<T>();

    public void add(T value){
	queue.enqueue(value);
    }

    public T next(){
	if(hasNext()){
	    return queue.dequeue();
	}
	throw new NoSuchElementException();
    }

    public boolean hasNext(){
	return !queue.isEmpty();
    }

    public String toString(){
	String ans = queue.toString();
	return ans;
    }

}
