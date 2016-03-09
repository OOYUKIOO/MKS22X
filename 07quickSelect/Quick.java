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


    //testing

}
