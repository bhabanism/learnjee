import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;


public class UserDataUtil {
    public static List<User> getAllUsers() throws Exception {
        List<User> userlist = new ArrayList<User>();
        List<String> list = DataAccess.getData();
        StringTokenizer tokens;
        User user;
        for(String line : list) {
            tokens = new StringTokenizer(line);
            user = new User(tokens.nextToken(), tokens.nextToken());
            user.setBalance(Long.parseLong(tokens.nextToken()));
            userlist.add(user);
        }
        return userlist;
    }

    public static void updateAllUsers(List<String> list) throws Exception {
        DataAccess.updateData(list);
    }

    public static void main(String[] args) {
        try {
            List<User> list = getAllUsers();
            for(User user : list) {
                System.out.println(user.toString());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
