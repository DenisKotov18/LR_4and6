package lr_4and6.models.application;

import lr_4and6.controllers.AuthorizationController;


public class Notifier implements Observed {

    public void addObserver(User user){
        App.users.add(user);
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        (new AuthorizationController()).handleEvent();
        (new User()).handleEvent();
    }
}
