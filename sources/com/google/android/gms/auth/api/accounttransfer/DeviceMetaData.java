package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class DeviceMetaData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceMetaData> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final int f8086a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f8087b;

    /* renamed from: c  reason: collision with root package name */
    private long f8088c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f8089d;

    DeviceMetaData(int i2, boolean z, long j, boolean z2) {
        this.f8086a = i2;
        this.f8087b = z;
        this.f8088c = j;
        this.f8089d = z2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8086a);
        b.a(parcel, 2, this.f8087b);
        b.a(parcel, 3, this.f8088c);
        b.a(parcel, 4, this.f8089d);
        b.b(parcel, a2);
    }
}
