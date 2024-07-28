package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzaf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaf> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    private final int f9081a = 1;

    /* renamed from: b  reason: collision with root package name */
    private final String f9082b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f9083c;

    zzaf(String str, byte[] bArr) {
        this.f9082b = (String) s.a(str);
        this.f9083c = (byte[]) s.a(bArr);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f9081a);
        b.a(parcel, 2, this.f9082b, false);
        b.a(parcel, 3, this.f9083c, false);
        b.b(parcel, a2);
    }
}
