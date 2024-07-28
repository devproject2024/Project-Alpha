package com.google.android.play.core.missingsplits;

import android.app.Application;

public class MissingSplitsDetectingApplication extends Application {

    /* renamed from: a  reason: collision with root package name */
    private boolean f37484a = false;

    public final void onCreate() {
        if (!this.f37484a) {
            this.f37484a = true;
            if (!b.a(this).a()) {
                super.onCreate();
                return;
            }
            return;
        }
        throw new IllegalStateException("The onCreate method must be invoked at most once.");
    }
}
