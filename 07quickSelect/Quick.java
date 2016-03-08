import java.util.Random;

public class Quick{

    Random rand = new Random();

    private static int partition(int[]data, int left, int right){
	return 0;
    }

    public static int quickselect(int[]data, int k){
	return 0;
    }

    private static int quickselect(int[]data, int k, int left, int right){
	int leftI = left;
	int rightI = right;
	while(left != right){
	    int pos = rand.nextInt(right - left);
	    int selected = data[pos];
	    data[pos] = data[right];
	    data[right] = selected;
	    right --;
	}
	return 0;
    }


}
