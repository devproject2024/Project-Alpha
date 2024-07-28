package net.one97.paytm.utils;

import android.app.Activity;
import java.lang.ref.WeakReference;

public final class as {

    /* renamed from: b  reason: collision with root package name */
    private static as f69660b;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Activity> f69661a;

    private as() {
    }

    public static as a() {
        if (f69660b == null) {
            f69660b = new as();
        }
        return f69660b;
    }

    public final void a(Activity activity) {
        this.f69661a = new WeakReference<>(activity);
    }
}
