package GameDevelopment.Class;

import java.util.*;

public class Account {
    static String green="\u001B[92m";
    static String reset="\u001B[0m";
    static String red="\u001B[91m";
    static String blue="\u001B[96m";
    private static HashMap<Integer, Register> map;
    private static Login login;
    private static Stack<History> history;
    private static final Scanner scanner = new Scanner(System.in);
    static String Receiverupi;
    private static int Receiverkey;
    private static Register existingRegister;

    Account(HashMap<Integer, Register> map, Login login, Stack<History> history) {
        Account.map = map;
        Account.login = login;
        Account.history = history;
    }


    public void UPIidMoneyTransfer() throws InterruptedException {
        byte upiFlag = 0;

        do {
            System.out.print(blue+"\n1.Back: ");
            System.out.print("\nEnter upi id or 1: "+reset);
            String upi = scanner.nextLine();

            try {
                if (Integer.parseInt(String.valueOf(upi)) == 1) {
                    break;
                }
            }catch (Exception ignored){

            }


            for (Map.Entry<Integer, Register> m : map.entrySet()) {
                if (!(m.getValue().getUpi().equals(map.get(login.getUserKey()).getUpi()))) {
                    Receiverupi = m.getValue().getUpi();
                    Receiverkey = m.getKey();
                    if (upi.equals(Receiverupi)) {
                        ProcessingAmount();
                        upiFlag = 1;
                    }
                }
            }
            if (upiFlag != 1) {
                System.out.println(red+"\nIncorrect Upi"+reset);
            }
        } while (upiFlag != 1);
    }

    public void searchAmountTransfer() throws InterruptedException {

        byte upiFlag = 0;
        long mobileNumber = 0;
        do {
            try {
                System.out.println(blue+"\n1.Back");
                System.out.print("\nEnter Mobile Number: "+reset);
                mobileNumber = scanner.nextLong();

                try {
                    if (mobileNumber == 1) {
                        break;
                    }
                }catch (Exception ignored){

                }
            } catch (Exception e) {
                System.out.println("Incorrect input");
                scanner.nextLine();
            }

            System.out.println(map);
            for (Map.Entry<Integer, Register> m : map.entrySet()) {
                if (!(m.getValue().getPhoneNumber() == map.get(login.getUserKey()).getPhoneNumber())) {
                    long ReceiverNumber = m.getValue().getPhoneNumber();
                    Receiverkey = m.getKey();
                    if (mobileNumber == ReceiverNumber) {
                        ProcessingAmount();
                        upiFlag = 1;
                    }
                }
            }
            if (upiFlag != 1) {
                System.out.println(red+"\n Incorrect mobile number"+reset);
            }
        } while (upiFlag != 1);
    }

    private static void creditAmount(double amount) {
        existingRegister = map.get(Receiverkey);
        existingRegister.setBalance(existingRegister.getBalance() + amount);
        System.out.println(green+"\n\nSuccessfully Credited Account:23546XXXX.\nThank You"+reset);
        System.out.println(existingRegister);
    }

    private static void debitAmount(double amount) throws InterruptedException {
        existingRegister = map.get(login.getUserKey());
        existingRegister.setBalance(existingRegister.getBalance() - amount);
        Thread.sleep(3000);
        System.out.println(green+"\n\nAccount:23546XXXX money Debited.\nThank You "+reset);
        System.out.println(existingRegister);

    }

    private static void ProcessingAmount() throws InterruptedException {
        byte passwordChance = 3;
        byte amountCheck = 0;
        byte out = 0;
        double amount = 0;
        try {
            System.out.print("\nEnter Amount: ");
            amount = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println(red+"Incorrect input"+reset);
            scanner.nextLine();
        }


        do {
            System.out.print("Enter Pin: ");
            int password = scanner.nextInt();

            if (password == map.get(login.getUserKey()).getUserPin()) {
                if (amount > 0 && amount <= map.get(login.getUserKey()).getBalance()) {
                    for (int i = 0; i <= 100; i++) {
                        System.out.print("\rProcessing..." + i);
                        if (i == 5) {
                            i += 4;
                            Thread.sleep(100);
                        } else if (i >= 20 && i <= 50) {
                            i += 5;
                            Thread.sleep(1000);
                        } else if (i >= 80 && i <= 90) {
                            i += 5;
                            Thread.sleep(100);
                        } else if (i == 100)
                            System.out.print("\rProcessing...\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");

                    }
                    out = 1;
                    debitAmount(amount);
                    creditAmount(amount);
                    history.push(new History(map.get(login.getUserKey()).getUpi(), map.get(login.getUserKey()).getPhoneNumber(), amount, map.get(Receiverkey).getUpi(), map.get(Receiverkey).getPhoneNumber(), map.get(Receiverkey).getName()));

                } else {
                    amountCheck = 1;
                    System.out.println(red+"\nInsufficient amount"+reset);
                    Profile.exits();
                }

            } else {
                passwordChance--;
                System.out.println(red+"\nIncorrect Pin"+reset);

            }
            if (amountCheck > 0) {
                break;
            }
            if (passwordChance == 0) {
                System.out.println(red+"after 24 hours try again or Forger password"+reset);
                break;
            }

        } while (out != 1);
    }
}
