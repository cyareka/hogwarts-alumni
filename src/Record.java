import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Record {

    private List<Alumni> alumniList = new ArrayList<>();

    private void addAlumni(Alumni alumni) {
        alumniList.add(alumni);
    }

    private void removeAlumni(String alumniName) {
        for (Alumni alumni : alumniList) {
           if (alumni.getAlumniName() == alumniName) {
               alumniList.remove(alumni);
            }
        System.out.println("Successfully removed " + alumniName);
        }
    }

    private void searchAlumniByName(String alumniNameSearch) {
        for (Alumni alumni : alumniList) {
            if (alumni.getAlumniName().equals(alumniNameSearch)) {
                System.out.println(alumni.getAlumniName() + "'s Record");
                System.out.println("Honors and Awards: " + alumni.getHonorsAwards());
                System.out.println("Current Company: " + alumni.getCompanyNow());
                System.out.println("Position: " + alumni.getPosition());
                System.out.println("Date Hired" + alumni.getDateHired());
            }
        }
    }

    private void showAlumniList() {
        for (Alumni alumni : alumniList) {
            System.out.println("Name: " + alumni.getAlumniName());
            System.out.println("Year Graduated: " + alumni.getYearGrad());
            System.out.println("Honors and Awards: " + alumni.getHonorsAwards());
            System.out.println("Current Company: " + alumni.getCompanyNow());
            System.out.println("Position: " + alumni.getPosition());
            System.out.println("Date Hired: " + alumni.getDateHired());
            System.out.println("");
        }
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
        System.out.println("Hogwarts Alumni Records");
        System.out.println("Menu");
        System.out.println("1 | Create new record");
        System.out.println("2 | Show all records");
        System.out.println("3 | Remove a record");
        System.out.println("4 | Search a record by name");
        System.out.println("5 | Exit");
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

            switch (inputMenu) {
                case 1:
                    // Add alumni
                    Alumni alumni = main.takeAlumni();
                    main.addAlumni(alumni);
                    break;
                case 2:
                    // Show Alumni
                    main.showAlumniList();
                    break;
                case 3:
                    // Delete Alumni
                    System.out.print("Enter name to delete: ");
                    String alumniName = s.nextLine().toUpperCase();
                    main.removeAlumni(alumniName);
                    break;
                case 4:
                    // Search Alumni by Name
                    System.out.print("Enter name to search: ");
                    String alumniNameSearch = s.nextLine().toUpperCase();
                    main.searchAlumniByName(alumniNameSearch);
                    break;
                case 5:
                    // Save to text file
                    String saveAlumni;
                    System.out.println("\nWould you like to save this record? (Y/N): ");
                    saveAlumni = s.nextLine().toUpperCase();
                        if (saveAlumni == "Y") { 
                        } else if (saveAlumni == "N") {
                        System.out.println("Operation is cancelled.");
                        }
                    break;
                case 6:
                    // Exit
                    System.exit(1);
                    break;
            }
        } while (inputMenu !=5);
        s.close();
    }
}
