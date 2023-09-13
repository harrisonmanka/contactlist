import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContactList {
    Table<WorkContact> workContacts;
    Table<PersonalContact> personalContacts;
    int count;
    boolean workFirst;

    public ContactList(){
        this.workContacts = new Table<WorkContact>();
        this.personalContacts = new Table<PersonalContact>();
        this.count = 0;
        this.workFirst = false;
    }

    public void readFiles(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Enter filename for contact list 1> ");
            File file = new File(scanner.next());
            System.out.println("Enter filename for contact list 2> ");
            File file2 = new File(scanner.next());

            populateTables(file);
            populateTables(file2);

            System.out.println("\n");
        }
        catch(Exception e){
            System.out.println("File was not found. Re-enter your two files.");
            readFiles();
        }
        scanner.close();
    }

    public void populateTables(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        if(scanner.next().equals("P")){ //reading in Personal Contact
            //Table<PersonalContact> personalContacts = new Table<>();
            count++;
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
        else if(scanner.next().equals("W")){ //reading in Work Contact
            //Table<WorkContact> workContacts = new Table<>();
            count++;
            if(count == 1){ workFirst = true;}
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
        scanner.close();
    }

    public String promptChoice(){
        String temp = "";
        temp += "Please make choice: \n";
        temp += "\t0) Quit\n";
        temp += "\t1) Intersect\n";
        temp += "\t2) Difference\n";
        temp += "\t3) Union\n";
        temp += "\t4) Select\n";
        temp += "\t5) Remove\n";
        temp += "\t6) Print both tables\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ";
        return temp;
    }

    public void promptUser(){
        System.out.println("Welcome to database display\n\n");
        Scanner scanner = new Scanner(System.in);
        boolean end = false;
        while(end){
            promptChoice();
            String input = scanner.next();
            switch(input){
                case "0": //quit
                    end = true;
                    break;

                case "1": //intersect
                    System.out.println("Enter group > ");
                    String group = scanner.next();
                    System.out.println("Enter attribute > ");
                    String attribute = scanner.next();
                    System.out.println("Enter value > ");
                    String value = scanner.next();
                    Table<? extends Contact> result;
                    if((workFirst == true) && (Integer.valueOf(group)) == 1){
                        result = workContacts.intersect(attribute, value, personalContacts);
                    }
                    else{
                        result = personalContacts.intersect(attribute, value, workContacts);
                    }
                    printTable(result);

                case "2": //difference
                    System.out.println("Enter Contact List > ");
                    String listNum = scanner.next();
                    Table<? extends Contact> result2;
                    if((workFirst == true) && (Integer.valueOf(listNum)) == 1){
                        result2 = workContacts.difference(personalContacts);
                    }
                    else{
                        result2 = personalContacts.difference(workContacts);
                    }
                    printTable(result2);

                case "3": //union
                    System.out.println("Enter Contact List > ");
                    String listNum2 = scanner.next();
                    Table<? extends Contact> result3;
                    if((workFirst == true) && (Integer.valueOf(listNum2)) == 1){
                        result3 = workContacts.union(personalContacts);
                    }
                    else{
                        result3 = personalContacts.union(workContacts);
                    }
                    printTable(result3);

                case "4": //select
                    System.out.println("Enter table (1 or 2) > ");
                    String tableNum = scanner.next();
                    System.out.println("Enter attribute > ");
                    String attribute2 = scanner.next();
                    System.out.println("Enter value > ");
                    String value2 = scanner.next();
                    Table<? extends Contact> result4;
                    if((workFirst == true) && (Integer.valueOf(tableNum)) == 1){
                        result4 = workContacts.select(attribute2, value2);
                    }
                    else{
                        result4 = personalContacts.select(attribute2, value2);
                    }
                    printTable(result4);

                case "5": //remove
                    System.out.println("Enter attribute > ");
                    String attribute3 = scanner.next();
                    System.out.println("Enter value > ");
                    String value3 = scanner.next();
                    workContacts.remove(attribute3, value3);
                    personalContacts.remove(attribute3, value3);


                case "6": //print both tables
                    
            }
        }
        scanner.close();
    }

    public void printTable(Table<? extends Contact> table){
        
    }
    public static void main(String[] args){
        ContactList go = new ContactList();
        go.readFiles();
        go.promptUser();
    }
}
