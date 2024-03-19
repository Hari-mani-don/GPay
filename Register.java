package GameDevelopment.Class;

import java.util.*;
import java.util.random.RandomGenerator;

import static com.sun.tools.attach.VirtualMachine.list;

public class Register {
    static String green="\u001B[92m";
    static String reset="\u001B[0m";
    static String red="\u001B[91m";
    private String Name;
    private String Password;
    private String Email;
    private String Country;
    private long PhoneNumber;
    private double Balance = 2000.00;
    static int id = 0;
    private String Upi;
    private int randomNumber = 0;
    private long accountNumber = 0;
    private int userPin;
    int atmValidateYear = 0;
   static Scanner scanner = new Scanner(System.in);
    private HashMap<Integer, Register> map;
    private BankAccountProcess bankAccountProcess;
    private LinkedList<String> bankList;
    static   ArrayList<Object> hasPreviousList = new ArrayList<>();


    //Constructor
    Register(String Name, String Password, String Email, String Country, long PhoneNumber, double Balance, String Upi, long accountNumber, int userPin) {
        this.Name = Name;
        this.Password = Password;
        this.Email = Email;
        this.Country = Country;
        this.PhoneNumber = PhoneNumber;
        this.Balance = Balance;
        this.Upi = Upi;
        this.accountNumber = accountNumber;
        this.userPin = userPin;
    }

    Register(HashMap<Integer, Register> map, BankAccountProcess bankAccountProcess, LinkedList<String> bankList) {

        this.map = map;
        this.bankAccountProcess = bankAccountProcess;
        this.bankList = bankList;
    }
    Register(){

    }

    //getter Setter
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setBalance(double balance) {
        this.Balance = balance;
    }

    public double getBalance() {
        return Balance;
    }

    public String getUpi() {
        return Upi;
    }

