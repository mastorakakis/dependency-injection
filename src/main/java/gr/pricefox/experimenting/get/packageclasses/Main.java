package gr.pricefox.experimenting.get.packageclasses;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        AccessingAllClassesInPackage instance = new AccessingAllClassesInPackage();

        Set<Class<?>> classes =
                instance.findAllClassesUsingClassLoader("pricefox.experimenting.get.packageclasses");

        System.out.println(classes);
    }
}
