package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.internal.s;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    final Set<k<?>> f8623a = Collections.newSetFromMap(new WeakHashMap());

    public static <L> k<L> a(L l, Looper looper, String str) {
        s.a(l, (Object) "Listener must not be null");
        s.a(looper, (Object) "Looper must not be null");
        s.a(str, (Object) "Listener type must not be null");
        return new k<>(looper, l, str);
    }

    public static <L> k.a<L> a(L l, String str) {
        s.a(l, (Object) "Listener must not be null");
        s.a(str, (Object) "Listener type must not be null");
        s.a(str, (Object) "Listener type must not be empty");
        return new k.a<>(l, str);
    }
}
