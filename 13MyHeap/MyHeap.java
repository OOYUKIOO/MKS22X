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
	//	heapify();
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
	int len = heap.length;
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
	if((index * 2) < (heap.length)){
	    if(heap[index].compareTo(heap[index*2]) < 0){
		int newIndex = index*2;
		pushDown(index,0);
		heapify(newIndex);
	    }else if(heap[index].compareTo(heap[index*2+1]) < 0){
		int newIndex = index*2+1;
		pushDown(index,1);
		heapify(newIndex);
	    }
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
    }

}
