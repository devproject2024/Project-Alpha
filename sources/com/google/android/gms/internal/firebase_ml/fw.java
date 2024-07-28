package com.google.android.gms.internal.firebase_ml;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class fw {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f9902a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f9903b = true;

    /* renamed from: c  reason: collision with root package name */
    private static volatile fw f9904c;

    /* renamed from: d  reason: collision with root package name */
    private static final fw f9905d = new fw((byte) 0);

    /* renamed from: e  reason: collision with root package name */
    private final Map<Object, Object<?, ?>> f9906e;

    public static fw a() {
        fw fwVar = f9904c;
        if (fwVar == null) {
            synchronized (fw.class) {
                fwVar = f9904c;
                if (fwVar == null) {
                    fwVar = f9905d;
                    f9904c = fwVar;
                }
            }
        }
        return fwVar;
    }

    fw() {
        this.f9906e = new HashMap();
    }

    private fw(byte b2) {
        this.f9906e = Collections.emptyMap();
    }
}
