package Menu;
import Operators.Operators;
import Database.ProductDB;
import Database.UserDB;
import java.util.Scanner;

public class Menu {


    //Login / Register

    /**
     * Funcion que muestra el proceso de Login
     * @return true si el proceso se completo correctamente.
     */
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
     * Funcion que muestra el proceso de creacion de usuario
     * @return true para salir del ciclo
     */
    public boolean showRegisterMenu(){
        try{
            UserDB userDB = new UserDB();
            Scanner sc = new Scanner(System.in);

            showTitle("Register", '-');
            System.out.println("Please, complete the fields.");
            System.out.println("Name:");
            String entryName = sc.nextLine();
            System.out.println("Username:");
            String entryUsername = sc.nextLine();
            System.out.println("Password:");
            String entryPassword = sc.nextLine();

            if(userDB.createNewUser(entryName, entryUsername, entryPassword)){
                System.out.println("User created successfully");
                return true;
            }
            return false;
        } catch (Exception ex){
            System.out.println("An error has occurred: " + ex.getMessage());
            return false;
        }
    }

    //Products

    /**
     * Funcion que muestra el proceso de crear productos
     * @return true si el proceso se completo correctamente.
     */
    public boolean showProductRegisterInterface(){
        try{
            ProductDB pdb = new ProductDB();
            Scanner sc = new Scanner(System.in);
            Operators op = new Operators();

            showTitle("Register Product", '-');
            System.out.println("Please, complete the fields.");

            System.out.println("Barcode:");
            String entryBarCode = sc.nextLine();

            System.out.println("Name:");
            String entryName = sc.nextLine();

            System.out.println("Quantity:");
            int entryQuantity;
            entryQuantity = op.toInt(sc.nextLine());

            System.out.println("Cost price:");
            float entryCostPrice = op.toFloat(sc.nextLine());

            return (pdb.createProduct(
                    new ProductDB(
                            entryBarCode,
                            entryName,
                            entryQuantity,
                            entryCostPrice
                    )
            ));
        } catch(Exception ex){
            System.out.println("An error has occurred: " + ex.getMessage());
            return false;
        }
    }

    //Menus

    /**
     * Funcion que muestra el menu inicial
     * @return true para romper ciclo del menu
     */
    public boolean showEntryMenu(){
        try{
            Scanner sc = new Scanner(System.in);
            String selection;
            boolean activeLoop = true;
            System.out.println("What do you want to do?");
            System.out.println("1. Login\n2. Register\n3. Exit");
            selection = sc.nextLine();

            switch (Integer.parseInt(selection)){
                case 1:
                    if(showLoginMenu()){
                        while (activeLoop) activeLoop = showMainMenu();
                    }
                    return true;
                case 2:
                    return showRegisterMenu();
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

    /**
     * Funcion que muestra el menu principal.
     * @return true para finalizar el ciclo
     */
    public boolean showMainMenu(){
        try{
            Scanner sc = new Scanner(System.in);
            String selection;
            System.out.println("What do you want to do?");
            System.out.println("1. Product Register\n2. Search Product\n3. Show Inventory\n4. Return");
            selection = sc.nextLine();

            switch (Integer.parseInt(selection)){
                case 1:
                    while (true){
                        if(showProductRegisterInterface() && !yesNoQuestion("Do you want to register another product? yes/no")) break;
                    }
                case 2:

                    return true;

                case 3:

                    return true;
                case 4:
                    return false;
                default:
                    System.out.println("Select a valid option.");
                    return false;
            }
        } catch (Exception ex){
            System.out.println("An error has occurred: " + ex.getMessage());
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

    /**
     * Funcion para generar preguntas de YES o NO
     * @param question pregunta a generar
     * @return true si es YES o false si es NO
     */
    public static boolean yesNoQuestion(String question){
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println(question);
            String response = sc.nextLine();

            switch(response) {
                case "yes":
                    return true;
                case "no":
                    return false;
                default:
                    break;
            }
        }
    }

}