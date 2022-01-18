package gr.pricefox.experimenting.custom.annotations;

import gr.pricefox.exception.CustomAnnotationException;

public class InvalidClass {

    public String getScope() throws ClassNotFoundException, CustomAnnotationException {

        Class<?> c = Class.forName("pricefox.experimenting.custom.annotations.InvalidClass");

        if (!c.isAnnotationPresent(CustomAnnotation.class)) {
            throw new CustomAnnotationException(c.getName() + " is not annotated");
        }
        CustomAnnotation anno = c.getAnnotation(CustomAnnotation.class);
        return anno.scope();
    }
}
