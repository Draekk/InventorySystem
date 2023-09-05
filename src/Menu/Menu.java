package Menu;
import Operators.Operators;
import Database.ProductDB;
import Database.UserDB;
import java.util.Scanner;

public class Menu extends Operators {


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

            showTitle("Register Product", '-');
            System.out.println("Please, complete the fields.");

            System.out.println("Barcode:");
            String entryBarCode = sc.nextLine();

            System.out.println("Name:");
            String entryName = sc.nextLine();

            System.out.println("Quantity:");
            int entryQuantity;
            entryQuantity = toInt(sc.nextLine());

            System.out.println("Cost price:");
            float entryCostPrice = toFloat(sc.nextLine());

            if(okCancelQuestion("Create product?", "yes", "no")) return (pdb.createProduct(
                                                            new ProductDB(
                                                                    entryBarCode,
                                                                    entryName,
                                                                    entryQuantity,
                                                                    entryCostPrice
                                                            )));
            else return false;
        } catch(Exception ex){
            System.out.println("An error has occurred: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Funcion que muestra el proceso de busqueda de producto.
     * @return true si el proceso se completo correctamente.
     */
    public boolean showProductSearchInterface(){
        try{
            Scanner sc = new Scanner(System.in);
            ProductDB pdb = new ProductDB();

            showTitle("Search Product", '-');
            System.out.println("Barcode:");
            String entryBarCode = sc.nextLine();
            ProductDB product = pdb.searchProduct(entryBarCode);
            if(product != null){
                System.out.println(product);
                return true;
            }
            return false;
        } catch(Exception ex){
            System.out.println("An error has occurred: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Funcion que muestra la lista de productos
     */
    public void showInventory(){
        try{
            Scanner sc = new Scanner(System.in);
            ProductDB pdb = new ProductDB();
            showTitle("Inventory", '-');
            pdb.showProducts();
        } catch(Exception ex){
            System.out.println("An error has occurred: " + ex.getMessage());
        }
    }

    public boolean showEditProductInterface(){
        try{
            Scanner sc = new Scanner(System.in);
            ProductDB pdb = new ProductDB();

            showTitle("Edit Product", '-');
            System.out.println("Barcode:");
            String entryBarCode = sc.nextLine();

            ProductDB product = pdb.searchProduct(entryBarCode);
            if(product != null){
                showTitle("Product details", '-');
                while (true){
                    System.out.printf("1. Name: %s\n2. Quantity %d\n3. Cost price: %.2f\n4. Sell price: %.2f\n5. Return",
                            product.getName(),
                            product.getQuantity(),
                            product.getCostPrice(),
                            product.getSellPrice()
                    );
                    System.out.println("\nSelect an option to modify:");
                    int selection = toInt(sc.nextLine());

                    switch (selection){
                        case 1:
                            System.out.println("Old name: " + product.getName());
                            System.out.println("New name:");
                            String entryName = sc.nextLine();
                            product.setName(entryName);
                            System.out.println("The product has been modified");
                            if(!okCancelQuestion("Keep modifying the product?", "yes", "no"))
                                return true;
                            else break;

                        case 2:
                            System.out.println("Old quantity: " + product.getQuantity());
                            System.out.println("New quantity:");
                            String entryQuantity = sc.nextLine();
                            product.setQuantity(toInt(entryQuantity));
                            System.out.println("The product has been modified");
                            if(!okCancelQuestion("Keep modifying the product?", "yes", "no"))
                                return true;
                            else break;

                        case 3:
                            System.out.println("Old cost price: " + product.getCostPrice());
                            System.out.println("New cost price:");
                            String entryCostPrice = sc.nextLine();
                            product.setCostPrice(toFloat(entryCostPrice));
                            product.setSellPrice(toFloat(entryCostPrice) + toFloat(entryCostPrice) * 0.3f);
                            System.out.println("The product has been modified");
                            if(!okCancelQuestion("Keep modifying the product?", "yes", "no"))
                                return true;
                            else break;

                        case 4:
                            System.out.println("Old sell price: " + product.getSellPrice());
                            System.out.println("New sell price:");
                            String entrySellPrice = sc.nextLine();
                            product.setSellPrice(toFloat(entrySellPrice));
                            System.out.println("The product has been modified");
                            if(!okCancelQuestion("Keep modifying the product?", "yes", "no"))
                                return true;
                            else break;

                        case 5:
                            return true;
                    }
                }

            }
            return true;
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

            switch (toInt(selection)){
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
            showTitle("Main menu", '*');
            System.out.println("What do you want to do?");
            System.out.println("1. Product Register\n2. Search Product\n3. Edit Product\n4. Delete Product\n5. Show Inventory\n6. Return");
            selection = sc.nextLine();

            switch (toInt(selection)){
                case 1:
                    while (true){
                        showProductRegisterInterface();
                        if(!okCancelQuestion("Do you want to register another product?", "yes", "no")) break;
                    }
                    return true;
                case 2:
                    while (true){
                        showProductSearchInterface();
                        if(!okCancelQuestion("Do you want to search another product?", "yes", "no")) break;
                    }
                    return true;
                case 3:
                    while (true){
                        showEditProductInterface();
                        break;
                    }
                    return true;
                case 4:

                    return true;
                case 5:
                    while (true){
                        showInventory();
                        if(okCancelQuestion("Do you want to go back?", "ok", "cancel")) break;
                    }
                    return true;
                case 6:
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
     * Funcion que genera preguntas positiva/negativa
     * @param question Pegunta a generar
     * @param positiveResponse respuesta positiva (example: yes, ok, true)
     * @param negativeResponse respuesta negativa (example: no, cancel, false)
     * @return true para respuesta positiva y false para respuesta negativa
     */
    public static boolean okCancelQuestion(String question, String positiveResponse, String negativeResponse){
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println(question + " " + positiveResponse + "/" + negativeResponse);
            String response = sc.nextLine();

            if(response.equals(positiveResponse))
                return true;
            else if (response.equals(negativeResponse))
                return false;
        }
    }

}