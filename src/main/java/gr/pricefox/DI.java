package gr.pricefox;

import gr.pricefox.annotation.Component;
import gr.pricefox.annotation.Scope;

import java.lang.reflect.Field;
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
        T t = oneOf(theClass);
        classMap.put(theClass, t);
        return t;
    }

    public <T> T oneOf(Class<T> theClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return theClass.getConstructor().newInstance();
    }

    public <T> T instanceOf(Class<T> theClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, CustomAnnotationException {
        if (theClass.isAnnotationPresent(Component.class)) {
            Component annotation = theClass.getAnnotation(Component.class);
            if (classMap.containsKey(theClass)) {
                return (T) classMap.get(theClass);
            }
            T t = oneOf(theClass);
            if (annotation.scope() == Scope.SINGLETON) {
                classMap.put(theClass, t);
            }
            for (Field field: theClass.getDeclaredFields()) {
                if (field.getType().isAnnotationPresent(Component.class)) {
                    field.setAccessible(true);
                    field.set(t, instanceOf(field.getType()));
                }
            }
            return t;
        }
        throw new CustomAnnotationException(theClass.getName() + " is not annotated");
    }
}









