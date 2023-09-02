import Database.UserDB;
import Menu.EntryMenu;

public class Main {
    public static void main(String[] args) {

        UserDB userDB = new UserDB();
        EntryMenu entryMenu = new EntryMenu();
        boolean activeLoop = true;

        //Bucle para iterar el menu inicial
        while (activeLoop){
            showTitle("Inventory system management", '=');
            activeLoop = entryMenu.showMenu();
        }
    }

    /**
     * Funcion para generar un titulo y decorarlo
     * @param title Titulo a mostrar.
     * @param border Caracter que evuelve al titulo.
     */
    public static void showTitle(String title, char border){
        int titleLength = Math.round(Math.round(title.length() * 1.5));
        String borderTitle = "";
        int align = ((titleLength - title.length()) / 2);
        String spaces = "";

        for(int i = 0; i <= titleLength; i++){
            borderTitle += border;
            if(i == titleLength){
                for (int j = 0; j < align; j++) {
                    spaces += " ";
                }
            }
        }
        System.out.println("\n" + borderTitle);
        System.out.println("|" + spaces + title + spaces + "|");
        System.out.println(borderTitle + "\n");
    }
}