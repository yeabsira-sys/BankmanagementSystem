
package Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Date;
import Account.BankAccount;

public class Registration {
    public boolean correctInput = false, ch, invalidinput, pinn;
    public static boolean accountFound;
    public static boolean checkPin;
    public static String name, password, file, prevB;
    private static final int adminpassword = 1234;
    public static int pin, newPin;
    public static char choosechar, a;
    public static int accountNumber;
    public boolean checkError = false;
    private static Date date;

    Scanner scanner = new Scanner(System.in);
    
    public void accountNumberGenerator() {
        accountNumber = (int) (Math.random() * (9999999) + 1000000);
    }
    public static int getAccountnumber() {
        return accountNumber;
    }
    
    // Default Constructor
    public Registration(String userName, int userPassword) {
        name = userName;
        pin = userPassword;
    }
    // Overloading Constructor for new user
    public Registration(String userName, int userPassword, int confPassword) {

        name = userName;
        newPin = userPassword;
        pin = confPassword;
    }

    // A method that return the name of the user
    public static String getUserName() {
        return name;
    }

    void setPassword() throws IOException {
        
        System.out.println("Enter Your pin");
    }
    static int getPin() {
        return pin;
    }
    void setNewPassword() {
        System.out.print("Enter New pin: ");
    }
    static double getBalance() {
        return BankAccount.balance;
    }
    public static Date getDate() {
        date = new Date();
        return date;
    }

    public class customerPin {

        public void setPassword(int intPass) {
            newPin = scanner.nextInt();
            newPin = intPass;
        }

        public boolean check() {
            // checks the input of the user
            char[] chars = name.toCharArray();
            for (char c : chars) {
                if (Character.isDigit(c)) {
                    ch = true;
                } else if (Character.isWhitespace(c)) {
                    ch = true;
                }

            }

            return ch;
        }

    }

    public static void createFile() throws IOException {

        try {
            date = new Date();
            String file = getUserName();
            FileWriter output = new FileWriter(file + ".txt", true);
            output.write("Name: " + getUserName() + "\n");
            output.write("Account number: 100" + getAccountnumber() + "\n");
            output.write(String.valueOf(pin));
            output.write("\n");
            output.close();

        } catch (IOException h) {

            System.out.println("\t\t Faild To Create File!!");
        }
    }
    public static void createDatabase() throws IOException {  
        FileWriter userdata = new FileWriter("user bank account database.txt", true);
        //userdata.write("\n");
        userdata.write("Name: " + getUserName() + "\n");
        userdata.write("Account number: 100" + getAccountnumber() + "\n");
        userdata.write("Date: " + getDate());
        userdata.write("\n");
        userdata.close();
    }
    public static void searchFile(String s) {

        try {
            String file = getUserName();
            password = Files.readAllLines(Paths.get(file + ".txt")).get(2);
            
            if (Integer.valueOf(password) == pin) {
                accountFound = true;
            } else {
                checkPin = false;
                System.out.print("INcorrect pin or username. \nPlease check your user name or password and try again!!");
                        
                System.exit(0);
            }

        } catch (IOException i) {

            System.out.println("\t\t File Not Found!!!");
            BankAccount.error();
        }
    }
    public static void deleteRecord(String delete) {

        File f = new File("C:\\Users\\yebel\\OneDrive\\Documents\\NetBeansProjects\\BankmanagementSystem\\" + delete + ".txt");

        if (f.delete()) {
            System.out.println("\t\t file deleted Successfully. ");
        } else {
            System.out.println("\t\t Failed to delete the file !!");
        }
    }
    public static String getPrevBalance() throws IOException, NumberFormatException{
        String file = getUserName();
        prevB = Files.readAllLines(Paths.get(file + ".txt")).get(3);
        System.out.print(prevB);
        return prevB;
    }
    // checks if the user has an account before
    public void checkNewUser() throws IOException, FileNotFoundException, ClassNotFoundException {
        try {
            Registration customer = new Registration(name, pin);
            customerPin docheck = new customerPin();
            while ( !correctInput) {
                // getPrevBalance();
                System.out.println(
                        "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                System.out.println("WELCOME!!");
                System.out.println("Do You Have an Account? (y/n) ");
                System.out.println(
                        "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                choosechar = scanner.next().charAt(0);
                if (Character.isUpperCase(choosechar)) {
                    choosechar = Character.toLowerCase(choosechar);
                }
                correctInput = (choosechar == 'y') || (choosechar == 'n');

                if (choosechar == 'y') {

                    System.out.println(
                            "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                    System.out.println("Login ");
                    System.out.println(
                            "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*= \n");

                    do {                      
                        System.out.println("Enter Your Name");
                        name = scanner.next();
                        invalidinput = docheck.check();
                        if (invalidinput) {
                            System.out.println(
                                    "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
                            System.out.println("*           !!! Please Enter only Alphabet letter         \t  *");
                            System.out.println(
                                    "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
                        }
                        ch = false;
                    } while (invalidinput);

                    customer.setPassword();
                    pin = scanner.nextInt();
                    searchFile(name);
                    getPrevBalance();

                } else if (choosechar == 'n') {
                    System.out.println(
                            "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                    System.out.println("SingUp ");
                    do {
                        System.out.println("Enter Your Name");
                        name = scanner.next();

                        invalidinput = docheck.check();
                        if (invalidinput) {
                            System.out.println(
                                    "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
                            System.out.println("*           !!! Please Enter only Alphabet letter         \t  *");
                            System.out.println(
                                    "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
                        }
                        ch = false;
                    } while (invalidinput);
                    do {
                        customer.setNewPassword();
                        newPin = scanner.nextInt();
                        customer.setPassword();
                        pin = scanner.nextInt();
                        pinn = newPin == pin;
                        if (pinn) {
                        } else {
                            System.out.println(
                                    "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
                            System.out.println("*           !!! Please Enter the same pin        \t  *");
                            System.out.println(
                                    "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
                        }
                    } while (!pinn);
                    createFile();
                } else {
                    System.out.println("Please Enter only 'y' Or 'n' ");
                }
            }
                   createDatabase();
        } catch (Exception e) {
            System.out.println(e + "Something went wrong!");
            System.exit(0);
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println("please enter the admin password");
        Scanner recievpassword = new Scanner(System.in);
        int chechpass = recievpassword.nextInt();
        if(chechpass == adminpassword){
        Scanner sc = new Scanner(System.in);
        boolean terminator = true;
        while(terminator){
            System.out.println("1: Show Customer Database");
        System.out.println("2: Remove Customer from Database");
        System.out.println("3: to exit");
        System.out.println("Enter your choice:");

        int choice = sc.nextInt();
        if (choice == 1) {
            try {
                FileReader fr = new FileReader("user bank account database.txt");
                int i;
                while ((i = fr.read()) != -1)
                    System.out.print((char) i);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } else if (choice == 2) {
            System.out.print("Enter the filename you want to delete: ");
            file = sc.next();
            deleteRecord(file);
        }
        else if(choice == 3){
            terminator = false;
            System.exit(0);
        }
        else {
            System.out.println("please enter the specified number only");
        }
        }
        }
        
        else{
            System.out.println("invalid password");
            System.exit(0);
        }
        
    }

}

