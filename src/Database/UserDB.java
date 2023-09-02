package Database;

import java.util.ArrayList;
import java.util.List;

public class UserDB {

    private int id = 0;
    private String username;
    private String password;

    private List<UserDB> userDBList;

    public boolean createNewUser(String username, String password){
        try {
            for (UserDB user : userDBList) {
                if (user.username == username) {
                    System.out.println("Username already exist. Try again.");
                    return false;
                }
            }
            userDBList.add( new UserDB(username, password) );
            return true;
        } catch (Exception ex) {
            System.out.println("An error has occurred: " + ex.getMessage());
            return false;
        }
    }

    public void showUsers(){
        for (UserDB u : userDBList) {
            System.out.println(u.toString());
        }
    }

    @Override
    public String toString() {
        return "Username: " + username + "\nPassword: " + password + "\n";
    }

    public UserDB(){
        userDBList = new ArrayList<UserDB>();
    }

    public UserDB(String username, String password) {
        id++;
        this.username = username;
        this.password = password;
    }
}