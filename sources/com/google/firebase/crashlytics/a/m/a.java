package com.google.firebase.crashlytics.a.m;

import android.content.Context;
import com.google.firebase.crashlytics.a.c.g;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f38710a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f38711b = false;

    /* renamed from: c  reason: collision with root package name */
    private String f38712c;

    public a(Context context) {
        this.f38710a = context;
    }

    public final String a() {
        if (!this.f38711b) {
            this.f38712c = g.j(this.f38710a);
            this.f38711b = true;
        }
        String str = this.f38712c;
        if (str != null) {
            return str;
        }
        return null;
    }
}
