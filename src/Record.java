import java.util.Scanner;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.Writer; 
import java.util.ArrayList;

public class Record {
    static Scanner s = new Scanner(System.in);
    ArrayList<Alumni> alumniList = new ArrayList<Alumni>();
    Alumni a = new Alumni();

    File fileName = new File("D:\\HUAWEI-PC\\Documents\\Repos\\hogwarts-alumni\\src\\ALUMNI.txt");

    private void addAlumni(Alumni alumni) {
        alumniList.add(alumni);
    }

    public void Save(Alumni alumni) {
        try {
            FileWriter fw = new FileWriter(fileName);
            Writer output = new BufferedWriter(fw);
            int sz = alumniList.size();
            for (int i = 0; i < sz; i++) {
                output.write(alumniList.get(i).toString() + "\n");
            }
            output.flush();
            output.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Successfully created record.");
    }
    
    private void Retrieve() throws FileNotFoundException {
        Scanner scan = new Scanner(fileName);
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());;
        }
        scan.close();
    }

    private Alumni takeAlumni() {
        System.out.println("\nCREATE A NEW RECORD");
        
        System.out.print("Name: ");
        String alumniName = s.nextLine();

        System.out.print("Year Graduated: ");
        int yearGrad = s.nextInt();
        s.nextLine();

        System.out.print("Honors & Awards: ");
        String honorsAwards = s.nextLine();

        System.out.print("Current Company: ");
        String companyNow = s.nextLine();
        
        System.out.print("Position: ");
        String position = s.nextLine();

        System.out.print("Date Hired (MM/DD/YY): ");
        String dateHired = s.nextLine();

        Alumni newAlumni = new Alumni(alumniName, yearGrad, honorsAwards, companyNow, position, dateHired);
        return newAlumni;
    }

    private Alumni modifyAlumni(String alumniNameSearch) throws FileNotFoundException {
        for (Alumni alumni : alumniList) {
            if (alumni.getAlumniName().equals(alumniNameSearch)) {
                System.out.println(alumni.getAlumniName() + "'s Record");
                System.out.println("Honors and Awards: " + alumni.getHonorsAwards());
                System.out.println("Current Company: " + alumni.getCompanyNow());
                System.out.println("Position: " + alumni.getPosition());
                System.out.println("Date Hired: " + alumni.getDateHired());
            }
        }

        System.out.println("");

        System.out.print("Current Company: ");
        String companyNow = s.nextLine();
        
        System.out.print("Position: ");
        String position = s.nextLine();

        System.out.print("Date Hired (MM/DD/YY): ");
        String dateHired = s.nextLine();

        Alumni updateAlumni = new Alumni(companyNow, position, dateHired);
        return updateAlumni;
    }
    
    void showMenu() {
        System.out.println("");
        System.out.println("HOGWARTS ALUMNI RECORDS");
        System.out.println("MENU");
        System.out.println("1 | Create new record");
        System.out.println("2 | View record");
        System.out.println("3 | Modify record");
        System.out.println("4 | Exit");
    }

    public static void main(String[] args) throws Exception {    
        Record main = new Record();
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
                    main.Save(alumni);
                    break;
                case 2:
                    // Show Alumni
                    main.Retrieve();
                    break;
                case 3:
                    // Modify Alumni
                    System.out.println("MODIFY RECORD");
                    System.out.println("CURRENT RECORDS");
                    main.Retrieve();

                    System.out.print("Input a record name: ");
                    String alumniNameSearch = s.nextLine().toUpperCase();

                    main.modifyAlumni(alumniNameSearch);
                    break;
                case 4:
                    // Exit
                    break;
            }
        } while (inputMenu != 4);
        s.close();
    }
}
