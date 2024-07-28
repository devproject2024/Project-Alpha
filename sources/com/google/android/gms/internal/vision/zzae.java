package com.google.android.gms.internal.vision;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzae> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    public final Rect f11292a;

    public zzae() {
        this.f11292a = new Rect();
    }

    public zzae(Rect rect) {
        this.f11292a = rect;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f11292a, i2, false);
        b.b(parcel, a2);
    }
}