    public void setUpi(String upi) {
        Upi = upi;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public int getUserPin() {
        return userPin;
    }

    public void setUserPin(int userPin) {
        this.userPin = userPin;
    }

    public long getAccountNumber() {
        return accountNumber;
    }


    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    //userCredentialMethods
    private void userName() {
        byte nameFlag;
        do {
            nameFlag = 0;
            System.out.print("Enter your name: ");
            scanner.nextLine();
            Name = scanner.nextLine();
            for (Map.Entry<Integer,Register> m:map.entrySet()){
                if(!Name.equals(m.getValue().getName())) {
                    if (!Digit(Name.toCharArray())) {
                        if (Name.isEmpty()) {
                            System.out.println(red+"please Enter name"+reset);
                            nameFlag = 1;
                        }
                    } else {
                        nameFlag = 1;
                        System.out.println(red+"Does not support number in name"+reset);
                    }
                }else {
                    nameFlag = 1;
                    System.out.println(red+"name already exist"+reset);
                }
            }

        } while (nameFlag == 1);
hasPreviousList.add(Name);
        switchCase();

    }

    private void userPassword() {
        byte passwordFlag;
        do {
            passwordFlag = 0;
            System.out.print("Enter your Password min 8(a,B,$,9): ");
            Password = scanner.nextLine();
            System.out.print("Re-enter password: ");
            String reEnterPassword = scanner.nextLine();
            if (Password.equals(reEnterPassword)) {
                if (!(Password.length() >= 8 && LowerLetterPassword(Password.toCharArray())
                        && UpperLetterPassword(Password.toCharArray()) && Digit(Password.toCharArray())
                        && SpecialCharacter(Password.toCharArray()))) {
                    System.out.println(red+"Incorrect password should be in all character"+reset);
                    passwordFlag = 1;
                } else{
                    Register.loadingThread("Searching");
                    System.out.println(green+"Successfully created"+reset);
                    hasPreviousList.add(Password);
                    switchCase();
                }

            } else{
                passwordFlag = 1;
                System.out.println(red+"password mismatch try again!!!"+reset);

            }

        } while (passwordFlag == 1);

    }

    private boolean LowerLetterPassword(char[] password) {
        for (char pass : password) {
            if (pass >= 'a' && pass <= 'z')
                return true;
        }
        return false;
    }

    private boolean UpperLetterPassword(char[] password) {
        for (char pass : password) {
            if (pass >= 'A' && pass <= 'Z')
                return true;
        }
        return false;

    }

    private boolean Digit(char[] password) {
        for (char pass : password) {
            if (pass >= '0' && pass <= '9')
                return true;
        }
        return false;
    }

    private boolean SpecialCharacter(char[] password) {
        for (char pass : password) {
            if (pass == '@' || pass == '#' || pass == '&' || pass == '$')
                return true;
        }
        return false;
    }

    private void userEmail() {
        byte emailFlag;
        scanner.nextLine();
        do {
            emailFlag = 0;
            System.out.print("Enter your Email: ");
            Email = scanner.nextLine();
            if (Email.contains("@gmail.com")) {
                for (Map.Entry<Integer, Register> emailCheck : map.entrySet()) {
                    if (Email.equals(emailCheck.getValue().getEmail())) {
                        System.out.println(red+"email already register"+reset);
                        break;
                    } else emailFlag = 1;
                }

            } else {
                System.out.println(red+"Incorrect email format"+reset);
            }
        } while (emailFlag != 1);
        hasPreviousList.add(Email);
        switchCase();
    }

    private void userPhoneNumber() {

        byte userPhoneNumberFlag;

        do {
            userPhoneNumberFlag = 0;
            try {
                System.out.print("Enter your PhoneNumber: ");
                PhoneNumber = scanner.nextLong();
            } catch (Exception e) {
                System.out.println(red+"Incorrect input"+reset);
                userPhoneNumberFlag = 1;
                scanner.nextLine();
            }

            if ((int) Math.log10(PhoneNumber) + 1 == 10) {
                for (Map.Entry<Integer, Register> phoneNumberCheck : map.entrySet()) {
                    if (PhoneNumber == phoneNumberCheck.getValue().getPhoneNumber()) {
                        System.out.println(red+"Phone number already register"+reset);
                        userPhoneNumberFlag = 0;
                        break;
                    } else userPhoneNumberFlag = 1;
                }
            } else {
                if (userPhoneNumberFlag != 1) System.out.println(red+"phone number out of range"+reset);
                userPhoneNumberFlag = 0;
            }
        } while (userPhoneNumberFlag != 1);
        hasPreviousList.add(PhoneNumber);
        switchCase();
    }

    public void OtPGenerate() {
        final int otpSize = 6;
        byte otpFlag;
        do {
            otpFlag = 0;
            Random random = new Random();
            randomNumber = random.nextInt((900000) + 100000);
            Register.loadingThread("Generating otp");
            System.out.println(green+"Generated Otp: "+reset + "\u001B[97m"+randomNumber+reset);
            int UserOtpEnter = 0;
            try {
                System.out.print("Enter Otp: ");
                UserOtpEnter = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(red+"Incorrect input"+reset);
                scanner.nextLine();
            }

            if (randomNumber == UserOtpEnter) {
                otpFlag = 1;
                Register.loadingThread("Processing");
            } else System.out.println(red+"Invalid OtP entered"+reset);
        } while (otpFlag != 1);
    }

    void userAccountNumber() {
        byte accountNumberFlag;
        do {
            accountNumberFlag = 0;
            try {
                System.out.print(reset+"Enter account number xxxx(12 digit): ");
                accountNumber = scanner.nextLong();
            } catch (Exception e) {
                System.out.println(red+"Incorrect input"+reset);
                accountNumberFlag = 1;
                scanner.nextLine();
            }

            if (((int) Math.log10(accountNumber)) + 1 == 12) {
                hasPreviousList.add(accountNumber);
                switchCase();
                for (Map.Entry<Integer, Register> accountNumberCheck : map.entrySet()) {
                    if (accountNumber == accountNumberCheck.getValue().getAccountNumber()) {
                        System.out.println(red+"account number already register"+reset);
                        accountNumberFlag = 0;
                        break;
                    } else {
                        do {
                            try {

                                System.out.print(reset+"Enter atm validate Year(/2002) : ");
                                atmValidateYear = scanner.nextInt();
                                if ((int) Math.log10(atmValidateYear) + 1 == 4){
                                    accountNumberFlag=1;
                                } else System.out.println(red+"year does not valid"+reset);
                            } catch (Exception e) {
                                System.out.println(red+"Incorrect input"+reset);
                                scanner.nextLine();
                            }
                        } while (accountNumberFlag!=1);
                        hasPreviousList.add(atmValidateYear);
                        switchCase();
                    }
                    break;
                }

            } else {
                if (accountNumberFlag != 1) {
                    System.out.println(red+"Incorrect account number"+reset);
                }
                accountNumberFlag = 0;
            }
        } while (accountNumberFlag != 1);
    }

    void PinSet() {

        byte pinFlag=0;
        byte usePinSize = 0;
        do {
            try {
                System.out.print("Enter pin size 4 or 6 ony: ");
                usePinSize = scanner.nextByte();
            } catch (Exception e) {
                System.out.println(red+"Incorrect input"+reset);
                pinFlag=1;
                scanner.nextLine();
            }
            if (usePinSize == 4 || usePinSize == 6 ) {
                pinFlag=1;
            } else{
                if(pinFlag!=1) System.out.println(red+"Incorrect pin size"+reset);
                pinFlag=0;
            }
        } while (pinFlag != 1);
        hasPreviousList.add(usePinSize);
        switchCase();
        do{
            pinFlag = 0;
            int userReEnterPin = 0;
            try {

                    System.out.print("Enter Pin: ");
                    userPin = Integer.parseInt(String.valueOf(scanner.nextInt()).substring(0, usePinSize));
                    System.out.print("Re-enter Pin: ");
                    userReEnterPin = Integer.parseInt(String.valueOf(scanner.nextInt()).substring(0, usePinSize));

                    if (userPin == userReEnterPin) {
                        Register.loadingThread("Processing");
                        System.out.println(green+" Successfully set Pin"+reset);
                        pinFlag = 1;
                    } else System.out.println(red+"try again!!!"+reset);


            } catch (Exception e) {
                System.out.println(red+"Incorrect input"+reset);
                scanner.nextLine();
            }

        } while (pinFlag != 1);
    }

    public boolean UserDetails() {
        id = (int) map.size();
        Register.loadingThread("Searching");
        if (!bankAccountProcess.BankAccountDetails()) {
            userPhoneNumber();
            OtPGenerate();
            userAccountNumber();
            PinSet();
            userEmail();
            userName();
            userPassword();
            System.out.print("Enter your Country: ");
            scanner.nextLine();
            Country = scanner.nextLine();
            hasPreviousList.add(Country);
            switchCase();
            String[] upi = getEmail().split("@");
            Upi = upi[0] +"@" + bankList.get(bankAccountProcess.selectBankNumber - 1);
            System.out.println(green+"Successfully Register!"+reset);
            map.put(id, new Register(getName(), getPassword(), getEmail(), getCountry(), getPhoneNumber(), getBalance(), getUpi(),
                    getAccountNumber(), getUserPin()));
//            System.out.println(map);
        } else return false;
        return true;
    }

    public static void loadingThread(String name) {
        for (int i = 0; i <= 100; i++) {
            if (i == 100) {
                System.out.print("\u001B[97m\r" + name + "...\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
            } else System.out.print("\u001B[97m\r" + name + "...\u001B[0m" + i);

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static void hasListPrevious(){
        System.out.println(hasPreviousList);
        byte value=2;
        ListIterator<Object> o = hasPreviousList.listIterator(hasPreviousList.size());
        boolean hari= o.hasPrevious();
        while (hari){
            if (value==1){
                System.out.println("\u001B[92mPrevious :"+o.next()+reset);
                o.previous();

            }
            if (value == 2) {
                System.out.println("\u001B[92mPrevious :"+o.previous()+reset);
            }

            System.out.println("1.next");

            if(o.hasPrevious()){
                System.out.println("2.Back");
            }

            value=scanner.nextByte();

            switch (value){
                case 1:
                    try{
                        o.next();
                    }catch (Exception ignore){

                    }
                    hari=o.hasNext();
                    break;
                case 2:
                    hari=o.hasPrevious();
                    break;
            }

        }


    }
    static void switchCase(){
        System.out.println("\n1.Back");
        System.out.println("2.No");
        byte value=0;
        try{
             value =scanner.nextByte();
        }catch (Exception e){
            System.out.println(red+"Incorrect input"+reset);
        }

        if (value == 1) {
            hasListPrevious();
        }
    }
    public String toString() {
        return Name + " " + " " + Password + " " + Email + " " + Country + " " + PhoneNumber + " " + Balance + " " + Upi + " " + accountNumber + " " + userPin;
    }


}
