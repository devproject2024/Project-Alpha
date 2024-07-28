package com.google.android.gms.internal.clearcut;

import android.net.Uri;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    final String f9421a;

    /* renamed from: b  reason: collision with root package name */
    final Uri f9422b;

    /* renamed from: c  reason: collision with root package name */
    final String f9423c;

    /* renamed from: d  reason: collision with root package name */
    final String f9424d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f9425e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f9426f;

    public n(Uri uri) {
        this((String) null, uri, "", "", false, false);
    }

    private n(String str, Uri uri, String str2, String str3, boolean z, boolean z2) {
        this.f9421a = str;
        this.f9422b = uri;
        this.f9423c = str2;
        this.f9424d = str3;
        this.f9425e = z;
        this.f9426f = z2;
    }

    public final n a(String str) {
        boolean z = this.f9425e;
        if (!z) {
            return new n(this.f9421a, this.f9422b, str, this.f9424d, z, this.f9426f);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final n b(String str) {
        return new n(this.f9421a, this.f9422b, this.f9423c, str, this.f9425e, this.f9426f);
    }
}
