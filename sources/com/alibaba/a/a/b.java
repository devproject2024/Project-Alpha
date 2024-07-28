package com.alibaba.a.a;

import com.alibaba.a.c.bb;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface b {
    int a() default 0;

    String b() default "";

    String c() default "";

    boolean d() default true;

    boolean e() default true;

    bb[] f() default {};
}
