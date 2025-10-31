import java.util.HashMap;
import java.util.Map;
public class BankDatabase{
    private final Map<String, User> u;

    public BankDatabase(){
        u=new HashMap<>();
        System.out.print("Initialized");
    }

    public void addUser(User user){
        u.put(user.getUserId(),user);
    }
    public boolean validateUser(String id,String pin){
        User user=u.get(id);
        return user!=null && user.getPin().equals(pin);
    }
    public User getUser(String id){
        return u.get(id);
    }
    public boolean userExists(String id){
        return u.containsKey(id);
    }

    public static void main(String[] ar){
        BankDatabase m=new BankDatabase();
        System.out.print("Database ready");
    }

}
