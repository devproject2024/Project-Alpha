package net.one97.paytm.fastscanner.c;

import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.fastscanner.b.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f50447a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f50448b = new a();

    /* renamed from: c  reason: collision with root package name */
    private static b f50449c;

    /* renamed from: d  reason: collision with root package name */
    private static c f50450d;

    /* renamed from: e  reason: collision with root package name */
    private static d f50451e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f50452f;

    /* renamed from: g  reason: collision with root package name */
    private static int f50453g;

    /* renamed from: h  reason: collision with root package name */
    private static int f50454h;

    private a() {
    }

    public static c a() {
        return f50450d;
    }

    public static d b() {
        return f50451e;
    }

    public static void a(boolean z) {
        f50452f = z;
    }

    public static boolean c() {
        return f50452f;
    }

    public static int d() {
        return f50453g;
    }

    public static void e() {
        f50453g = 0;
    }

    public static int f() {
        return f50454h;
    }

    public static void g() {
        f50454h = 0;
    }

    public static void a(String str) {
        if (f50449c == null) {
            try {
                Class<?> cls = Class.forName(str);
                k.a((Object) cls, "Class.forName(path)");
                Object newInstance = cls.newInstance();
                if (newInstance != null) {
                    f50449c = (b) newInstance;
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.fastscanner.communicator.FastScanCommunicator");
            } catch (Exception unused) {
                b bVar = b.f50423a;
                b.b("ganesh", "error while creating communicator");
            }
        }
    }

    public static b h() {
        String str;
        if (f50449c == null) {
            synchronized (a.class) {
                if (f50449c == null && (str = f50447a) != null) {
                    a(str);
                }
                x xVar = x.f47997a;
            }
        }
        b bVar = f50449c;
        if (bVar == null) {
            k.a();
        }
        return bVar;
    }

    public static void a(c cVar) {
        f50450d = cVar;
    }

    public static void a(d dVar) {
        f50451e = dVar;
    }

    public static void i() {
        c cVar = f50450d;
        if (cVar != null) {
            cVar.b();
        }
    }

    public static void j() {
        f50453g++;
    }

    public static void k() {
        f50454h++;
    }
}
