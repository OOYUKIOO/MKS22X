import java.util.Random;

public class select{

    int[]data;
    Random rand = new Random();
    
    public select(int length){
	data = new int[length];
	for (int i = 0; i < data.length; i ++){
	    data[i] = rand.nextInt(21);
	}
    }

    public int select(int[]data, int k){
	return 0;
    }

    public void swap(int[]data, int Lindex, int Rindex, int goal){

    }

    public void printArray(){
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
	select x = new select(10);
	x.printArray();
    }



}
