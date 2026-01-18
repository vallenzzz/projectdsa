/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package momentumgym;

/**
 *
 * @author User
 */
public class Node {
    
    String id;
    String name;
    String phoneno;
    String email;
    int age;
    String classname;
    String regdate;
    Node next;
    
    public Node (String id, String name, String phoneno, String email, int age, String classname, String regdate){
    this.id = id;
    this.name = name;
    this.phoneno = phoneno;
    this.email = email;
    this.age = age;
    this.classname = classname;
    this.regdate = regdate;
    this.next = null;
    }  
}
