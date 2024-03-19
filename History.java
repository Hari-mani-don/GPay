package GameDevelopment.Class;

import java.util.*;

public class History {
    static String green="\u001B[92m";
    static String reset="\u001B[0m";
    static String red="\u001B[91m";
    static String blue="\u001B[96m";
    private final Scanner scanner=new Scanner(System.in);
   private  String userUpi;
   private long userMobileNumber;
   private double userAmount;
    private  String ReceiverUpi;
    private  String ReceiverName;
    private  String Userpassword;
    private  int UserKey;
    private long ReceiverMobileNumber;
   public Stack<History> history=new Stack<>();
    private static HashMap<Integer,Register> map;
    History(String userUpi, long userMobileNumber, double userAmount, String receiverUpi, long receiverMobileNumber, String receiverName){
        this.userUpi=userUpi;
        this.userMobileNumber=userMobileNumber;
        this.userAmount=userAmount;
        this.ReceiverUpi=receiverUpi;
        this.ReceiverMobileNumber=receiverMobileNumber;
        this.ReceiverName=receiverName;
    }
    History(HashMap<Integer,Register> map){
        History.map=map;
        history.push(new History("pselvamani486@moneyPay",9361931850L,3000.0D,"mani@moneyPay",7826980179L,"hariMani"));
        history.push(new History("pselvamani486@moneyPay",9361931850L,3000.0D,"mani@moneyPay",7826980179L,"hariMani"));
        history.push(new History("pselvamani486@moneyPay",9361931850L,3000.0D,"mani@moneyPay",7826980179L,"hariMani"));
        history.push(new History("pselvamani486@",9361931850L,3000.0D,"mani@moneyPay",7826980179L,"hariMani"));
        history.push(new History("@moneyPay",9361931850L,3000.0D,"mani@moneyPay",7826980179L,"hariMani"));
    }
    public String getUserUpi() {
        return userUpi;
    }

    public void setUserUpi(String userUpi) {
        this.userUpi = userUpi;
    }

    public long getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(long userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public double getUserAmount() {
        return userAmount;
    }

    public void setUserAmount(double userAmount) {
        this.userAmount = userAmount;
    }

    public String getReceiverUpi() {
        return ReceiverUpi;
    }

    public void setReceiverUpi(String receiverUpi) {
        ReceiverUpi = receiverUpi;
    }

    public String getReceiverName() {
        return ReceiverName;
    }

    public void setReceiverName(String receiverName) {
        ReceiverName = receiverName;
    }

    public long getReceiverMobileNumber() {
        return ReceiverMobileNumber;
    }

    public void setReceiverMobileNumber(long receiverMobileNumber) {
        ReceiverMobileNumber = receiverMobileNumber;
    }



    public void UserTransactionHistory(int showHistory){
        int iterateCount=0;
        System.out.println(history);
        ListIterator<History> itr=history.listIterator(history.size());
        Register.loadingThread("Processing");
        while (itr.hasPrevious()){
            if(iterateCount >= Math.abs(history.size()-(Math.abs(showHistory-history.size())))){
                break;
            }
            History list= itr.previous();
            System.out.println(blue+"\n\n\tSender Details                       |                       Receiver Details"+reset);
            System.out.printf("\t\tuser upi: %-50s Receiver upi: %s\n",list.getUserUpi(),list.getReceiverUpi());
            System.out.printf("\t\tuser number: %-50s Receiver number: %s\n",list.getUserMobileNumber(),list.getReceiverMobileNumber());
            System.out.printf("\t\tTransaction amount: %-50s /`Receiver name: %s\n",list.getUserAmount(),list.getReceiverName());
            System.out.print(green+"\tSuccessfully Sent\n"+reset);
            iterateCount++;
        }
        Profile.exits();
        if (history.isEmpty()){
            System.out.println(red+"\nNo Transaction History"+reset);
        }
    }

    @Override
    public String toString() {
        return getUserUpi()+" "+getUserMobileNumber()+" "+getUserAmount()+" "+getReceiverUpi()
                +" "+getReceiverName()+" "+getReceiverMobileNumber();
    }
    public void userBalanceCheck(String Userpassword,int UserKey){
        this.Userpassword=Userpassword;
        this.UserKey=UserKey;
        byte passFlag=3;
        byte backButtonFlag=0;
        int existingPassword=0;
        while (true){
           try{
               System.out.print("\nEnter Pin :");
                existingPassword=scanner.nextInt();
           }catch (Exception e){
               System.out.println(red+"InputMismatchException"+reset);
               backButtonFlag=1;
               scanner.nextLine();
           }
            if(existingPassword==map.get(UserKey).getUserPin()){
                backButtonFlag=1;
                Register.loadingThread("Processing");
                System.out.println(green+"Balance : "+reset+"\u001B[97m₹ "+map.get(UserKey).getBalance()+reset);
            }else {
                if(backButtonFlag!=1){
                    passFlag--;
                    System.out.println(red+"Incorrect Pin try again!!!"+reset);
                }
                backButtonFlag=0;
            }
      if (passFlag<=0){
          System.out.println(red+"after 24 hours try again!!!"+reset);
          break;
      }
      if(backButtonFlag==1){
          Profile.exits();
          break;
      }

        }
    }
}
