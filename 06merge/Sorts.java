public class Sorts{

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



}
