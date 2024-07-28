package com.google.firebase.e;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class d {

    /* renamed from: b  reason: collision with root package name */
    private static volatile d f38732b;

    /* renamed from: a  reason: collision with root package name */
    private final Set<f> f38733a = new HashSet();

    d() {
    }

    /* access modifiers changed from: package-private */
    public final Set<f> a() {
        Set<f> unmodifiableSet;
        synchronized (this.f38733a) {
            unmodifiableSet = Collections.unmodifiableSet(this.f38733a);
        }
        return unmodifiableSet;
    }

    public static d b() {
        d dVar = f38732b;
        if (dVar == null) {
            synchronized (d.class) {
                dVar = f38732b;
                if (dVar == null) {
                    dVar = new d();
                    f38732b = dVar;
                }
            }
        }
        return dVar;
    }
}
