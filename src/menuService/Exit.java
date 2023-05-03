package menuService;

import account.Config;

public class Exit implements MainMenuService{
    @Override
    public void process(){
        System.exit(1);
    }

}
