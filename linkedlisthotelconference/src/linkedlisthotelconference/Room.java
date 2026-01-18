/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlisthotelconference;

/**
 *
 * @author User
 */
public class Room {
    
    int room;
    String event;
    Room next;
    
    public Room(int room, String event){
    this.room=room;
    this.event=event;
    this.next=null;    
    }
    
}
