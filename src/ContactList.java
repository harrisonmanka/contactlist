import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContactList {
    Table<Contact> table1;
    Table<Contact> table2;

    Scanner systemIn = new Scanner(System.in);

    public ContactList(){
        this.table1 = new Table<>();
        this.table2 = new Table<>();
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

            populateTables(file, table1);
            populateTables(file2, table2);

            System.out.println("\n");
        }
        catch(Exception e){
            System.out.println("File was not found. Re-enter your two files.\n" + e);
            readFiles();
        }
    }

    public void populateTables(File file, Table table) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String fileType = scanner.nextLine();
        if(fileType.equals("P")){ //reading in Personal Contact
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                String[] temp = line.split(",\\s*");
                Contact contact = new PersonalContact(Label.valueOf(temp[8].toUpperCase()));
                contact.setInfo(new PersonalInfo(temp[1], temp[0], Status.NA));
                contact.setEmail(temp[2]);
                contact.setPhoneNumber(temp[3]);
                contact.buildAddress(temp[4], temp[5], temp[6], temp[7]);
                table.insert(contact);
            }
        }
        else if(fileType.equals("W")){ //reading in Work Contact
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                String[] temp = line.split(",\\s*");
                Contact contact = new WorkContact(temp[9], temp[10], temp[11]);
                contact.setInfo(new PersonalInfo(temp[1], temp[0], Status.valueOf(temp[2].toUpperCase())));
                contact.setEmail(temp[3]);
                contact.setPhoneNumber(temp[4]);
                contact.buildAddress(temp[5], temp[6], temp[7], temp[8]);
                table.insert(contact);
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
                    if(Integer.parseInt(group) == 1){
                        result = table1.intersect(attribute, value, table2);
                    }
                    else{
                        result = table2.intersect(attribute, value, table1);
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
                    if(Integer.parseInt(listNum) == 1){
                        result2 = table2.difference(table1);
                    }
                    else{
                        result2 = table1.difference(table2);
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
                    if(Integer.parseInt(listNum2) == 1){
                        result3 = table2.union(table1);
                    }
                    else{
                        result3 = table1.union(table2);
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
                    if(Integer.parseInt(tableNum) == 1){
                        result4 = table2.select(attribute2, value2);
                    }
                    else{
                        result4 = table1.select(attribute2, value2);
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
                    table2.remove(attribute3, value3);
                    table1.remove(attribute3, value3);
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
