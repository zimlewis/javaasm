package qu_method;

import java.util.regex.Pattern;
import java.util.*;



public class input_limit {

    public static int int_input(Scanner scanner, String first_mess) {
        String ex_mess = "Integer only!";
        return int_input(scanner, first_mess, ex_mess);
    }

    public static double double_input(Scanner scanner, String first_mess) {
        String ex_mess = "Double only!";
        return double_input(scanner, first_mess, ex_mess);
    }
    

    public static String string_input(Scanner scanner, String first_mess) {
        String ex_mess = "Integer only!";
        return string_input(scanner, first_mess, ex_mess);
    }



    public static int int_input(Scanner scanner, String first_mess, String ex_mess) {
        try {
            System.out.print(first_mess);
            int r = scanner.nextInt();
            return r;
        } catch (Exception ex) {
            System.out.println(ex_mess);
            scanner.nextLine(); // Consume the remaining input
            return int_input(scanner, first_mess, ex_mess);
        }
    }

    public static double double_input(Scanner scanner, String first_mess, String ex_mess) {
        try {
            System.out.print(first_mess);
            Double r = scanner.nextDouble();
            return r;
        } 
        catch (Exception ex) {
            System.out.println(ex_mess);
            scanner.nextLine(); // Consume the remaining input
            return double_input(scanner, first_mess, ex_mess);
        }
    }
    

    public static String string_input(Scanner scanner, String first_mess, String ex_mess) {
        try {
            System.out.print(first_mess);
            String r = scanner.nextLine();
            return r;
        } 
        catch (Exception ex) {
            System.out.println(ex_mess);
            scanner.nextLine(); // Consume the remaining input
            return string_input(scanner, first_mess, ex_mess);
        }
    }

    public static boolean isNameValid(String name)
    {
        String nameRegex = "^[a-zA-Z]+(?:\\s[a-zA-Z]+)+$";;
                              
        Pattern pat = Pattern.compile(nameRegex);
        if (name == null)
            return false;
        return pat.matcher(name).matches();
        
    }

    public static boolean isEmailValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
        
    }

    public static boolean isPhoneValid(String n)
    {
        String Regex = "^0\\d{9}$";
                              
        Pattern pat = Pattern.compile(Regex);
        if (n == null)
            return false;
        return pat.matcher(n).matches();
        
    }

    public static String email_input(Scanner scanner, String first_mess){
        return email_input(scanner, first_mess, "Wrong mail format");
    }
    
    public static String name_input(Scanner scanner, String first_mess){
        return name_input(scanner, first_mess, "Wrong name format");
    }

    public static String phone_input(Scanner scanner, String first_mess){
        return phone_input(scanner, first_mess, "Wrong phone format");
    }

    public static String email_input(Scanner scanner, String first_mess, String ex_mess) {
        String mail;
        do{
            mail = string_input(scanner, first_mess, ex_mess);
            if (!isEmailValid(mail)){
                System.out.println(ex_mess);
                scanner.nextLine();
            }
        }while(!isEmailValid(mail));

        return mail;
    }

    public static String name_input(Scanner scanner, String first_mess, String ex_mess) {
        String name;
        do{
            name = string_input(scanner, first_mess, ex_mess);
            if (!isNameValid(name)){
                System.out.println(ex_mess);
                scanner.nextLine();
            }
        }while(!isNameValid(name));

        return name;
    }

    public static String phone_input(Scanner scanner, String first_mess, String ex_mess) {
        String n;
        do{
            n = string_input(scanner, first_mess, ex_mess);
            if (!isPhoneValid(n)){
                System.out.println(ex_mess);
                scanner.nextLine();
            }
        }while(!isPhoneValid(n));

        return n;
    }


}
