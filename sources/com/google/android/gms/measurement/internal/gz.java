package com.google.android.gms.measurement.internal;

import android.net.Uri;

final class gz implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f12085a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Uri f12086b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f12087c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f12088d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ ha f12089e;

    gz(ha haVar, boolean z, Uri uri, String str, String str2) {
        this.f12089e = haVar;
        this.f12085a = z;
        this.f12086b = uri;
        this.f12087c = str;
        this.f12088d = str2;
    }

    public final void run() {
        this.f12089e.a(this.f12085a, this.f12086b, this.f12087c, this.f12088d);
    }
}
