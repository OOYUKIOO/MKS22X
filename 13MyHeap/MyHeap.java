import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{

    private T[] heap;
    private int size;
    private boolean max;

    public MyHeap(){
	//	heap = (T[])new Object[0];
	//size = 0;
    }

    public MyHeap(int length){

    }

    public MyHeap(T[] array){

    }

    public MyHeap(T[] array, boolean isMax){
	heap = (T[])new Object[array.length+1];
	for(int i = 1; i<heap.length; i++){
	    heap[i] = array[i-1];
	}
	size = array.length;
	max = isMax;
	heapify();
    }

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


    public static void main(String[]args){
	Integer[] x = new Integer[5];
	for (Integer num : x){
	    num = new Integer((int)Math.random()*10);
	}
	MyHeap<Integer> h = new MyHeap<Integer>(x, true);
    }

}
