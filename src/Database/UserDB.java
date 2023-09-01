package Database;

import java.util.ArrayList;
import java.util.List;

public class UserDB {

    private int id = 0;
    private String username;
    private String password;

    private List<UserDB> userDBList;

    public void createNewUser(String username, String password){




        userDBList.add( new UserDB(username, password) );
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