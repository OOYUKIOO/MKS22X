import java.util.*;
public class FrontierStack<T> implements Frontier<T>{

    MyStack<T> stack = new MyStack<T>();

    public void add(T value){
	stack.push(value);
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
