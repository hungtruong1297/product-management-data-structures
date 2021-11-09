public class Product {
    private String code;
    private String name;
    private int quantity;
    private double price;
    private final int defaultQuantity = 20;
    private final double defaultPrice = 50;

    public Product(String code, String name, int quantity, double price) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(String code, String name) {
        this.code = code;
        this.name = name;
        this.quantity = defaultQuantity;
        this.price = defaultPrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static Product create(String code, String name, int quantity, double price) {
        return new Product(code,name,quantity,price);
    }

    @Override


    public String toString() {
        return String.format("%s,%s,%d,%.2f",code,name,quantity,price);
    }
    //    public String toString() {
    //        return "Product{" +
    //                "code='" + code + '\'' +
    //                ", name='" + name + '\'' +
    //                ", quantity=" + quantity +
    //                ", price=" + price +
    //                '}';
    //    }
}
