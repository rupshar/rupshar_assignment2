package BST_A2;

public class BST implements BST_Interface {
	public BST_Node root;
	int size;

	public BST(){ size=0; root=null; }

	@Override
	//used for testing, please leave as is
	public BST_Node getRoot(){ return root; }

	@Override
	public boolean insert(String s) {
		if(root == null) {
			root = new BST_Node(s);
			size++;
			root.parent = null;
			return true;
		} else if (root.containsNode(s)) {
			return false;
		} else {
			root.insertNode(s);
			size++;
			return true;
		}
	}

	@Override
	public boolean remove(String s) {
		if(s == null) {
			return false;
		} else if(size == 0) {
			return false;
		} else if(!root.containsNode(s)) {
			return false;
		} else if(s.equals(root.data)) {
			if(root.left != null && root.right != null) {
				BST_Node maximum = root.right.findMin();
				root.removeNode(maximum.data);
				root.data = maximum.data;
				size--;
				return true;
			} else if(root.left == null && root.right != null) {
				root = root.right;
				size--;
				return true;
			} else if(root.left != null && root.right == null) {
				root = root.left;
				size--;
				return true;
			} else {
				root = null;
				size--;
				return true;
			}
		} else {
			size--;
			if(root == null) {
				return false;
			}
			return root.removeNode(s);
		}
	}

	@Override
	public String findMin() {
		if(size == 0) {
			return null;
		} else {
			return root.findMin().getData();
		}
	}

	@Override
	public String findMax() {
		if(size == 0) {
			return null;
		} else {
			return root.findMax().getData();
		}
	}

	@Override
	public boolean empty() {
		if (size == 0 || root == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(String s) {
		if(root == null) {
			return false;
		} else {
			return root.containsNode(s);
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int height() {
		if(root == null) {
			return -1;
		} else {
			return root.getHeight();
		}
	}

}

