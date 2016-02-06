public class Recursion{


    //REMEMBER TO REMOVE ALL STATIC!!!!!!!!!!!!!!!!!!!!


    public static String name(){
	return "Chen,Yuxuan";
    }

    
    public static double sqrt(double n){
	if(n<0){
	    throw new IllegalArgumentException();
	}
	return 0;
    }


    public static void main(String[]args){
	try{
	    sqrt(-1);
	}catch(IllegalArgumentException e){
	    System.out.println("caught!");
	}
	System.out.println(name());
    }


}
