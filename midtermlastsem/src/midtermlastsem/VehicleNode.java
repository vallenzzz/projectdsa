/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midtermlastsem;

/**
 *
 * @author User
 */
public class VehicleNode {
    
    String vehicleregno;
    String ownername;
    String contactno;
    VehicleNode next;
    
    public VehicleNode(String vehicleregno, String ownername, String contactno){
    
        this.vehicleregno=vehicleregno;
        this.ownername=ownername;
        this.contactno=contactno;
        this.next=null;
    
    }
    
}
