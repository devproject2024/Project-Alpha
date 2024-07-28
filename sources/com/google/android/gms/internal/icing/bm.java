package com.google.android.gms.internal.icing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class bm {

    /* renamed from: a  reason: collision with root package name */
    static final bm f10090a = new bm((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f10091b = false;

    /* renamed from: c  reason: collision with root package name */
    private static final Class<?> f10092c = b();

    /* renamed from: d  reason: collision with root package name */
    private static volatile bm f10093d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Object, Object> f10094e;

    private static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static bm a() {
        bm bmVar = f10093d;
        if (bmVar == null) {
            synchronized (bm.class) {
                bmVar = f10093d;
                if (bmVar == null) {
                    bmVar = bj.a();
                    f10093d = bmVar;
                }
            }
        }
        return bmVar;
    }

    bm() {
        this.f10094e = new HashMap();
    }

    private bm(byte b2) {
        this.f10094e = Collections.emptyMap();
    }
}
