package data;

/**
 *
 * @author hasu
 */
public class User {

    public static final int ROLE_ADMIN = 0;
    public static final int ROLE_DOCTOR = 1;
    public static final int ROLE_USER = 2;

    private String id;      // user 1
    private String pass;    // xx           ==> user 1,xx,0
    private int role;       // ROLE_ADMIN

    public User() {
    }

    public User(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }

    public boolean validate() {
        // user1,xx,0
        // user2,xx,2
//        if (check id, pass == true) { // check user nam, pass then set role
//            this.role = ???? ROLE_ADMIN | ROLE_USER
//        }
        // hard code
        return true;
    }

    public boolean checkRole(int role) {
        return this.role <= role;
    }

}
