package Database;

import java.util.*;

public class UserDB {

    private int id = 0;
    private String username;
    private String password;
    private boolean isChecked;

    public static ArrayList<UserDB> userDBList;

    public boolean createNewUser(String username, String password){
        try {
            if(!userDBList.isEmpty()){
                for (UserDB user : userDBList) {
                    if (user.username.equals(username)) {
                        System.out.println("Username already exist. Try again.");
                        return false;
                    }
                }
            }
            userDBList.add( new UserDB(username, password, true) );
            return true;
        } catch (Exception ex) {
            System.out.println("An error has occurred: " + ex.getMessage());
            return false;
        }
    }

    public boolean checkUser(UserDB userToCheck){
        boolean checked = false;
        if(!userDBList.isEmpty()){
            for (UserDB user : userDBList) {
                if(user.username.equals(userToCheck.username)){
                    checked = true;
                    break;
                }
            }
        }

        if(checked) {
            for (UserDB user : userDBList) {
                if(user.password.equals(userToCheck.password)){
                    return checked;
                }
            }
            System.out.println("Wrong password");
        } else {
            System.out.println("Username doesn't exist");
        }
        return false;
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

    public UserDB(){}

    public UserDB(String username, String password, boolean isChecked) {
        this.id = (isChecked) ? +1 : 0;
        this.username = username;
        this.password = password;
    }
}