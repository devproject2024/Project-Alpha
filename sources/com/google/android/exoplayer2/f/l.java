package com.google.android.exoplayer2.f;

import android.net.Uri;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.android.exoplayer2.g.a;
import java.util.Arrays;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f32395a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32396b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f32397c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f32398d;

    /* renamed from: e  reason: collision with root package name */
    public final long f32399e;

    /* renamed from: f  reason: collision with root package name */
    public final long f32400f;

    /* renamed from: g  reason: collision with root package name */
    public final long f32401g;

    /* renamed from: h  reason: collision with root package name */
    public final String f32402h;

    /* renamed from: i  reason: collision with root package name */
    public final int f32403i;

    public l(Uri uri) {
        this(uri, 0, (String) null, 1);
    }

    public l(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
    }

    public l(Uri uri, long j, String str, int i2) {
        this(uri, j, j, -1, str, i2);
    }

    public l(Uri uri, long j, long j2, long j3, String str, int i2) {
        this(uri, j, j2, j3, str, i2, (byte) 0);
    }

    private l(Uri uri, long j, long j2, long j3, String str, int i2, byte b2) {
        this(uri, 1, (byte[]) null, j, j2, j3, str, i2);
    }

    public l(Uri uri, int i2, byte[] bArr, long j, long j2, long j3, String str, int i3) {
        byte[] bArr2 = bArr;
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        boolean z = true;
        a.a(j4 >= 0);
        a.a(j5 >= 0);
        if (j6 <= 0 && j6 != -1) {
            z = false;
        }
        a.a(z);
        this.f32395a = uri;
        this.f32396b = i2;
        this.f32397c = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f32398d = this.f32397c;
        this.f32399e = j4;
        this.f32400f = j5;
        this.f32401g = j6;
        this.f32402h = str;
        this.f32403i = i3;
    }

    public final boolean a(int i2) {
        return (this.f32403i & i2) == i2;
    }

    public final String toString() {
        return "DataSpec[" + b(this.f32396b) + " " + this.f32395a + ", " + Arrays.toString(this.f32397c) + ", " + this.f32399e + ", " + this.f32400f + ", " + this.f32401g + ", " + this.f32402h + ", " + this.f32403i + "]";
    }

    public static String b(int i2) {
        if (i2 == 1) {
            return H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD;
        }
        if (i2 == 2) {
            return "POST";
        }
        if (i2 == 3) {
            return "HEAD";
        }
        throw new AssertionError(i2);
    }

    public final l a(long j) {
        long j2 = this.f32401g;
        long j3 = -1;
        if (j2 != -1) {
            j3 = j2 - j;
        }
        return a(j, j3);
    }

    public final l a(long j, long j2) {
        if (j == 0 && this.f32401g == j2) {
            return this;
        }
        return new l(this.f32395a, this.f32396b, this.f32397c, this.f32399e + j, this.f32400f + j, j2, this.f32402h, this.f32403i);
    }
}
