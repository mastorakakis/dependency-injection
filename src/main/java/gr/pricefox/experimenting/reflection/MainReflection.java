package gr.pricefox.experimenting.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MainReflection {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        User panos = new User(123, new Person("Eleni", 65), new Person("Giorgos", 75));
        User popi = new User(321, new Person("Soula", 60), new Person("Giannis", 65));

        Class<?> clazz = panos.getClass();
        Field[] fields = User.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getType() == Person.class) {
                field.set(panos, new Person("Tasos", 23));
            }
        }


        System.out.println(panos.getFather().getName());
    }
}
