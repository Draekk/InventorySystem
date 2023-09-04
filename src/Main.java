import Database.ProductDB;
import Database.UserDB;
import Menu.Menu;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        UserDB userDB = new UserDB();
        ProductDB pdb = new ProductDB();
        Menu menu = new Menu();
        boolean activeLoop = true;

        //Creando usuario admin
        UserDB.userDBList = new ArrayList<>();
        userDB.createNewUser("Gever", "Admin", "1234");

        //Inicializando lista de productos
        ProductDB.products = new ArrayList<>();

        //Bucle para iterar el menu inicial
        while (activeLoop){
            Menu.showTitle("Inventory system management", '=');
            activeLoop = menu.showEntryMenu();
        }
        userDB.showUsers();
        pdb.showProducts();
    }


}