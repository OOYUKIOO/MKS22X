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
	double med = getMedian();
	if(maxHeap.getSize() == minHeap.getSize()){
	    if(x <= med){
		maxHeap.add(x);
	    }else{
		minHeap.add(x);
	    }
	}else if(maxHeap.getSize() > minHeap.getSize()){
	    if(x >= med){
		minHeap.add(x);
	    }else{
		Integer moveOver = maxHeap.delete();
		maxHeap.add(x);
		minHeap.add(moveOver);
	    }
	}else{
	    if(x <= med){
		maxHeap.add(x);
	    }else{
		Integer moveOver = minHeap.delete();
		minHeap.add(x);
		maxHeap.add(moveOver);
	    }
	}
    }

    public String toString(){
	String ans="";
	return ans;

    }

}
