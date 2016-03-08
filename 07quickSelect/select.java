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

    public void select(int k){
	swap(0,data.length-1,k);
    }

    public void swap(int Lindex, int Rindex, int goal){
	printArray();
	int rightIndex = Rindex;
	int leftIndex = Lindex;
	//System.out.println("Left Index is: " + leftIndex + "\nRight Index is : " + rightIndex);
	int pos = rand.nextInt(rightIndex - leftIndex);
	int selected = data[pos];
	System.out.println(Rindex+", " + rightIndex);
	data[pos] = data[Rindex];
	Rindex --;
	printArray();
	while(Lindex != Rindex){
	    System.out.println("Left Index is: " + Lindex + "\nRight Index is : " + Rindex +
			       "\nselected: " + pos + "\ngoal : " + goal);
	    //	    System.out.println(rightIndex - leftIndex);
	    //	    pos = rand.nextInt(rightIndex - leftIndex);
	    //	    selected = data[pos];
	    //	    data[pos] = data[Rindex];
	    
	    int temp = data[Lindex];
	    if(temp>selected){
		Lindex ++;
	    }else{
		data[Lindex] = data[Rindex];
		data[Rindex] = temp;
		Rindex --;
	    }
	    printArray();
	}
	if(data[Lindex] > selected){
	    Lindex++;
	}
	data[rightIndex] = data[Lindex];
	data[Lindex] = selected;
	if(Lindex+1  == goal){
	    System.out.println(data[Lindex]);
	}else if(Lindex > goal){
	    swap(leftIndex,Rindex,goal);
	}else{
	    swap(Rindex,rightIndex,goal);
	}
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
	//	x.printArray();
	x.select(1);
    }



}
