package com.alibaba.a.a;

import com.alibaba.a.c.bb;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface c {
    String[] a() default {};

    String[] b() default {};

    bb[] c() default {};

    com.alibaba.a.b.c[] d() default {};

    Class<?> e() default Void.class;
}
