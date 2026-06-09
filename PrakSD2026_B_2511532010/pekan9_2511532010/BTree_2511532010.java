package pekan9_2511532010;

public class BTree_2511532010 {
	private Node_2511532010 root_2010;
	private Node_2511532010 currentNode_2010;
	
	public BTree_2511532010() {
		root_2010 = null;
	}
	
	public boolean search (int data_2010) {
		return search(root_2010, data_2010);
	}
	
	private boolean search(Node_2511532010 node_2010, int data_2010) {
		if (node_2010 == null) return false;
		
		if (node_2010.getData()==data_2010)
			return true;
		if (node_2010.getLeft()!= null)
			if (search(node_2010.getLeft(), data_2010))
				return true;
		if(node_2010.getRight()!=null)
			if (search(node_2010.getRight(), data_2010))
				return true;
		return false;
	}
	
	public void printInorder() {
		root_2010.printInorder(root_2010);
	}
	
	public void printPreOrder() {
		root_2010.printPreorder(root_2010);
	}
	
	public void printPostOrder() {
		root_2010.printPostorder(root_2010);
	}
	
	public Node_2511532010 getRoot() {
		return root_2010;
	}

	public boolean isEmpty() {
		return root_2010 == null;
	}
	
	int countNodes(Node_2511532010 node_2010) {
		int count_2010 = 1;
		if (node_2010 == null) {
			return 0;
		} else {
			count_2010 += countNodes(node_2010.getLeft());
			count_2010 += countNodes(node_2010.getRight());
			return count_2010;
		}
	}
	
	public void print() {
		root_2010.print();
	}
	
	public Node_2511532010 getCurrent() {
		return currentNode_2010;
	}
	
	public void setCurrent(Node_2511532010 node_2010) {
		this.currentNode_2010 = node_2010;
	}
	
	public void setRoot(Node_2511532010 root_2010) {
		this.root_2010 = root_2010;
	}
}