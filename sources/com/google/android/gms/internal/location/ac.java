package com.google.android.gms.internal.location;

import android.os.Looper;
import com.google.android.gms.common.internal.s;

public final class ac {
    public static Looper a() {
        s.a(Looper.myLooper() != null, (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        return Looper.myLooper();
    }

    public static Looper a(Looper looper) {
        return looper != null ? looper : a();
    }
}
