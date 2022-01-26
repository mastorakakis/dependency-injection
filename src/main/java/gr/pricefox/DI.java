package gr.pricefox;

import gr.pricefox.annotation.Component;
import gr.pricefox.annotation.Scope;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DI {

    private static final DI instance = new DI();
    private final Map<Class<?>, Object> classMap = new HashMap<>();

    private DI() {
    }

    public static DI getInstance() {
        return instance;
    }

    public <T> T oneOf(Class<T> theClass) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Constructor<T> constructor = theClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        return constructor.newInstance();
    }

    public <T> T objectOf(Class<T> theClass) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException, CustomAnnotationException {
        if (theClass.isAnnotationPresent(Component.class)) {
            Component annotation = theClass.getAnnotation(Component.class);
            if (classMap.containsKey(theClass)) {
                return (T) classMap.get(theClass);
            }
            T t = oneOf(theClass);
            if (annotation.scope() == Scope.SINGLETON) {
                classMap.put(theClass, t);
            }
            for (Field field : theClass.getDeclaredFields()) {
                if (field.getType().isAnnotationPresent(Component.class)) {
                    field.setAccessible(true);
                    field.set(t, objectOf(field.getType()));
                }
            }
            return t;
        }
        throw new CustomAnnotationException(theClass.getName() + " is not annotated");
    }

    public <T> List<Class<T>> classListOf(Class<T> theInterface) {
        List<Class<T>> subClassesOfInterface = new ArrayList<>();

        for (String packageName : getAllPackageNames()) {
            Set<Class<?>> classes = findAllClassesUsingClassLoader(packageName);
            for (Class<?> classElement: classes) {
                if (Arrays.asList(classElement.getInterfaces()).contains(theInterface)) {
                    subClassesOfInterface.add((Class<T>) classElement);
                }
            }
        }
        return subClassesOfInterface;
    }

    public List<String> getAllPackageNames() {
        return Arrays.stream(Package.getPackages())
                .map(Package::getName)
                .filter(s -> s.startsWith(this.getClass().getPackageName()))
                .collect(Collectors.toList());
    }

    public Set<Class<?>> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private Class<?> getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}









