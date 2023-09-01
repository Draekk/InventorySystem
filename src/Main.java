import Database.UserDB;

public class Main {
    public static void main(String[] args) {

        UserDB userDB = new UserDB();
        userDB.createNewUser("Drakkseid", "THEHELl9000");
        userDB.createNewUser("Aluranyx", "130613");
        userDB.showUsers();
    }
}