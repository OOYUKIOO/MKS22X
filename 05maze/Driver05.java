public class Driver05{

    public static void main(String[]args){
        Maze f;
        f = new Maze("data1.dat",true);//true animates the maze.
        f.solve();
	//System.out.println(f);


	/*        
        f.clearTerminal();
        f.solve();

        f.clearTerminal();
        System.out.println(f);
	*/
    }
}
