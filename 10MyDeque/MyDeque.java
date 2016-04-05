import java.util.*;
public class MyDeque<T>{

    private int start;
    private int end;
    private int size;
    private T[] circular;
    
    @SuppressWarnings("unchecked")
    public MyDeque(int length){
	circular = (T[])new Object[length];
	size = 0;
    }

    public MyDeque(){
	this(10);
    }
    @SuppressWarnings("unchecked")
    private void resize(){
	T[] newCircular = (T[])new Object[size*2];
	end = 0;
	for (int i = start; i<circular.length; i++){
	    newCircular[i-start] = circular[i];
	    end++;
	}
	/*
	for (int i = 0; i<start; i++){
	    newCircular[start+1+i]=circular[i];
	    end++;
	}
	*/
	start = 0;
	circular = newCircular;
    }

    public void addFirst(T value){
	start--;
	if(start < 0){
	    start = circular.length-1;
	}
	if(start == end){
	    resize();
	}
	circular[start] = value;
	size++;
    }

    public void addLast(T value){
	end++;
	if(end > circular.length-1){
	    end = 0;
	}
	if(end == start){
	    resize();
	}
	circular[end] = value;
	size++;
    }

    public T removeFirst(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	T ans = circular[start];
	circular[start] = null;
	start++;
	size--;
	return ans;
    }

    public T removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	T ans = circular[end];
	circular[end] = null;
	end--;
	size--;
	return ans;
    }

    public int getSize(){
	return size;
    }

    public String toString(){
	String ans = "[";
	for(int i = 0; i < circular.length; i++){
	    ans+= circular[i] + ",";
	}
	return(ans.substring(0,ans.length()-1)+"]");
    }

    public void debugString(){
	System.out.println(toString()+", size="+getSize()+", start ="+start+", end="+end);
    }



    //testing
    public static void main(String[]args){
	MyDeque<Integer> x = new MyDeque<Integer>();
	for(int i = 0; i<5; i++){
	    x.addFirst(new Integer(i));
	}
	x.debugString();
	for(int i = 0; i<5; i++){
	    x.addLast(new Integer(i));
	}
	x.debugString();
	for(int i = 0; i<3; i++){
	    x.removeFirst();
	}
	x.debugString();
	for(int i = 0; i<4; i++){
	    x.removeLast();
	}
	x.debugString();
    }

}
