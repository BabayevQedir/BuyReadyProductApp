package main;

import menuPackage.Menu;
import menuPackage.MenuUtil;

public class Main {
    public static void main(String[] args) {
        MenuUtil menuUtil=new MenuUtil();
        menuUtil.menuProcess();
//        App run olduqda bizə 2 seçim verəcək
//1. New cart  2. Start spending 3. exit
//1 seçildikdə məndən pin daxil etməyimi istəsin və daha sonra təkrar pin daxil et desin.
//pinlər fərgli olarsa xəta atsın (pinlər eynilik təşkil etmir)
//əks halda name, surname, age, balance məlumatlarını userdən istəsin. cart nömrəsi
// - random 4 rəgəm generate edirik və bunu name və surname in uzunlugu ilə birləşdiririk.
//
//2 seçilərsə stabil məhsullar (name, price) ibarət məshulları userə göstəririk.
//1. məshsulu al, User seçim edir məhsul adını daxil edir, miqdarin daxil edir və ödəniş.
// əgər balance ok-sə məhsulu alırıq əks halda uyğun mesaj ilə xəta atır.
//2. aldiğim məöhsulları göstər
//3.exit
       }
}
