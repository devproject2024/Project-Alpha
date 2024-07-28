package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f8892a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8893b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8894c;

    public FavaDiagnosticsEntity(int i2, String str, int i3) {
        this.f8892a = i2;
        this.f8893b = str;
        this.f8894c = i3;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8892a);
        b.a(parcel, 2, this.f8893b, false);
        b.b(parcel, 3, this.f8894c);
        b.b(parcel, a2);
    }
}
