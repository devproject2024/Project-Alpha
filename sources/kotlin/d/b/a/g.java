package kotlin.d.b.a;

import java.lang.reflect.Field;
import kotlin.g.b.k;

public final class g {
    static final int a(a aVar) {
        try {
            Field declaredField = aVar.getClass().getDeclaredField("label");
            k.b(declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(aVar);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }
}
