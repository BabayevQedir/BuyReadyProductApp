package menuPackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUtil {
    public void menuProcess() {
        Scanner sc = new Scanner(System.in);
        System.out.println("please select menu");
        showMenu();
        try {
            int selectedNumber = sc.nextInt();
            Menu menuFindProcess = findMenu(selectedNumber);
            menuFindProcess.process();
        }catch (InputMismatchException e){
            System.err.println("please select right menu id");
            menuProcess();
        }

    }

    Menu[] menus = Menu.values();

    public void showMenu() {
        for (Menu menu1 : menus) {
            if (menu1 != Menu.UNKNOWN) {
                System.out.println(menu1);
            }
        }

    }

    public Menu findMenu(int inputNumber) {
        for (Menu menu : menus) {
            if (inputNumber == menu.getId()) {
                return menu;
            }
        }
        return Menu.UNKNOWN;
    }
}
