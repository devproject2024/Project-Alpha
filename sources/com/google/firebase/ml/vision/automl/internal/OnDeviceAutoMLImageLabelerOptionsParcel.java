package com.google.firebase.ml.vision.automl.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class OnDeviceAutoMLImageLabelerOptionsParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<OnDeviceAutoMLImageLabelerOptionsParcel> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    public final float f39085a;

    /* renamed from: b  reason: collision with root package name */
    public final String f39086b;

    /* renamed from: c  reason: collision with root package name */
    public final String f39087c;

    /* renamed from: d  reason: collision with root package name */
    public final String f39088d;

    public OnDeviceAutoMLImageLabelerOptionsParcel(float f2, String str, String str2, String str3) {
        this.f39085a = f2;
        this.f39086b = str;
        this.f39087c = str2;
        this.f39088d = str3;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f39085a);
        b.a(parcel, 2, this.f39086b, false);
        b.a(parcel, 3, this.f39087c, false);
        b.a(parcel, 4, this.f39088d, false);
        b.b(parcel, a2);
    }
}
