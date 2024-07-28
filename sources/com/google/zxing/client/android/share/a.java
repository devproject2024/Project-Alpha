package com.google.zxing.client.android.share;

import android.graphics.drawable.Drawable;

final class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    final String f40288a;

    /* renamed from: b  reason: collision with root package name */
    final Drawable f40289b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40290c;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f40290c.compareTo(((a) obj).f40290c);
    }

    a(String str, String str2, Drawable drawable) {
        this.f40288a = str;
        this.f40290c = str2;
        this.f40289b = drawable;
    }

    public final String toString() {
        return this.f40290c;
    }

    public final int hashCode() {
        return this.f40290c.hashCode();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        return this.f40290c.equals(((a) obj).f40290c);
    }
}
