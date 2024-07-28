package com.google.android.exoplayer2.g;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

final class y implements b {
    y() {
    }

    public final long a() {
        return SystemClock.elapsedRealtime();
    }

    public final long b() {
        return SystemClock.uptimeMillis();
    }

    public final k a(Looper looper, Handler.Callback callback) {
        return new z(new Handler(looper, callback));
    }
}
