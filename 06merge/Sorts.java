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




 public static int[] mergeSort(int[]data){
     if(data.length<=1){
	 return data;
     }
     int[] firstHalf = new int[data.length/2];
     int[] secondHalf = new int[data.length - firstHalf.length];
     System.arraycopy(data,0,firstHalf,0,firstHalf.length);
     //     printArray(firstHalf);
     System.arraycopy(data,firstHalf.length,secondHalf,0,secondHalf.length);
     //     printArray(secondHalf);
     mergeSort(firstHalf);
     mergeSort(secondHalf);
     merge(data,firstHalf,secondHalf);
     return data;
 }

    public static void merge(int[]data, int[]first, int[]second){
	int firstI = 0;
	int secondI = 0;
	int dataI = 0;
	while(firstI < first.length && secondI < second.length){
	    if(first[firstI] < second[secondI]){
		data[dataI] = first[firstI];
		firstI ++;
		dataI ++;
	    }else{
		data[dataI] = second[secondI];
		secondI ++;
		dataI ++;
	    }
	}
	System.arraycopy(first,firstI,data,dataI,first.length-firstI);
	System.arraycopy(second,secondI,data,dataI,second.length-secondI);
    }


    //testing
    public static void main(String[]args){
	int[] x = {1,4,19,3,5,12};
	printArray(x);
	printArray(mergeSort(x));
    }

}
