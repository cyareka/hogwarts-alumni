import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Record {
    ArrayList<Alumni> alumniList = new ArrayList<Alumni>();

    private void addAlumni(Alumni alumni) {
        alumniList.add(alumni);
    }

    private Alumni[] convertListToArray() {
        ArrayList<Alumni> alumniList = new ArrayList<Alumni>();
        Alumni[] alumniArray = new Alumni[alumniList.size()];
        alumniList.toArray(alumniArray);
        for (Alumni alumni : alumniArray) {
            System.out.println(alumni);
        }
        return alumniArray;
    }

    public void Save() throws FileNotFoundException {
        File fileName = new File("ALUMNI.txt");
        
        PrintWriter outputFile = new PrintWriter(fileName);
        convertListToArray();

        for (int i = 0; i < convertListToArray().length; i++) {
            outputFile.println(convertListToArray()[i]);
        }
        outputFile.close();
    }
    
    private void Retrieve() {
    }

    private Alumni takeAlumni() {
        Scanner scan = new Scanner(System.in); 
            System.out.print("Name: ");
            String alumniName = scan.nextLine();

            System.out.print("Year Graduated: ");
            int yearGrad = scan.nextInt();
            scan.nextLine();

            System.out.print("Honors & Awards: ");
            String honorsAwards = scan.nextLine();

            System.out.print("Current Company: ");
            String companyNow = scan.nextLine();
            
            System.out.print("Position: ");
            String position = scan.nextLine();

            System.out.print("Date Hired (MM/DD/YY): ");
            String dateHired = scan.nextLine();

            
            Alumni newAlumni = new Alumni(alumniName, yearGrad, honorsAwards, companyNow, position, dateHired);
            return newAlumni;
        
    }
    
    public void showMenu() {
        System.out.println("");
        System.out.println("HOGWARTS ALUMNI RECORDS");
        System.out.println("MENU");
        System.out.println("1 | Create new record");
        System.out.println("2 | Show all records");
        System.out.println("3 | Modify a record");
        System.out.println("4 | Search a record by name");
        System.out.println("5 | Save and Exit");
    }

    public static void main(String[] args) throws Exception {    
        Record main = new Record();
        Scanner s = new Scanner(System.in);
        int inputMenu;
        
        do {
            main.showMenu();
            System.out.print("Input a Number: ");
            inputMenu = s.nextInt();
            s.nextLine();
            System.out.print("");

            switch (inputMenu) {
                case 1:
                    // Add alumni
                    Alumni alumni = main.takeAlumni();
                    main.addAlumni(alumni);
                    break;
                case 2:
                    // Modify Alumni
                    System.out.print("Enter name to modify record: ");
                    String alumniName = s.nextLine().toUpperCase();
                    main.Retrieve();
                    break;
                case 3:
                    // Exit
                    System.exit(1);
                    break;
            }
        } while (inputMenu !=3);
        s.close();
    }
}
