public class Menu {

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
    System.out.println();
    System.out.println(borderTitle);
    System.out.println("|" + spaces + title + spaces + "|");
    System.out.println(borderTitle);
    System.out.println();
    }
    public static class Login {

    public void showLogin(){
        Menu.showTitle("Login", '*');
        System.out.println("Please insert your Username:");
    }



    }
}
