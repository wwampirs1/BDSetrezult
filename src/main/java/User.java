/**
 * Created by Dmytro on 16.06.2015.
 */
public class User {
    private int id;
    private String userName;
    private String password;

    @Override
    public String toString() {
        return "{ Id="+id+" userName="+userName+" password="+password+"}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public User() {
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }

    public User(int id, String userName, String password) {

        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}
