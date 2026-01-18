/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlistclinictreatment;

/**
 *
 * @author User
 */
public class clinicroom {
    
    int room;// data field
    String patientnumber; // data field
    
    clinicroom next; // linkfield
    
    public clinicroom (int room, String patientnumber){
    this.room=room;
    this.patientnumber=patientnumber;
    this.next=null;
    }
    
}
