package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class Tile extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Tile> CREATOR = new w();

    /* renamed from: a  reason: collision with root package name */
    public final int f11649a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11650b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f11651c;

    public Tile(int i2, int i3, byte[] bArr) {
        this.f11649a = i2;
        this.f11650b = i3;
        this.f11651c = bArr;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 2, this.f11649a);
        b.b(parcel, 3, this.f11650b);
        b.a(parcel, 4, this.f11651c, false);
        b.b(parcel, a2);
    }
}
