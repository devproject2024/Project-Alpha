package com.google.android.play.core.d;

import android.content.Context;

public final class as {
    private as() {
    }

    public static Context a(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }
}
