import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UI ui = new UI();
        PhoneBook phoneBook = new PhoneBook();
        Scanner input = new Scanner(System.in);
        while (true) {
            ui.initialize();
            String choice = input.nextLine();
            int choiceNumber = Integer.parseInt(choice);
            switch (choiceNumber) {
                case 2:
                    System.out.println("Enter phone number: ");
                    String phoneNumber = input.nextLine();
                    System.out.println("Enter group: ");
                    String group = input.nextLine();
                    System.out.println("Enter name: ");
                    String name = input.nextLine();
                    System.out.println("Enter gender: ");
                    String gender = input.nextLine();
                    System.out.println("Enter address: ");
                    String address = input.nextLine();
                    System.out.println("Enter birthdate");
                    String birthDate = input.nextLine();
                    System.out.println("Enter email: ");
                    String email = input.nextLine();
                    while (!phoneBook.add(phoneNumber,group,name,gender,address,birthDate,email)) {
                        System.out.println("Re-enter");
                        System.out.println("Enter phone number: ");
                        phoneNumber = input.nextLine();
                        System.out.println("Enter group: ");
                        group = input.nextLine();
                        System.out.println("Enter name: ");
                        name = input.nextLine();
                        System.out.println("Enter gender: ");
                        gender = input.nextLine();
                        System.out.println("Enter address: ");
                        address = input.nextLine();
                        System.out.println("Enter birthdate");
                        birthDate = input.nextLine();
                        System.out.println("Enter email: ");
                        email = input.nextLine();
                    }
                    break;
                case 1:
                    phoneBook.show();
                    break;
                case 4:
                    System.out.println("Enter phone number: ");
                    String toDeletePhoneNumber = input.nextLine();
                    if (phoneBook.delete(toDeletePhoneNumber)) {
                        System.out.println("Xoa thanh cong");
                    }
                    else {
                        if (toDeletePhoneNumber.isEmpty()) {
                            break;
                        } else {
                            System.out.println("Khong tim duoc danh ba voi so dien thoai tren");
                        }
                    }
                case 5:
                    System.out.println("Enter phone number: ");
                    String phoneOrName = input.nextLine();
                    if (phoneBook.find(phoneOrName) != -1) {
                        System.out.println(phoneBook.showAt(phoneBook.find(phoneOrName)));
                    }
                    else {
                        System.out.println("Cant find");
                    }
                case 6:
                    try {
                        File csvFile = new File("src/data/contacts.csv");
                        Scanner myReader = new Scanner(csvFile);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        myReader.close();
                    } catch (FileNotFoundException exception) {
                        exception.printStackTrace();
                    }
                    break;
                case 7:
                        try (PrintWriter sourcePrintWriter = new PrintWriter(new BufferedWriter(new FileWriter("src/data/contacts.csv",true)))) {
                            System.out.println("Enter phone number: ");
                            String newphoneNumber = input.nextLine();
                            System.out.println("Enter group: ");
                            String newgroup = input.nextLine();
                            System.out.println("Enter name: ");
                            String newname = input.nextLine();
                            System.out.println("Enter gender: ");
                            String newgender = input.nextLine();
                            System.out.println("Enter address: ");
                            String newaddress = input.nextLine();
                            System.out.println("Enter birthdate");
                            String newbirthDate = input.nextLine();
                            System.out.println("Enter email: ");
                            String newemail = input.nextLine();
                            Person person = new Person(newphoneNumber,newgroup,newname,newgender,newaddress,newbirthDate,newemail);
                            sourcePrintWriter.write(person.toString());
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }


                case 8:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
