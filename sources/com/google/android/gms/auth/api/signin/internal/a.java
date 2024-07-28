package com.google.android.gms.auth.api.signin.internal;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static int f8254b = 31;

    /* renamed from: a  reason: collision with root package name */
    public int f8255a = 1;

    public final a a(Object obj) {
        this.f8255a = (f8254b * this.f8255a) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public final a a(boolean z) {
        this.f8255a = (f8254b * this.f8255a) + (z ? 1 : 0);
        return this;
    }
}
