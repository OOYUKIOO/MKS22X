public class BSTree<T extends Comparable<T>>{

    Node root;

    private class Node{

	Node left, right;
	T data;

	public T getData(){
	    return data;
	}

	public Node getLeft(){
	    return left;
	}

	public Node getRight(){
	    return right;
	}

	public void setData(T value){
	    data = value;
	}

	public void setLeft(Node newTree){
	    left = newTree;
	}

	public void setRight(Node newTree){
	    right = newTree;
	}

	public int height(){
	    return 0;
	}

	public void add(T value){

	}

	public void add(Node parent, T value){
	    if(childrenNum(parent) == 0){
		parent.setLeft(value);
	    }
	}


	public int childrenNum(Node parent){
	    int ans=0;
	    if(!parent.getLeft().getData().equals(null)){
		ans++;
	    }
	    if(!parent.getRight().getData().equals(null)){
		ans++;
	    }
	    return ans;

	}
	public String toString(){
	    String ans = toString(root);
	    return ans;
	}
	
	public String toString(Node local){
	    String ans="";
	    return ans;
	}
	
	public boolean contains(T value){
	    return true;
	}
	
    }

    
    public int getHeight(){
	if(root.getData().equals(null)){
	    return 0;
	}
	return root.height();
    }

    public void add(T value){
	if (getHeight() == 0){
	    root.setData(value);
	}
	
    }


    public String toString(){
	String ans = root.toString();
	return ans;
    }

    public boolean contains(T value){
	return root.contains(value);
    }

   

}
