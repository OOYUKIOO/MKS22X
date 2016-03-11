import java.util.Random;
import java.util.Arrays;
import java.lang.System;
public class Quick{

    static boolean DEBUG = false;

    private static void debug(String s){
	if(DEBUG){
	    System.out.println(s);
	}
    }

    public static String name(){
	return "6,Chen,Yuxuan";
    }

    /*
    public static int quickselect(int[]data, int k){
	return quickselect(data,k,0,data.length-1);
    }

    private static int quickselect(int[]data, int k, int left, int right){
	int[]guess = new int[2];
	guess[0] = partition(data,left,right)[0];
	guess[1] = partition(data,left,right)[1];
	debug("guess position = "+guess+"\nresult array is: ");
	printArray(data);
	if(guess == k){
	    return data[guess];
	}else if(guess < k){
	    return quickselect(data,k,guess+1,right);
	}else{
	    return quickselect(data,k,left,guess-1);
	}
    }
*/
    private static int[] partition(int[]data, int left, int right){
	Random rand = new Random();
	int[]ans = new int[2];
	int [] copy = new int[data.length];
	int copyleft = left;
	int copyright = right;//lol
	int leftI = left;
	int rightI = right;
	int pos = 0; 
	int pivots = 1;      
	if(left == right){
	    return ans;
	}else{
	    pos = left + rand.nextInt(right-left + 1);
	}
	int selected = data[pos];
	data[pos] = data[right];
	data[right] = selected;
	right --;
	while(left <= right){
	    int temp = data[left];
	    if(temp == selected){
		pivots++;
		left++;
	    }else if(temp < selected){
		copy[copyleft] = temp;
		left++;
		copyleft++;
	    }else{
		copy[copyright] = temp;
		right--;
		copyright--;
	    }
	}
	ans[0] = copyleft-1;
	ans[1] = copyright+1;
	for(int i = leftI; leftI < rightI; leftI++){
	    if(i >= copyleft && i <= copyright){
		data[i] = selected;
	    }else{
		data[i] = copy[i];
	    }
	}
	printArray(data);
	return ans;
    }

    /*
    public static void quickSort(int[]data){
	quickSort(data,0,data.length-1);
    }

    private static void quickSort(int[]data, int left, int right){
	if(right>left){
	    int offset = partition(data,left,right);
	    //   printArray(data);
	    quickSort(data,left,offset-1);
	    quickSort(data,offset+1,right);
	    
	}
    }

*/
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
	int[] x = new int[10];
	int[] y = new int[10];
	Random rand = new Random();
	for(int i = 0; i < x.length; i++){
	    x[i] = rand.nextInt(21);
	    y[i] = x[i];
	}
	partition(x,0,x.length-1);
	printArray(x);
	/*
	printArray(x);
	System.out.println(quickselect(x,8));
	printArray(x);
	*/	


	/*
	//runtime result, quickSort takes around 10 millisecond more
	long startTimeX = System.currentTimeMillis();
	quickSort(x);
	long endTimeX = System.currentTimeMillis();

	long startTimeY = System.currentTimeMillis();
	Arrays.sort(x);
	long endTimeY = System.currentTimeMillis();

	System.out.println("Time for quickSort is :" + (endTimeX - startTimeX) +
			   "\nTime for array sort is : " + (endTimeY - startTimeY));

    }
*/
    }
}

