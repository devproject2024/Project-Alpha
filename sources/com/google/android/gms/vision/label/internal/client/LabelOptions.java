package com.google.android.gms.vision.label.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class LabelOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LabelOptions> CREATOR = new c();
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public final int f12656a;

    public LabelOptions(int i2) {
        this.f12656a = i2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 2, this.f12656a);
        b.b(parcel, a2);
    }
}
