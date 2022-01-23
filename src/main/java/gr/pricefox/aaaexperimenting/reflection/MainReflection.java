package gr.pricefox.aaaexperimenting.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

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

        User user1 = new User();
        System.out.println(Arrays.asList(user.getClass().getInterfaces()).get(0));
        List<Class<?>> classList = Arrays.asList(user.getClass().getInterfaces());
    }
}
