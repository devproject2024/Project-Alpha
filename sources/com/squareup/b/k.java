package com.squareup.b;

import com.squareup.b.g;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface k {
    int a();

    g.a b() default g.a.MESSAGE;

    g.b c() default g.b.OPTIONAL;

    boolean d() default false;
}
