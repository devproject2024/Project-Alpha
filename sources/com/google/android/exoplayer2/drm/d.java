package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.g;
import java.util.Map;

public interface d<T extends g> {
    int e();

    a f();

    T g();

    Map<String, String> h();

    public static class a extends Exception {
        public a(Throwable th) {
            super(th);
        }
    }
}
