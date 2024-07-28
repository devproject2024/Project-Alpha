package com.airbnb.lottie.f;

import com.airbnb.lottie.i;
import java.util.HashSet;
import java.util.Set;

public final class c implements i {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f6109a = new HashSet();

    public final void a(String str) {
        b(str);
    }

    public final void b(String str) {
        if (!f6109a.contains(str)) {
            f6109a.add(str);
        }
    }

    public final void b() {
        boolean z = com.airbnb.lottie.c.f5801a;
    }

    public final void a() {
        boolean z = com.airbnb.lottie.c.f5801a;
    }
}
