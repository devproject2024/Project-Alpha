package kotlin.d.b.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface f {
    int a() default 1;

    String b() default "";

    int[] c() default {};

    String d() default "";

    String e() default "";
}
