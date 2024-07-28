package kotlin.g.b;

import com.business.merchant_payments.common.utility.AppUtility;
import java.util.Arrays;
import kotlin.e;
import kotlin.w;

public class k {
    public static int a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    private k() {
    }

    public static String a(String str, Object obj) {
        return str + obj;
    }

    public static void a() {
        throw ((e) a(new e()));
    }

    public static void a(String str) {
        throw ((w) a(new w("lateinit property " + str + " has not been initialized")));
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) a(new IllegalStateException(str + " must not be null")));
        }
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            throw ((NullPointerException) a(new NullPointerException(str + " must not be null")));
        }
    }

    private static String b(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + AppUtility.CENTER_DOT + methodName + ", parameter " + str;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean a(Double d2, double d3) {
        return d2 != null && d2.doubleValue() == d3;
    }

    public static boolean a(double d2, Double d3) {
        return d3 != null && d2 == d3.doubleValue();
    }

    public static boolean a(Float f2) {
        return f2 != null && f2.floatValue() == 0.0f;
    }

    private static <T extends Throwable> T a(T t) {
        return a(t, k.class.getName());
    }

    static <T extends Throwable> T a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
        return t;
    }

    public static void a(Object obj) {
        if (obj == null) {
            throw ((NullPointerException) a(new NullPointerException()));
        }
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalArgumentException) a(new IllegalArgumentException(b(str))));
        }
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            throw ((NullPointerException) a(new NullPointerException(b(str))));
        }
    }

    public static void b() {
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }
}
