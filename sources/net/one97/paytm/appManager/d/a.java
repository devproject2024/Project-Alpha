package net.one97.paytm.appManager.d;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f49043a;

    /* renamed from: b  reason: collision with root package name */
    private b f49044b;

    private a() {
    }

    public static void a(b bVar) {
        if (f49043a == null) {
            a aVar = new a();
            f49043a = aVar;
            aVar.f49044b = bVar;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:4|5|(3:7|8|9)|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001b */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static net.one97.paytm.appManager.d.a b() {
        /*
            net.one97.paytm.appManager.d.a r0 = f49043a
            if (r0 != 0) goto L_0x002c
            java.lang.Class<net.one97.paytm.appManager.d.a> r0 = net.one97.paytm.appManager.d.a.class
            monitor-enter(r0)
            net.one97.paytm.appManager.d.a r1 = f49043a     // Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x001b
            java.lang.String r1 = "net.one97.paytm.appManager.AppManagerProvider"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x001b }
            java.lang.String r2 = "init"
            r3 = 0
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r3)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x001b }
            r1.invoke(r3, r3)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x001b }
        L_0x001b:
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            net.one97.paytm.appManager.d.a r0 = f49043a
            if (r0 == 0) goto L_0x0021
            goto L_0x002c
        L_0x0021:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "getInstance() called before AppMangerHelper's init()"
            r0.<init>(r1)
            throw r0
        L_0x0029:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            throw r1
        L_0x002c:
            net.one97.paytm.appManager.d.a r0 = f49043a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.appManager.d.a.b():net.one97.paytm.appManager.d.a");
    }

    public static b a() {
        return b().f49044b;
    }
}
