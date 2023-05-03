package menuPackage;

public enum ProductMenu {
    BREAD("bread", 1),
    MEAT("meat", 12),
    ONION("onion", 3),
    COFFEE("coffee", 5),
    SWEET("sweet", 7),
    APPLE("apple", 2),
    TV("TV", 120);
    private String label;
    private int cost;


    ProductMenu(String label, int cost) {
        this.label = label;
        this.cost = cost;
    }

    public String getLabel() {
        return label;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return label+" "+cost+"$";
    }


}
