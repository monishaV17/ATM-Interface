import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        BankDatabase db=new BankDatabase();
        Account acc1=new Account();
        Account acc2=new Account();
        User user1=new User("user1", "1234", acc1);
        User user2=new User("user2","5678",acc2);
        db.addUser(user1);
        db.addUser(user2);

        System.out.println("------- Welcome to Console ATM -------");
        System.out.print("Enter User ID: ");
        String userId=s.nextLine();
        System.out.print("Enter PIN: ");
        String pin=s.nextLine();

        if(db.validateUser(userId,pin)){
            User currentUser=db.getUser(userId);
            Account account=currentUser.getAccount();

            while(true) {
                System.out.println("\nATM Menu:");
                System.out.println("1. View Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Select option: ");
                int choice=s.nextInt();
                s.nextLine();

                switch(choice) {
                    case 1:
                        System.out.println("Transaction History:");
                        for(Transaction t:account.getTransactionHistory()){
                            System.out.println(t);
                        }
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount=s.nextDouble();
                        s.nextLine();
                        if(account.withdraw(withdrawAmount)){
                            System.out.println("Withdraw Successful.");
                        } else{
                            System.out.println("Withdraw Failed: Insufficient balance.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount=s.nextDouble();
                        s.nextLine();
                        account.deposit(depositAmount);
                        System.out.println("Deposit Successful.");
                        break;
                    case 4:
                        System.out.print("Enter target User ID for transfer: ");
                        String targetId=s.nextLine();
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount=s.nextDouble();
                        s.nextLine();
                        if(db.userExists(targetId) && account.getBalance() >= transferAmount){
                            account.withdraw(transferAmount);
                            db.getUser(targetId).getAccount().deposit(transferAmount);
                            account.addTransaction("TRANSFER",transferAmount, "To "+targetId);
                            db.getUser(targetId).getAccount().addTransaction("TRANSFER",transferAmount, "From "+userId);
                            System.out.println("Transfer Successful.");
                        }
                        else{
                            System.out.println("Transfer Failed: Invalid user or insufficient balance.");
                        }
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        s.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } else{
            System.out.println("Invalid User ID or PIN.");
        }
    }
}

