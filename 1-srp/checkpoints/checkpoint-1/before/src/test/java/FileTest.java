

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.platform.commons.util.ReflectionUtils.tryToLoadClass;

public class FileTest {
    public static Optional<Class<?>> getClass(String classToFind) {
        Try<Class<?>> aClass = tryToLoadClass(classToFind);
        return aClass.toOptional();
    }

    /*
    @Test
    public void printMethod() {
        // Could be simplified by removing the optional and creating a `getMethodName` method.
        final Optional<Class<?>> maybeInventory = getClass("Inventory");
        final Class<?> inventoryClass = maybeInventory.get();

        final Optional<Class<?>> maybeSRP = getClass("SRP");
        final Class<?> SRPClass = maybeSRP.get();

        final List<Method> printMethodInventory = Arrays.stream(inventoryClass.getDeclaredMethods())
                .filter(method -> method.getName().equals("printInventory"))
                .collect(Collectors.toList());

        final List<Method> printMethodSRP = Arrays.stream(SRPClass.getDeclaredMethods())
                .filter(method -> method.getName().equals("printInventory"))
                .collect(Collectors.toList());

        assertEquals(0, printMethodInventory.size());
        assertEquals(1, printMethodSRP.size());
    }
    */

    @Test
    public void UnitConversionClassConstantsExists(){
        var unitConversionClass = getClass("UnitConversionConstants");
        assertTrue(unitConversionClass.isPresent());
    }

    @Test
    public void PasswordConstantsClassExists(){
        var passwordConstants = getClass("PasswordConstants");
        assertTrue(passwordConstants.isPresent());
    }

    @Test
    public void ConstantsClassWasRemovedExists(){
        var passwordConstants = getClass("Constants");
        assertFalse(passwordConstants.isPresent());
    }
}
