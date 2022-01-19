package gr.pricefox.lib;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class DI {

    private static final DI instance = new DI();

    private DI() {
    }

    public static DI getInstance() {
        return instance;
    }

    private final Map<Class<?>, Object> classMap = new HashMap<>();

    public <T> T singletonOf(Class<T> theClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (classMap.containsKey(theClass)) {
            return (T) classMap.get(theClass);
        }
        T t = theClass.getConstructor().newInstance();
        classMap.put(theClass, t);
        return t;
    }

    public <T> T oneOf(Class<T> theClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return theClass.getConstructor().newInstance();
    }
}
