import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ProductTests {
    @Test
    public void getPriceShouldReturnPriceWhenItIsLessThan1000(){
        var product = new Product("Lego Farm", 169.00, ProductCategory.Toys);

        var result = product.getPrice();

        assertEquals(169.00, result, 0.01);
    }

    @Test
    public void getPriceShouldReturnPriceWhenItIsGreaterThan1000(){
        var product = new Product("Laptop", 1100, ProductCategory.Electronics);

        var result = product.getPrice();

        assertEquals(1100, result, 0.01);
    }

    @Test
    public void getDiscountPriceShouldReturnPriceWhenItIsGreaterThan1000() throws InvocationTargetException, IllegalAccessException {
        var product = new Product("Laptop", 1100, ProductCategory.Electronics);

        var methodToInvoke = TestHelpers.getMethod("Product", "getDiscountPrice");
        if(methodToInvoke.isPresent()){
            double result = (double) methodToInvoke.get().invoke(product);
            assertEquals(990, result, 0.01);
        } else{
            fail("Method getDiscountPrice does not exist or is not correct");
        }
    }

    @Test
    public void getDiscountPriceShouldReturnNormalPriceWhenItIsLessThan1000() throws InvocationTargetException, IllegalAccessException {
        var product = new Product("Laptop", 900, ProductCategory.Electronics);

        var methodToInvoke = TestHelpers.getMethod("Product", "getDiscountPrice");
        if(methodToInvoke.isPresent()){
            double result = (double) methodToInvoke.get().invoke(product);
            assertEquals(900, result, 0.01);
        } else{
            fail("Method getDiscountPrice does not exist or is not correct");
        }
    }
}
