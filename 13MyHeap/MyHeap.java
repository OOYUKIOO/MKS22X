public class MyHeap<T extends Comparable<T>>{

    T[] heap;


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
