package gr.pricefox.experimenting.custom.annotations;

import gr.pricefox.CustomAnnotationException;

public class MainAnnotations {

    public static void main(String[] args) throws CustomAnnotationException, ClassNotFoundException {

        MyClass myClass = new MyClass();
        System.out.println(myClass.getScope());

        InvalidClass invalidClass = new InvalidClass();
        System.out.println(invalidClass.getScope());
    }
}
