public class Product implements Comparable<Product>{
public int compareTo(Product o) {
        return this.getProductID().compareTo(o.getProductID());
    }
}
