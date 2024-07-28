package d.a.a.a;

import d.a.a.c;
import java.util.Map;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<? extends Throwable>, Integer> f45935a;

    public final Integer a(Throwable th) {
        Throwable th2 = th;
        int i2 = 20;
        do {
            Class<?> cls = th2.getClass();
            Integer num = this.f45935a.get(cls);
            if (num == null) {
                Class cls2 = null;
                for (Map.Entry next : this.f45935a.entrySet()) {
                    Class cls3 = (Class) next.getKey();
                    if (cls3.isAssignableFrom(cls) && (cls2 == null || cls2.isAssignableFrom(cls3))) {
                        num = (Integer) next.getValue();
                        cls2 = cls3;
                    }
                }
            }
            if (num != null) {
                return num;
            }
            th2 = th2.getCause();
            i2--;
            if (i2 <= 0 || th2 == th) {
                String str = c.f45942a;
                new StringBuilder("No specific message ressource ID found for ").append(th);
            }
        } while (th2 != null);
        String str2 = c.f45942a;
        new StringBuilder("No specific message ressource ID found for ").append(th);
        return null;
    }
}
