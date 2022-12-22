package lr_4and6.models.application;

public class Autorization {
    public static User checkLogIn(String login, String password){
        User curr_user = null;
        for (User user : App.users) {
            if(user.getLogin().equals(login)){
                if(user.getPassword().equals(password)) curr_user = user;
            }
        }
        return curr_user;
    }

    public static boolean entry(String login, String password){
        User user = checkLogIn(login,password);
        if(user != null) {
            User.setOnline(user);
            return true;
        }
        return false;
    }
}
