package kotlin.g.b;

import kotlin.k.d;

public final class z {
    public static d a(Class cls, String str) {
        return new r(cls, str);
    }

    public static String a(h hVar) {
        String obj = hVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }
}
