import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContactList {
    Table<WorkContact> workContacts;
    Table<PersonalContact> personalContacts;

    public ContactList(Table<WorkContact> workContacts, Table<PersonalContact> personalContacts){
        this.workContacts = workContacts;
        this.personalContacts = personalContacts;
    }

    public void readFiles(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Enter a file to read from: ");
            File file = new File(scanner.next());
            populateTables(file);
            System.out.println("Enter a file to read from: ");
            File file2 = new File(scanner.next());
            populateTables(file2);
        }
        catch(Exception e){
            System.out.println("FILE NOT FOUND ENTER ANOTHER");
        }
        scanner.close();
    }

    public void populateTables(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        if(scanner.next().equals("")){

        }
        else if(scanner.next().equals("")){

        }
        else{
            System.out.println("This file does not contain any contacts.");
        }
    }
}
