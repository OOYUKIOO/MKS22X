import java.util.Random;
import java.util.Arrays;
import java.lang.System;
public class QuickOld{

    static boolean DEBUG = false;

    private static void debug(String s){
	if(DEBUG){
	    System.out.println(s);
	}
    }

    public static String name(){
	return "6,Chen,Yuxuan";
    }


    public static int quickselectOld(int[]data, int k){
	return quickselectOld(data,k,0,data.length-1);
    }

    private static int quickselectOld(int[]data, int k, int left, int right){
	int guess = partitionOld(data,left,right);
	debug("guess position = "+guess+"\nresult array is: ");
	printArray(data);
	if(guess == k){
	    return data[guess];
	}else if(guess < k){
	    return quickselectOld(data,k,guess+1,right);
	}else{
	    return quickselectOld(data,k,left,guess-1);
	}
    }

    private static int partitionOld(int[]data, int left, int right){
	Random rand = new Random();
	int leftI = left;
	int rightI = right;
	int pos = 0;       
	if(left == right){
	    return left;
	}else{
	    pos = left + rand.nextInt(right-left + 1);
	}
	int selected = data[pos];
	data[pos] = data[right];
	data[right] = selected;
	right --;
	while(left != right){
	    int temp = data[left];
	    if(temp <= selected){
		left++;
	    }else{
		data[left] = data[right];
		data[right] = temp;
		right--;
	    }
	}
	if(data[left] < selected){
	    left++;
	}
	data[rightI] = data[left];
	data[left] = selected;
	return left;
    }

    public static void quickSortOld(int[]data){
	quickSortOld(data,0,data.length-1);
    }

    private static void quickSortOld(int[]data, int left, int right){
	if(right>left){
	    int offset = partitionOld(data,left,right);
	    //   printArray(data);
	    quickSortOld(data,left,offset-1);
	    quickSortOld(data,offset+1,right);
	    
	}
    }


    public static void printArray(int[]data){
	String ans = "[";
	if(data.length == 0){
	    ans+= " ";
	}
	for(int i = 0; i < data.length; i++){
	    ans += data[i]+",";
	}
	System.out.println(ans.substring(0,ans.length()-1)+"]");
    }

    //testing
    public static void main(String[]args){
	int[] x = new int[9000];
	int[] y = new int[9000];
	Random rand = new Random();
	for(int i = 0; i < x.length; i++){
	    x[i] = rand.nextInt(10000);
	    y[i] = x[i];
	}
	/*
	printArray(x);
	System.out.println(quickselect(x,8));
	printArray(x);
	*/	

	//runtime result, quickSort takes around 10 millisecond more
	long startTimeX = System.currentTimeMillis();
	quickSortOld(x);
	long endTimeX = System.currentTimeMillis();

	long startTimeY = System.currentTimeMillis();
	Arrays.sort(x);
	long endTimeY = System.currentTimeMillis();

	System.out.println("Time for quickSort is :" + (endTimeX - startTimeX) +
			   "\nTime for array sort is : " + (endTimeY - startTimeY));

    }

}
