import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitConverterTest {
    @Test
    public void ShouldConvertNmToMeters(){
        var valueInMeters = 1;

        var unitConverter = new UnitConverter();
        var result = unitConverter.convertFromMetersToNm(valueInMeters);

        assertEquals(1852, result);
    }


    @Test
    public void ShouldCovertFromGallonsToLiters(){
        var valueInGallons = 1;

        var unitConverter = new UnitConverter();
        var result = unitConverter.convertFromGallonsToLiters(valueInGallons);

        assertEquals(4.54, result, 0.001);
    }
}
