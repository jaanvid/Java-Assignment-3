import java.util.Scanner;

public class Students {
    long prn;
    String name;
    int dob;
    int marks;

    public Students(long prn, String name, int dob, int marks) {
        this.prn = prn;
        this.name = name;
        this.dob = dob;
        this.marks = marks;
    }

    void addDetails(Scanner sc) {
        System.out.println("Enter PRN");
        prn = sc.nextLong();
        sc.nextLine(); // Consume newline
        System.out.println("Enter Name");
        name = sc.nextLine();
        System.out.println("Enter Date of Birth");
        dob = sc.nextInt();
        System.out.println("Enter Marks");
        marks = sc.nextInt();
    }

    void displayDetails() {
        System.out.println("PRN: " + prn);
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Marks: " + marks);
    }

    int searchByPRN(long searchPRN) {
        if (prn == searchPRN) {
            return 1; // Found
        }
        return 0; // Not found
    }

    int searchByName(String searchName) {
        if (name.equals(searchName)) {
            return 1; // Found
        }
        return 0; // Not found
    }

    void updateDetails(Scanner sc) {
        System.out.println("Enter new Name");
        name = sc.nextLine();
        System.out.println("Enter new Date of Birth");
        dob = sc.nextInt();
        System.out.println("Enter new Marks");
        marks = sc.nextInt();
    }

    void deleteDetails() {
        prn = 0;
        name = "";
        dob = 0;
        marks = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        Students[] studentArray = new Students[100]; // Array of objects
        int studentCount = 0;

        do {
            System.out.println("1:Add Students");
            System.out.println("2:Display Students");
            System.out.println("3:Search Students by PRN");
            System.out.println("4:Search Students by Name");
            System.out.println("5:Search Students by Position");
            System.out.println("6:Update Students");
            System.out.println("7:Delete Students");
            System.out.println("Press 0 to quit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting Program");
                    break;
                case 1:
                    studentArray[studentCount] = new Students(0, "", 0, 0); 
                    studentArray[studentCount].addDetails(sc); 
                    studentCount++; 
                    break;
                case 2:
                    for (int i = 0; i < studentCount; i++) {
                        studentArray[i].displayDetails();
                    }
                    break;
                case 3:
                    System.out.println("Enter PRN to search: ");
                    long searchPRN = sc.nextLong();
                    int foundPRN = 0;
                    for (int i = 0; i < studentCount; i++) {
                        if (studentArray[i].searchByPRN(searchPRN) == 1) {
                            studentArray[i].displayDetails();
                            foundPRN = 1;
                            break;
                        }
                    }
                    if (foundPRN == 0) {
                        System.out.println("Student with given PRN not found!");
                    }
                    break;
                case 4:
                    System.out.println("Enter Name to search: ");
                    sc.nextLine(); // Consume newline
                    String searchName = sc.nextLine();
                    int foundName = 0;
                    for (int i = 0; i < studentCount; i++) {
                        if (studentArray[i].searchByName(searchName) == 1) {
                            studentArray[i].displayDetails();
                            foundName = 1;
                        }
                    }
                    if (foundName == 0) {
                        System.out.println("Student with given Name not found!");
                    }
                    break;
                case 5:
                    System.out.println("Enter Position to search (starting from 0): ");
                    int position = sc.nextInt();
                    if (position >= 0 && position < studentCount) {
                        studentArray[position].displayDetails();
                    } else {
                        System.out.println("Invalid position!");
                    }
                    break;
                case 6:
                    System.out.println("Enter PRN to update: ");
                    long updatePRN = sc.nextLong();
                    int updateIndex = -1;
                    for (int i = 0; i < studentCount; i++) {
                        if (studentArray[i].prn == updatePRN) {
                            updateIndex = i;
                            break;
                        }
                    }
                    if (updateIndex != -1) {
                        studentArray[updateIndex].updateDetails(sc);
                        System.out.println("Student details updated successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 7:
                    System.out.println("Enter PRN to delete: ");
                    long deletePRN = sc.nextLong();
                    int deleteIndex = -1;
                    for (int i = 0; i < studentCount; i++) {
                        if (studentArray[i].prn == deletePRN) {
                            deleteIndex = i;
                            break;
                        }
                    }
                    if (deleteIndex != -1) {
                        studentArray[deleteIndex].deleteDetails();
                        System.out.println("Student details deleted successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 0);
    }
}