import java.util.*;
public class RunningMedian{

    private MyHeap<Integer> maxHeap;
    private MyHeap<Integer> minHeap;

    private boolean DEBUG = false;;
    public void debug(String s){
	if(DEBUG){
	    System.out.println(s);
	}
    }


    public RunningMedian(){
	maxHeap = new MyHeap<Integer>();
	minHeap = new MyHeap<Integer>();
    }

    public double getMedian(){
	if(maxHeap.getSize() + minHeap.getSize() == 0){
	    System.out.println(maxHeap);
	    System.out.println(minHeap);
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
	double med;
	try{
	    med = getMedian();
	}catch(NoSuchElementException e){
	    med = 0;
	}
	if(maxHeap.getSize() == minHeap.getSize()){
	    if(x <= med){
		debug("add to left");
		maxHeap.add(x);
	    }else{
		debug("add to right");
		minHeap.add(x);
	    }
	}else if(maxHeap.getSize() > minHeap.getSize()){
	    if(x >= med){
		debug("add to right");
		minHeap.add(x);
	    }else{
		Integer moveOver = maxHeap.delete();
		debug("add to left");
		maxHeap.add(x);
		minHeap.add(moveOver);
	    }
	}else{
	    if(x <= med){
		debug("add to left");
		maxHeap.add(x);
	    }else{
		Integer moveOver = minHeap.delete();
		debug("add to right");
		minHeap.add(x);
		maxHeap.add(moveOver);
	    }
	}
    }

    public String toString(){
	String left = maxHeap.toString().substring(0,maxHeap.toString().length()-2);
	String right = minHeap.toString().substring(1);
	try{
	    return left + " |" + right + " Median = " + getMedian();
	}catch(NoSuchElementException e){
	    return left + " |" + right + " Median = N/A";
	}
	
    }


    public static void main(String[]args){

	RunningMedian a = new RunningMedian();
	System.out.println(a);
	a.add(new Integer(2));
	a.add(new Integer(1));
	a.add(new Integer(9));
	a.add(new Integer(4));
	a.add(new Integer(7));
	a.add(new Integer(0));
	a.add(new Integer(-4));
	System.out.println(a);


    }
}
