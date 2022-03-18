import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;  
import java.io.Writer; 
import java.util.ArrayList;

public class Record {
    static Scanner s = new Scanner(System.in);
    ArrayList<Alumni> alumniList = new ArrayList<Alumni>();
    Alumni a = new Alumni();

    File fileName = new File("D:\\HUAWEI-PC\\Documents\\Repos\\hogwarts-alumni\\src\\ALUMNI.txt");
    String fileN = "ALUMNI.txt";
    String line;

    private void addAlumni(Alumni alumni) {
        alumniList.add(alumni);
    }

    private void removeAlumni(Alumni alumni) {
        Retrieve();
        alumniList.removeAll(alumniList);
    }

    public void Save(Alumni alumni) throws FileNotFoundException {
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
    
    private void Retrieve() {
        try {
            BufferedReader input = new BufferedReader(new FileReader(fileN));
            if (!input.ready()) {
                throw new IOException();
            }
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    private Alumni takeAlumni() {
        System.out.println("CREATE A NEW RECORD \n");
        
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

    private Alumni modifyAlumni() {
        Retrieve();

        System.out.println("MODIFY RECORD \n");
        System.out.println("Name: " + a.getAlumniName());
        System.out.println("Year Graduated: " + a.getYearGrad());
        System.out.println("Honors & Awards: " + a.getHonorsAwards());

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
        System.out.println("2 | Modify records");
        System.out.println("3 | Save and Exit");
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
                    // Modify Alumni
                    alumni = main.modifyAlumni();
                    main.removeAlumni(alumni);
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
