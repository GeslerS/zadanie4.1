package pl.sagiton.model;

/**
 * Created by szymon on 20.02.16.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Foo {
    String value();
}
