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
	start++;
    }




    public String toString(){
	String ans = "[";
	for(int i = 0; i < circular.length; i++){
	    ans+= circular[i] + ",";
	}
	return(ans.substring(0,ans.length()-1)+"]");
    }



    //testing
    public static void main(String[]args){
	MyDeque x = new MyDeque();
	System.out.println(x);
    }

}
