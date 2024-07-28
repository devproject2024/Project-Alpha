package com.google.android.gms.maps.a;

import android.content.Context;
import com.google.android.gms.common.g;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.dynamite.DynamiteModule;

public class v {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11541a = v.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static Context f11542b = null;

    /* renamed from: c  reason: collision with root package name */
    private static y f11543c;

    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.maps.a.y a(android.content.Context r3) throws com.google.android.gms.common.e {
        /*
            com.google.android.gms.common.internal.s.a(r3)
            com.google.android.gms.maps.a.y r0 = f11543c
            if (r0 == 0) goto L_0x0008
            return r0
        L_0x0008:
            int r0 = com.google.android.gms.common.g.b(r3)
            if (r0 != 0) goto L_0x0055
            android.content.Context r0 = b(r3)
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.String r1 = "com.google.android.gms.maps.internal.CreatorImpl"
            java.lang.Object r0 = a(r0, r1)
            android.os.IBinder r0 = (android.os.IBinder) r0
            if (r0 != 0) goto L_0x0022
            r0 = 0
            goto L_0x0036
        L_0x0022:
            java.lang.String r1 = "com.google.android.gms.maps.internal.ICreator"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.maps.a.y
            if (r2 == 0) goto L_0x0030
            r0 = r1
            com.google.android.gms.maps.a.y r0 = (com.google.android.gms.maps.a.y) r0
            goto L_0x0036
        L_0x0030:
            com.google.android.gms.maps.a.z r1 = new com.google.android.gms.maps.a.z
            r1.<init>(r0)
            r0 = r1
        L_0x0036:
            f11543c = r0
            com.google.android.gms.maps.a.y r0 = f11543c     // Catch:{ RemoteException -> 0x004e }
            android.content.Context r3 = b(r3)     // Catch:{ RemoteException -> 0x004e }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ RemoteException -> 0x004e }
            com.google.android.gms.b.b r3 = com.google.android.gms.b.d.a(r3)     // Catch:{ RemoteException -> 0x004e }
            int r1 = com.google.android.gms.common.g.f8686a     // Catch:{ RemoteException -> 0x004e }
            r0.a((com.google.android.gms.b.b) r3, (int) r1)     // Catch:{ RemoteException -> 0x004e }
            com.google.android.gms.maps.a.y r3 = f11543c
            return r3
        L_0x004e:
            r3 = move-exception
            com.google.android.gms.maps.model.d r0 = new com.google.android.gms.maps.model.d
            r0.<init>(r3)
            throw r0
        L_0x0055:
            com.google.android.gms.common.e r3 = new com.google.android.gms.common.e
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.a.v.a(android.content.Context):com.google.android.gms.maps.a.y");
    }

    private static Context b(Context context) {
        Context context2 = f11542b;
        if (context2 != null) {
            return context2;
        }
        Context c2 = c(context);
        f11542b = c2;
        return c2;
    }

    private static Context c(Context context) {
        try {
            return DynamiteModule.a(context, DynamiteModule.f9008a, "com.google.android.gms.maps_dynamite").f9016g;
        } catch (Exception unused) {
            return g.d(context);
        }
    }

    private static <T> T a(ClassLoader classLoader, String str) {
        try {
            return a(((ClassLoader) s.a(classLoader)).loadClass(str));
        } catch (ClassNotFoundException unused) {
            String valueOf = String.valueOf(str);
            throw new IllegalStateException(valueOf.length() != 0 ? "Unable to find dynamic class ".concat(valueOf) : new String("Unable to find dynamic class "));
        }
    }

    private static <T> T a(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException unused) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalStateException(valueOf.length() != 0 ? "Unable to instantiate the dynamic class ".concat(valueOf) : new String("Unable to instantiate the dynamic class "));
        } catch (IllegalAccessException unused2) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new IllegalStateException(valueOf2.length() != 0 ? "Unable to call the default constructor of ".concat(valueOf2) : new String("Unable to call the default constructor of "));
        }
    }
}
