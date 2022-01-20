package gr.pricefox.aaaexperimenting.get.packageclasses;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        AccessingAllClassesInPackage instance = new AccessingAllClassesInPackage();

        Set<Class<?>> classes =
                instance.findAllClassesUsingClassLoader("gr.pricefox.experimenting.get.packageclasses");

        System.out.println(classes);
    }
}
