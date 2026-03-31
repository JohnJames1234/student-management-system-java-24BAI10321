import java.io.*;
import java.util.*;

class StudentManager {
    List<Student> students = new ArrayList<>();
    final String FILE_NAME = "students.txt";

    StudentManager() {
        loadFromFile();
    }

    void addStudent(Student s) {
        students.add(s);
        saveToFile();
    }

    void viewStudents() {
        for (Student s : students) {
            System.out.println("ID: " + s.id + " Name: " + s.name + " Age: " + s.age);
        }
    }

    Student searchStudent(int id) {
        for (Student s : students) {
            if (s.id == id) return s;
        }
        return null;
    }

    void deleteStudent(int id) {
        students.removeIf(s -> s.id == id);
        saveToFile();
    }

    void updateStudent(int id, String name, int age) {
        for (Student s : students) {
            if (s.id == id) {
                s.name = name;
                s.age = age;
                break;
            }
        }
        saveToFile();
    }

    void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }

    void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                students.add(Student.fromString(line));
            }
        } catch (IOException e) {
            // file may not exist initially
        }
    }
}
