package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class ProxyRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    public static final int f8187a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f8188b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f8189c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f8190d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f8191e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final int f8192f = 5;

    /* renamed from: g  reason: collision with root package name */
    public static final int f8193g = 6;

    /* renamed from: h  reason: collision with root package name */
    public static final int f8194h = 7;

    /* renamed from: i  reason: collision with root package name */
    public static final int f8195i = 7;
    public final String j;
    public final int k;
    public final long l;
    public final byte[] m;
    private final int n;
    private Bundle o;

    ProxyRequest(int i2, String str, int i3, long j2, byte[] bArr, Bundle bundle) {
        this.n = i2;
        this.j = str;
        this.k = i3;
        this.l = j2;
        this.m = bArr;
        this.o = bundle;
    }

    public String toString() {
        String str = this.j;
        int i2 = this.k;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 42);
        sb.append("ProxyRequest[ url: ");
        sb.append(str);
        sb.append(", method: ");
        sb.append(i2);
        sb.append(" ]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.j, false);
        b.b(parcel, 2, this.k);
        b.a(parcel, 3, this.l);
        b.a(parcel, 4, this.m, false);
        b.a(parcel, 5, this.o);
        b.b(parcel, 1000, this.n);
        b.b(parcel, a2);
    }
}
