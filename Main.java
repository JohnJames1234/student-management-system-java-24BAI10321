import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    manager.addStudent(new Student(id, name, age));
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    Student s = manager.searchStudent(sc.nextInt());
                    if (s != null)
                        System.out.println("Found: " + s.name);
                    else
                        System.out.println("Not Found");
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String uname = sc.nextLine();
                    System.out.print("New Age: ");
                    int uage = sc.nextInt();

                    manager.updateStudent(uid, uname, uage);
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    manager.deleteStudent(sc.nextInt());
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}
