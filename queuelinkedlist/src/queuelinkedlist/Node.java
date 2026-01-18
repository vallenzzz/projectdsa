/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queuelinkedlist;

/**
 *
 * @author User
 */
public class Node {
    String headoffamily;
    int familysize;
    String phoneno;
    Node next;
    
    public Node(String headoffamily, int familysize, String phoneno) {  //contructor
        this.headoffamily = headoffamily;
        this.familysize = familysize;
        this.phoneno = phoneno;
        this.next = null;
    }
}
