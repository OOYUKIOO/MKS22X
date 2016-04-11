import java.util.*;
public class FrontierQueue<T> implements Frontier<T>{

    MyQueue<T> queue = new MyQueue<T>();

    public void add(T value){

    }

    public T next(){
	return null;
    }

    public boolean hasNext(){
	return true;
    }

    public String toString(){
	String ans = queue.toString();
	return ans;
    }

}
