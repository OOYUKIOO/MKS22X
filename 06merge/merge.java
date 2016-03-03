public class merge{

public static void printArray(int[]data){
	String message = "[";
	if (data.length==0){
	    message+=" ";
	}
	for(int i=0;i<data.length;i++){
	    message += data[i]+",";
	}
	System.out.println(message.substring(0,message.length()-1)+"]");
    }

    /*
      The function can take an array, and the start/end indices of each part to be merged. it could then merge into a new array, and copy the results back.
    */
    public static void merge(int[]data, int startA, int endA, int startB, int endB){
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
	printArray(temp);
	for(int i = 0; i < temp.length; i++){
	    data[start] = temp[i];
	    start++;
	}
	printArray(data);
    }


    //testing
    public static void main(String[]args){
	int[] x = {1,5,2,8,4,10};
	merge(x,2,3,4,5);
    }

}
