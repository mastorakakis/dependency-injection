package gr.pricefox.experimenting.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MainReflection {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        User user = new User();

        Field[] fields = user.getClass().getDeclaredFields();
        Arrays.stream(fields).forEach(field -> System.out.println(field.getName()));

        Class<?> clazz = user.getClass();
        System.out.println(clazz);
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());

        try {
            Class<?> cl = Class.forName("gr.pricefox.experimenting.reflection.User");
            System.out.println(cl.getSimpleName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(clazz.getPackageName());

        System.out.println(clazz.getSuperclass().getSimpleName());

        Class<?>[] interfaces = clazz.getInterfaces();
        System.out.println(Arrays.asList(interfaces));

        System.out.println(clazz.getConstructors().length);

        try {
            User u = (User) clazz.getConstructor(String.class, int.class).newInstance("Panos", 39);
            System.out.println(u.getName());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        Class<?> c = Class.forName("gr.pricefox.experimenting.reflection.User");
        Field[] fs = c.getFields();
        Field[] fs2 = c.getDeclaredFields();
        System.out.println(fs.length);
        System.out.println(fs2.length);
        System.out.println(fs2[1].getName());

        Method method = clazz.getMethod("showMessage");
        System.out.println(method);
        System.out.println(method.getName());

    }
}
