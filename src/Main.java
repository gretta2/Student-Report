import java.io.*;

public class Main {

    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("=== Student Report System ===");
            System.out.print("Enter student name: ");
            String name = consoleReader.readLine();

            System.out.print("Enter roll number: ");
            String rollNumber = consoleReader.readLine();

            System.out.print("Enter marks: ");
            String marksInput = consoleReader.readLine();
            int marks = Integer.parseInt(marksInput);

            writeToFile(name, rollNumber, marks);

            System.out.println("\n=== Saved Student Details ===");
            readFromFile();

        } catch (NumberFormatException e) {
            System.out.println("Invalid input for marks. Please enter a number.");
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
    }

    private static void writeToFile(String name, String rollNumber, int marks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt", true))) {
            writer.write("Name: " + name);
            writer.newLine();
            writer.write("Roll Number: " + rollNumber);
            writer.newLine();
            writer.write("Marks: " + marks);
            writer.newLine();
            writer.write("-----------");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Failed to write to file: " + e.getMessage());
        }
    }

    private static void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file doesn't exist yet. Please add some student records first.");
        } catch (IOException e) {
            System.out.println("Failed to read from file: " + e.getMessage());
        }
    }
}

