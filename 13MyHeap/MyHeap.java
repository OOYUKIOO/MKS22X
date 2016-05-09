import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{

    private T[] heap;
    private int size;
    private boolean max;

    public int compare(int first, int second){
	if(max){
	    return heap[first].compareTo(heap[second]);
	}else{
	    return (-1)*(heap[first].compareTo(heap[second]));
	}
    }
    
    
    public MyHeap(){
	heap = (T[])new Comparable[1];
	max = true;
	size = 0;
    }


    public MyHeap(T[] array){
	heap = (T[])new Comparable[array.length + 1];
	for(int i = 1; i < heap.length; i++){
	    heap[i] = array[i-1];
	}
	max = true;
	size = array.length;
	heapify();
    }

    public MyHeap(boolean isMax){
	this();
	max = isMax;
    }
    
    public MyHeap(T[] array, boolean isMax){
	heap = (T[])new Comparable[array.length + 1];
	for(int i = 1; i < heap.length; i++){
	    heap[i] = array[i-1];
	}
	max = isMax;
	size = array.length;
	heapify();
	
    }

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
	if(heap[index] != null){
	    int newIndex;	
	    if((index * 2 + 1) <= size){
		if(compare(index,index*2) < 0 ||
		   compare(index,index*2+1) < 0){
		    if(compare(index*2,index*2+1) < 0){
			newIndex = index*2+1;
		    }else{
			newIndex = index*2;
		    }
		    pushDown(index,newIndex-index*2);
		    heapify(newIndex);
		}
	    }else if((index * 2) <= size &&
		     compare(index,index*2) < 0){
		newIndex = index*2;
		pushDown(index,0);
		heapify(newIndex);
	    }else if(index > 1 &&
		     compare(index,index/2) > 0){
		pushUp(index);
		heapify(index/2);
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

    public int height(){
	if(heap.length == 1){
	    return 0;
	}
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

    private void doubleSize(){
	T[] newHeap = (T[])new Comparable[heap.length*2];
	for(int i = 0; i<heap.length; i++){
	    newHeap[i] = heap[i];
	}
	heap = newHeap;
    }

    public void add(T item){
	int index = size+1;
	if(index >= heap.length){
	    doubleSize();
	}
	heap[index] = item;
	size += 1;
	heapify(index);
    }

    public T delete(){
	T ans = heap[1];
	heap[1] = heap[size];
	heap[size] = null;
	size -= 1;
	heapify(1);
	return ans;
    }

    public String toString(){
	String ans = "";
	for(T item : heap){
	    if(item == null){
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
	
	MyHeap<Integer> h = new MyHeap<Integer>(x,false);
	System.out.println(h);
	h.add(new Integer(5));
	h.add(new Integer(2));
	h.add(new Integer(8));
	System.out.println(h);
	h.delete();
	System.out.println(h);
	h.add(new Integer(7));
	System.out.println(h);
    }

}
