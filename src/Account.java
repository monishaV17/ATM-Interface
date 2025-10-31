import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Account {
    private double balance;
    public List<Transaction> th;

    public Account(){
        this.balance=0.0;
        this.th=new ArrayList<>();
        System.out.println(" Account created! ");
    }

    public double getBalance(){
        return balance;
    }
    public List<Transaction> getTransactionHistory(){
        return th;
    }

    public boolean withdraw(double amt2){
        if(amt2>0 && amt2<=balance){
            balance-=amt2;
            addTransaction("WITHDRAW",amt2,"CASH");
            return true;
        }
        return false;
    }
    public void deposit(double amt){
        if(amt>0){
            balance+=amt;
            addTransaction("DEPOSIT",amt,"CASH");
        }
    }
    public void addTransaction(String type,double amt,String details){
        th.add(new Transaction(type,amt,details));
    }

    public static void main(String[] ar){
        Scanner s=new Scanner(System.in);
        Account acc=new Account();
        System.out.println("Enter Deposit Amount: ");
        double amt=s.nextDouble();
        acc.deposit(amt);
        System.out.println("Enter Withdraw amount: ");
        double amt2=s.nextDouble();
        boolean success=acc.withdraw(amt2);
        if(!success){
            System.out.println("Insufficient balance or invalid withdraw amount");
        }
        System.out.println("Final Account Balance: $ "+acc.getBalance());
    }
}
