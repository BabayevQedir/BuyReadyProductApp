package menuService;

import account.Config;
import account.Registration;
import account.RequireScanner;
import menuPackage.MenuUtil;
import menuPackage.ProductMenu;

import java.util.InputMismatchException;
import java.util.List;

public class BuyProduct implements MainMenuService {
    @Override
    public void process() {
        Registration user = findUser(RequireScanner.requireTextString("please enter your pin"));
        if (user != null) {
            showMenu();
            int enterNum = buyMenuId();
            if (enterNum == 1) {
                String productName = productName();
                ProductMenu productMenu = findMenu(productName);
                try {
                    int count = RequireScanner.requireNumberInt("how much do you want? ");
                    double buyingCost = count * productMenu.getCost();
                    try {
                        if (user.getBalance() < buyingCost)
                            throw new Exception();
                    } catch (Exception e) {
                        System.err.println("your balance is not enough");
                        MenuUtil menuUtil = new MenuUtil();
                        menuUtil.menuProcess();
                    }
                    user.setBalance(user.getBalance() - buyingCost);
                    System.out.println("your card balance=" + user.getBalance() + "$");
                    Config.getInstance().addProduct(productName, count);
                } catch (InputMismatchException e) {
                    System.err.println("please enter number");
                }
            } else if (enterNum == 2) {
                System.out.println("buying product list");
                Config.getInstance().showBuyingProduct();
            } else {
                System.exit(12);
            }
        }
    }

    ProductMenu[] productMenus = ProductMenu.values();

    public void showMenu() {
        for (ProductMenu productMenu : productMenus) {
                System.out.println(productMenu);
        }
    }

    public ProductMenu findMenu(String name) {
        for (int i = 0; i < productMenus.length; i++) {
            if (productMenus[i].getLabel().equals(name)) {
                return productMenus[i];
            }
        }

        return null;
    }

    public Registration findUser(String pin) {
        List<Registration> registrationList = Config.getInstance().getRegistrationList();
        for (int i = 0; i < registrationList.size(); i++) {
            if (registrationList.get(i).getPin().equals(pin)) {
                return registrationList.get(i);
            }
        }
        return null;
    }

    public int buyMenuId() {
        int i = 0;
        try {
            i = RequireScanner.requireNumberInt("1.buy product\n" +
                    "2.Show buying product\n" +
                    "3.exit");
        } catch (InputMismatchException e) {
            System.err.println("please enter number");
            MenuUtil menuUtil = new MenuUtil();
            menuUtil.showMenu();
        }
        return i;
    }

    public String productName() {
        String s = RequireScanner.requireTextString("Start spending" +
                "\nEnter product name ");
        try {
            if (findMenu(s) == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.err.println("There is not product name");
            MenuUtil menuUtil = new MenuUtil();
            menuUtil.menuProcess();
        }
        return s;
    }
}
