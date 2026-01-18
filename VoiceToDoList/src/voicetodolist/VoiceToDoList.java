/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package voicetodolist;
import java.util.Scanner;

public class VoiceToDoList {

    static Scanner scanner = new Scanner(System.in);
    static User currentUser = new User("Student_Group_1", "English");
    static int idCounter = 1; // auto assign ID
    static Task sortHead = null;//Used for my sorting data and avoid effect to other people data

    public static void main(String[] args) {
        // examples
        addManualTask("Buy groceries", "High", "Monday");
        addManualTask("Submit assignment", "Medium", "Tuesday");

        char ch;
        boolean session = true;

        while (session) {

            System.out.println("\n==========================================");
            System.out.println("   VOICE-CONTROLLED TO-DO LIST MANAGER");
            System.out.println("==========================================");
            System.out.println(" [A] - Add Task (Simulate Voice Command)");
            System.out.println(" [L] - List All Tasks");
            System.out.println(" [U] - Update Task Status/Details");
            System.out.println(" [D] - Delete Task");
            System.out.println(" [V] - View Full Details");
            System.out.println(" [S] - Add/View Subtasks");
            System.out.println(" [O] - Sorting Option");
            System.out.println(" [F] - Find / Search Tasks");
            System.out.println(" [X] - Exit");
            System.out.println("==========================================");
            System.out.print("Enter choice: ");

            String input = scanner.nextLine();
            ch = input.toUpperCase().charAt(0);
//            scanner.nextLine();

            switch (ch) {
                case 'A':
                    addTaskVoice();
                    break;
                case 'L':
                    listTasks();
                    break;
                case 'U':
                    updateTask();
                    break;
                case 'D':
                    deleteTask();
                    break;
                case 'V':
                    viewTaskDetails();
                    break;
                case 'S':
                    addViewSubtasks();
                    break;
                case 'O':
                    sortingMenu();
                    break;
                case 'F':
                    searching();
                    break;
                case 'X':
                    System.out.println("Exiting system...");
                    session = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // 1. LINKED LIST INSERTION (The "Voice" Feature)

    static void addTaskVoice() {
        System.out.println("\n--- SIMULATE VOICE INPUT ---");
        System.out.println("Try saying: 'Buy Milk Priority High on Friday'");
        System.out.print("🎤 Enter your command: ");
        String voiceInput = scanner.nextLine();

        String extractedPriority = "Low"; // Default
        String extractedDate = "Today"; // Default
        String extractedName = voiceInput; // Assume whole string is name initially

        if (voiceInput.toLowerCase().contains("priority high")) {
            extractedPriority = "High";
            extractedName = extractedName.replaceAll("(?i)priority high", "");
        } else if (voiceInput.toLowerCase().contains("priority medium")) {
            extractedPriority = "Medium";
            extractedName = extractedName.replaceAll("(?i)priority medium", "");
        }

        if (voiceInput.toLowerCase().contains("on monday"))
            extractedDate = "Monday";
        else if (voiceInput.toLowerCase().contains("on tuesday"))
            extractedDate = "Tuesday";
        else if (voiceInput.toLowerCase().contains("on friday"))
            extractedDate = "Friday";

        extractedName = extractedName.replaceAll("(?i)on [a-z]+", "").trim();

        // 2. Create the New Node
        Task newTask = new Task(idCounter++, voiceInput, extractedName, extractedPriority, extractedDate);

        // 3. Insert into Linked List (Insertion at End)
        if (currentUser.head == null) {
            currentUser.head = newTask;
        } else {
            Task current = currentUser.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }

        System.out.println("✅ AI Processed: Task '" + extractedName + "' added successfully!");
    }

    // Helper method to add tasks without typing (for pre-populating)
    static void addManualTask(String name, String prio, String date) {
        Task newTask = new Task(idCounter++, "Manual Entry", name, prio, date);
        if (currentUser.head == null) {
            currentUser.head = newTask;
        } else {
            Task current = currentUser.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
    }

    // 2. LINKED LIST TRAVERSAL (Display)

    static void listTasks() {
        if (currentUser.head == null) {
            System.out.println("\n[!] The list is empty.");
            return;
        }

        Task current = currentUser.head;
        System.out.println("\n--- YOUR TO-DO LIST ---");
        System.out.printf("%-5s %-20s %-10s %-10s %-10s\n", "ID", "Task Name", "Priority", "Date", "Status");
        System.out.println("-------------------------------------------------------------");

        while (current != null) {
            String status = current.isCompleted ? "[DONE]" : "[ ]";
            System.out.printf("%-5d %-20s %-10s %-10s %-10s\n",
                    current.taskID,
                    current.taskName,
                    current.priority,
                    current.dueDate,
                    status);

            current = current.next;
        }
        System.out.println("-------------------------------------------------------------");
    }

    // 3. LINKED LIST MODIFICATION (Update)

    static void updateTask() {
        listTasks();
        System.out.print("\nEnter ID of task to update: ");
        int searchId = scanner.nextInt();
        scanner.nextLine();

        Task current = currentUser.head;
        boolean found = false;

        while (current != null) {
            if (current.taskID == searchId) {
                found = true;
                System.out.println("Found Task: " + current.taskName);
                System.out.println("1. Mark as Completed");
                System.out.println("2. Change Priority");
                System.out.print("Enter choice: ");
                int updateChoice = scanner.nextInt();

                if (updateChoice == 1) {
                    current.isCompleted = true;
                    System.out.println("✅ Task marked as completed.");
                } else if (updateChoice == 2) {
                    System.out.print("Enter new priority (High/Medium/Low): ");
                    current.priority = scanner.next();
                    System.out.println("✅ Priority updated.");
                }
                break;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("❌ Task ID not found.");
        }
    }

    // 4. LINKED LIST DELETION (Delete)

    static void deleteTask() {
        if (currentUser.head == null) {
            System.out.println("List is empty.");
            return;
        }

        listTasks();
        System.out.print("\nEnter ID of task to delete: ");
        int deleteId = scanner.nextInt();

        Task current = currentUser.head;
        Task prev = null;

        // Case 1: Deleting the Head
        if (current != null && current.taskID == deleteId) {
            currentUser.head = current.next; // Move head
            System.out.println("✅ Task deleted successfully.");
            return;
        }

        // Case 2: Searching for the node
        while (current != null && current.taskID != deleteId) {
            prev = current;
            current = current.next;
        }

        // Case 3: Node not found
        if (current == null) {
            System.out.println("❌ Task ID not found.");
            return;
        }

        // Case 4: Unlink the node
        prev.next = current.next;
        System.out.println("✅ Task deleted successfully.");
    }

    // --------------------------------------------------------
    // NEW FEATURE: VIEW ALL 16 VARIABLES (Satisfies Rubric for "Access")
    // --------------------------------------------------------
    static void viewTaskDetails() {
        if (currentUser.head == null) {
            System.out.println("List is empty.");
            return;
        }

        System.out.print("\nEnter Task ID to view full details: ");
        int searchId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Task current = currentUser.head;
        boolean found = false;

        while (current != null) {
            if (current.taskID == searchId) {
                found = true;
                System.out.println("\n===========================================");
                System.out.println("   📝 FULL TASK DETAILS (Using all 16 Variables)");
                System.out.println("===========================================");

                // 1. Identification
                System.out.println("[ID]:             " + current.taskID);

                // 2. Voice Data (These are the ones you were worried about!)
                System.out.println("[Raw Command]:    " + current.rawVoiceCommand);
                System.out.println("[AI Confidence]:  " + current.voiceConfidenceScore + "%");
                System.out.println("[Audio Path]:     " + current.audioFilePath);
                System.out.println("[Language]:       " + current.detectedLanguage);

                // 3. Task Details
                System.out.println("[Task Name]:      " + current.taskName);
                System.out.println("[Category]:       " + current.category);
                System.out.println("[Priority]:       " + current.priority);
                System.out.println("[Extra Notes]:    " + current.extraNotes);

                // 4. Time & Scheduling
                System.out.println("[Due Date]:       " + current.dueDate);
                System.out.println("[Due Time]:       " + current.dueTime);
                System.out.println("[Est. Duration]:  " + current.estimatedDuration + " mins");
                System.out.println("[Recurring]:      " + (current.isRecurring ? "Yes" : "No"));

                // 5. Context & Status
                System.out.println("[Location]:       " + current.location);
                System.out.println("[Status]:         " + (current.isCompleted ? "Completed" : "Pending"));
                System.out.println("[Created By]:     " + current.createdBy + " on " + current.creationDate);
                System.out.println("===========================================");
                break;
            }
            current = current.next;
        }
        if (!found)
            System.out.println("❌ Task ID not found.");
    }




        // SUBTASKS
    static void addViewSubtasks() {
        System.out.println("\n--- ADD/VIEW SUBTASKS ---");

        System.out.println("Enter Task ID: ");
        int taskID = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Task current = currentUser.head;
        boolean found = false;

        while (current != null) {
            if (current.taskID == taskID) {
                found = true;
                break;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("❌ Task ID not found.");
            return;
        }

        boolean subtasksesh = true;
        while (subtasksesh) {
            System.out.println("\n[A] - Add Subtask");
            System.out.println("[D] - Delete Subtask");
            System.out.println("[V] - View Subtasks");
            System.out.println("[X] - Exit");
            System.out.print("Enter choice: ");
            
            String input = scanner.next();
            char choice = input.toUpperCase().charAt(0);
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 'A':
                    addSubtask(current); // Pass current
                    break;
                case 'D':
                    removeSubtask(current); // Pass current
                    break;
                case 'V':
                    listSubtasks(current); // Pass current
                    break;
                case 'X':
                    subtasksesh = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // 1. STACK INSERTION (Add)
    static void addSubtask(Task current) { // Accept current
        System.out.print("Enter a subtask for " + current.taskName + " : ");
        String subtask = scanner.nextLine();

        SubTask newsubtask = new SubTask(subtask);

        if (current.subtaskdetail == null) {
            current.subtaskdetail = newsubtask;
        } else {
            newsubtask.next = current.subtaskdetail; // Use next, not ptrnext
            current.subtaskdetail = newsubtask;
        }
        System.out.println("✅ Subtask added.");
    }

    // 2. STACK DELETION (Delete/Pop)
    static void removeSubtask(Task current) { // Accept current
        if (current.subtaskdetail == null) {
            System.out.println("\n\nThe list is empty. Nothing to delete!!!");
        } else {
            System.out.println("Completed: " + current.subtaskdetail.subtaskdetail);
            current.subtaskdetail = current.subtaskdetail.next; // Use next
        }
    }

    // 3. STACK DISPLAY (List)
    static void listSubtasks(Task current) { // Accept current
        if (current.subtaskdetail == null) {
            System.out.println("\nEmpty list");
            return;
        }

        SubTask currentNode = current.subtaskdetail;
        System.out.println("\n--- SUBTASKS FOR " + current.taskName + " ---");
        while (currentNode != null) {
            System.out.println("- " + currentNode.subtaskdetail);
            currentNode = currentNode.next; // Use next
        }
    }
    

    public static void sortingMenu() {
        int sortMenu;
        do{
            System.out.println("\n===========================================");
            System.out.println("---------------SORTING TASKS---------------");
            System.out.println("===========================================");
            System.out.println("\n1. Sort In TO-DO LIST");
            System.out.println("2. Sort In FULL TASKS DETAILS");
            System.out.println("3. Exit");
            System.out.println("Enter choice (1, 2 or 3): ");
            sortMenu = scanner.nextInt();
            scanner.nextLine();
            if(sortMenu == 1) {
                sortTaskLists();
            }
            else if(sortMenu == 2) {
                sortFullTaskDetails();
            }
            else if(sortMenu != 1 && sortMenu != 2 && sortMenu != 3){
                System.out.println("You are only allow to choose 1, 2 or 3!! Please try again. ");
            }
        }while(sortMenu != 3);
    }

    public static void sortTaskLists() {
        int sortToDoList;
        do{
            System.out.println("\n===========================================");
            System.out.println("-------------SORT TO-DO LIST---------------");
            System.out.println("===========================================");
            System.out.println("\n1. Sort the priority (From High to Low). "); // Upper to lower
            System.out.println("2. Sort the date(From Monday to Sunday). "); //Lower to Upper
            System.out.println("3. Exit");
            System.out.println("Enter choice (1, 2 or 3): ");
            sortToDoList = scanner.nextInt();
            if(sortToDoList == 1) {
                displayAfterSortedPriority();
            }
            else if(sortToDoList == 2) {
                displayAfterSortedDate();
            }
            else if(sortToDoList != 1 && sortToDoList != 2 && sortToDoList != 3){
                System.out.println("You are only allow to choose 1, 2 or 3!! Please try again. ");
            }
        }while(sortToDoList != 3);     
    }
    
    public static void displayAfterSortedPriority() { // bubble sort on Priority
        int totalData = 0;
        int temp;
        int secondTemp;
        int taskID;
        String taskName;
        String priority;
        String dueDate;
        boolean isCompleted;
        String status = null;
        Task current = currentUser.head;
        Task newCurrent = null;
        if(current == null) {
            System.out.println("\n--- SORTED RESULTS (Priority: High to Low)---");
            System.out.println("ID    Task Name             Priority     Date      Status");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("The data inside your TO-DO LIST is empty!! Nothing to sorting. ");
            System.out.println("-----------------------------------------------------------------");
        }
        else if(current.next == null){
            System.out.println("\n--- SORTED RESULTS ---");
            System.out.println("ID    Task Name             Priority     Date      Status");
            System.out.println("-----------------------------------------------------------------");
            while(current != null) {
                
                if(current.isCompleted == true) {
                    status = "[DONE]";
                }
                else if (current.isCompleted == false) { 
                   status = "[PENDING]"; 
                }
                System.out.println(current.taskID+"    "+current.taskName+"       "+current.priority+"       "+current.dueDate+"     "+status);
                current = current.next;
            }
            System.out.println("-----------------------------------------------------------------");
        }
        else {
            
            while(current != null) {
                totalData+= 1;
                newCurrent = new Task(current.taskID, null, current.taskName, current.priority, current.dueDate);
                newCurrent.isCompleted = current.isCompleted;
                if(sortHead == null) {
                    sortHead = newCurrent;
                }
                else {
                    Task currentNode = sortHead;
                    while(currentNode.next != null) {
                        currentNode = currentNode.next;
                    }
                    currentNode.next = newCurrent;
                }
                current = current.next;
            }
            while(totalData > 1) {
                totalData--;
                newCurrent = sortHead;
                while(newCurrent != null) {
                    if(newCurrent.next != null) {
                        temp = getPriority(newCurrent.priority);
                        secondTemp = getPriority(newCurrent.next.priority);
                        if(temp < secondTemp) {

                            taskID = newCurrent.taskID;
                            newCurrent.taskID = newCurrent.next.taskID;
                            newCurrent.next.taskID = taskID;
                            
                            taskName = newCurrent.taskName;
                            newCurrent.taskName = newCurrent.next.taskName;
                            newCurrent.next.taskName = taskName;
                            
                            priority = newCurrent.priority;
                            newCurrent.priority = newCurrent.next.priority;
                            newCurrent.next.priority = priority;
                            
                            dueDate = newCurrent.dueDate;
                            newCurrent.dueDate = newCurrent.next.dueDate;
                            newCurrent.next.dueDate = dueDate;
                            
                            isCompleted = newCurrent.isCompleted;
                            newCurrent.isCompleted = newCurrent.next.isCompleted;
                            newCurrent.next.isCompleted = isCompleted;
                        }
                    }
                newCurrent = newCurrent.next;  
                }
                newCurrent = sortHead;
            }
            System.out.println("\n--- SORTED RESULTS (Priority: High to Low)---");
            System.out.printf("%-5s %-20s %-10s %-10s %-10s\n", "ID", "Task Name", "Priority", "Date", "Status");
            System.out.println("-------------------------------------------------------------");
            while(newCurrent != null) {
                if(newCurrent.isCompleted == true) {
                    status = "[DONE]";
                }
                else if (newCurrent.isCompleted == false) { 
                   status = "[PENDING]"; 
                }
                System.out.printf("%-5d %-20s %-10s %-10s %-10s\n", newCurrent.taskID, newCurrent.taskName, newCurrent.priority, newCurrent.dueDate, status);
                newCurrent = newCurrent.next;
            }
            System.out.println("-------------------------------------------------------------");
            sortHead = null;
            
        }
        
    }
    
    public static int getPriority(String priority) {
        int exchangeToNumerical = 0;
        if(priority.equalsIgnoreCase("High")) {
            exchangeToNumerical = 3;
        }
        else if(priority.equalsIgnoreCase("Medium")) {
            exchangeToNumerical = 2;
        }
        else if(priority.equalsIgnoreCase("Low")){
            exchangeToNumerical = 1;
        }
        return exchangeToNumerical;
    }
    
    public static void displayAfterSortedDate() { //Bubble sort the Date
        int totalData = 0;
        int temp;
        int secondTemp;
        int taskID;
        String taskName;
        String priority;
        String dueDate;
        boolean isCompleted;
        String status = null;
        Task current = currentUser.head;
        Task newCurrent = null;
        if(current == null) {
            System.out.println("\n--- SORTED RESULTS (Priority: Monday to Sunday)---");
            System.out.println("ID    Task Name             Priority     Date      Status");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("The data inside your TO-DO LIST is empty!! Nothing to sorting. ");
            System.out.println("-----------------------------------------------------------------");
        }
        else if(current.next == null){
            System.out.println("\n--- SORTED RESULTS ---");
            System.out.println("ID    Task Name             Priority     Date      Status");
            System.out.println("-----------------------------------------------------------------");
            while(current != null) {
                
                if(current.isCompleted == true) {
                    status = "[DONE]";
                }
                else if (current.isCompleted == false) { 
                   status = "[PENDING]"; 
                }
                System.out.println(current.taskID+"    "+current.taskName+"       "+current.priority+"       "+current.dueDate+"     "+status);
                current = current.next;
            }
            System.out.println("-----------------------------------------------------------------");
        }
        else {
            while(current != null) {
                totalData+= 1;
                newCurrent = new Task(current.taskID, null, current.taskName, current.priority, current.dueDate);
                newCurrent.isCompleted = current.isCompleted;
                if(sortHead == null) {
                    sortHead = newCurrent;
                }
                else {
                    Task currentNode = sortHead;
                    while(currentNode.next != null) {
                        currentNode = currentNode.next;
                    }
                    currentNode.next = newCurrent;
                }
                current = current.next;
            }
            while(totalData > 1) {
                totalData--;
                newCurrent = sortHead;
                while(newCurrent != null) {
                    if(newCurrent.next != null) {
                        temp = getDate(newCurrent.dueDate);
                        secondTemp = getDate(newCurrent.next.dueDate);
                        if(temp > secondTemp) {

                            taskID = newCurrent.next.taskID;
                            newCurrent.next.taskID = newCurrent.taskID;
                            newCurrent.taskID = taskID;
                            
                            taskName = newCurrent.next.taskName;
                            newCurrent.next.taskName = newCurrent.taskName;
                            newCurrent.taskName = taskName;
                            
                            priority = newCurrent.next.priority;
                            newCurrent.next.priority = newCurrent.priority;
                            newCurrent.priority = priority;
                            
                            dueDate = newCurrent.next.dueDate;
                            newCurrent.next.dueDate = newCurrent.dueDate;
                            newCurrent.dueDate = dueDate;
                            
                            isCompleted = newCurrent.next.isCompleted;
                            newCurrent.next.isCompleted = newCurrent.isCompleted;
                            newCurrent.isCompleted = isCompleted;
                        }
                    }
                newCurrent = newCurrent.next;  
                }
                newCurrent = sortHead;
            }
            System.out.println("\n--- SORTED RESULTS (Priority: Monday to Sunday)---");
            System.out.printf("%-5s %-20s %-10s %-10s %-10s\n", "ID", "Task Name", "Priority", "Date", "Status");
            System.out.println("-------------------------------------------------------------");
            while(newCurrent != null) {
                if(newCurrent.isCompleted == true) {
                    status = "[DONE]";
                }
                else if (newCurrent.isCompleted == false) { 
                   status = "[PENDING]"; 
                }
                System.out.printf("%-5d %-20s %-10s %-10s %-10s\n", newCurrent.taskID, newCurrent.taskName, newCurrent.priority, newCurrent.dueDate, status);
                newCurrent = newCurrent.next;
            }
            System.out.println("-------------------------------------------------------------");
            sortHead = null;
        }
    }
    
    public static int getDate(String Date) {
        int exchangeToNumerical = 8;
        if(Date.equalsIgnoreCase("Monday")) {
            exchangeToNumerical = 1;
        }
        else if(Date.equalsIgnoreCase("Tuesday")) {
            exchangeToNumerical = 2;
        }
        else if(Date.equalsIgnoreCase("Wednesday")) {
            exchangeToNumerical = 3;
        }
        else if(Date.equalsIgnoreCase("Thursday")) {
            exchangeToNumerical = 4;
        }
        else if(Date.equalsIgnoreCase("Friday")) {
            exchangeToNumerical = 5;
        }
        else if(Date.equalsIgnoreCase("Saturday")) {
            exchangeToNumerical = 6;
        }
        else if(Date.equalsIgnoreCase("Sunday")) {
            exchangeToNumerical = 7;
        }
        return exchangeToNumerical;
    }
    
    public static void sortFullTaskDetails() {
        int sortToDoList;
        do{
            System.out.println("\n===========================================");
            System.out.println("-------SORT (FULL TASKS) TO-DO LIST--------");
            System.out.println("===========================================");
            System.out.println("\n1. Sort the status (From Pending to Completed). "); //Lower to Upper
            System.out.println("2. Sort the date(From Completed to Pending). "); //Upper to Lower
            System.out.println("3. Exit");
            System.out.println("Enter choice (1, 2 or 3): ");
            sortToDoList = scanner.nextInt();
            scanner.nextLine();
            if(sortToDoList == 1) {
                displayAfterUpperStatus();
            }
            else if(sortToDoList == 2) {
                displayAfterLowerStatus();
            }
            else if(sortToDoList != 1 && sortToDoList != 2 && sortToDoList != 3){
                System.out.println("You are only allow to choose 1, 2 or 3!! Please try again. ");
            }
        }while(sortToDoList != 3);     
    }
    
    public static void displayAfterUpperStatus() { //Merge Sort For First Case(ASC)
        int totalData = 0;
        Task current = currentUser.head;
        System.out.println("\n------- SORTED BY STATUS (PENDING TO COMPLETED) -------");
        if(current == null) {
            System.out.println("\n===========================================");
            System.out.println("-------------FULL TASK DETAILS-------------");
            System.out.println("===========================================");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("The data inside your TO-DO LIST is empty!! Nothing to sorting. ");
            System.out.println("-----------------------------------------------------------------");
        }
        else if(current.next == null) {
            System.out.println("\n===========================================");
            System.out.println("-------------FULL TASK DETAILS-------------");
            System.out.println("===========================================");
            System.out.println("[ID]:             " + current.taskID);
            System.out.println("[Raw Command]:    " + current.rawVoiceCommand);
            System.out.println("[AI Confidence]:  " + current.voiceConfidenceScore + "%");
            System.out.println("[Audio Path]:     " + current.audioFilePath);
            System.out.println("[Language]:       " + current.detectedLanguage);
            System.out.println("[Task Name]:      " + current.taskName);
            System.out.println("[Category]:       " + current.category);
            System.out.println("[Priority]:       " + current.priority);
            System.out.println("[Extra Notes]:    " + current.extraNotes);
            System.out.println("[Due Date]:       " + current.dueDate);
            System.out.println("[Due Time]:       " + current.dueTime);
            System.out.println("[Est. Duration]:  " + current.estimatedDuration + " mins");
            System.out.println("[Recurring]:      " + (current.isRecurring ? "Yes" : "No"));
            System.out.println("[Location]:       " + current.location);
            System.out.println("[Status]:         " + (current.isCompleted ? "Completed" : "Pending"));
            System.out.println("[Created By]:     " + current.createdBy + " on " + current.creationDate);
            System.out.println("===========================================");
        }
        else{
            while(current != null) {
                totalData+= 1;
                current = current.next;
            }
            Task[] newTask = new Task[totalData];
            current = currentUser.head;
            for(int i = 0; i < totalData; i++) {
                newTask[i] = current;
                current = current.next;
            }
            
            mergeSort(newTask, 0, totalData - 1, totalData);
            for(int j = 0; j < totalData; j++) {
                Task t = newTask[j];
                System.out.println("\n--------------------{"+(j+1)+"]--------------------");
                System.out.println("\n===========================================");
                System.out.println("-------------FULL TASK DETAILS-------------");
                System.out.println("===========================================");
                System.out.println("[ID]:             " + t.taskID);
                System.out.println("[Raw Command]:    " + t.rawVoiceCommand);
                System.out.println("[AI Confidence]:  " + t.voiceConfidenceScore + "%");
                System.out.println("[Audio Path]:     " + t.audioFilePath);
                System.out.println("[Language]:       " + t.detectedLanguage);
                System.out.println("[Task Name]:      " + t.taskName);
                System.out.println("[Category]:       " + t.category);
                System.out.println("[Priority]:       " + t.priority);
                System.out.println("[Extra Notes]:    " + t.extraNotes);
                System.out.println("[Due Date]:       " + t.dueDate);
                System.out.println("[Due Time]:       " + t.dueTime);
                System.out.println("[Est. Duration]:  " + t.estimatedDuration + " mins");
                System.out.println("[Recurring]:      " + (t.isRecurring ? "Yes" : "No"));
                System.out.println("[Location]:       " + t.location);
                System.out.println("[Status]:         " + (t.isCompleted ? "Completed" : "Pending"));
                System.out.println("[Created By]:     " + t.createdBy + " on " + t.creationDate);
                System.out.println("===========================================");
            }
            
            
        }
    }
    
    public static void mergeSort(Task[] newTask, int first, int last, int maxSize) {
        if(first < last) {
            int middle = (first + last) / 2;
            mergeSort(newTask, first, middle, maxSize);
            mergeSort(newTask, middle + 1, last, maxSize);
            mergeList(newTask, first, middle, last, maxSize);
        }
    }
    
    public static void mergeList(Task[] newTask, int first, int middle, int last, int maxSize) {
        int L, R, count, i;
        Task[] temp = new Task[maxSize];

        L = first;
        count = first;
        R = middle + 1;
        while((L <= middle) && (R <= last)){
            if(getStatus(newTask[L].isCompleted) <= getStatus(newTask[R].isCompleted)) {
                temp[count] = newTask[L];
                L++;
            }
            else {
                temp[count] = newTask[R];
                R++;
            }
            count++;
        }
        if(L > middle) {
            for(i = R; i <= last; i++) {
                temp[count] = newTask[i];
                count++;
            }
        }
        else {
            for(i = L; i <= middle; i++) {
                temp[count] = newTask[i];
                count++;
            }
        }
        for(i=first; i <= last; i++) {
            newTask[i] = temp[i];
        }
    }
    
    public static int getStatus(boolean status) {
        int exchangeToNumerical = 0;
        if(status == true) {
            exchangeToNumerical = 1;
        }
        return exchangeToNumerical;
    }
    
    public static void displayAfterLowerStatus() { //Merge Sort For Case 2(DESC)
        int totalData = 0;
        Task current = currentUser.head;
        System.out.println("\n--- SORTED BY STATUS (COMPLETED TO PENDING) ---");
        if(current == null) {
            System.out.println("\n===========================================");
            System.out.println("-------------FULL TASK DETAILS-------------");
            System.out.println("===========================================");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("The data inside your TO-DO LIST is empty!! Nothing to sorting. ");
            System.out.println("-----------------------------------------------------------------");
        }
        else if(current.next == null) {
            System.out.println("\n===========================================");
            System.out.println("-------------FULL TASK DETAILS-------------");
            System.out.println("===========================================");

            System.out.println("[ID]:             " + current.taskID);
            System.out.println("[Raw Command]:    " + current.rawVoiceCommand);
            System.out.println("[AI Confidence]:  " + current.voiceConfidenceScore + "%");
            System.out.println("[Audio Path]:     " + current.audioFilePath);
            System.out.println("[Language]:       " + current.detectedLanguage);
            System.out.println("[Task Name]:      " + current.taskName);
            System.out.println("[Category]:       " + current.category);
            System.out.println("[Priority]:       " + current.priority);
            System.out.println("[Extra Notes]:    " + current.extraNotes);
            System.out.println("[Due Date]:       " + current.dueDate);
            System.out.println("[Due Time]:       " + current.dueTime);
            System.out.println("[Est. Duration]:  " + current.estimatedDuration + " mins");
            System.out.println("[Recurring]:      " + (current.isRecurring ? "Yes" : "No"));
            System.out.println("[Location]:       " + current.location);
            System.out.println("[Status]:         " + (current.isCompleted ? "Completed" : "Pending"));
            System.out.println("[Created By]:     " + current.createdBy + " on " + current.creationDate);
            System.out.println("===========================================");
        }
        else{
            //count total
            while(current != null) {
                totalData+= 1;
                current = current.next;
            }
            
            Task[] newTask = new Task[totalData];
            current = currentUser.head; //get the value
            for(int i = 0; i < totalData; i++) {
                newTask[i] = current; //insert value into array
                current = current.next;
            }
            
            mergeSortDesc(newTask, 0, totalData - 1, totalData);
            for(int j = 0; j < totalData; j++) {
                Task t = newTask[j];
                System.out.println("\n--------------------{"+(j+1)+"]--------------------");
                System.out.println("\n===========================================");
                System.out.println("-------------FULL TASK DETAILS-------------");
                System.out.println("===========================================");
                System.out.println("[ID]:             " + t.taskID);
                System.out.println("[Raw Command]:    " + t.rawVoiceCommand);
                System.out.println("[AI Confidence]:  " + t.voiceConfidenceScore + "%");
                System.out.println("[Audio Path]:     " + t.audioFilePath);
                System.out.println("[Language]:       " + t.detectedLanguage);
                System.out.println("[Task Name]:      " + t.taskName);
                System.out.println("[Category]:       " + t.category);
                System.out.println("[Priority]:       " + t.priority);
                System.out.println("[Extra Notes]:    " + t.extraNotes);
                System.out.println("[Due Date]:       " + t.dueDate);
                System.out.println("[Due Time]:       " + t.dueTime);
                System.out.println("[Est. Duration]:  " + t.estimatedDuration + " mins");
                System.out.println("[Recurring]:      " + (t.isRecurring ? "Yes" : "No"));
                System.out.println("[Location]:       " + t.location);
                System.out.println("[Status]:         " + (t.isCompleted ? "Completed" : "Pending"));
                System.out.println("[Created By]:     " + t.createdBy + " on " + t.creationDate);
                System.out.println("===========================================");
            }
        }
    }
    
    public static void mergeSortDesc(Task[] newTask, int first, int last, int maxSize) {
        if(first < last) {
            int middle = (first + last) / 2;
            mergeSortDesc(newTask, first, middle, maxSize);
            mergeSortDesc(newTask, middle + 1, last, maxSize);
            mergeListDesc(newTask, first, middle, last, maxSize);
        }
    }
    
    public static void mergeListDesc(Task[] newTask, int first, int middle, int last, int maxSize) {
        int L, R, count, i;
        Task[] temp = new Task[maxSize];

        L = first;
        count = first;
        R = middle + 1;
        while((L <= middle) && (R <= last)){
            if(getStatus(newTask[L].isCompleted) >= getStatus(newTask[R].isCompleted)) {
                temp[count] = newTask[L];
                L++;
            }
            else {
                temp[count] = newTask[R];
                R++;
            }
            count++;
        }
        if(L > middle) {
            for(i = R; i <= last; i++) {
                temp[count] = newTask[i];
                count++;
            }
        }
        else {
            for(i = L; i <= middle; i++) {
                temp[count] = newTask[i];
                count++;
            }
        }
        for(i=first; i <= last; i++) {
            newTask[i] = temp[i];
        }
    }


    static void searching() {

        if (currentUser.head == null) {
            System.out.println("List is empty. Nothing to search.");
            return;
        }

        System.out.println("====================");
        System.out.println("--- SEARCH MENU ---");
        System.out.println("====================");
        System.out.println("1. Search by Keyword (Task Name)");
        System.out.println("2. Filter by Priority");
        System.out.println("3. Filter by Due Date");
        System.out.println("====================");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        String searchBy = "";

        switch (choice) {
            case 1:
                System.out.print("Enter keyword to find: ");
                searchBy = scanner.nextLine();
                break;
            case 2:
                System.out.print("Enter Priority (High/Medium/Low): ");
                searchBy = scanner.nextLine();
                break;
            case 3:
                System.out.print("Enter Due Date (Example: Monday): ");
                searchBy = scanner.nextLine();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        
        System.out.println("\n--- SEARCH RESULTS ---");
        System.out.printf("%-5s %-20s %-10s %-10s %-10s\n", "ID", "Task Name", "Priority", "Date", "Status");
        System.out.println("-------------------------------------------------------------");

        Task current = currentUser.head;
        boolean foundAny = false;
        
        
        while (current != null) {
            boolean match = false;

            if (choice == 1) {
                //"assign" finds "Assignment"
                if (current.taskName.toLowerCase().contains(searchBy.toLowerCase())) {
                    match = true;
                }
            } else if (choice == 2) {
                if (current.priority.equalsIgnoreCase(searchBy)) {
                    match = true;
                }
            } else if (choice == 3) {
                if (current.dueDate.equalsIgnoreCase(searchBy)) {
                    match = true;
                }
            }
        
            if(match) {
                String status = current.isCompleted ? "[DONE]" : "[PENDING]";
                System.out.printf("%-5d %-20s %-10s %-10s %-10s\n",current.taskID,current.taskName,current.priority,current.dueDate,status);
                foundAny = true;
            }

            current = current.next;    
        } 
        
        System.out.println("-------------------------------------------------------------");
        if (!foundAny) {
            System.out.println("No tasks found matching '" + searchBy + "'");
        }
            
    }
}
