package BST_A2;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	BST_Node parent;

	BST_Node(String data){ this.data=data; }

	// --- used for testing  ----------------------------------------------
	//
	// leave these 3 methods in, as is

	public String getData(){ return data; }
	public BST_Node getLeft(){ return left; }
	public BST_Node getRight(){ return right; }
	public BST_Node getParent(){ return parent; }

	// --- end used for testing -------------------------------------------


	// --- fill in these methods ------------------------------------------
	//
	// at the moment, they are stubs returning false 
	// or some appropriate "fake" value
	//
	// you make them work properly
	// add the meat of correct implementation logic to them

	// you MAY change the signatures if you wish...
	// make the take more or different parameters
	// have them return different types
	//
	// you may use recursive or iterative implementations

	/*
  public boolean containsNode(String s){ return false; }
  public boolean insertNode(String s){ return false; }
  public boolean removeNode(String s){ return false; }
  public BST_Node findMin(){ return left; }
  public BST_Node findMax(){ return right; }
  public int getHeight(){ return 0; }
	 */

	// --- end fill in these methods --------------------------------------


	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------

	public boolean containsNode(String s) {
		int comp = s.compareTo(this.data);
		if(comp == 0) {
			return true;
		} else if(comp < 0) {
			if(this.left == null) {
				return false;
			}
			return this.left.containsNode(s);
		} else if(comp > 0){
			if(this.right == null) {
				return false;
			}
			return this.right.containsNode(s);
		}
		return false;
	}

	public boolean insertNode(String s) {
		int comp = s.compareTo(this.data);
		if(s.equals(this.data)) {
			return false;
		} else if(comp > 0) {
			if(this.right == null) {
				this.right = new BST_Node(s);
				this.right.parent = this;
				return true;
			}
			return this.right.insertNode(s);
		} else {
			if(this.left == null) {
				this.left = new BST_Node(s);
				this.left.parent = this;
				return true;
			}
			return this.left.insertNode(s);
		}
	}

	public boolean removeNode(String s) {
		BST_Node parent = this.getParent(s);
		BST_Node current = this.getCurrent(s);
		if(current.left == null && current.right == null) {
			int comp_parent = parent.data.compareTo(current.data);
			if(comp_parent < 0) {
				parent.right = null;
				return true;
			} else {
				parent.left = null;
				return true;
			}
		} else if(current.left != null && current.right == null) {
			int comp_parent = parent.data.compareTo(current.data);
			if(comp_parent < 0) {
				parent.right = current.left;
				current.left.parent = parent;
				return true;
			} else {
				parent.left = current.left;
				current.left.parent = parent;
				return true;
			}
		} else if(current.left == null && current.right != null) {
			int comp_parent = parent.data.compareTo(current.data);
			if(comp_parent < 0) {
				parent.right = current.right;
				current.right.parent = parent;
				return true;
			} else {
				parent.left = current.right;
				current.right.parent = parent;
				return true;
			}
		} else {
			BST_Node minimum = current.right.findMin();
			this.removeNode(minimum.data);
			current.data = minimum.data;
			return true;
		}
	}

	public BST_Node getParent(String s) {
		BST_Node parent = this;
		BST_Node left_child = parent.left;
		BST_Node right_child = parent.right;
		if(left_child == null || right_child == null) {
			return this.getCurrent(s).getParent();
		} else if(left_child.data.equals(s) || right_child.data.equals(s)) {
			return parent;
		} else {
			int comp = s.compareTo(parent.data);
			if(comp > 0) {
				return parent.right.getParent(s);
			} else {
				return parent.left.getParent(s);
			}
		}
	}

	public BST_Node getCurrent(String s) {
		int comp = s.compareTo(this.data);
		if(comp == 0) {
			return this;
		} else if(comp > 0) {
			return this.right.getCurrent(s);
		} else {
			return this.left.getCurrent(s);
		}
	}

	public BST_Node findMin() {
		BST_Node minimum = this;
		if(minimum.left == null) {
			return minimum;
		} else {
			return minimum.left.findMin();
		}
	}

	public BST_Node findMax() {
		BST_Node maximum = this;
		if(maximum.right == null) {
			return maximum;
		} else {
			return maximum.right.findMax();
		}
	}

	public int getHeight() {
		int height = 0;

		if(this.left == null && this.right == null) {
			height = 0;
		} else if(this.left != null && this.right == null) {
			height = 1 + this.left.getHeight();
		} else if(this.left == null && this.right != null) {
			height = 1 + this.right.getHeight();
		} else {
			height = 1 + Math.max(this.left.getHeight(), this.right.getHeight());
		}

		return height;
	}

	public String toString(){
		return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
				+",Right: "+((this.right!=null)?right.data:"null");
	}
}
