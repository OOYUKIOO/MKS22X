public class Recursion{


    //REMEMBER TO REMOVE ALL STATIC!!!!!!!!!!!!!!!!!!!!


    public static String name(){
	return "Chen,Yuxuan";
    }

    
    public static double sqrt(double n){
	//throw exception when n is negative
	if(n<0){
	    throw new IllegalArgumentException();
	}
	return sqrt_helper(n,n/2);
    }

    public static double sqrt_helper(double n, double guess){
	//exit case: percentage error less than .001%
	if((Math.abs(Math.pow(guess,2)-n)/n)*100 <0.001){
	    return guess;
	}
	guess = (n/guess + guess)/2;
	return sqrt_helper(n,guess);
    }


    public static void main(String[]args){
	try{
	    sqrt(-1);
	}catch(IllegalArgumentException e){
	    System.out.println("caught!");
	}
	System.out.println(name());
	System.out.println(sqrt(100));
    }


}
