import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContactList {
    Table<Contact> workContacts;
    Table<Contact> personalContacts;
    int count;
    boolean workFirst;

    Scanner systemIn = new Scanner(System.in);

    public ContactList(){
        this.workContacts = new Table<>();
        this.personalContacts = new Table<>();
        this.count = 0;
        this.workFirst = false;
    }

    public void readFiles(){
        try{
            System.out.print("Enter filename for contact list 1> ");
            String file1 = systemIn.next();
            System.out.println(file1);
            File file = new File(file1);
            System.out.println();
            System.out.print("Enter filename for contact list 2> ");
            String file2name = systemIn.next();
            System.out.println(file2name);
            File file2 = new File(file2name);

            populateTables(file);
            populateTables(file2);

            System.out.println("\n");
        }
        catch(Exception e){
            System.out.println("File was not found. Re-enter your two files.\n" + e);
            readFiles();
        }
    }

    public void populateTables(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String fileType = scanner.nextLine();
        if(fileType.equals("P")){ //reading in Personal Contact
            //Table<PersonalContact> personalContacts = new Table<>();
            count++;
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                String[] temp = line.split(",\\s*");
                Contact contact = new PersonalContact(Label.valueOf(temp[8].toUpperCase()));
                contact.setInfo(new PersonalInfo(temp[1], temp[0], Status.NA));
                contact.setEmail(temp[2]);
                contact.setPhoneNumber(temp[3]);
                contact.buildAddress(temp[4], temp[5], temp[6], temp[7]);
                personalContacts.insert(contact);
            }
        }
        else if(fileType.equals("W")){ //reading in Work Contact
            //Table<WorkContact> workContacts = new Table<>();
            count++;
            if(count == 1){ workFirst = true;}
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                String[] temp = line.split(",\\s*");
                Contact contact = new WorkContact(temp[9], temp[10], temp[11]);
                contact.setInfo(new PersonalInfo(temp[1], temp[0], Status.valueOf(temp[2].toUpperCase())));
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
        boolean inProgress = true;
        while(inProgress){
            System.out.println(promptChoice());
            String input = systemIn.next();
            switch(input){
                case "0": //quit
                    inProgress = false;
                    break;

                case "1": //intersect
                    System.out.println("Enter group > ");
                    String group = systemIn.next();
                    System.out.println("Enter attribute > ");
                    String attribute = systemIn.next();
                    System.out.println("Enter value > ");
                    String value = systemIn.next();
                    String otherGroup;
                    if(group.equals("1")){
                        otherGroup = "2";
                    }
                    else{
                        otherGroup = "1";
                    }
                    Table<? extends Contact> result;
                    if(workFirst && Integer.parseInt(group) == 1 || !workFirst && Integer.parseInt(group) == 2){
                        result = workContacts.intersect(attribute, value, personalContacts);
                    }
                    else{
                        result = personalContacts.intersect(attribute, value, workContacts);
                    }
                    printHeader(group, otherGroup);
                    printTable(result);
                    printHeader(group, otherGroup);
                    System.out.print("\n");
                    break;

                case "2": //difference
                    System.out.println("Enter Contact List > ");
                    String listNum = systemIn.next();
                    String otherGroup2;
                    if(listNum.equals("1")){
                        otherGroup2 = "2";
                    }
                    else{
                        otherGroup2 = "1";
                    }
                    Table<? extends Contact> result2;
                    if(workFirst && Integer.parseInt(listNum) == 1 || !workFirst && Integer.parseInt(listNum) == 2){
                        result2 = workContacts.difference(personalContacts);
                    }
                    else{
                        result2 = personalContacts.difference(workContacts);
                    }
                    printHeader(listNum, otherGroup2);
                    printTable(result2);
                    printHeader(listNum, otherGroup2);
                    System.out.print("\n");
                    break;

                case "3": //union
                    System.out.println("Enter Contact List > ");
                    String listNum2 = systemIn.next();
                    String otherGroup3;
                    if(listNum2.equals("1")){
                        otherGroup3 = "2";
                    }
                    else{
                        otherGroup3 = "1";
                    }
                    Table<? extends Contact> result3;
                    if(workFirst && Integer.parseInt(listNum2) == 1 || !workFirst && Integer.parseInt(listNum2) == 2){
                        result3 = workContacts.union(personalContacts);
                    }
                    else{
                        result3 = personalContacts.union(workContacts);
                    }
                    printHeader(listNum2, otherGroup3);
                    printTable(result3);
                    printHeader(listNum2, otherGroup3);
                    System.out.print("\n");
                    break;

                case "4": //select
                    System.out.println("Enter table (1 or 2) > ");
                    String tableNum = systemIn.next();
                    System.out.println("Enter attribute > ");
                    String attribute2 = systemIn.next();
                    System.out.println("Enter value > ");
                    String value2 = systemIn.next();
                    String otherGroup4;
                    if(tableNum.equals("1")){
                        otherGroup4 = "2";
                    }
                    else{
                        otherGroup4 = "1";
                    }
                    Table<? extends Contact> result4;
                    if(workFirst && Integer.parseInt(tableNum) == 1 || !workFirst && Integer.parseInt(tableNum) == 2){
                        result4 = workContacts.select(attribute2, value2);
                    }
                    else{
                        result4 = personalContacts.select(attribute2, value2);
                    }
                    printHeader(tableNum, otherGroup4);
                    printTable(result4);
                    printHeader(tableNum, otherGroup4);
                    System.out.print("\n");
                    break;

                case "5": //remove
                    System.out.println("Enter attribute > ");
                    String attribute3 = systemIn.next();
                    System.out.println("Enter value > ");
                    String value3 = systemIn.next();
                    workContacts.remove(attribute3, value3);
                    personalContacts.remove(attribute3, value3);
                    break;


                case "6": //print both tables
                    break;
            }
        }
        systemIn.close();
    }

    public void printTable(Table<? extends Contact> table){
        System.out.println(table.toString());
    }

    public void printHeader(String num, String num2){
        String result = "";
        result += "===========================Contact List " + num + ", Contact List " +
                num2 + "============================";
        System.out.println(result);
    }

    public static void main(String[] args){
        ContactList go = new ContactList();
        go.readFiles();
        go.promptUser();
    }
}
