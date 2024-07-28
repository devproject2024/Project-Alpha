package androidx.navigation;

import androidx.navigation.s;
import java.util.HashMap;

public class t {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<Class, String> f3964a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, s<? extends k>> f3965b = new HashMap<>();

    private static boolean b(String str) {
        return str != null && !str.isEmpty();
    }

    static String a(Class<? extends s> cls) {
        String str = f3964a.get(cls);
        if (str == null) {
            s.b bVar = (s.b) cls.getAnnotation(s.b.class);
            str = bVar != null ? bVar.a() : null;
            if (b(str)) {
                f3964a.put(cls, str);
            } else {
                throw new IllegalArgumentException("No @Navigator.Name annotation found for " + cls.getSimpleName());
            }
        }
        return str;
    }

    public final <T extends s<?>> T a(String str) {
        if (b(str)) {
            T t = (s) this.f3965b.get(str);
            if (t != null) {
                return t;
            }
            throw new IllegalStateException("Could not find Navigator with name \"" + str + "\". You must call NavController.addNavigator() for each navigation type.");
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    public final s<? extends k> a(s<? extends k> sVar) {
        return a(a((Class<? extends s>) sVar.getClass()), sVar);
    }

    public s<? extends k> a(String str, s<? extends k> sVar) {
        if (b(str)) {
            return this.f3965b.put(str, sVar);
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }
}
