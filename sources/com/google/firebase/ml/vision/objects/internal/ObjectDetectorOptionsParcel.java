package com.google.firebase.ml.vision.objects.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class ObjectDetectorOptionsParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ObjectDetectorOptionsParcel> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final int f39169a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f39170b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f39171c;

    public ObjectDetectorOptionsParcel(int i2, boolean z, boolean z2) {
        this.f39169a = i2;
        this.f39170b = z;
        this.f39171c = z2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f39169a);
        b.a(parcel, 2, this.f39170b);
        b.a(parcel, 3, this.f39171c);
        b.b(parcel, a2);
    }
}
