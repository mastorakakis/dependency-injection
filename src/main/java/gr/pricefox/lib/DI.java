package gr.pricefox.lib;

import java.lang.reflect.InvocationTargetException;

public class DI {

    private static final DI instance = new DI();

    private DI() {}

    public static DI getInstance() {
        return instance;
    }

    public <T> T singletonOf(Class<T> theClass)  {
        T t = null;
        try {
            t =  theClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return t;
    }

}
