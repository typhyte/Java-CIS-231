/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *

/**
 *
 * @author fali
 */
public class BST_Example {

    /**
     * @param args the command line arguments
     */
    Node root;


  public int leafCount(Node root){
	  if(root==null)
	  return 0;
	 if(root.left==null&&root.right==null){
		 System.out.println("Found a leaf");
	  return 1;
  }
	  else{
	  Employee e = (Employee) root.emp;
     // System.out.print("  " + e.id + ",");
	  return leafCount(root.left)+leafCount(root.right);
  }

  }

    public void add(Employee o) {

        Node n = new Node(o, o.getId());
        Node curr = root;
        Node parent = null;
        if (root == null) {
            root = n;
        } else {
            while (curr != null) {
                if (n.key < curr.key) {
                    parent = curr;
                    curr = curr.left;

                } else if (n.key > curr.key) {
                    parent = curr;
                    curr = curr.right;
                } else {
                    System.out.println("Cannot add Node, ID already exists");
                    return;
                }
            }
            //  System.out.println(n.toString()+"    "+parent);
            if (n.key < parent.key) {
                parent.left = n;
            } else {
                parent.right = n;
            }
        }
    }

    public Employee find(int id) {
        Node curr = root;
        while (curr != null) {
            if (curr.key == id) {
                return (Employee) curr.emp;
            } else if (id < curr.key) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return null;
    }

    public Node getRoot() {
        return root;
    }

    public void LNR(Node root) {
        if (root != null) {

            LNR(root.left);
            Employee e =  root.emp;
            System.out.println( e.toString() );
            LNR(root.right);

        }

    }
public void NLR(Node root) {
        if (root != null) {
             Employee e =  root.emp;
            System.out.println( e.toString());
            LNR(root.left);

            LNR(root.right);

        }

    }

    public void LRN(Node root) {
        if (root != null) {

            LRN(root.left);
            LRN(root.right);
            Employee e = (Employee) root.emp;
            System.out.println(e.toString());

        }

    }
}
