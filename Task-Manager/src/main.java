import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        TaskManager manager=new TaskManager();
        Scanner scan=new Scanner(System.in);
        while(true){
            System.out.println("*******************");
            System.out.println("1) Add Task");
            System.out.println("2) Show Task");
            System.out.println("3) Delete Task");
            System.out.println("4) Complete Task");
            System.out.println("5) Exit");

            int choice=scan.nextInt();
            scan.nextLine();
            switch (choice){
                case 1:
                    System.out.println("-------------");
                    System.out.println("Enter Your Task...");
                    String title=scan.nextLine();

                    System.out.println("Enter DueDate...");
                    String duedate=scan.nextLine();

                    System.out.println("Enter Your Task Priority...");
                    String priority=scan.nextLine();

                    manager.addTask(new Task(title,duedate,priority));
                    break;

                case 2:
                    manager.show();
                    break;
                case 3:
                    System.out.println("Enter index to delete:");
                    int deleteIndex = scan.nextInt();
                    scan.nextLine();

                    manager.deleteTask(deleteIndex);
                    break;

                case 4:
                    System.out.println("Enter index to complete:");
                    int completeIndex = scan.nextInt();
                    scan.nextLine();

                    manager.completeTask(completeIndex);
                    break;

                case 5:
                    System.exit(0);
                    break;
            }

        }
    }
}
