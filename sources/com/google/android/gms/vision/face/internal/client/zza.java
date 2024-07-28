package com.google.android.gms.vision.face.internal.client;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final PointF[] f12644a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12645b;

    public zza(PointF[] pointFArr, int i2) {
        this.f12644a = pointFArr;
        this.f12645b = i2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, (T[]) this.f12644a, i2);
        b.b(parcel, 3, this.f12645b);
        b.b(parcel, a2);
    }
}
