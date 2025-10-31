import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Transaction {
    private final String type;
    private final double amt;
    private final String timestamp;
    private final String details;

    public Transaction(String type,double amt,String details){
        this.type=type;
        this.amt=amt;
        this.details=details;
        this.timestamp=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
    @Override
    public String toString(){
        return String.format("%s | %-8s | $%.2f | %s",timestamp,type,amt,details);
    }

    static void main(String[] ar){
        Scanner s=new Scanner(System.in);
        System.out.print("Enter transaction type: ");
        String type=s.nextLine();
        System.out.print("Enter transaction amount: ");
        double amt=Double.parseDouble(s.nextLine());
        System.out.print("Enter transaction details: ");
        String details=s.nextLine();
        Transaction t=new Transaction(type,amt,details);
        System.out.println(t);

    }
}
