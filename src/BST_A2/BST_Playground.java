package BST_A2;

public class BST_Playground {
/*
 * you will test your own BST implementation in here
 *
 * we will replace this with our own when grading, and will
 * do what you should do in here... create BST objects,
 * put data into them, take data out, look for values stored
 * in it, checking size and height, and looking at the BST_Nodes
 * to see if they are all linked up correctly for a BST
 * 
*/
  
  public static void main(String[]args){

   // you should test your BST implementation in here
   // it is up to you to test it thoroughly and make sure
   // the methods behave as requested above in the interface
  
   // do not simple depend on the oracle test we will give
   // use the oracle tests as a way of checking AFTER you have done
   // your own testing

   // one thing you might find useful for debugging is a print tree method
   // feel free to use the printLevelOrder method to verify your trees manually
   // or write one you like better
   // you may wish to print not only the node value, and indicators of what
   // nodes are the left and right subtree roots,
   // but also which node is the parent of the current node
	  
	  BST myTree = new BST();

//	  System.out.println(myTree.empty());
//	  myTree.insert("B");
//	  myTree.insert("A");
//	  myTree.insert("D");
//	  myTree.insert("C");
//	  myTree.insert("E");
//	  printInOrder(myTree.getRoot());
//	  System.out.println();
//	  myTree.insert("F");
//	  myTree.insert("H");
//	  myTree.insert("L");
//	  myTree.insert("G");
//	  myTree.insert("R");
//	  System.out.println(myTree.remove("S"));
//	  myTree.insert("T");
//	  myTree.remove("C");
//	  System.out.println(myTree.contains("B"));
//	  myTree.remove(myTree.findMax());
//	  System.out.println(myTree.findMax());
//	  System.out.println(myTree.findMin());
//	  System.out.println(myTree.contains("D"));
//	  myTree.insert("C");
//	  myTree.insert("A");
//	  myTree.insert("B");
//	  myTree.insert("E");
//	  myTree.insert("D");
//	  printInOrder(myTree.getRoot());
//	  System.out.println();
//	  System.out.println(myTree.findMin());
//	  myTree.remove(myTree.findMin());
//	  myTree.insert("0");
//	  myTree.insert("C");
//	  myTree.insert("A");
//	  myTree.insert("B");
//	  myTree.insert("E");
//	  myTree.insert("D");
//	  myTree.remove("C");
	  myTree.insert("0");
	  myTree.insert("C");
	  myTree.insert("A");
	  myTree.insert("B");
	  myTree.insert("E");
	  myTree.insert("D");
	  myTree.remove("C");
	  myTree.remove("A");
	  myTree.remove("D");
	  myTree.remove("B");
	  myTree.remove("E");
	  printInOrder(myTree.getRoot());
 
  }

  static void printLevelOrder(BST tree){ 
  //will print your current tree in Level-Order...
  //https://en.wikipedia.org/wiki/Tree_traversal
    int h=tree.getRoot().getHeight();
    for(int i=0;i<=h;i++){
      printGivenLevel(tree.getRoot(), i);
    }
    
  }
  static void printGivenLevel(BST_Node root,int level){
    if(root==null)return;
    if(level==0)System.out.print(root.data+" ");
    else if(level>0){
      printGivenLevel(root.left,level-1);
      printGivenLevel(root.right,level-1);
    }
  }
  static void printInOrder(BST_Node root){
  //will print your current tree In-Order
  if(root!=null){
    printInOrder(root.getLeft());
    System.out.print(root.getData() + " ");
    printInOrder(root.getRight());
  }
  }
}
