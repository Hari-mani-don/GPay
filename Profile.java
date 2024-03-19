package GameDevelopment.Class;

import java.util.Scanner;


public class Profile {
    static String reset="\u001B[0m";
    static String red="\u001B[91m";
    static String blue="\u001B[96m";
   private  static String UserName;
    private static String Upi;
    private static long phoneNumber;
    private static String UserEmail;
    private static final   Scanner scanner = new Scanner(System.in);
  static  Register register;

    Profile(String UserName,String UserUpi, long phoneNumber, String UserEmail,Register register){
        Profile.UserName=UserName;
        Profile.Upi=UserUpi;
        Profile.phoneNumber=phoneNumber;
        Profile.UserEmail=UserEmail;
        Profile.register=register;
    }
    public static boolean UserProfile(){
        System.out.println("\tUPI id: "+Upi);
        System.out.println("\tUPI number: "+phoneNumber);

        byte number=0;
        while(true){

            try{
                Register.loadingThread("loading");
                wordsTitle.SettingTitle();
                System.out.println(blue+"\n1.Settings");
                System.out.println("2.Back"+reset);
                number =scanner.nextByte();
            }catch (Exception e){
                System.out.println(red+"Incorrect input"+reset);
                scanner.nextLine();
            }
            switch (number){
                case 1:
                    wordsTitle.SettingTitle();
                  boolean LogOutCheck=  UserSettings();
                  if (LogOutCheck){
                      return true;
                  }
                    break;
                case 2:
                    break;
                default:
                    System.out.println(red+"\nIncorrect Input"+reset);
            }
            if(number==2){
                break;
            }
        }
        return false;
    }
    public static boolean UserSettings(){
        while (true) {
            System.out.println(blue+"\n1.Terms & Conditions");
            System.out.println("2.Personal Info");
            System.out.println("3.Logout");
            System.out.println("4.Add new account");
            System.out.println("5.Back"+reset);

            byte number = 0;
            try {
                number = scanner.nextByte();
            } catch (Exception e) {
                System.out.println(e);
                scanner.nextLine();
            }
            switch (number) {
                case 1:
                    Register.loadingThread("loading");
                    wordsTitle.TermsConditionTitle();
                    TermsConditions();
                    exits();
                    break;
                case 2:
                    Register.loadingThread("loading");
                    wordsTitle.PersonalInfoTitle();
                    System.out.println("\t\tuser name: "+UserName);
                    System.out.println("\t\tuser e-mail: "+UserEmail);
                    System.out.println("\t\tuser phone number: "+phoneNumber);
                    exits();
                    break;
                case 3:
                    Register.loadingThread("loading");
                    return true;
                case 4:
                    Register.loadingThread("loading");
                    wordsTitle.NewAccountTitle();
                    register.UserDetails();
                    break;
                case 5:
                    break;
                default:
                    System.out.println(red+"\nIncorrect Input"+reset);
            }
            if(number==5){
                break;
            }
        }
     return false;
    }
    public static void TermsConditions(){
        String red="\u001B[97m";
        String reset="\u001B[0m";
        System.out.println(red+"Definitions:"+reset+" \n\t\tClearly defining terms used throughout the document, such as \"user\", \"service\", \"payment\", etc.\n" +
                "\n" +
                red+"Service Description:"+reset+" \n\t\tExplanation of the services provided by Google Pay, including its functionalities, features, and capabilities.\n" +
                "\n" +
                red+"User Agreement:"+reset+" \n\t\tOutlining the agreement between the user and Google regarding the use of the Google Pay service.\n" +
                "\n" +
                red+"Registration and Account:"+reset+" \n\t\tInformation about how users can register for Google Pay, create accounts, and manage their account information.\n" +
                "\n" +
                red+"Payments:"+reset+" \n\t\tGuidelines on how payments are processed through Google Pay, including transaction limits, supported payment methods, and transaction fees.\n" +
                "\n" +
                red+"Security:"+reset+" \n\t\tDetails about security measures implemented by Google Pay to protect user data and transactions, as well as user responsibilities for maintaining account security.\n" +
                "\n" +
                red+"Privacy Policy:"+reset+" \n\t\tExplanation of how user data is collected, stored, and used by Google Pay, including consent for data processing and sharing practices.\n" +
                "\n" +
                red+"Intellectual Property:"+reset+" \n\t\tClarification of ownership rights and permitted uses of intellectual property associated with Google Pay.\n" +
                "\n" +
                red+"Liability and Disputes:"+reset+" \n\t\tTerms regarding liability for unauthorized transactions, disputes resolution procedures, and limitations of liability for Google Pay and its affiliates.\n" +
                "\n" +
                red+"Termination:"+reset+" \n\t\tConditions under which Google or the user can terminate the agreement, as well as consequences of termination.\n" +
                "\n" +
                red+"Updates and Changes:"+reset+" \n\t\tInformation on how Google may update the terms and conditions, and how users will be notified of changes.\n" +
                "\n" +
                red+"Governing Law:"+reset+" \n\t\tSpecification of the jurisdiction and laws governing the agreement between the user and Google.");
    }
    public static void exits(){
        byte number=0;
        do {

            try {
                System.out.println(blue+"\n1.Back"+reset);
                number = scanner.nextByte();
            } catch (Exception e) {
                System.out.println(e);
                scanner.nextLine();
            }
            if (number == 1) {
            } else {
                System.out.println(red+"\nIncorrect Input"+reset);
            }
        } while (number != 1);
    }
}

