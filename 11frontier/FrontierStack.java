import java.util.*;
public class FrontierStack<T> implements Frontier<T>{

    MyStack<T> stack = new MyStack<T>();

    public void add(T value){
	stack.push(value);
    }

    public T next(){
	if(hasNext()){
	    return stack.pop();
	}
	throw new NoSuchElementException();
    }

    public boolean hasNext(){
	return !stack.isEmpty();
    }


    public String toString(){
	String ans = stack.toString();
	return ans;
    }
}
