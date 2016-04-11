import java.util.*;
public class MyStack<T>{
    private int size;
    private T item;
    private MyLinkedList<T> stack;
    private static boolean debugMatch = false;	

    public static void DEBUG(String s){
	if(debugMatch){
	    System.out.println(s);
	}
    }

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

    public int indexOf(T item){
	return stack.indexOf(item);
    }

    public static boolean isMatching(String s){
	String open = "({[<";
	String close = ")}]>";
	MyStack<String> parens = new MyStack<String>();
	for(int i = 0; i < s.length(); i ++){
	    String current = s.substring(i,i+1);
	    int posClose = close.indexOf(current);
	    int posOpen = open.indexOf(current);
	    DEBUG("current: "+current+"; pos: "+posClose);
	    if(posClose>=0){
		DEBUG(i+" "+parens.isEmpty()+open.substring(posClose,posClose+1));
		if(!parens.isEmpty() && 
		   open.substring(posClose,posClose+1).equals(parens.peek())){
		    parens.pop();
		}else{
		    parens.push(current);
		}
	    }else if(posOpen >= 0){
		parens.push(current);
	    }
	    DEBUG(parens.toString());
	}
	return parens.isEmpty();
    }
	
    public String toString(){
	String ans = stack.toString();
	return ans;
    }	
}
