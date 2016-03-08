import java.util.Random;

public class Quick{


    private static int partition(int[]data, int left, int right){
	return 0;
    }

    public static int quickselect(int[]data, int k){
	return 0;
    }

    private static int quickselect(int[]data, int k, int left, int right){
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
	    }
	}
	return 0;
    }


}
