/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author fali
 */
public class Node {
    Employee emp;
   public Node left;
    public Node right;
    public int key;
    public Node(Employee e, int key)
    {
        this.emp=e;
        this.key=key;

      }
}
