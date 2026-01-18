/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package voicetodolist;

/**
 *
 * @author User
 */
public class SubTask {
    // --- DATA FIELD ---
     String subtaskdetail;
    // --- LINK FIELD ---
    SubTask next; // Pointer to the next node in the Stack

    // --- CONSTRUCTOR ---
    public SubTask(String subtaskdetail) {
        this.subtaskdetail = subtaskdetail;
        this.next = null;
    }
}
