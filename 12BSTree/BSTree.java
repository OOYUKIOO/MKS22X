public class BSTree<T extends Comparable<T>>{

    Node root;

    private class Node{

	Node left, right;
	T data;

	public Node(T data){
	    this.data = data;
	}

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
	    int leftH = 1;
	    int rightH = 1;
	    if(left!=null){
		leftH += left.height();
	    }
	    if(right!=null){
	        rightH += right.height();
	    }
	    return Math.max(leftH,rightH);
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
	if(root == null){
	    return 0;
	}
	return root.height();
    }

    public void add(T value){
	if (root == null){
	    root = new Node(value);
	}else{
	    root.add(value);
	}
    }

    public boolean contains(T value){
	return root.contains(value);
    }

   

    public static void main(String[]args){
	BSTree<Integer> x = new BSTree<Integer>();
	x.add(new Integer(1));
	System.out.println(x.getHeight());
    }

}
