import java.util.*;
public class User {
    private final String id;
    private final String pin;
    private Account account;

    User(String id,String pin,Account acc){
        this.id=id;
        this.pin=pin;
        this.account=acc;
        System.out.println(" User " +id+" Created ");
    }

    public String getUserId(){
        return id;
    }
    public String getPin(){
        return pin;
    }
    public Account getAccount(){
        return account;
    }

    public static void main(String[] ar){
        Scanner s=new Scanner(System.in);
        System.out.println(" Enter UserId: ");
        String id=s.nextLine();
        System.out.println(" Enter Pin: ");
        String pin=s.nextLine();
        Account acc=new Account();
        User u=new User(id,pin,acc);
    }
}
