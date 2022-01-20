package gr.pricefox.aaaexperimenting.custom.annotations;

import gr.pricefox.CustomAnnotationException;

public class InvalidClass {

    public String getScope() throws ClassNotFoundException, CustomAnnotationException {

        Class<?> c = Class.forName("gr.pricefox.aaaexperimenting.custom.annotations.InvalidClass");

        if (!c.isAnnotationPresent(CustomAnnotation.class)) {
            throw new CustomAnnotationException(c.getName() + " is not annotated");
        }
        CustomAnnotation anno = c.getAnnotation(CustomAnnotation.class);
        return anno.scope();
    }
}
