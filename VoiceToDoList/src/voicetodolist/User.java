/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package voicetodolist;

/**
 *
 * @author User
 */
public class User {
    // --- DATA FIELDS ---
    String username; // Name of the user (e.g., "Student Group 1")
    String language; // Voice setting (e.g., "English", "Malay")

    // This connects the User to the Task Linked List
    Task head;

    // --- CONSTRUCTOR ---
    public User(String name, String lang) {
        this.username = name;
        this.language = lang;
        this.head = null; // List starts empty
    }
}
