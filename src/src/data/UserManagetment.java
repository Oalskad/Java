package data;

import util.Utils;

/**
 *
 * @author hasu
 */
public class UserManagetment {

    private static final UserManagetment instance = new UserManagetment();
    
    private User currentUser;

    public static UserManagetment getInstance() {
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    private UserManagetment() {
        currentUser = login();
    }

    private User login() {
        System.out.println("Login ...");
        String name = Utils.inputString("user name");
        String pass = Utils.inputString("pass");
        User user = new User(name, pass);
        if (user.validate() == true) {
            return user;
        }
        return null;
    }

}
