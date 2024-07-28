package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class ProxyResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyResponse> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    public final int f8196a;

    /* renamed from: b  reason: collision with root package name */
    public final PendingIntent f8197b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8198c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f8199d;

    /* renamed from: e  reason: collision with root package name */
    private final int f8200e;

    /* renamed from: f  reason: collision with root package name */
    private final Bundle f8201f;

    ProxyResponse(int i2, int i3, PendingIntent pendingIntent, int i4, Bundle bundle, byte[] bArr) {
        this.f8200e = i2;
        this.f8196a = i3;
        this.f8198c = i4;
        this.f8201f = bundle;
        this.f8199d = bArr;
        this.f8197b = pendingIntent;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8196a);
        b.a(parcel, 2, this.f8197b, i2, false);
        b.b(parcel, 3, this.f8198c);
        b.a(parcel, 4, this.f8201f);
        b.a(parcel, 5, this.f8199d, false);
        b.b(parcel, 1000, this.f8200e);
        b.b(parcel, a2);
    }
}
