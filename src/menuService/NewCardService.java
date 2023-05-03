package menuService;

import account.Config;
import account.Registration;
import account.RequireScanner;
import menuPackage.MenuUtil;
import menuService.MainMenuService;

import java.util.InputMismatchException;

public class NewCardService implements MainMenuService {
    String pin1,pin2;
    @Override
    public void process() {

         pin1 = RequireScanner.requireTextString("enter pin");
         pin2 = RequireScanner.requireTextString("repeat pin");
        try {
            if (!(pin1.equals(pin2))) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.err.println("pin's are not right");
            MenuUtil menuUtil = new MenuUtil();
            menuUtil.menuProcess();
        }
        Registration registration = registrationAccount();
        Config.getInstance().addRegister(registration);
        Config.showAllUser();
    }

    private Registration registrationAccount() {

        Registration registration = new Registration();

        registration.setPin(pin1);

        registration.setName(RequireScanner.requireTextString("Enter name"));
        registration.setSurname(RequireScanner.requireTextString("Enter surname"));

        try {
            registration.setAge(RequireScanner.requireNumberInt("Enter age"));
        } catch (InputMismatchException e) {
            System.err.println("    WRONG AGE !!!");
            MenuUtil menuUtil = new MenuUtil();
            menuUtil.menuProcess();
        }

        try {
            registration.setBalance(RequireScanner.requireNumberDouble("Enter balance"));

        } catch (InputMismatchException e) {
            System.err.println("    WRONG  BALANCE  !!!  ");
            MenuUtil menuUtil = new MenuUtil();
            menuUtil.menuProcess();
        }
        registration.setCardNumber(registration.getName().length() + "" + registration.getSurname().length() + "" + registration.getName().length() + "" + registration.getSurname().length());

        return registration;

    }
}
