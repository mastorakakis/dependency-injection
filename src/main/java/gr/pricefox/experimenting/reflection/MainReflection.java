package gr.pricefox.experimenting.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MainReflection {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        User user = User.class.getConstructor().newInstance();
        for (Field field : User.class.getDeclaredFields()) {
            if (field.getType() == Person.class) {
                field.setAccessible(true);
                field.set(user, Person.class.getConstructor().newInstance());
            }
        }
        System.out.println(user);

    }
}
