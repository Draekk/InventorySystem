package Menu;
import Database.UserDB;

import java.util.Scanner;

public class Menu {

    public boolean showEntryMenu(){
        try{
            Scanner sc = new Scanner(System.in);
            String selection;
            System.out.println("What do you want to do?");
            System.out.println("1. Login\n2. Register\n3. Exit");
            selection = sc.nextLine();

            switch (Integer.parseInt(selection)){
                case 1:
                    return showLoginMenu();
                case 2:
                    System.out.println("Register Screen");
                    return true;
                case 3:
                    System.out.println("Exit");
                    return false;
                default:
                    System.out.println("Select a valid option");
                    return true;
            }
        } catch (Exception ex) {
            System.out.println("An error has occurred: " + ex.getMessage() + ex.getCause());
            return true;
        }
    }

    public boolean showLoginMenu(){
        try{
            Scanner sc = new Scanner(System.in);
            UserDB userDB = new UserDB();

            showTitle("Login", '-');
            System.out.println("Username:");
            String entryUsername = sc.nextLine();
            System.out.println("Password:");
            String entryPassword = sc.nextLine();

            UserDB userToLog = new UserDB(entryUsername, entryPassword, false);
            if(userDB.checkUser(userToLog)){
                System.out.println("Logged in");
                return true;
            }
            return false;
        } catch(Exception ex){
            System.out.println("An error has occurred: " + ex.getMessage() + "\n" + ex.getCause());
            return false;
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