import org.junit.platform.commons.function.Try;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.platform.commons.util.ReflectionUtils.tryToLoadClass;

public class TestHelpers {
    public static Optional<Class<?>> getClass(String classToFind) {
        Try<Class<?>> aClass = tryToLoadClass(classToFind);
        return aClass.toOptional();
    }

    public static Optional<Field> getField(String className, String fieldName){
        final Optional<Class<?>> maybeClass = getClass(className);
        final Class<?> classDefinition = maybeClass.get();

        var field = Arrays.stream(classDefinition.getDeclaredFields())
                .filter(f -> f.getName().equals(fieldName))
                .findFirst();
        return field;
    }

    public static Optional<Method> getMethod(String className, String methodName){
        final Optional<Class<?>> maybeClass = getClass(className);
        final Class<?> classDefinition = maybeClass.get();

        var method = Arrays.stream(classDefinition.getMethods())
                .filter(f -> f.getName().equals(methodName))
                .findFirst();
        return method;
    }
}
