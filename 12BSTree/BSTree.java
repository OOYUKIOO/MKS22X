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
	    if(value.compareTo(data) < 0){
		if(left == null){
		    left.setData(value);
		}else{
		    left.add(value);
		}
	    }else if(value.compareTo(data) > 0){
		if(right == null){
		    right.setData(value);
		}else{
		    right.add(value);
		}
	    }
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
