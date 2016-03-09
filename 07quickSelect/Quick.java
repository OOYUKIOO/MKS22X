import java.util.Random;

public class Quick{


    private static int quickselect(int[]data, int k){
	return quickselect(data,k,0,data.length-1);
	
    }

    
    public static int quickselect(int[]data, int k, int left, int right){
	int pos = partition(data,left,right);
	if(pos == k){
	    return data[k];
	}
	if(pos < k){
	    return  quickselect(data,k,pos+1,right);
	}else{
	    return quickselect(data,k,left,pos-1);
	}
    }
    

    private static int partition(int[]data, int left, int right){
	Random rand = new Random();

	int leftI = left;
	int rightI = right;
	int pos = rand.nextInt(right - left);
	int selected = data[pos];
	data[pos] = data[right];
	data[right] = selected;
	right --;
	while(left != right){
	    int temp = data[left];
	    if(temp < selected){
		left++;
	    }else{
		data[left] = data[right];
		data[right] = temp;
		right--;
	    }
	}
	if(data[left] > selected){
	    left++;
	}
	data[rightI] = data[left];
	data[left] = selected;
	/*
	if(left == k){
	    return data[left];
	}else if(left > k){
	    return quickselect(data, k, leftI, left-1);
	}else{
	    return quickselect(data, k, left+1, rightI);
	}
	*/
	return left;
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
	Random rand = new Random();
	for(int i = 0; i < x.length; i++){
	    x[i] = rand.nextInt(11);
	}
	printArray(x);
	System.out.println(quickselect(x,0));
    }

}
