import java.util.Random;

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


    public static int quickselect(int[]data, int k){
	return quickselect(data,k,0,data.length-1);
    }

    private static int quickselect(int[]data, int k, int left, int right){
	int guess = partition(data,left,right);
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

    private static int partition(int[]data, int left, int right){
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
	/*
	if(left == k){
	    return data[k];
	}else if (left < k){
	    return partition(data,left+1,rightI,k);
	}else{
	    return partition(data,leftI,left-1,k);
	}
	*/

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
	    x[i] = rand.nextInt(20);
	}
	printArray(x);
	System.out.println(quickselect(x,8));
	printArray(x);
    }

}
