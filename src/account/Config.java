package account;

import menuPackage.ProductMenu;
import menuService.BuyProduct;

import java.util.*;

public class Config {
    private static Config config;
   private Set<Registration> registrationList=new HashSet<>;
   private Map<String,Double> mapList=new HashMap<>();
   public static Config getInstance(){
       if (config==null){
           config=new Config();
       }
       return config;
   }
   public void addRegister(Registration registration){
       registrationList.add(registration);
   }

    public List<Registration> getRegistrationList() {
        return registrationList;
    }
    public static void showAllUser(){
        for (Registration registration: config.registrationList){
            System.out.println(registration);
        }
    }

    public Map<String, Double> getMapList() {
        return mapList;
    }

    public void addProduct(String name, double count){
        BuyProduct buyProduct=new BuyProduct();
        ProductMenu productMenu=buyProduct.findMenu(name);
        String buyingList=productMenu.getLabel();
        double buyingCost=productMenu.getCost()*count;
        System.out.println(productMenu);
        mapList.put(buyingList, buyingCost);
    }
    public  void showBuyingProduct(){
      for (Map.Entry m:mapList.entrySet()){
          System.out.println("Product name-"+m.getKey()+"  Product cost-"+m.getValue());
       }
    }

}
