package GameDevelopment.Class;

import java.util.*;

public class BankAccountProcess {
    static String blue="\u001B[96m";
    static String reset="\u001B[0m";
    static String red="\u001B[91m";

    byte selectBankNumber = 0;
    Scanner scanner = new Scanner(System.in);
    public LinkedList<String> addBank = new LinkedList<>();

    //      Register register=new Register(new BankAccountProcess(),addBank);
    BankAccountProcess() {

    }

    public boolean BankAccountDetails() {
        byte bankFlag;
        do {
            bankFlag = 0;
            System.out.println(blue+"\n1.HDFC Bank");
            System.out.println("2.CITY Bank");
            System.out.println("3.Union Bank");
            System.out.println("4.Indian Bank");
            System.out.println("5.Bank of Baroda");
            System.out.println("6.Karur Bank");
            System.out.println("7.Central Bank of India");
            System.out.println("8.State Bank of India");
            System.out.println("9.ICICI Bank");
            System.out.println("10.Back"+reset);

            try {
                System.out.print("\nSelect the Bank :");
                selectBankNumber = scanner.nextByte();
                if (selectBankNumber == 10) {
                    return true;
                }
            } catch (Exception e) {
                System.out.println(red+"Incorrect input"+reset);
                scanner.nextLine();
                bankFlag = 1;
            }
        } while (bankFlag == 1);
        return false;
    }

    void NewBankAddInList() {
        String bankList = "hdfc cub union ind bob krb cbi sbi icic";
        String[] list = bankList.split(" ");
        addBank.addAll(Arrays.asList(list));
    }


}
