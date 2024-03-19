package GameDevelopment.Class;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {
    static String green="\u001B[92m";
    static String reset="\u001B[0m";
    static String red="\u001B[91m";
    private static String LogUserName;
    private static String Password;
    private static int userKey=0;
    private static String Upi;
   private static final Scanner scanner = new Scanner(System.in);
   private static HashMap<Integer,Register> map;
          private static Profile profile;
   private static Register register;
    Login(HashMap<Integer,Register> map, Register register){
        Login.map = map;
        this.register=register;
    }

    public int getUserKey() {
        return userKey;
    }

    public void setUserKey(int userKey) {
        Login.userKey = userKey;
    }

    public String getLogUserName() {
        return LogUserName;
    }

    public void setLogUserName(String logUserName) {
        LogUserName = logUserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUpi() {
        return Upi;
    }

    public void setUpi(String upi) {
        Upi = upi;
    }

    public static boolean UserLoginDetails() throws InterruptedException {

        System.out.print("Enter Name or Email : ");
        LogUserName=scanner.nextLine();
        if(!LogUserName.isEmpty()) {
            System.out.print("Enter Password: ");
            Password = scanner.nextLine();


            for (Map.Entry<Integer, Register> m : map.entrySet()) {

                String name = m.getValue().getName();
                String email = m.getValue().getEmail();
                String password = m.getValue().getPassword();

                if ((LogUserName.equals(name) || LogUserName.equals(email)) && Password.equals(password)) {
                    Register.loadingThread("Checking");
                    System.out.println(green+"Login successfully"+reset);
                    userKey=m.getKey();
                    Upi=m.getValue().getUpi();
                     profile = new Profile(map.get(userKey).getName(),map.get(userKey).getUpi(),map.get(userKey).getPhoneNumber(),map.get(userKey).getEmail(),register);
                    return true;
                }
            }
            Register.loadingThread("Checking");
            System.out.println(red+"\npassword does not match try again!!!"+reset);
        }else{
            Register.loadingThread("Checking");
            System.out.println(red+"Username or Email cannot be empty. Please try again."+reset);
            return false;
        }
        return false;
    }
   public static void userPasswordChange(){
        byte Breakflag=0;
        do {
            System.out.print("Enter old Password: ");
            String oldPassword = scanner.nextLine();
            if (oldPassword.equals(map.get(userKey).getPassword())) {
                System.out.print("Enter new Password: ");
                String newPassword = scanner.nextLine();
                System.out.print("Enter new Re-enter Password: ");
                String reEnterPassword = scanner.nextLine();
                if(reEnterPassword.equals(newPassword)) {
                    Register register = map.get(userKey);
                    register.setPassword(newPassword);
                    System.out.println(green+"Successfully changed password"+reset);
                    Breakflag = 1;
                    System.out.println(map.get(userKey));
                }else System.out.println(red+"password mismatch"+reset);
            } else System.out.println(red+"\nIncorrect Password"+reset);
        } while (Breakflag != 1);

    }
}
