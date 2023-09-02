package Menu;

import java.util.Scanner;

public class EntryMenu {

    public boolean showMenu(){
        try{
            Scanner sc = new Scanner(System.in);
            String selection;
            System.out.println("What do you want to do?");
            System.out.println("1. Login\n2. Register\n3. Exit");
            selection = sc.nextLine();

            switch (Integer.parseInt(selection)){
                case 1:
                    System.out.println("Login Screen");
                    return true;
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

}