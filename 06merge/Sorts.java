import java.util.Arrays;

public class Sorts{


    public static void printArray(int[]data){
	String message = "[";
	if(data.length == 0){
	    message+=" ";
	}
	for(int i = 0; i < data.length; i++){
	    message += data[i] + ",";
	}
	System.out.println(message.substring(0,message.length()-1)+"]");
    }

    /*
      public static void bubbleSort(int[]data){
      for(int x = 0; x < data.length-1; x++){
      for (int i = 0; i<data.length - 1; i++){
      if(data[i]>data[i+1]){
      int toSwap = data[i];
      data[i] = data[i+1];
      data[i+1] = toSwap;
      }
      }
      }
      }
      
      public static void insertionSort(int[]data){
      for(int i=1;i<data.length;i++){
      int carry = data[i];
      int x = i;
      while((x>0) && (data[x-1]>carry)){
		data[x]=data[x-1];
		data[x-1]=carry;
		x--;
	    }
	}
    }

public static void selectionSort(int[]data){

	int start = 0;
	int end = data.length;
	int toSwap;

	while(start < end){
	    int min = Integer.MAX_VALUE;
	    for(int x=start; x<end; x++){
		min = Math.min(min,data[x]);
	    }

	    toSwap = data[start];
	    data[start] = min;
	    for(int x = start+1; x<end; x++){
		if (data[x] == min){
		    data[x] = toSwap;
		    x = end;
		}
	    }
	    start ++;
	}
	
}
*/



 public static int[] mergeSort(int[]data){
     /*
     if(data.length == 1){
	 return merge(data,0,0,0,0);
     }else{
	 int midway = data.length / 2;
	 mergeSort(Arrays.copyOfRange(data,0,midway));
	 mergeSort(Arrays.copyOfRange(data,midway,data.length));
     }
     return data;
     */
     return merge(data,0,0,0,0);
 }

public static int[] merge(int[]data, int startA, int endA, int startB, int endB){
	int start = startA;
	int[] temp = new int[(endA-startA+1) + (endB-startB+1)];
	for(int i = 0; i < temp.length; i++){
	    if(startA > endA){
		temp[i] = data[startB];
		startB++;
	    }else if(startB > endB){
		temp[i] = data[startA];
		startA++;
	    }else{
		temp[i] = Math.min(data[startA], data[startB]);
		if(temp[i] == data[startA]){
		    startA++;
		}else{
		    startB++;
		}
	    }
	}
	for(int i = 0; i < temp.length; i++){
	    data[start] = temp[i];
	    start++;
	}
	return data;
    }




    //testing
    public static void main(String[]args){
	int[] x = {1,4,19,3,5,12};
	printArray(x);
	printArray(mergeSort(x));
    }

}
