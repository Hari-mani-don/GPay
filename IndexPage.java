package GameDevelopment.Class;

import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class IndexPage {
   private static final Scanner scanner = new Scanner(System.in);
   private static HashMap<Integer,Register> map;
   private static Login login;
   private static Register register;
   private static Profile profile;
   private static Account account;
   private static History history;
    private static BankAccountProcess bankAccountProcess;
    static String blue="\u001B[96m";
    static String reset="\u001B[0m";
    static String red="\u001B[91m";

    public static void main(String[] args) throws InterruptedException, IOException {
        //Data Store
        map= new HashMap<>();
        map.put(0,new Register("hari","mani","pselvamani486@gmail.com","India",9361931850L,2000,"pselvamani486@moneyPay",869800118351L,486486));
        map.put(1,new Register("hariMani","h93mani486@iraH","mani@gmail.com","India",7826980179L,2000,"mani@moneyPay",978800118351L,486));
        bankAccountProcess=new BankAccountProcess();
        bankAccountProcess.NewBankAddInList();
        register= new Register(map,bankAccountProcess,bankAccountProcess.addBank);
        login = new Login(map,register);
        history = new History(map);
        account=new Account(map,login,history.history);


        wordsTitle.moneyTitle();
        byte  number;
        do{

            number=0;
            System.out.println(blue+"\n1.Login");
            System.out.println("2.Register");
            System.out.println("3.exit"+reset);



          try{

                number =scanner.nextByte();
              System.out.print("\033[H\033[2J");
              System.out.flush();
          }catch (Exception e){
              System.out.println(red+"Incorrect input");
              scanner.nextLine();
          }
            switch (number) {
                case 1:
                    wordsTitle.LoginTitle();
                    boolean LoginCheck = Login.UserLoginDetails();
                    if (LoginCheck) {
                        boolean LogOutCheck = FirstPage();
                        if (LogOutCheck) {
                            break;
                        }
                    }
                    break;

                case 2:
                    wordsTitle.RegisterTitle();
                    boolean result = register.UserDetails();
                    break;
            }

        }while (number!=3);

    }

    private static boolean FirstPage() throws InterruptedException {

        while (true){
            wordsTitle.moneyTitle();
            System.out.println(blue+"\n1.Profile");
            System.out.println("2.UPI id use to money transfer");
            System.out.println("3.Pay Contact");
            System.out.println("4.Transaction History");
            System.out.println("5.Balance Check");
            System.out.println("6.Change Password"+reset);

            int number =0;
            try{
                number =scanner.nextInt();
            } catch (Exception e){
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
            switch (number){
                case 1:
                    Register.loadingThread("loading");
                    wordsTitle.ProfileTitle();
                   boolean LogOutCheck= Profile.UserProfile();
                   if(LogOutCheck){
                       return true;
                   }
                    break;
                case 2:

                    Register.loadingThread("loading");
                    wordsTitle.UPiTitle();
                    account.UPIidMoneyTransfer();
                    break;
                case 3:

                    Register.loadingThread("loading");
                    wordsTitle.PayTitle();
                    account.searchAmountTransfer();
                    break;
                case 4:
                    Register.loadingThread("loading");
                    wordsTitle.HistoryTitle();
                    System.out.print("\nHow many Transaction history do you want?: ");
                    scanner.nextLine();
                    int showHistory=scanner.nextInt();
                    history.UserTransactionHistory(showHistory);
                    break;
                case 5:
                    Register.loadingThread("loading");
                    wordsTitle.BalanceTitle();
                    history.userBalanceCheck(login.getPassword(),login.getUserKey());
                    break;
                case 6:
                    Register.loadingThread("Processing");
                    wordsTitle.PasswordTitle();
                    Login.userPasswordChange();
                    break;
                default:
                    System.out.println(red+"\nIncorrect Input");

            }
        }
    }
}
