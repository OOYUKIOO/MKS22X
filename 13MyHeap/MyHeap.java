import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{

    private T[] heap;
    private int size;
    private boolean max;

    public MyHeap(){
	heap = (T[])new Comparable[1];
	size = 0;
    }


    public MyHeap(T[] array){
	heap = (T[])new Comparable[array.length + 1];
	size = array.length;
	for(int i = 1; i < heap.length; i++){
	    heap[i] = (array[i-1]);
	    System.out.println(array[i-1] + "," + heap[i]);
	}
	heapify();
    }

    /*
    public MyHeap(T[] array, boolean isMax){
	heap = (T[])new Object[array.length+1];
	for(int i = 1; i<heap.length; i++){
	    heap[i] = array[i-1];
	}
	size = array.length;
	max = isMax;
	heapify();
    }
    */

    private void heapify(){
	int len = (int)Math.pow(2,height());
	int start = len/4;
	int end = len/2;
	while(start < end){
	    heapify(start);
	    if(start == end - 1){
		len = end;
		start = len/4;
		end = len/2;
	    }else{
		start++;
	    }
	}

    }

    private void heapify(int index){
	if((index * 2) < heap.length && heap[index] != null){
	    int newIndex;	
	    if(heap[index].compareTo(heap[index*2]) < 0){
    		if(heap[index].compareTo(heap[index*2+1]) < 0 &&
		   heap[index*2+1].compareTo(heap[index*2]) > 0){
		    newIndex = index*2 + 1;
		}else{
		    newIndex = index*2;
		}
		pushDown(index,newIndex-index*2);

		System.out.println("parent index:" + index + ", " +
				   "child index:" + newIndex);

		heapify(newIndex);
	    }
	    /*
	    else if(heap[index].compareTo(heap[index*2+1]) < 0){
		int newIndex = index*2+1;
		pushDown(index,1);

		System.out.println("child index:" + index + ", " +
				   "parent index:" + newIndex);

		heapify(newIndex);
	    }
	    */
	}
    }

    private void pushUp(int index){
	T child = heap[index];
	heap[index] = heap[index/2];
	heap[index/2] = child;
    }

    private void pushDown(int index, int shift){
	T parent = heap[index];
	heap[index] = heap[index*2+shift];
	heap[index*2+shift] = parent;
    }

    public int height(){
	double decHeight = Math.log(size);
	int height = (int)decHeight;
	double round = 0.5;
	if(decHeight - height >= round){
	    height += 2;
	}else{
	    height += 1;
	}
	return height;
    }

    public String toString(){
	String ans = "";
	for(T item : heap){
	    if(item == null){
		ans += "_ ";
	    }else{
		ans += item+" ";
	    }
	}
	return ans;
    }


    public static void main(String[]args){
	Integer [] x = new Integer[5];
	
	for(int i = 0; i < x.length; i++){
	    x[i] = new Integer(i);
	}
	
	MyHeap<Integer> h = new MyHeap<Integer>(x);
	System.out.println(h);
	System.out.println(h.height());
	System.out.println(Math.log(16));
    }

}
