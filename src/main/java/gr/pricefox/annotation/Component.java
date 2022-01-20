package gr.pricefox.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Component {

    Scope scope() default Scope.SINGLETON;
}
