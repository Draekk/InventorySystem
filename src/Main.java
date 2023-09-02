import Database.UserDB;
import Menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserDB userDB = new UserDB();
        Menu menu = new Menu();
        boolean activeLoop = true;

        UserDB.userDBList = new ArrayList<>();
        userDB.createNewUser("Drakkseid", "THEHELl9000.");

        //Bucle para iterar el menu inicial
        while (activeLoop){
            Menu.showTitle("Inventory system management", '=');
            activeLoop = menu.showEntryMenu();
        }
    }


}