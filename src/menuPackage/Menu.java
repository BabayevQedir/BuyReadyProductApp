package menuPackage;

import menuService.Exit;
import menuService.NewCardService;
import menuService.MainMenuService;
import menuService.BuyProduct;

public enum Menu {
    NEW_CARD(1, "New card", new NewCardService()),
    START_SPENDING(2, "Start spending", new BuyProduct()),
    EXIT(3, "Exit", new Exit()),
    UNKNOWN;

    Menu() {

    }

    private int id;
    private String label;
    private MainMenuService service;

    Menu(int id, String label, MainMenuService service) {
        this.id = id;
        this.label = label;
        this.service = service;
    }

    public void process() {
        service.process();
        MenuUtil menuUtil = new MenuUtil();
        menuUtil.menuProcess();
    }

    @Override
    public String toString() {
        return id + "." + label;
    }

    public int getId() {
        return id;
    }
}
