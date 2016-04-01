import java.util.Arrays;
public class MyDeque<T>{

    private int start;
    private int end;
    private int size;
    private T[] circular;

    public MyDeque(Class<T> x){
	@SuppressWarnings("unchecked")
	    //	circular = (T[])new Object[10];
	    final T[] circular = (T[]) Array.newInstance(x,10);
	this.circular = circular;
    }

    private void resize(){

    }


}
