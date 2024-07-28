package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.bf;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ar {

    /* renamed from: a  reason: collision with root package name */
    static final ar f9161a = new ar((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f9162b = false;

    /* renamed from: c  reason: collision with root package name */
    private static final Class<?> f9163c = b();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Object, bf.f<?, ?>> f9164d;

    ar() {
        this.f9164d = new HashMap();
    }

    private ar(byte b2) {
        this.f9164d = Collections.emptyMap();
    }

    public static ar a() {
        return aq.a();
    }

    private static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
