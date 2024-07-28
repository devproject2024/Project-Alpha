package net.one97.paytm.feed.utility;

import android.os.SystemClock;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final u f35438a = new u();

    /* renamed from: b  reason: collision with root package name */
    private static long f35439b;

    private u() {
    }

    public static boolean a() {
        if (SystemClock.elapsedRealtime() - f35439b < 1000) {
            return true;
        }
        f35439b = SystemClock.elapsedRealtime();
        return false;
    }
}
