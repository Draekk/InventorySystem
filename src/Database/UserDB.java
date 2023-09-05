package Database;

import java.util.*;
import  java.util.UUID;

public class UserDB {

    private UUID id;
    private String name;
    private String username;
    private String password;
    private boolean isChecked;

    public static ArrayList<UserDB> userDBList;

    /**
     * Funcion para crear un nuevo usuario y agregarlo a la lista.
     * @param name Nombre del usuario
     * @param username Nombre de usuario
     * @param password Contraseña
     * @return true si el proceso se completa correctamente
     */
    public boolean createNewUser(String name, String username, String password){
        try {
            if(!userDBList.isEmpty()){
                for (UserDB user : userDBList) {
                    if (user.username.equals(username)) {
                        System.out.println("Username already exist. Try again.");
                        return false;
                    }
                }
            }
            userDBList.add( new UserDB(name, username, password, true) );
            return true;
        } catch (Exception ex) {
            System.out.println("An error has occurred: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Funcion que valida los datos del usuario al hacer Login.
     * @param userToCheck Usuario a validar.
     * @return true si el proceso se completo correctamente.
     */
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

    /**
     * Funcion que muestra la lista de los usuarios
     */
    public void showUsers(){
        for (UserDB u : userDBList) {
            System.out.println(u.toString());
        }
    }

    @Override
    public String toString() {
        return "ID : " + id + "\nName: " + name + "\nUsername: " + username + "\nPassword: " + password + "\n";
    }

    public UserDB(){}

    public UserDB(String username, String password, boolean isChecked){
        if(isChecked) id = UUID.randomUUID(); else id = null;
        this.username = username;
        this.password = password;
    }

    public UserDB(String name, String username, String password, boolean isChecked) {
        if(isChecked) id = UUID.randomUUID(); else id = null;
        this.name = name;
        this.username = username;
        this.password = password;
    }
}