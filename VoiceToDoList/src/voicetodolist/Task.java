/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package voicetodolist;

/**
 *
 * @author User
 */
public class Task {
    // --- DATA FIELDS (Attributes) ---

    // 1. Identification
    int taskID; // Unique ID for searching/deleting

    // 2. Voice Processing Data
    String rawVoiceCommand; // The original "spoken" sentence
    int voiceConfidenceScore; // Simulated AI confidence (0-100)
    String audioFilePath; // Path to the saved voice recording (Simulated)
    String detectedLanguage; // e.g., "English", "Malay"

    // 3. Task Details
    String taskName; // Extracted task name
    String category; // Work, Personal, Study, etc.
    String priority; // High, Medium, Low
    String extraNotes; // Additional details added manually later

    // 4. Time & Scheduling
    String dueDate; // Date string (YYYY-MM-DD)
    String dueTime; // Time string (HH:MM)
    double estimatedDuration; // In minutes (e.g., 30.0)
    boolean isRecurring; // Is this a repeating task? (True/False)

    // 5. Context & Status
    String location; // e.g., "Home", "Office"
    boolean isCompleted; // Status: True = Done, False = Pending
    String createdBy; // User name (e.g., "Student Group 1")
    String creationDate; // System timestamp when added

    //6. Subtask Details
    SubTask subtaskdetail;

    // --- LINK FIELD ---
    Task next; // Pointer to the next node in Linked List

    // --- CONSTRUCTOR ---
    public Task(int id, String rawCommand, String name, String priority, String date) {
        // Initialize essential fields passed from Main
        this.taskID = id;
        this.rawVoiceCommand = rawCommand;
        this.taskName = name;
        this.priority = priority;
        this.dueDate = date;

        // Initialize default values for the other 11 variables
        this.category = "General";
        this.dueTime = "09:00 AM";
        this.location = "Unset";
        this.extraNotes = "None";
        this.audioFilePath = "/voice/recordings/task_" + id + ".mp3";
        this.detectedLanguage = "English";

        this.isCompleted = false;
        this.isRecurring = false;

        this.estimatedDuration = 30.0;
        this.voiceConfidenceScore = 98;

        this.createdBy = "Admin";
        this.creationDate = "2026-01-12";

        this.subtaskdetail = null;

        this.next = null;
    }
}
