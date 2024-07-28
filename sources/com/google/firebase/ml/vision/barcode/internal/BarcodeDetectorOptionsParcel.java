package com.google.firebase.ml.vision.barcode.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class BarcodeDetectorOptionsParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<BarcodeDetectorOptionsParcel> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    public final int f39117a;

    public BarcodeDetectorOptionsParcel(int i2) {
        this.f39117a = i2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f39117a);
        b.b(parcel, a2);
    }
}
