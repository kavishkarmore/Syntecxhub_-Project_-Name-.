import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Studentmanager {

    private ArrayList<Student> students = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    private static final String FILE_NAME = "students.txt";
//adding a constructor

    public Studentmanager() {
    loadFromFile();
}

    // Add Student
    public void addStudent() {

   try {

            System.out.print("Enter Student ID: ");
                        int id = sc.nextInt();
            sc.nextLine();

         if (isDuplicateId(id)) {
            System.out.println("Student ID already exists!");
                        return;
            }

            System.out.print("Enter Name: ");
        String name = sc.nextLine();

            System.out.print("Enter Age: ");
        int age = sc.nextInt();
            sc.nextLine();

        if (age <= 0) {
                System.out.println("Invalid Age!");
                return;
            }

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            if (!isValidEmail(email)) {
                System.out.println("Invalid Email!");
                return;
            }

            System.out.print("Enter Phone: ");
            String phone_number = sc.nextLine();

            if (!isValidPhone(phone_number)) {
                System.out.println("Invalid Phone Number!");
                return;
            }

            Student student = new Student(id, name, age, course, email, phone_number);
            students.add(student);
             saveToFile();

System.out.println("\nStudent Added Successfully!");

        } catch (InputMismatchException e) {

            System.out.println("Invalid Input! Please enter numbers only.");
            sc.nextLine();

        }
    }

    // View Students
    public void viewStudents() {

        if (students.isEmpty()) {
                    System.out.println("No Student Records Found.");
            return;
        }

        for (Student student : students) {
          student.display();
        }
    }

    // Search Student
    public void searchStudent() {

  try {
            System.out.print("Enter Student ID to Search: ");
            int id = sc.nextInt();
            sc.nextLine();

            if (id <= 0) {
                System.out.println("Invalid Student ID!");
                return;         }

            boolean found = false;

            for (Student student : students) {

                if (student.getid() == id) {

                    System.out.println("\nStudent Found:");
                    student.display();

                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Student Not Found!");
            }

        } catch (InputMismatchException e) {

            System.out.println("Invalid Input! Please enter a valid Student ID.");
        sc.nextLine();

        }
    }

    // Update Student
    public void updateStudent() {
      try {

            System.out.print("Enter Student ID to Update: ");
            int id = sc.nextInt();
      sc.nextLine();

            boolean found = false;

            for (Student student : students) {

                if (student.getid() == id) {
                    System.out.print("Enter New Name: ");
                    student.setname(sc.nextLine());

                    System.out.print("Enter New Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    if (age <= 0) {
                        System.out.println("Invalid Age!");
                        return;
            }

                    student.setage(age);

                    System.out.print("Enter New Course: ");
                    student.setcourse(sc.nextLine());

                    System.out.print("Enter New Email: ");
            String email = sc.nextLine();

                    if (!isValidEmail(email)) {
                        System.out.println("Invalid Email!");
                        return;
                    }

                student.setemail(email);

                    System.out.print("Enter New Phone: ");
                    String phone_number = sc.nextLine();
                    if (!isValidPhone(phone_number)) {
                        System.out.println("Invalid Phone Number!");
                        return;
                    }

             student.setno(phone_number);
                    saveToFile();

System.out.println("Student Updated Successfully!");

                    found = true;
                    break;
                }
  }
            if (!found) {
                System.out.println("Student Not Found!");
            }
        } catch (InputMismatchException e) {

            System.out.println("Invalid Input! Please enter numbers only.");
            sc.nextLine();
    }
    }

    // Delete Student
    public void deleteStudent() {

        try {
            System.out.print("Enter Student ID to Delete: ");
            int id = sc.nextInt();
            sc.nextLine();


            if (id <= 0) {
                System.out.println("Invalid Student ID!");
                return;
            }

            boolean found = false;

            for (int i = 0; i < students.size(); i++) {

                if (students.get(i).getid() == id) {

                    students.remove(i);

                    saveToFile();

System.out.println("Student Deleted Successfully!");
        found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Student Not Found!");
            }


        } catch (InputMismatchException e) {

            System.out.println("Invalid Input! Please enter numbers only.");
            sc.nextLine();

        }
    }

    // Validate Email
    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    // Validate Phone Number
    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }



    // Check Duplicate ID
    private boolean isDuplicateId(int id) {

        for (Student student : students) {

            if (student.getid() == id) {
                return true;
            }
        }
        return false;
    }

    private void saveToFile() {

        System.out.println(new File(FILE_NAME).getAbsolutePath());

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

        for (Student student : students) {

            bw.write(student.getid() + "," +
                     student.getname() + "," +
                     student.getage() + "," +
                     student.getcourse() + "," +
                     student.getemail() + "," +
                     student.getno());

            bw.newLine();
        }

    } catch (IOException e) {

        System.out.println("Error while saving data.");

    }
}


private void loadFromFile() {

    File file = new File(FILE_NAME);

    if (!file.exists()) {
        return;
    }

    try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

        String line;

        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");

            Student student = new Student(
                    Integer.parseInt(data[0]),
                    data[1],
                    Integer.parseInt(data[2]),
                    data[3],
                    data[4],
                    data[5]
            );

            students.add(student);
        }

    } catch (IOException e) {

        System.out.println("Error while loading data.");

    }
}
}