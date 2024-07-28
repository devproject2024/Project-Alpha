package com.google.android.gms.internal.p001firebaseperf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.de  reason: invalid package */
public class de {

    /* renamed from: a  reason: collision with root package name */
    static final de f9548a = new de((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f9549b = false;

    /* renamed from: c  reason: collision with root package name */
    private static final Class<?> f9550c = b();

    /* renamed from: d  reason: collision with root package name */
    private static volatile de f9551d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Object, Object> f9552e;

    private static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static de a() {
        de deVar = f9551d;
        if (deVar == null) {
            synchronized (de.class) {
                deVar = f9551d;
                if (deVar == null) {
                    deVar = df.a();
                    f9551d = deVar;
                }
            }
        }
        return deVar;
    }

    de() {
        this.f9552e = new HashMap();
    }

    private de(byte b2) {
        this.f9552e = Collections.emptyMap();
    }
}
