package gr.pricefox.experimenting.custom.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {

    String scope() default "Singleton";
}
