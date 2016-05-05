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
	heap = (T[])new Object(array.length+1);
	size = array.length;
	max = isMax;
    }

    private void convert(){

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



}
