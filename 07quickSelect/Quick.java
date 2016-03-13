import java.util.Random;
import java.util.Arrays;
import java.lang.System;
public class Quick{

    static boolean DEBUG = true;

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
	if(left == right){
	    return ans;
	}else{
	    pos = left + rand.nextInt(right-left + 1);
	}
	int selected = data[pos];
	debug("The pivot element is "+selected+" at position "+pos);
	while(left <= right){
	    int temp = data[left];
	    debug("the choosen element is "+temp);
	    if(temp == selected){
		left++;
		debug("choosen element is equal to pivot");
	    }else if(temp < selected){
		copy[copyleft] = temp;
		left++;
		copyleft++;
		debug("choosen element is less than pivot");
	    }else{
		copy[copyright] = temp;
		left++;
		copyright--;
		debug("choosen element is greater than pivot");
	    }
	    printArray(copy);
	}
	debug("left index for copy array is "+copyleft+" and right index for copy array is "+copyright);
	ans[0] = copyleft-1;
	ans[1] = copyright+1;
	for(int i = leftI; i <= rightI; i++){
	    if(i >= copyleft && i <= copyright){
		data[i] = selected;
	    }else{
		data[i] = copy[i];
	    }
	}
	return ans;
    }

    
    public static void quickSort(int[]data){
	quickSort(data,0,data.length-1);
    }
   
    private static void quickSort(int[]data, int left, int right){
	printArray(data);
	debug("The left index is "+left+"\nthe right index is "+right);
 	if(left<right){
	    int[] offsets = partition(data,left,right);
	    int leftOffset = offsets[0];
 	    int rightOffset = offsets[1];

	    if(leftOffset>0 && leftOffset<data.length){
		debug("doing left side");
		quickSort(data,left,leftOffset);
       	    }
	    if(rightOffset>0 && rightOffset<data.length){
		debug("doing right side "+rightOffset+", "+right);
		quickSort(data,rightOffset,right);
	    }
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
	int[] x = new int[10];
	int[] y = new int[10];
	int[] a = {3,5,2,5,6,2,1,6,4,7,3,2,4,2,2,3,3,5,6,9};
	Random rand = new Random();
	for(int i = 0; i < x.length; i++){
	    x[i] = rand.nextInt(21);
	    y[i] = x[i];
	}
	//	partition(a,0,a.length-1);
	printArray(x);
	quickSort(x);
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

