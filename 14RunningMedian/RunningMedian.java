import java.util.*;
public class RunningMedian{

    private MyHeap<Integer> maxHeap;
    private MyHeap<Integer> minHeap;

    public RunningMedian(){
	maxHeap = new MyHeap<Integer>();
	minHeap = new MyHeap<Integer>();
    }

    public double getMedian(){
	if(maxHeap.getSize() + minHeap.getSize() == 0){
	    throw new NoSuchElementException();
	}
	double med = 0.;
	if(maxHeap.getSize() == minHeap.getSize()){
	    med = (maxHeap.peek() + minHeap.peek())/2.;
	}else if (maxHeap.getSize() > minHeap.getSize()){
	    med = maxHeap.peek();
	}else{
	    med = minHeap.peek();
	}
	return med;
    }

    public void add(Integer x){

	if(maxHeap.getSize() == minHeap.getSize()){

	}
    }


}
