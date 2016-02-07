public class Recursion implements hw01{


    public String name(){
	return "Chen,Yuxuan";
    }

    
    public double sqrt(double n){
	//throw exception when n is negative
	if(n<0){
	    throw new IllegalArgumentException();
	}
	return sqrt_helper(n,n/2);
    }

    public double sqrt_helper(double n, double guess){
	//exit case: percentage error less than .001%
	if((Math.abs(Math.pow(guess,2)-n)/n)*100 <0.001){
	    return guess;
	}
	//update guess
	guess = (n/guess + guess)/2;
	return sqrt_helper(n,guess);
    }


}
