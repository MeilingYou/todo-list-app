
import java.util.ArrayList;
import java.util.Scanner;
    public class ToDoListApp { //blueprint
        static ArrayList<String> tasks = new ArrayList<>();
        //collection of multiple string value

        static String[] message = {
                "You're doing great!",
                "Keep it up, you're awesome!",
                "One step closer to your goal!",
                "Don't stop now!",
                "Believe in yourself!",
                "You're almost there!",
                "Keep pushing, you've got this!"
        };

        public static void main(String[] args) {//start running
            Scanner scanner = new Scanner(System.in);//create scanner
            boolean running = true; //track of whether the program should continue

            while (running){
                System.out.println("\nTo-Do List Menu:");
                System.out.println("1. Add a task");
                System.out.println("2. Remove a task by name");
                System.out.println("3. Remove a task by index");
                System.out.println("4. View tasks");
                System.out.println("5. Quit");
                System.out.println("Choose an option (1-5): ");

                int choice = -1; //Default invalid choice
                try{
                    choice = scanner.nextInt();//read the user's choice
                    scanner.nextLine();//consume the newline character
                } catch (Exception e){
                    System.out.println("Invalid input! Please enter a number");
                    scanner.nextLine();//clear invalid input
                    continue;//restart the menu
                }



                switch (choice){
                    case 1://add task
                        System.out.print("Enter a task to add: ");
                        String taskToAdd = scanner.nextLine();
                        if(!taskToAdd.isEmpty()) {
                            addTask(taskToAdd);
                        }else {
                            System.out.println("Task cannot be empty!");
                        }
                        break;
                    case 2: //remove a task by name
                        System.out.print("Enter the name of the task to remove: ");
                        String taskToRemove = scanner.nextLine();
                        removeTaskByName(taskToRemove);
                        break;
                    case 3: //Remove a task by index
                        System.out.print("Enter the index of the task to remove: ");
                        int indexToRemove = scanner.nextInt();
                        scanner.nextLine();
                        removeTaskByIndex(indexToRemove);
                        break;

                    case 4: //View tasks
                        if (tasks.isEmpty()) {
                            System.out.println("No tasks in the to-do list.");
                        }else{
                            System.out.println("\nCurrent Tasks :");
                            for (int i = 0; i < tasks.size(); i++){
                                System.out.println(i + ": " + tasks.get(i));
                            }
                        }
                        break;

                    case 5: //Quit
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                    default:
                        System.out.println("Invalid option! Please choose a number between 1 and 5.");
                }


            }

            scanner.close();


        }
        public static void addTask(String task){//method that handle adding tasks
            tasks.add(task);
            showMotivationMessage();
            System.out.println("Task added!");
            //.add() method add the task(String) to task list
        }

        public static void removeTaskByIndex(int index) { //method that remove task
           if (index >= 0 && index < tasks.size()) {
               tasks.remove(index); //removes the task at specified index
               System.out.println("Task removed at index " + index);
            }else {
                System.out.println("invalid index!"); //prints out invalid when
                //can't find the specific task
            }
        }

        public static void removeTaskByName(String taskName){
            if(tasks.contains(taskName)) {
                tasks.remove(taskName);
                System.out.println("Task removed: " + taskName);
            }else {
                System.out.println("Task not found: " + taskName);
            }
        }
        public static void showMotivationMessage(){
            int randomIndex = (int) (Math.random() * message.length); //Generate a random index
            System.out.println(message[randomIndex]);//print the random message
        }

    }
