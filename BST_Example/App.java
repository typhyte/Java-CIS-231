public class App{

public static void main(String args[]){

  BST_Example bst= new BST_Example();

        bst.add(new Employee("Zim",89,568,1));
        bst.add(new Employee("Tim",102,568,1));
        bst.add(new Employee("Kim",35,568,1));
        bst.add(new Employee("Lim",38,568,1));
        bst.add(new Employee("Dim",10,568,1));
        bst.add(new Employee("Sim",178,568,1));
        System.out.println(bst.leafCount(bst.getRoot()));
        Employee emp=bst.find(110);
        if(emp!=null)
        System.out.println(emp.toString());
        else

       System.out.println("Employee not found");
       System.out.println("\n**************  Post-Order Traversal *************\n");
       bst.LRN(bst.getRoot());
        System.out.println("\n**************  Pre-Order Traversal *************\n");
        bst.NLR(bst.getRoot());

        System.out.println("\n**************  In-Order Traversal *************\n");

         bst.LNR(bst.getRoot());


}
}