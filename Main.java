import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
         Studentmanager sm=new Studentmanager();
         int choice;
         
         while (true) { 
          System.out.println("\n--------------------------------------------------");
          System.out.println("student Management System");
          System.out.println("---------------------------------------------------");   
          System.out.println("1. Add Student");
          System.out.println("2. View Student");
          System.out.println("3. Search Student");
          System.out.println("4. Update student");
          System.out.println("5. Delete Student");
          System.out.println("6. Exit");



          try {

    System.out.print("Enter Choice: ");
    choice = s.nextInt();

} catch (InputMismatchException e) {

    System.out.println("Invalid Choice! Please enter numbers only.");
    s.nextLine();
    continue;
}

          switch (choice) {
              case 1:
                sm.addStudent();
                  break;

                  case 2:
                    sm.viewStudents();
                    break;
                    
                case 3:
                    sm.searchStudent();
                    break;

                    case 4:
                        sm.updateStudent();
                        break;

                        case 5:
                            sm.deleteStudent();
                            break;

                            case 6: 
                           
    System.out.println("Bye Bye");
    System.exit(0);  // clean exit
    break;


                            default:
                                System.out.println("Invalid Choice!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");


            
          }


         }

    }
    
}
