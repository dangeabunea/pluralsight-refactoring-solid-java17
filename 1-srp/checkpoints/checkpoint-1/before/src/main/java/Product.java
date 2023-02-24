import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private double price;
    private ProductCategory category;

    public Product(String name, double price, ProductCategory category) {
        id = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountPrice() {
        // General discount
        if (price > 1000) {
            return price * 0.9;
        }

        // Christmas discount
        if (LocalDate.now().getMonth() == Month.DECEMBER &&
                LocalDate.now().getDayOfMonth() == 24) {
            return price * 0.8;
        }

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }
}
