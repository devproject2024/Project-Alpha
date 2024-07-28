package com.google.android.exoplayer2.g;

import android.os.Trace;

public final class ac {
    public static void a(String str) {
        if (ae.f32499a >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void a() {
        if (ae.f32499a >= 18) {
            Trace.endSection();
        }
    }
}
