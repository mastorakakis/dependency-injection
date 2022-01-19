package gr.pricefox.experimenting.custom.annotations;

import gr.pricefox.exception.CustomAnnotationException;
import lombok.Getter;
import lombok.Setter;

@CustomAnnotation
@Getter
@Setter
public class MyClass {

    private String name;

    public String getScope() throws ClassNotFoundException, CustomAnnotationException {

        Class<?> c = Class.forName("gr.pricefox.experimenting.custom.annotations.MyClass");

        if (!c.isAnnotationPresent(CustomAnnotation.class)) {
            throw new CustomAnnotationException(c.getName() + "is not annotated");
        }
        CustomAnnotation anno = c.getAnnotation(CustomAnnotation.class);
        return anno.scope();
    }
}
