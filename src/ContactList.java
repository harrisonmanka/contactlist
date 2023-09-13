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
        if(scanner.next().equals("P")){ //reading in Personal Contact
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                String[] temp = line.split(",\\s*");
                Contact contact = new PersonalContact(Label.valueOf(temp[8]));
                contact.setInfo(new PersonalInfo(temp[1], temp[0], Status.NA));
                contact.setEmail(temp[2]);
                contact.setPhoneNumber(temp[3]);
                contact.buildAddress(temp[4], temp[5], temp[6], temp[7]);
                personalContacts.insert(contact);
            }
        }
        else if(scanner.next().equals("")){
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                String[] temp = line.split(",\\s*");
                Contact contact = new WorkContact(temp[9], temp[10], temp[11]);
                contact.setInfo(new PersonalInfo(temp[1], temp[0], Status.valueOf(temp[2])));
                contact.setEmail(temp[3]);
                contact.setPhoneNumber(temp[4]);
                contact.buildAddress(temp[5], temp[6], temp[7], temp[8]);
                workContacts.insert(contact);
            }
        }
        else{
            System.out.println("This file does not contain any contacts.");
        }
    }
}
