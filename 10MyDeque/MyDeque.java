import java.util.Arrays;
public class MyDeque<T>{

    private int start;
    private int end;
    private int size;
    private T[] circular;
    
    @SuppressWarnings("unchecked")
    public MyDeque(int size){
	circular = (T[])new Object[size];
	this.size = size;
    }

    public MyDeque(){
	this(10);
    }

    private void resize(){
	MyDeque newCircular = new MyDeque(size*2);
	for (int i = 0; i<circular.length; i++){
	    //	    newCircular[i] = circular[i];
	}
	//	circular = newCircular;
    }

    public void addFirst(T value){
	circular[start] = value;
	start--;
	if(start < 0){
	    start = circular.length-1;
	}
    }

    public void addLast(T value){
	circular[end] = value;
	end++;
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
	for(int i = 0; i<4; i++){
	    x.addFirst(new Integer(i));
	}
	x.debugString();
	for(int i = 0; i<5; i++){
	    x.addLast(new Integer(i));
	}
	x.debugString();
    }

}
