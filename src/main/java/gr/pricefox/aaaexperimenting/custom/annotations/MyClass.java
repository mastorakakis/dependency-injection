package gr.pricefox.aaaexperimenting.custom.annotations;

import gr.pricefox.CustomAnnotationException;
import lombok.Getter;
import lombok.Setter;

@CustomAnnotation
@Getter
@Setter
public class MyClass {

    private String name;

    public String getScope() throws ClassNotFoundException, CustomAnnotationException {

        Class<?> c = Class.forName("gr.pricefox.aaaexperimenting.custom.annotations.MyClass");

        if (!c.isAnnotationPresent(CustomAnnotation.class)) {
            throw new CustomAnnotationException(c.getName() + " is not annotated");
        }
        CustomAnnotation anno = c.getAnnotation(CustomAnnotation.class);
        return anno.scope();
    }
}
