package kotlin.g.b;

import kotlin.k.c;
import kotlin.k.d;
import kotlin.k.e;
import kotlin.k.g;
import kotlin.k.h;
import kotlin.k.j;
import kotlin.k.k;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    private static final z f47932a;

    /* renamed from: b  reason: collision with root package name */
    private static final c[] f47933b = new c[0];

    public static e a(i iVar) {
        return iVar;
    }

    public static g a(n nVar) {
        return nVar;
    }

    public static h a(p pVar) {
        return pVar;
    }

    public static j a(t tVar) {
        return tVar;
    }

    public static k a(v vVar) {
        return vVar;
    }

    static {
        z zVar = null;
        try {
            zVar = (z) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (zVar == null) {
            zVar = new z();
        }
        f47932a = zVar;
    }

    public static d a(Class cls) {
        return z.a(cls, "");
    }

    public static d a(Class cls, String str) {
        return z.a(cls, str);
    }

    public static String a(h hVar) {
        return z.a(hVar);
    }

    public static c b(Class cls) {
        return new e(cls);
    }

    public static String a(l lVar) {
        return z.a(lVar);
    }
}
